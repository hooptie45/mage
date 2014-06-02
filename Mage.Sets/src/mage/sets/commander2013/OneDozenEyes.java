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
package mage.sets.commander2013;

import java.util.UUID;
import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.Mode;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.keyword.EntwineAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.game.permanent.token.InsectToken;
import mage.game.permanent.token.Token;

/**
 *
 * @author LevelX2
 */
public class OneDozenEyes extends CardImpl {

    public OneDozenEyes(UUID ownerId) {
        super(ownerId, 159, "One Dozen Eyes", Rarity.UNCOMMON, new CardType[]{CardType.SORCERY}, "{5}{G}");
        this.expansionSetCode = "C13";

        this.color.setGreen(true);

        // Choose one -
        this.getSpellAbility().getModes().setMinModes(1);
        this.getSpellAbility().getModes().setMaxModes(1);
        // Put a 5/5 green Beast creature token onto the battlefield;
        this.getSpellAbility().addEffect(new CreateTokenEffect(new OneDozenEyesBeastToken()));
        // or put five 1/1 green Insect creature tokens onto the battlefield.
        Mode mode = new Mode();
        mode.getEffects().add(new CreateTokenEffect(new InsectToken(),5));
        this.getSpellAbility().addMode(mode);
        // Entwine {G}{G}{G}
        this.addAbility(new EntwineAbility("{G}{G}{G}"));
    }

    public OneDozenEyes(final OneDozenEyes card) {
        super(card);
    }

    @Override
    public OneDozenEyes copy() {
        return new OneDozenEyes(this);
    }
}

class OneDozenEyesBeastToken extends Token {

    public OneDozenEyesBeastToken() {
        super("Beast", "5/5 green Beast creature token");
        cardType.add(CardType.CREATURE);
        color = ObjectColor.GREEN;
        subtype.add("Beast");
        power = new MageInt(5);
        toughness = new MageInt(5);
    }

}
