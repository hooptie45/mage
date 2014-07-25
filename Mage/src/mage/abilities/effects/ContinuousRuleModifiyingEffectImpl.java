/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.abilities.effects;

import mage.MageObject;
import mage.abilities.Ability;
import mage.constants.Duration;
import mage.constants.EffectType;
import mage.constants.Outcome;
import mage.game.Game;

/**
 *
 * @author LevelX2
 */
public abstract class ContinuousRuleModifiyingEffectImpl extends ContinuousEffectImpl implements ContinuousRuleModifiyingEffect {

    protected final String infoMessage;
    
    // 613.10
    // Some continuous effects affect game rules rather than objects. For example, effects may modify 
    // a players maximum hand size, or say that a creature must attack this turn if able. These effects
    // are applied after all other continuous effects have been applied. Continuous effects that affect
    // the costs of spells or abilities are applied according to the order specified in rule 601.2e. 
    // All other such effects are applied in timestamp order. See also the rules for timestamp order 
    // and dependency (rules 613.6 and 613.7).
    
    // Some of this rule modifying effects are implemented as normal CONTINUOUS effects using the Layer.RulesEffects.
    // But if the rule change can be implemented simply by preventing an event from happening, CONTINUOUS_RULE_MODIFICATION effects can be used.
    // They work technical like a replacement effect that replaces the event completely. 
    // But player isn't asked to choose order of effects if multiple are applied to the same event.

    public ContinuousRuleModifiyingEffectImpl(Duration duration, Outcome outcome) {
        super(duration, outcome);
        this.effectType = EffectType.CONTINUOUS_RULE_MODIFICATION;
        this.infoMessage = null;
    }

    public ContinuousRuleModifiyingEffectImpl(final ContinuousRuleModifiyingEffectImpl effect) {
        super(effect);
        this.infoMessage = effect.infoMessage;
    }

    @Override
    public String getInfoMessage(Ability source, Game game) {
        if (infoMessage == null) {
            String message = null;
            MageObject object = game.getObject(source.getSourceId());
            if (object != null) {
                message = source.getRule(object.getLogName());
            } else {
                message = source.getRule();
            }            
            return message;
        } else {
            return infoMessage;
        }
    }

}
