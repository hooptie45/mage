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
package mage.sets.fatereforged;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.AttacksTriggeredAbility;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.keyword.DashAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.game.Game;
import mage.players.Player;
import mage.players.Players;
/**
 *
 * @author fireshoes
 */
public class MarduShadowspear extends CardImpl {

    public MarduShadowspear(UUID ownerId) {
        super(ownerId, 74, "Mardu Shadowspear", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{B}");
        this.expansionSetCode = "FRF";
        this.subtype.add("Human");
        this.subtype.add("Warrior");
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // Whenever Mardu Shadowspear attacks, each opponent loses 1 life.
        this.addAbility(new AttacksTriggeredAbility(new MarduShadowspearLoseLifeEffect(), false));
        // Dash {1}{B}
        this.addAbility(new DashAbility(this, "{1}{B}"));
    }

    public MarduShadowspear(final MarduShadowspear card) {
        super(card);
    }

    @Override
    public MarduShadowspear copy() {
        return new MarduShadowspear(this);
    }
}

class MarduShadowspearLoseLifeEffect extends OneShotEffect {

    private static final String effectText = "each opponent loses 1 life";

    MarduShadowspearLoseLifeEffect ( ) {
        super(Outcome.Damage);
        staticText = effectText;
    }

    MarduShadowspearLoseLifeEffect ( MarduShadowspearLoseLifeEffect effect ) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Players players = game.getPlayers();

        for ( Player player : players.values() ) {
            if ( !player.getId().equals(source.getControllerId()) ) {
                player.loseLife(1, game);
            }
        }

        return true;
    }

    @Override
    public MarduShadowspearLoseLifeEffect copy() {
        return new MarduShadowspearLoseLifeEffect(this);
    }

}