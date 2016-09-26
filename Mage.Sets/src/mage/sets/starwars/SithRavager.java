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
package mage.sets.starwars;

import java.util.UUID;
import mage.MageInt;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.keyword.HasteAbility;
import mage.abilities.keyword.TrampleAbility;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.DamagedPlayerEvent;
import mage.game.events.GameEvent;

/**
 *
 * @author Styxo
 */
public class SithRavager extends CardImpl {

    public SithRavager(UUID ownerId) {
        super(ownerId, 122, "Sith Ravager", Rarity.NA/*COMMON*/, new CardType[]{CardType.CREATURE}, "{3}{R}");
        this.expansionSetCode = "SWS";
        this.subtype.add("Human");
        this.subtype.add("Sith");
        this.power = new MageInt(4);
        this.toughness = new MageInt(2);

        // <i>Hate</i> &mdash; Whenever an opponent loses life from a source other than combat damage, Sith Ravager gains haste and trample until end of turn.
        this.addAbility(new LostNonCombatLifeTriggeredAbility());
    }

    public SithRavager(final SithRavager card) {
        super(card);
    }

    @Override
    public SithRavager copy() {
        return new SithRavager(this);
    }

    public class LostNonCombatLifeTriggeredAbility extends TriggeredAbilityImpl {

        public LostNonCombatLifeTriggeredAbility() {
            super(Zone.BATTLEFIELD, new GainAbilitySourceEffect(HasteAbility.getInstance(), Duration.EndOfTurn), false);
            addEffect(new GainAbilitySourceEffect(TrampleAbility.getInstance(), Duration.EndOfTurn));
        }

        public LostNonCombatLifeTriggeredAbility(final LostNonCombatLifeTriggeredAbility ability) {
            super(ability);
        }

        @Override
        public LostNonCombatLifeTriggeredAbility copy() {
            return new LostNonCombatLifeTriggeredAbility(this);
        }

        @Override
        public boolean checkEventType(GameEvent event, Game game) {
            return event.getType() == GameEvent.EventType.DAMAGED_PLAYER
                    || event.getType() == GameEvent.EventType.LOST_LIFE;
        }

        @Override
        public boolean checkTrigger(GameEvent event, Game game) {
            // ON DAMAGE TRIGGER TWICE
            if (event.getType() == GameEvent.EventType.LOST_LIFE) {
                game.informPlayers("LOST LIFE TRIGGER");
            }
            if (event.getType() == GameEvent.EventType.DAMAGED_PLAYER) {
                game.informPlayers("DAMAGED PLAYER TRIGGER " + ((DamagedPlayerEvent) event).isCombatDamage());
            }

            if (event.getType() == GameEvent.EventType.DAMAGED_PLAYER) {
                return !((DamagedPlayerEvent) event).isCombatDamage() && game.getOpponents(game.getControllerId(sourceId)).contains(event.getPlayerId());
            } else if (event.getType() == GameEvent.EventType.LOST_LIFE) {
                return game.getOpponents(game.getControllerId(sourceId)).contains(event.getPlayerId());
            }
            return false;
        }

        @Override
        public String getRule() {
            return "<i>Hate</i> &mdash; Whenever an opponent loses life from a source other than combat damage, Sith Ravager gains haste and trample until end of turn";
        }

    }
}
