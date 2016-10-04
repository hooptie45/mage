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
package mage.cards.m;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.effects.ContinuousEffect;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.filter.common.FilterCreaturePermanent;
import mage.abilities.effects.common.DontUntapInControllersNextUntapStepTargetEffect;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.TargetPlayer;
import mage.target.targetpointer.FixedTargets;

/**
 *
 * @author djbrez
 */
public class Misstep extends CardImpl {
    
    public Misstep(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{1}{U}");

        // Creatures target player controls don't untap during that player's next untap step.
        this.getSpellAbility().addEffect(new MisstepEffect());
        this.getSpellAbility().addTarget(new TargetPlayer());
    }

    public Misstep(final Misstep card) {
        super(card);
    }

    @Override
    public Misstep copy() {
        return new Misstep(this);
    }
}

class MisstepEffect extends OneShotEffect {
    
    MisstepEffect() {
        super(Outcome.Detriment);
        this.staticText = "Creatures target player controls don't untap during his or her next untap step";
    }
    
    MisstepEffect(final MisstepEffect effect) {
        super(effect);
    }
    
    @Override
    public MisstepEffect copy() {
        return new MisstepEffect(this);
    }
    
    @Override
    public boolean apply(Game game, Ability source) {
    Player player = game.getPlayer(source.getFirstTarget());
         if (player != null) {
         List<Permanent> doNotUntapNextUntapStep = new ArrayList<>();
         for (Permanent creature : game.getBattlefield().getAllActivePermanents(new FilterCreaturePermanent(), player.getId(), game)) {
           doNotUntapNextUntapStep.add(creature); 
        }
        if (!doNotUntapNextUntapStep.isEmpty()) {
                ContinuousEffect effect = new DontUntapInControllersNextUntapStepTargetEffect("", player.getId());
                effect.setText("those creatures don't untap during that player's next untap step");
                effect.setTargetPointer(new FixedTargets(doNotUntapNextUntapStep, game));
                game.addEffect(effect, source);
             }
             return true;
         }
        return false;
    }
}
