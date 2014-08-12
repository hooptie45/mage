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
package mage.sets.ninthedition;

import java.util.UUID;
import mage.MageObject;

import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.stack.StackObject;
import mage.target.common.TargetCreatureOrPlayer;

/**
 *
 * @author dustinconrad
 */
public class GuerrillaTactics extends CardImpl {

    public GuerrillaTactics(UUID ownerId) {
        super(ownerId, 196, "Guerrilla Tactics", Rarity.UNCOMMON, new CardType[]{CardType.INSTANT}, "{1}{R}");
        this.expansionSetCode = "9ED";

        this.color.setRed(true);

        // Guerrilla Tactics deals 2 damage to target creature or player.
        this.getSpellAbility().addEffect(new DamageTargetEffect(2));
        this.getSpellAbility().addTarget(new TargetCreatureOrPlayer());
        // When a spell or ability an opponent controls causes you to discard Guerrilla Tactics, Guerrilla Tactics deals 4 damage to target creature or player.
        this.addAbility(new GuerrillaTacticsTriggeredAbility());
    }

    public GuerrillaTactics(final GuerrillaTactics card) {
        super(card);
    }

    @Override
    public GuerrillaTactics copy() {
        return new GuerrillaTactics(this);
    }
}

class GuerrillaTacticsTriggeredAbility extends TriggeredAbilityImpl {

    GuerrillaTacticsTriggeredAbility() {
        super(Zone.ALL, new DamageTargetEffect(4));
        this.addTarget(new TargetCreatureOrPlayer());
    }

    GuerrillaTacticsTriggeredAbility(final GuerrillaTacticsTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public GuerrillaTacticsTriggeredAbility copy() {
        return new GuerrillaTacticsTriggeredAbility(this);
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (GameEvent.EventType.DISCARDED_CARD.equals(event.getType()) 
                && event.getSourceId() != null // can be null if e.g. discard down to hand limit
                && event.getTargetId().equals(getSourceId())
                && event.getPlayerId().equals(getControllerId())) {
            MageObject mageObject = game.getObject(event.getSourceId());
            if (mageObject != null && (mageObject instanceof StackObject)) {
                return game.getOpponents(this.getControllerId()).contains(((StackObject)mageObject).getControllerId());
            }
        }
        return false;
    }

    @Override
    public String getRule() {
        return "When a spell or ability an opponent controls causes you to discard {this}, " + super.getRule();
    }
}
