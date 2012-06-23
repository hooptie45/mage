/*
 *  Copyright 2011 BetaSteward_at_googlemail.com. All rights reserved.
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

package mage.sets.mirrodinbesieged;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Duration;
import mage.Constants.Outcome;
import mage.Constants.Rarity;
import mage.Constants.Zone;
import mage.MageInt;
import mage.MageObject;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.ReplacementEffectImpl;
import mage.cards.CardImpl;
import mage.choices.Choice;
import mage.choices.ChoiceImpl;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.GameEvent.EventType;
import mage.players.Player;
import mage.sets.Sets;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class PhyrexianRevoker extends CardImpl<PhyrexianRevoker> {

    public PhyrexianRevoker(UUID ownerId) {
        super(ownerId, 122, "Phyrexian Revoker", Rarity.RARE, new CardType[]{CardType.ARTIFACT, CardType.CREATURE}, "{2}");
        this.expansionSetCode = "MBS";
        this.subtype.add("Horror");
        this.power = new MageInt(2);
        this.toughness = new MageInt(1);

        // As Phyrexian Revoker enters the battlefield, name a nonland card.
        this.addAbility(new EntersBattlefieldTriggeredAbility(new PhyrexianRevokerEffect1()));

        // Activated abilities of sources with the chosen name can't be activated.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new PhyrexianRevokerEffect2()));
    }

    public PhyrexianRevoker(final PhyrexianRevoker card) {
        super(card);
    }

    @Override
    public PhyrexianRevoker copy() {
        return new PhyrexianRevoker(this);
    }

}

class PhyrexianRevokerEffect1 extends OneShotEffect<PhyrexianRevokerEffect1> {

    public PhyrexianRevokerEffect1() {
        super(Outcome.Detriment);
        staticText = "name a nonland card";
    }

    public PhyrexianRevokerEffect1(final PhyrexianRevokerEffect1 effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        if (controller != null) {
            Choice cardChoice = new ChoiceImpl();
            cardChoice.setChoices(Sets.getNonLandCardNames());
            cardChoice.clearChoice();
            while (!controller.choose(Outcome.Detriment, cardChoice, game)) {
                game.debugMessage("player canceled choosing name. retrying.");
            }
            String cardName = cardChoice.getChoice();
            game.informPlayers("Phyrexian Revoker, named card: [" + cardName + "]");
            game.getState().setValue(source.getSourceId().toString(), cardName);
        }        
        return false;
    }

    @Override
    public PhyrexianRevokerEffect1 copy() {
        return new PhyrexianRevokerEffect1(this);
    }

}

class PhyrexianRevokerEffect2 extends ReplacementEffectImpl<PhyrexianRevokerEffect2> {

    public PhyrexianRevokerEffect2() {
        super(Duration.WhileOnBattlefield, Outcome.Detriment);
        staticText = "Activated abilities of sources with the chosen name can't be activated";
    }

    public PhyrexianRevokerEffect2(final PhyrexianRevokerEffect2 effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        return true;
    }

    @Override
    public PhyrexianRevokerEffect2 copy() {
        return new PhyrexianRevokerEffect2(this);
    }

    @Override
    public boolean replaceEvent(GameEvent event, Ability source, Game game) {
        return true;
    }

    @Override
    public boolean applies(GameEvent event, Ability source, Game game) {
        if (event.getType() == EventType.ACTIVATE_ABILITY) {
            MageObject object = game.getObject(event.getSourceId());
            if (object != null && object.getName().equals(game.getState().getValue(source.getSourceId().toString()))) {
                return true;
            }
        }
        return false;
    }

}
