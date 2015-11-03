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
package mage.sets.mercadianmasques;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.InfoEffect;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.constants.TargetController;
import mage.constants.Zone;

/**
 *
 * @author LoneFox
 */
public class FlailingOgre extends CardImpl {

    public FlailingOgre(UUID ownerId) {
        super(ownerId, 188, "Flailing Ogre", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{2}{R}");
        this.expansionSetCode = "MMQ";
        this.subtype.add("Ogre");
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // {1}: Flailing Ogre gets +1/+1 until end of turn. Any player may activate this ability.
        SimpleActivatedAbility ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new BoostSourceEffect(1, 1, Duration.EndOfTurn) , new ManaCostsImpl("{1}"));
        ability.setMayActivate(TargetController.ANY);
        ability.addEffect(new InfoEffect("Any player may activate this ability"));
        this.addAbility(ability);
        // {1}: Flailing Ogre gets -1/-1 until end of turn. Any player may activate this ability.
        ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new BoostSourceEffect(-1, -1, Duration.EndOfTurn) , new ManaCostsImpl("{1}"));
        ability.setMayActivate(TargetController.ANY);
        ability.addEffect(new InfoEffect("Any player may activate this ability"));
        this.addAbility(ability);
    }

    public FlailingOgre(final FlailingOgre card) {
        super(card);
    }

    @Override
    public FlailingOgre copy() {
        return new FlailingOgre(this);
    }
}
