package org.mage.test.cards.continuous;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

/**
 * Angel of Jubilation
 *   Other nonblack creatures you control get +1/+1.
 *   Players can't pay life or sacrifice creatures to cast spells or activate abilities
 *
 * @author noxx
 */
public class AngelOfJubilationTest extends CardTestPlayerBase {

    /**
     * Tests boosting other non black creatures
     */
    @Test
    public void testBoost() {
        addCard(Zone.BATTLEFIELD, playerA, "Angel of Jubilation");
        addCard(Zone.BATTLEFIELD, playerA, "Devout Chaplain");
        addCard(Zone.BATTLEFIELD, playerA, "Corpse Traders");

        setStopAt(1, PhaseStep.BEGIN_COMBAT);
        execute();

        assertLife(playerA, 20);
        assertLife(playerB, 20);

        assertPowerToughness(playerA, "Angel of Jubilation", 3, 3);
        assertPowerToughness(playerA, "Devout Chaplain", 3, 3);
        assertPowerToughness(playerA, "Corpse Traders", 3, 3);
    }

    /**
     * Tests boost disappeared on leaving battlefield
     */
    @Test
    public void testNoBoostOnBattlefieldLeave() {
        addCard(Zone.BATTLEFIELD, playerA, "Angel of Jubilation");
        addCard(Zone.BATTLEFIELD, playerA, "Devout Chaplain");
        addCard(Zone.BATTLEFIELD, playerA, "Corpse Traders");

        addCard(Zone.HAND, playerA, "Lightning Bolt");
        addCard(Zone.BATTLEFIELD, playerA, "Mountain");

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Lightning Bolt", "Angel of Jubilation");

        setStopAt(1, PhaseStep.BEGIN_COMBAT);
        execute();

        assertLife(playerA, 20);
        assertLife(playerB, 20);

        assertPermanentCount(playerA, "Angel of Jubilation", 0);
        assertPowerToughness(playerA, "Devout Chaplain", 2, 2);
        assertPowerToughness(playerA, "Corpse Traders", 3, 3);
    }

}
