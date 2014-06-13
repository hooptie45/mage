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
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.condition.common.KickedCondition;
import mage.abilities.decorator.ConditionalTriggeredAbility;
import mage.abilities.effects.common.SacrificeEffect;
import mage.abilities.keyword.KickerAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.filter.common.FilterControlledPermanent;
import mage.filter.predicate.mageobject.CardTypePredicate;
import mage.target.TargetPlayer;

/**
 *
 * @author maurer.it_at_gmail.com
 */
public class GatekeeperOfMalakir extends CardImpl {

    private static final FilterControlledPermanent filter;

    static {
        filter = new FilterControlledPermanent(" a creature");
        filter.add(new CardTypePredicate(CardType.CREATURE));
    }

    public GatekeeperOfMalakir(UUID ownerId) {
        super(ownerId, 89, "Gatekeeper of Malakir", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{B}{B}");
        this.expansionSetCode = "ZEN";
        this.subtype.add("Vampire");
        this.subtype.add("Warrior");

        this.color.setBlack(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Kicker {B} (You may pay an additional {B} as you cast this spell.)
        this.addAbility(new KickerAbility("{B}"));

        // When Gatekeeper of Malakir enters the battlefield, if it was kicked, target player sacrifices a creature.
        EntersBattlefieldTriggeredAbility ability =
                new EntersBattlefieldTriggeredAbility(new SacrificeEffect(filter, 1, "target player"));
        Ability conditionalAbility = new ConditionalTriggeredAbility(ability, KickedCondition.getInstance(), "When {this} enters the battlefield, if it was kicked, target player sacrifices a creature.");
        conditionalAbility.addTarget(new TargetPlayer());
        this.addAbility(conditionalAbility);
    }

    public GatekeeperOfMalakir(final GatekeeperOfMalakir card) {
        super(card);
    }

    @Override
    public GatekeeperOfMalakir copy() {
        return new GatekeeperOfMalakir(this);
    }
}
