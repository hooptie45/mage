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
package mage.sets.tempest;

import java.util.UUID;

import mage.Mana;
import mage.abilities.common.BeginningOfPreCombatMainTriggeredAbility;
import mage.abilities.effects.common.AddManaToManaPoolTargetControllerEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.TargetController;
import mage.constants.Zone;

/**
 *
 * @author LevelX2
 */
public class EladamrisVineyard extends CardImpl {

    public EladamrisVineyard(UUID ownerId) {
        super(ownerId, 118, "Eladamri's Vineyard", Rarity.RARE, new CardType[]{CardType.ENCHANTMENT}, "{G}");
        this.expansionSetCode = "TMP";


        // At the beginning of each player's precombat main phase, add {G}{G} to that player's mana pool.
        this.addAbility(new BeginningOfPreCombatMainTriggeredAbility(
                Zone.BATTLEFIELD, new AddManaToManaPoolTargetControllerEffect(Mana.GreenMana(2), "that player's"), TargetController.ANY, false, true));
    }

    public EladamrisVineyard(final EladamrisVineyard card) {
        super(card);
    }

    @Override
    public EladamrisVineyard copy() {
        return new EladamrisVineyard(this);
    }
}
