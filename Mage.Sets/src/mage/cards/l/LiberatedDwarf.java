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

import java.util.UUID;
import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.continuous.BoostTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.keyword.FirstStrikeAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Zone;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.ColorPredicate;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author LoneFox
 */
public class LiberatedDwarf extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("green creature");

    static {
        filter.add(new ColorPredicate(ObjectColor.GREEN));
    }

    public LiberatedDwarf(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{R}");
        this.subtype.add("Dwarf");
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // {R}, Sacrifice Liberated Dwarf: Target green creature gets +1/+0 and gains first strike until end of turn.
        Effect effect = new BoostTargetEffect(1, 0, Duration.EndOfTurn);
        effect.setText("Target green creature gets +1/+0");
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, effect, new ManaCostsImpl("{R}"));                                                                                                     ability.addCost(new SacrificeSourceCost());
        effect = new GainAbilityTargetEffect(FirstStrikeAbility.getInstance(), Duration.EndOfTurn);
        effect.setText("and gains first strike until end of turn");
        ability.addEffect(effect);
        ability.addTarget(new TargetCreaturePermanent(filter));
        this.addAbility(ability);
    }

    public LiberatedDwarf(final LiberatedDwarf card) {
        super(card);
    }

    @Override
    public LiberatedDwarf copy() {
        return new LiberatedDwarf(this);
    }
}
