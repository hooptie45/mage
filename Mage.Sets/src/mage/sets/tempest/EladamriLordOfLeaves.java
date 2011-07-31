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
package mage.sets.tempest;

import java.util.UUID;

import mage.Constants;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.continious.GainAbilityAllEffect;
import mage.abilities.keyword.ForestwalkAbility;
import mage.abilities.keyword.ShroudAbility;
import mage.cards.CardImpl;
import mage.filter.Filter;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;

/**
 *
 * @author Loki
 */
public class EladamriLordOfLeaves extends CardImpl<EladamriLordOfLeaves> {

    private final static FilterCreaturePermanent filterCreatures = new FilterCreaturePermanent("Elf creatures");
    private final static FilterPermanent filterPermanents = new FilterPermanent("Elves");

    static {
        filterCreatures.getSubtype().add("Elf");
        filterCreatures.setScopeSubtype(Filter.ComparisonScope.Any);
        filterPermanents.getSubtype().add("Elf");
        filterPermanents.setScopeSubtype(Filter.ComparisonScope.Any);
    }

    public EladamriLordOfLeaves(UUID ownerId) {
        super(ownerId, 117, "Eladamri, Lord of Leaves", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{G}{G}");
        this.expansionSetCode = "TMP";
        this.supertype.add("Legendary");
        this.subtype.add("Elf");
        this.subtype.add("Warrior");
        this.color.setGreen(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);
        this.addAbility(new SimpleStaticAbility(Constants.Zone.BATTLEFIELD, new GainAbilityAllEffect(new ForestwalkAbility(), Constants.Duration.WhileOnBattlefield, filterCreatures, true)));
        this.addAbility(new SimpleStaticAbility(Constants.Zone.BATTLEFIELD, new GainAbilityAllEffect(ShroudAbility.getInstance(), Constants.Duration.WhileOnBattlefield, filterPermanents, true)));
    }

    public EladamriLordOfLeaves(final EladamriLordOfLeaves card) {
        super(card);
    }

    @Override
    public EladamriLordOfLeaves copy() {
        return new EladamriLordOfLeaves(this);
    }
}
