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

package mage.sets.zendikar;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Duration;
import mage.Constants.Rarity;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.abilities.effects.common.GainAbilityTargetEffect;
import mage.abilities.effects.common.GainControlTargetEffect;
import mage.abilities.effects.common.UntapTargetEffect;
import mage.abilities.keyword.HasteAbility;
import mage.cards.CardImpl;
import mage.counters.common.PlusOneCounter;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author maurer.it_at_gmail.com
 */
public class MarkofMutiny extends CardImpl<MarkofMutiny> {

    public MarkofMutiny (UUID ownerId) {
        super(ownerId, 137, "Mark of Mutiny", Rarity.UNCOMMON, new CardType[]{CardType.SORCERY}, "{2}{R}");
        this.expansionSetCode = "ZEN";
        
		this.color.setRed(true);
		this.getSpellAbility().addTarget(new TargetCreaturePermanent());
        this.getSpellAbility().addEffect(new GainControlTargetEffect(Duration.EndOfTurn));
		this.getSpellAbility().addEffect(new AddCountersTargetEffect(new PlusOneCounter()));
		this.getSpellAbility().addEffect(new GainAbilityTargetEffect(HasteAbility.getInstance(), Duration.EndOfTurn));
		this.getSpellAbility().addEffect(new UntapTargetEffect());
    }

    public MarkofMutiny (final MarkofMutiny card) {
        super(card);
    }

    @Override
    public MarkofMutiny copy() {
        return new MarkofMutiny(this);
    }

}
