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
package mage.sets.shadowmoor;

import java.util.UUID;
import mage.ObjectColor;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.RestrictionEffect;
import mage.abilities.effects.common.combat.CantBlockAllEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.CardTypePredicate;
import mage.filter.predicate.mageobject.ColorPredicate;
import mage.filter.predicate.permanent.ControllerIdPredicate;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.TargetPlayer;

/**
 *
 * @author jeffwadsworth
 */
public class EmberGale extends CardImpl {

    public EmberGale(UUID ownerId) {
        super(ownerId, 91, "Ember Gale", Rarity.COMMON, new CardType[]{CardType.SORCERY}, "{3}{R}");
        this.expansionSetCode = "SHM";

        this.color.setRed(true);

        // Creatures target player controls can't block this turn. Ember Gale deals 1 damage to each white and/or blue creature that player controls.
        this.getSpellAbility().addTarget(new TargetPlayer());
        this.getSpellAbility().addEffect(new EmberGaleEffect());

    }

    public EmberGale(final EmberGale card) {
        super(card);
    }

    @Override
    public EmberGale copy() {
        return new EmberGale(this);
    }
}

class EmberGaleEffect extends OneShotEffect {

    public EmberGaleEffect() {
        super(Outcome.Detriment);
        staticText = "Creatures target player controls can't block this turn. {this} deals 1 damage to each white and/or blue creature that player controls";
    }

    public EmberGaleEffect(final EmberGaleEffect effect) {
        super(effect);
    }

    @Override
    public EmberGaleEffect copy() {
        return new EmberGaleEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player targetPlayer = game.getPlayer(source.getFirstTarget());
        if (targetPlayer != null) {
            FilterCreaturePermanent filter = new FilterCreaturePermanent();
            filter.add(new ControllerIdPredicate(targetPlayer.getId()));
            RestrictionEffect effect = new CantBlockAllEffect(filter, Duration.EndOfTurn);
            game.addEffect(effect, source);
            FilterPermanent filter2 = new FilterPermanent();
            filter2.add(new ControllerIdPredicate(targetPlayer.getId()));
            filter2.add(Predicates.or(new ColorPredicate(ObjectColor.WHITE),
                    new ColorPredicate(ObjectColor.BLUE)));
            filter2.add(new CardTypePredicate(CardType.CREATURE));
            for (Permanent creature : game.getBattlefield().getAllActivePermanents(filter2, targetPlayer.getId(), game)) {
                creature.damage(1, source.getSourceId(), game, true, false);
            }
            return true;
        }
        return false;
    }
}
