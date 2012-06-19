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
package mage.sets.innistrad;

import java.util.UUID;
import mage.Constants;
import mage.Constants.CardType;
import mage.Constants.Outcome;
import mage.Constants.Rarity;
import mage.abilities.Ability;
import mage.abilities.SpellAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.CostModificationEffectImpl;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.game.Game;
import mage.players.Player;
import mage.util.CardUtil;

/**
 *
 * @author BetaSteward
 */
public class RooftopStorm extends CardImpl<RooftopStorm> {

    public RooftopStorm(UUID ownerId) {
        super(ownerId, 71, "Rooftop Storm", Rarity.RARE, new CardType[]{CardType.ENCHANTMENT}, "{5}{U}");
        this.expansionSetCode = "ISD";

        this.color.setBlue(true);

        // You may pay {0} rather than pay the mana cost for Zombie creature spells you cast.
        this.addAbility(new SimpleStaticAbility(Constants.Zone.BATTLEFIELD, new RooftopStormCostReductionEffect()));

    }

    public RooftopStorm(final RooftopStorm card) {
        super(card);
    }

    @Override
    public RooftopStorm copy() {
        return new RooftopStorm(this);
    }
}

//class RooftopStormAlternativeCost extends AlternativeCostImpl<RooftopStormAlternativeCost> {
//
//    public RooftopStormAlternativeCost() {
//        super("You may pay {0} rather than pay the mana cost");
//        this.add(new GenericManaCost(0));
//    }
//
//    public RooftopStormAlternativeCost(final RooftopStormAlternativeCost cost) {
//        super(cost);
//    }
//
//    @Override
//    public RooftopStormAlternativeCost copy() {
//        return new RooftopStormAlternativeCost(this);
//    }
//
//    @Override
//    public boolean isAvailable(Game game, Ability source) {
//        return true;
//    }
//
//    @Override
//    public String getText() {
//        return "You may pay {0} rather than pay the mana cost";
//    }
//
//}

class RooftopStormCostReductionEffect extends CostModificationEffectImpl<RooftopStormCostReductionEffect> {

    private static final String effectText = "You may pay {0} rather than pay the mana cost for Zombie creature spells you cast";

    RooftopStormCostReductionEffect() {
        super(Constants.Duration.WhileOnBattlefield, Constants.Outcome.Benefit);
        staticText = effectText;
    }

    RooftopStormCostReductionEffect(RooftopStormCostReductionEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source, Ability abilityToModify) {
        SpellAbility spellAbility = (SpellAbility) abilityToModify;
        CardUtil.adjustCost(spellAbility, 2);
        return true;
    }

    @Override
    public boolean applies(Ability abilityToModify, Ability source, Game game) {
        if (abilityToModify instanceof SpellAbility) {
            SpellAbility spell = (SpellAbility) abilityToModify;
            if (spell.getControllerId().equals(source.getControllerId())) {
                Card sourceCard = game.getCard(spell.getSourceId());
                if (sourceCard != null && sourceCard.getSubtype().contains("Zombie")) {
                    Player player = game.getPlayer(spell.getControllerId());
                    if (player != null && player.chooseUse(Outcome.Benefit, "Pay {0} rather than pay the mana cost for Zombie creature", game)) {
                        spell.getManaCostsToPay().clear();
                        spell.getManaCostsToPay().addAll(new ManaCostsImpl("{0}"));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public RooftopStormCostReductionEffect copy() {
        return new RooftopStormCostReductionEffect(this);
    }

}
