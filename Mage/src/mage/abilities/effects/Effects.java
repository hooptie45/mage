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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mage.abilities.Mode;
import mage.constants.Outcome;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class Effects extends ArrayList<Effect> {

    public Effects() {}

    public Effects(final Effects effects) {
        for (Effect effect: effects) {
            this.add(effect.copy());
        }
    }

    public Effects copy() {
        return new Effects(this);
    }

    public String getText(Mode mode) {
        StringBuilder sbText = new StringBuilder();
        String rule = null;
        for (Effect effect: this) {
            String endString = "";
            if (rule != null && rule.length()> 3 && !rule.endsWith(".")) {
                endString = ". ";
            }
            rule = effect.getText(mode);
            if (rule != null) {
                if (rule.startsWith("and ")) {
                    endString = " ";
                } else if (rule.startsWith(",")) {
                    endString = "";
                }
                sbText.append(endString).append(rule);
            }
        }
        if (rule != null && rule.length()> 3 && !rule.endsWith(".") && !rule.endsWith("\"") && !rule.startsWith("<b>Level ")) {
            sbText.append(".");
        }
        return sbText.toString();
    }

    public boolean hasOutcome(Outcome outcome) {
        for (Effect effect: this) {
            if (effect.getOutcome() == outcome) {
                return true;
            }
        }
        return false;
    }

    public List<Outcome> getOutcomes() {
        Set<Outcome> outcomes = new HashSet<>();
        for (Effect effect: this) {
            outcomes.add(effect.getOutcome());
        }
        return new ArrayList(outcomes);
    }

    public int getOutcomeTotal() {
        int total = 0;
        for (Effect effect: this) {
            if (effect.getOutcome().isGood()) {
                total++;
            }
            else {
                total--;
            }
        }
        return total;
    }

    public void newId() {
        for (Effect effect: this) {
            effect.newId();
        }
    }
}
