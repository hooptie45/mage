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
package mage.sets.darkascension;

import java.util.UUID;

import mage.constants.CardType;
import mage.constants.Rarity;
import mage.MageInt;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.abilities.keyword.IntimidateAbility;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.constants.Zone;
import mage.counters.CounterType;
import mage.game.Game;
import mage.game.events.GameEvent;

/**
 *
 * @author BetaSteward
 */
public class WithengarUnbound extends CardImpl<WithengarUnbound> {

    public WithengarUnbound(UUID ownerId) {
        super(ownerId, 147, "Withengar Unbound", Rarity.MYTHIC, new CardType[]{CardType.CREATURE}, "");
        this.expansionSetCode = "DKA";
        this.supertype.add("Legendary");
        this.subtype.add("Demon");

        // this card is the second face of double-faced card
        this.nightCard = true;
        this.canTransform = true;

        this.power = new MageInt(13);
        this.toughness = new MageInt(13);

        this.addAbility(FlyingAbility.getInstance());
        this.addAbility(IntimidateAbility.getInstance());
        this.addAbility(TrampleAbility.getInstance());
        // Whenever a player loses the game, put thirteen +1/+1 counters on Withengar Unbound.
        this.addAbility(new WithengarUnboundTriggeredAbility());

    }

    public WithengarUnbound(final WithengarUnbound card) {
        super(card);
    }

    @Override
    public WithengarUnbound copy() {
        return new WithengarUnbound(this);
    }
}

class WithengarUnboundTriggeredAbility extends TriggeredAbilityImpl {

    public WithengarUnboundTriggeredAbility() {
        super(Zone.BATTLEFIELD, new AddCountersSourceEffect(CounterType.P1P1.createInstance(13)), false);
    }

    public WithengarUnboundTriggeredAbility(final WithengarUnboundTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public WithengarUnboundTriggeredAbility copy() {
        return new WithengarUnboundTriggeredAbility(this);
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (event.getType() == GameEvent.EventType.LOST)
            return true;
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever a player loses the game, put thirteen +1/+1 counters on Withengar Unbound.";
    }
}