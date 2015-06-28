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
package mage.sets.futuresight;

import java.util.UUID;

import mage.abilities.Mode;
import mage.abilities.effects.common.counter.AddRemoveAllTimeSuspentCountersEffect;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.counters.Counter;
import mage.counters.CounterType;
import mage.filter.Filter;
import mage.filter.FilterCard;
import mage.filter.predicate.permanent.CounterPredicate;

/**
 *
 * @author Gal Lerman

 */
public class DustOfMoments extends CardImpl {

    private static final Filter<Card> filter = new FilterCard("Has Time Counter Filter");

    static {
        filter.add(new CounterPredicate(CounterType.TIME));
    }

    public DustOfMoments(UUID ownerId) {
        super(ownerId, 5, "Dust of Moments", Rarity.UNCOMMON, new CardType[]{CardType.INSTANT}, "{2}{W}");
        this.expansionSetCode = "FUT";

        // Choose one
        // Remove two time counters from each permanent and each suspended card
        final Counter counter = new Counter(CounterType.TIME.getName(), 2);
        this.getSpellAbility().addEffect(new AddRemoveAllTimeSuspentCountersEffect(counter, filter, true));
        // Or put two time counters on each permanent with a time counter on it and each suspended card
        Mode mode = new Mode();
        mode.getEffects().add(new AddRemoveAllTimeSuspentCountersEffect(counter, filter, false));
        this.getSpellAbility().getModes().addMode(mode);
    }

    public DustOfMoments(final DustOfMoments card) {
        super(card);
    }

    @Override
    public DustOfMoments copy() {
        return new DustOfMoments(this);
    }
}
