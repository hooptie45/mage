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
package mage.sets.magic2013;

import java.util.UUID;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.MageInt;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.continious.BoostSourceWhileControlsEffect;
import mage.abilities.effects.common.continious.GainAbilitySourceEffect;
import mage.abilities.keyword.HasteAbility;
import mage.cards.CardImpl;
import mage.filter.FilterPermanent;
import mage.filter.predicate.mageobject.SubtypePredicate;

/**
 *
 * @author North
 */
public class FlinthoofBoar extends CardImpl {

    private static final FilterPermanent filter = new FilterPermanent("Mountain");

    static {
        filter.add(new SubtypePredicate("Mountain"));
    }

    public FlinthoofBoar(UUID ownerId) {
        super(ownerId, 171, "Flinthoof Boar", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{1}{G}");
        this.expansionSetCode = "M13";
        this.subtype.add("Boar");

        this.color.setGreen(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Flinthoof Boar gets +1/+1 as long as you control a Mountain.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new BoostSourceWhileControlsEffect(filter, 1, 1)));

        // {R}: Flinthoof Boar gains haste until end of turn.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD,
                new GainAbilitySourceEffect(HasteAbility.getInstance(), Duration.EndOfTurn),
                new ManaCostsImpl("{R}")));
    }

    public FlinthoofBoar(final FlinthoofBoar card) {
        super(card);
    }

    @Override
    public FlinthoofBoar copy() {
        return new FlinthoofBoar(this);
    }
}
