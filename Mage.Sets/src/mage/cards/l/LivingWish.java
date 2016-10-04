/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.cards.l;

import java.util.Set;
import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.cards.Cards;
import mage.cards.CardsImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.CardTypePredicate;
import mage.game.Game;
import mage.players.Player;
import mage.target.TargetCard;

/**
 *
 * @author Plopman
 */
public class LivingWish extends CardImpl {

    public LivingWish(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{1}{G}");


        // You may choose a creature or land card you own from outside the game, reveal that card, and put it into your hand. Exile Living Wish.
        this.getSpellAbility().addEffect(new LivingWishEffect());
    }

    public LivingWish(final LivingWish card) {
        super(card);
    }

    @Override
    public LivingWish copy() {
        return new LivingWish(this);
    }
}

class LivingWishEffect extends OneShotEffect {

    private static final String choiceText = "Choose a creature or land card you own from outside the game, and put it into your hand";

    private static final FilterCard filter = new FilterCard("creature or land card");
    static{
         filter.add(Predicates.or(
                new CardTypePredicate(CardType.CREATURE),
                new CardTypePredicate(CardType.LAND)));
    }

    public LivingWishEffect() {
        super(Outcome.Benefit);
        this.staticText = "You may choose a creature or land card you own from outside the game, reveal that card, and put it into your hand. Exile Living Wish";
    }

    public LivingWishEffect(final LivingWishEffect effect) {
        super(effect);
    }

    @Override
    public LivingWishEffect copy() {
        return new LivingWishEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        if (player != null) {
            while (player.chooseUse(Outcome.Benefit, choiceText, source, game)) {
                Cards cards = player.getSideboard();
                if(cards.isEmpty()) {
                    game.informPlayer(player, "You have no cards outside the game.");
                    break;
                }

                Set<Card> filtered = cards.getCards(filter, game);
                if (filtered.isEmpty()) {
                    game.informPlayer(player, "You have no " + filter.getMessage() + " outside the game.");
                    break;
                }

                Cards filteredCards = new CardsImpl();
                for (Card card : filtered) {
                    filteredCards.add(card.getId());
                }

                TargetCard target = new TargetCard(Zone.OUTSIDE, filter);
                if (player.choose(Outcome.Benefit, filteredCards, target, game)) {
                    Card card = player.getSideboard().get(target.getFirstTarget(), game);
                    if (card != null) {

                        card.moveToZone(Zone.HAND, source.getSourceId(), game, false);
                        Cards revealCard = new CardsImpl();
                        revealCard.add(card);
                        player.revealCards("Living Wish", revealCard, game);
                        break;
                    }
                }
            }
            Card cardToExile = game.getCard(source.getSourceId());
            if(cardToExile != null)
            {
                cardToExile.moveToExile(null, "", source.getSourceId(), game);
            }
        }
        return true;
    }

}
