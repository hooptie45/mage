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
package mage.sets.championsofkamigawa;

import java.util.UUID;
import mage.MageObject;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.Cards;
import mage.cards.CardsImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.game.Game;
import mage.players.Player;
import mage.target.TargetCard;
import mage.target.common.TargetOpponent;

/**
 *
 * @author LevelX2
 */
public class StruggleForSanity extends CardImpl {

    public StruggleForSanity(UUID ownerId) {
        super(ownerId, 145, "Struggle for Sanity", Rarity.UNCOMMON, new CardType[]{CardType.SORCERY}, "{2}{B}{B}");
        this.expansionSetCode = "CHK";

        // Target opponent reveals his or her hand. That player exiles a card from it, then you exile a card from it. Repeat this process until all cards in that hand have been exiled. That player returns the cards he or she exiled this way to his or her hand and puts the rest into his or her graveyard.
        this.getSpellAbility().addEffect(new StruggleForSanityEffect());
        this.getSpellAbility().addTarget(new TargetOpponent());
    }

    public StruggleForSanity(final StruggleForSanity card) {
        super(card);
    }

    @Override
    public StruggleForSanity copy() {
        return new StruggleForSanity(this);
    }
}

class StruggleForSanityEffect extends OneShotEffect {

    public StruggleForSanityEffect() {
        super(Outcome.Discard); // kind of
        this.staticText = "Target opponent reveals his or her hand. That player exiles a card from it, then you exile a card from it. Repeat this process until all cards in that hand have been exiled. That player returns the cards he or she exiled this way to his or her hand and puts the rest into his or her graveyard";
    }

    public StruggleForSanityEffect(final StruggleForSanityEffect effect) {
        super(effect);
    }

    @Override
    public StruggleForSanityEffect copy() {
        return new StruggleForSanityEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player targetPlayer = game.getPlayer(getTargetPointer().getFirst(game, source));
        MageObject sourceObject = source.getSourceObject(game);
        Player controller = game.getPlayer(source.getControllerId());
        if (targetPlayer == null || sourceObject == null || controller == null) {
            return false;
        }
        targetPlayer.revealCards(sourceObject.getIdName(), targetPlayer.getHand(), game);

        Cards cardsLeft = new CardsImpl(targetPlayer.getHand());
        Cards exiledByController = new CardsImpl();
        UUID exileZoneController = UUID.randomUUID();
        Cards exiledByOpponent = new CardsImpl();
        UUID exileZoneOpponent = UUID.randomUUID();
        boolean opponentsChoice = true;
        TargetCard target = new TargetCard(Zone.HAND, new FilterCard("a card to exile"));
        while (!cardsLeft.isEmpty()) {
            if (opponentsChoice) {
                targetPlayer.choose(Outcome.ReturnToHand, cardsLeft, target, game);
                Card card = game.getCard(target.getFirstTarget());
                if (card != null) {
                    exiledByOpponent.add(card);
                    cardsLeft.remove(card);
                    targetPlayer.moveCardsToExile(card, source, game, true, exileZoneOpponent, sourceObject.getIdName() + " exiled by " + targetPlayer.getName());
                }
            } else {
                controller.choose(Outcome.Discard, cardsLeft, target, game);
                Card card = game.getCard(target.getFirstTarget());
                if (card != null) {
                    exiledByController.add(card);
                    cardsLeft.remove(card);
                    controller.moveCardsToExile(card, source, game, true, exileZoneController, sourceObject.getIdName() + " exiled by " + controller.getName());
                }
            }
            target.clearChosen();
            opponentsChoice = !opponentsChoice;

        }
        targetPlayer.moveCards(exiledByOpponent, Zone.HAND, source, game);
        targetPlayer.moveCards(exiledByController, Zone.GRAVEYARD, source, game);
        return true;
    }
}
