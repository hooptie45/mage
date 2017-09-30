/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mage.abilities.keyword;

import java.io.ObjectStreamException;
import mage.abilities.Ability;
import mage.abilities.EvasionAbility;
import mage.abilities.MageSingleton;
import mage.abilities.effects.RestrictionEffect;
import mage.constants.Duration;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 *
 * @author LevelX2
 */
public class SkulkAbility extends EvasionAbility implements MageSingleton {

    private static final SkulkAbility instance = new SkulkAbility();

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    public static SkulkAbility getInstance() {
        return instance;
    }

    public SkulkAbility() {
        this.addEffect(new SkulkEffect(Duration.WhileOnBattlefield));
    }

    @Override
    public Ability copy() {
        return instance;
    }

    @Override
    public String getRule() {
        return "Skulk <i>(This creature can't be blocked by creatures with greater power.)</i>";
    }
}

class SkulkEffect extends RestrictionEffect {

    public SkulkEffect(Duration duration) {
        super(duration);
        staticText = "Skulk <i>(This creature can't be blocked by creatures with greater power.)</i>";
    }

    public SkulkEffect(final SkulkEffect effect) {
        super(effect);
    }

    @Override
    public boolean applies(Permanent permanent, Ability source, Game game) {
        return permanent.getId().equals(source.getSourceId());
    }

    @Override
    public boolean canBeBlocked(Permanent attacker, Permanent blocker, Ability source, Game game) {
        return blocker.getPower().getValue() <= attacker.getPower().getValue();
    }

    @Override
    public SkulkEffect copy() {
        return new SkulkEffect(this);
    }
}
