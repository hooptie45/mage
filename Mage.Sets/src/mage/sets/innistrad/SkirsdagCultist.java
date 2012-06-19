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

import mage.Constants;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeTargetCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.cards.CardImpl;
import mage.target.common.TargetControlledCreaturePermanent;
import mage.target.common.TargetCreatureOrPlayer;

import java.util.UUID;

/**
 * @author nantuko
 */
public class SkirsdagCultist extends CardImpl<SkirsdagCultist> {

    public SkirsdagCultist(UUID ownerId) {
        super(ownerId, 163, "Skirsdag Cultist", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{2}{R}{R}");
        this.expansionSetCode = "ISD";
        this.subtype.add("Human");
        this.subtype.add("Shaman");

        this.color.setRed(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // {R}, {T}, Sacrifice a creature: Skirsdag Cultist deals 2 damage to target creature or player.
        Ability ability = new SimpleActivatedAbility(Constants.Zone.BATTLEFIELD, new DamageTargetEffect(2), new ManaCostsImpl("{R}"));
        ability.addCost(new TapSourceCost());
        ability.addCost(new SacrificeTargetCost(new TargetControlledCreaturePermanent()));
        ability.addTarget(new TargetCreatureOrPlayer());
        this.addAbility(ability);
    }

    public SkirsdagCultist(final SkirsdagCultist card) {
        super(card);
    }

    @Override
    public SkirsdagCultist copy() {
        return new SkirsdagCultist(this);
    }
}
