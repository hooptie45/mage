/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mage.abilities.keyword;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.DelayedTriggeredAbility;
import mage.abilities.common.AttacksTriggeredAbility;
import mage.abilities.common.delayed.AtTheEndOfCombatDelayedTriggeredAbility;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.ExileTargetEffect;
import mage.abilities.effects.common.PutTokenOntoBattlefieldCopyTargetEffect;
import mage.constants.Outcome;
import mage.constants.SetTargetPointer;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.targetpointer.FixedTarget;

public class MyriadAbility extends AttacksTriggeredAbility {

    public MyriadAbility() {
        super(new MyriadEffect(), false,
                "Myriad <i>(Whenever this creature attacks, for each opponent other than the defending player, put a token that's a copy of this creature onto the battlefield tapped and attacking that player or a planeswalker he or she controls. Exile those tokens at the end of combat.)</i>",
                SetTargetPointer.PLAYER
        );
    }

    public MyriadAbility(final MyriadAbility ability) {
        super(ability);
    }

    @Override
    public MyriadAbility copy() {
        return new MyriadAbility(this);
    }

}

class MyriadEffect extends OneShotEffect {

    public MyriadEffect() {
        super(Outcome.Benefit);
        this.staticText = "for each opponent other than the defending player, you may put a token that's a copy of this creature onto the battlefield tapped and attacking that player or a planeswalker he or she controls. Exile the tokens at the end of combat";
    }

    public MyriadEffect(final MyriadEffect effect) {
        super(effect);
    }

    @Override
    public MyriadEffect copy() {
        return new MyriadEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        Permanent sourceObject = game.getPermanentOrLKIBattlefield(source.getSourceId());
        if (controller != null && sourceObject != null) {
            UUID defendingPlayerId = game.getCombat().getDefendingPlayerId(source.getSourceId(), game);
            for (UUID playerId : game.getState().getPlayersInRange(controller.getId(), game)) {
                if (playerId != defendingPlayerId && controller.hasOpponent(playerId, game)) {
                    Player opponent = game.getPlayer(playerId);
                    if (opponent != null && controller.chooseUse(Outcome.PutCreatureInPlay,
                            "Put a copy of " + sourceObject.getIdName() + " onto battlefield attacking " + opponent.getName() + "?", source, game)) {
                        PutTokenOntoBattlefieldCopyTargetEffect effect = new PutTokenOntoBattlefieldCopyTargetEffect(controller.getId(), null, false, 1, true, true, playerId);
                        effect.setTargetPointer(new FixedTarget(sourceObject, game));
                        effect.apply(game, source);
                        for (Permanent tokenPermanent : effect.getAddedPermanent()) {
                            ExileTargetEffect exileEffect = new ExileTargetEffect();
                            exileEffect.setTargetPointer(new FixedTarget(tokenPermanent, game));
                            DelayedTriggeredAbility delayedAbility = new AtTheEndOfCombatDelayedTriggeredAbility(exileEffect);
                            delayedAbility.setSourceId(source.getSourceId());
                            delayedAbility.setControllerId(source.getControllerId());
                            delayedAbility.setSourceObject(source.getSourceObject(game), game);
                            game.addDelayedTriggeredAbility(delayedAbility);
                        }
                    }
                }

            }
            return true;
        }
        return false;
    }
}
