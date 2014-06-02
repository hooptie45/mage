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
package mage.sets.theros;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.continious.BoostEnchantedEffect;
import mage.abilities.effects.common.combat.CantBeBlockedByOneEffect;
import mage.abilities.effects.common.continious.GainAbilityAttachedEffect;
import mage.abilities.keyword.BestowAbility;
import mage.cards.CardImpl;
import mage.constants.AttachmentType;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.Zone;

/**
 *
 * @author LevelX2
 */
public class PurphorossEmissary extends CardImpl {

    public PurphorossEmissary(UUID ownerId) {
        super(ownerId, 136, "Purphoros's Emissary", Rarity.UNCOMMON, new CardType[]{CardType.ENCHANTMENT, CardType.CREATURE}, "{3}{R}");
        this.expansionSetCode = "THS";
        this.subtype.add("Ox");

        this.color.setRed(true);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // Bestow {6}{R}  (If you cast this card for its bestow cost, it's an Aura spell with enchant creature. It becomes a creature again if it's not attached to a creature.)
        this.addAbility(new BestowAbility(this, "{6}{R}"));
        // Purphoros's Emissary can't be blocked except by two or more creatures.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new CantBeBlockedByOneEffect(2)));
        // Enchanted creature gets +3/+3 and can't be blocked except by two or more creatures.
        Ability ability = new SimpleStaticAbility(Zone.BATTLEFIELD, new BoostEnchantedEffect(3,3));
        Effect effect = new GainAbilityAttachedEffect(new SimpleStaticAbility(Zone.BATTLEFIELD, new CantBeBlockedByOneEffect(2)), AttachmentType.AURA);
        effect.setText("and can't be blocked except by two or more creatures");
        ability.addEffect(effect);
        this.addAbility(ability);
    }

    public PurphorossEmissary(final PurphorossEmissary card) {
        super(card);
    }

    @Override
    public PurphorossEmissary copy() {
        return new PurphorossEmissary(this);
    }
}
