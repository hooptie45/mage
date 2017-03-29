/*
 * Copyright 2011 BetaSteward_at_googlemail.com. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets;

import java.util.ArrayList;
import java.util.List;
import mage.cards.CardGraphicInfo;
import mage.cards.ExpansionSet;
import mage.cards.repository.CardCriteria;
import mage.cards.repository.CardInfo;
import mage.cards.repository.CardRepository;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 *
 * @author fireshoes
 */
public class Amonkhet extends ExpansionSet {

    private static final Amonkhet instance = new Amonkhet();

    public static Amonkhet getInstance() {
        return instance;
    }

    protected final List<CardInfo> savedSpecialLand = new ArrayList<>();

    private Amonkhet() {
        super("Amonkhet", "AKH", ExpansionSet.buildDate(2017, 4, 28), SetType.EXPANSION);
        this.blockName = "Amonkhet";
        this.hasBoosters = true;
        this.hasBasicLands = true;
        this.numBoosterLands = 1;
        this.numBoosterCommon = 10;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 8;
        this.maxCardNumberInBooster = 269;
        this.ratioBoosterSpecialLand = 144;

        cards.add(new SetCardInfo("Ancient Crab", 40, Rarity.COMMON, mage.cards.a.AncientCrab.class));
        cards.add(new SetCardInfo("Angler Drake", 41, Rarity.UNCOMMON, mage.cards.a.AnglerDrake.class));
        cards.add(new SetCardInfo("Archfiend of Ifnir", 78, Rarity.RARE, mage.cards.a.ArchfiendOfIfnir.class));
        cards.add(new SetCardInfo("Cursed Minotaur", 85, Rarity.COMMON, mage.cards.c.CursedMinotaur.class));
        cards.add(new SetCardInfo("Dune Beetle", 89, Rarity.COMMON, mage.cards.d.DuneBeetle.class));
        cards.add(new SetCardInfo("Fling", 132, Rarity.COMMON, mage.cards.f.Fling.class));
        cards.add(new SetCardInfo("Forest", 254, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Giant Spider", 166, Rarity.COMMON, mage.cards.g.GiantSpider.class));
        cards.add(new SetCardInfo("Gideon, Martial Paragon", 270, Rarity.MYTHIC, mage.cards.g.GideonMartialParagon.class));
        cards.add(new SetCardInfo("Graceful Cat", 273, Rarity.COMMON, mage.cards.g.GracefulCat.class));
        cards.add(new SetCardInfo("Gravedigger", 93, Rarity.UNCOMMON, mage.cards.g.Gravedigger.class));
        cards.add(new SetCardInfo("Hyena Pack", 139, Rarity.COMMON, mage.cards.h.HyenaPack.class));
        cards.add(new SetCardInfo("Impeccable Timing", 18, Rarity.COMMON, mage.cards.i.ImpeccableTiming.class));
        cards.add(new SetCardInfo("Island", 251, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Liliana, Death Wielder", 274, Rarity.MYTHIC, mage.cards.l.LilianaDeathWielder.class));
        cards.add(new SetCardInfo("Miasma Mummy", 100, Rarity.COMMON, mage.cards.m.MiasmaMummy.class));
        cards.add(new SetCardInfo("Mighty Leap", 20, Rarity.COMMON, mage.cards.m.MightyLeap.class));
        cards.add(new SetCardInfo("Mountain", 253, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Oracle's Vault", 234, Rarity.RARE, mage.cards.o.OraclesVault.class));
        cards.add(new SetCardInfo("Plains", 250, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Sixth Sense", 187, Rarity.UNCOMMON, mage.cards.s.SixthSense.class));
        cards.add(new SetCardInfo("Spidery Grasp", 188, Rarity.COMMON, mage.cards.s.SpideryGrasp.class));
        cards.add(new SetCardInfo("Swamp", 252, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Tattered Mummy", 278, Rarity.COMMON, mage.cards.t.TatteredMummy.class));
    }

    @Override
    public List<CardInfo> getSpecialLand() {
        if (savedSpecialLand.isEmpty()) {
            CardCriteria criteria = new CardCriteria();
            criteria.setCodes("MPS");
            criteria.minCardNumber(31);
            criteria.maxCardNumber(54);
            savedSpecialLand.addAll(CardRepository.instance.findCards(criteria));
        }

        return new ArrayList<>(savedSpecialLand);
    }
}
