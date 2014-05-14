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
package mage.sets.mirage;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.costs.mana.ManaCost;
import mage.abilities.costs.mana.ManaCosts;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.filter.common.FilterCreatureCard;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.common.TargetCardInHand;
import mage.util.CardUtil;

/**
 *
 * @author Quercitron
 */
public class Flash extends CardImpl<Flash> {

    public Flash(UUID ownerId) {
        super(ownerId, 66, "Flash", Rarity.RARE, new CardType[]{CardType.INSTANT}, "{1}{U}");
        this.expansionSetCode = "MIR";

        this.color.setBlue(true);

        // You may put a creature card from your hand onto the battlefield. If you do, sacrifice it unless you pay its mana cost reduced by up to {2}.
        this.getSpellAbility().addEffect(new FlashEffect());
    }

    public Flash(final Flash card) {
        super(card);
    }

    @Override
    public Flash copy() {
        return new Flash(this);
    }
}

class FlashEffect extends OneShotEffect<FlashEffect> {
    
    private static final String choiceText = "Put a creature card from your hand onto the battlefield?";

    public FlashEffect() {
        super(Outcome.PutCreatureInPlay);
        this.staticText = "You may put a creature card from your hand onto the battlefield. If you do, sacrifice it unless you pay its mana cost reduced by up to {2}.";
    }

    public FlashEffect(final FlashEffect effect) {
        super(effect);
    }

    @Override
    public FlashEffect copy() {
        return new FlashEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        if (player == null || !player.chooseUse(Outcome.PutCreatureInPlay, choiceText, game)) {
            return false;
        }

        TargetCardInHand target = new TargetCardInHand(new FilterCreatureCard());
        if (player.choose(Outcome.PutCreatureInPlay, target, source.getSourceId(), game)) {
            Card card = game.getCard(target.getFirstTarget());
            if (card != null) {
                card.putOntoBattlefield(game, Zone.HAND, source.getId(), source.getControllerId());
                
                ManaCosts<ManaCost> reducedCost = CardUtil.removeVariableManaCost(CardUtil.reduceCost(card.getManaCost(), 2));
                StringBuilder sb = new StringBuilder("Pay ").append(reducedCost.getText()).append("?");
                if (player.chooseUse(Outcome.Benefit, sb.toString(), game)) {
                    reducedCost.clearPaid();
                    if (reducedCost.pay(source, game, source.getSourceId(), source.getControllerId(), false)) {
                        return true;
                    }
                }
                
                Permanent permanent = game.getPermanent(card.getId());
                if (permanent != null) {
                    permanent.sacrifice(source.getSourceId(), game);
                }
                
                return true;
            }
        }
        return false;
    }
    
}
