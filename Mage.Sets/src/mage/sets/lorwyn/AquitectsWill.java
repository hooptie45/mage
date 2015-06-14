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
package mage.sets.lorwyn;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.condition.common.PermanentsOnTheBattlefieldCondition;
import mage.abilities.decorator.ConditionalOneShotEffect;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.abilities.mana.BlueManaAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.counters.CounterType;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.target.common.TargetLandPermanent;

/**
 *
 * @author ilcartographer
 */
public class AquitectsWill extends CardImpl {
    private static final String rule = "land is an Island in addition to its other types for as long as it has a flood counter on it.";

    public AquitectsWill(UUID ownerId) {
        super(ownerId, 52, "Aquitect's Will", Rarity.COMMON, new CardType[]{CardType.TRIBAL, CardType.SORCERY}, "{U}");
        this.expansionSetCode = "LRW";
        this.subtype.add("Merfolk");

        // Put a flood counter on target land. That land is an Island in addition to its other types for as long as it has a flood counter on it. If you control a Merfolk, draw a card.
        // Add the flood counter to target land
        this.getSpellAbility().addEffect(new AddCountersTargetEffect(CounterType.FLOOD.createInstance()));
        this.getSpellAbility().addTarget(new TargetLandPermanent());
        
        // Add the Flood counter effect
        Effect effect = new AquitectsWillGainAbilityEffect(
                new BlueManaAbility(),
                Duration.Custom, rule);
        this.getSpellAbility().addEffect(effect);
        
        // Draw if you control a Merfolk
        this.getSpellAbility().addEffect(new ConditionalOneShotEffect(
                new DrawCardSourceControllerEffect(1), 
                new PermanentsOnTheBattlefieldCondition(new FilterControlledCreaturePermanent("Merfolk", "Merfolk")),
                "If you control a Merfolk, draw a card"));
    }

    public AquitectsWill(final AquitectsWill card) {
        super(card);
    }

    @Override
    public AquitectsWill copy() {
        return new AquitectsWill(this);
    }
}

class AquitectsWillGainAbilityEffect extends GainAbilityTargetEffect {

    public AquitectsWillGainAbilityEffect(Ability ability, Duration duration, String rule) {
        super(ability, duration, rule);
    }

    public AquitectsWillGainAbilityEffect(final AquitectsWillGainAbilityEffect effect) {
        super(effect);
    }

    @Override
    public boolean isInactive(Ability source, Game game) {
        Permanent land = game.getPermanent(this.targetPointer.getFirst(game, source));
        if (land != null && land.getCounters().getCount(CounterType.FLOOD) < 1) {
            return true;
        }
        return false;
    }

    @Override
    public AquitectsWillGainAbilityEffect copy() {
        return new AquitectsWillGainAbilityEffect(this);
    }
}