/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.mage.abilities.effects.common.turn;

import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.constants.Outcome;
import mage.game.Game;
import mage.game.turn.TurnMod;
import mage.util.CardUtil;

/**
 *
 * @author Mael
 */
public class SkipNextTurnSourceEffect extends OneShotEffect {

    int numberOfTurns;

    public SkipNextTurnSourceEffect() {
        this(1);
    }

    public SkipNextTurnSourceEffect(int numberOfTurns) {
        super(Outcome.Neutral);
        this.numberOfTurns = numberOfTurns;
        staticText = "you skip your next " + (numberOfTurns == 1 ? "turn" : CardUtil.numberToText(numberOfTurns) + " turns");
    }

    public SkipNextTurnSourceEffect(final SkipNextTurnSourceEffect effect) {
        super(effect);
        this.numberOfTurns = effect.numberOfTurns;
    }

    @Override
    public SkipNextTurnSourceEffect copy() {
        return new SkipNextTurnSourceEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        for (int i = 0; i < numberOfTurns; i++) {
            game.getState().getTurnMods().add(new TurnMod(source.getControllerId(), true));
        }
        return true;
    }
}
