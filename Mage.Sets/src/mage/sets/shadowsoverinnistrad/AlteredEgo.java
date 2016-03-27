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
package mage.sets.shadowsoverinnistrad;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.CantBeCounteredAbility;
import mage.abilities.common.EntersBattlefieldAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.CopyPermanentEffect;
import mage.abilities.effects.common.EntersBattlefieldWithXCountersEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.counters.CounterType;
import mage.filter.common.FilterCreaturePermanent;

/**
 *
 * @author LevelX2
 */
public class AlteredEgo extends CardImpl {

    public AlteredEgo(UUID ownerId) {
        super(ownerId, 241, "Altered Ego", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{X}{2}{G}{U}");
        this.expansionSetCode = "SOI";
        this.subtype.add("Shapeshifter");
        this.power = new MageInt(0);
        this.toughness = new MageInt(0);

        // Altered Ego can't be countered.
        this.addAbility(new CantBeCounteredAbility());

        // You may have Altered Ego enter the battlefield as a copy of any creature on the battlefield, except it enters with an additional X +1/+1 counters on it.
        Effect effect = new CopyPermanentEffect(new FilterCreaturePermanent(), null);
        effect.setText("a copy of any creature on the battlefield");
        EntersBattlefieldAbility ability = new EntersBattlefieldAbility(effect, true);
        effect = new EntersBattlefieldWithXCountersEffect(CounterType.P1P1.createInstance());
        effect.setText(", except it enters with an additional X +1/+1 counters on it");
        ability.addEffect(effect);
        this.addAbility(ability);
    }

    public AlteredEgo(final AlteredEgo card) {
        super(card);
    }

    @Override
    public AlteredEgo copy() {
        return new AlteredEgo(this);
    }
}
