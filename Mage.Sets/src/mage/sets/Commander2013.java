/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
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

import mage.cards.ExpansionSet;
import mage.cards.n.NightSoil;
import mage.constants.SetType;
import mage.constants.Rarity;
import mage.cards.CardGraphicInfo;

/**
 *
 * @author LevelX2
 */

public class Commander2013 extends ExpansionSet {

    private static final Commander2013 instance = new Commander2013();

    public static Commander2013 getInstance() {
        return instance;
    }

    private Commander2013() {
        super("Commander 2013 Edition", "C13", ExpansionSet.buildDate(2013, 11, 01), SetType.SUPPLEMENTAL);
        this.blockName = "Command Zone";
        cards.add(new SetCardInfo("Acidic Slime", 134, Rarity.UNCOMMON, mage.cards.a.AcidicSlime.class));
        cards.add(new SetCardInfo("Act of Authority", 1, Rarity.RARE, mage.cards.a.ActOfAuthority.class));
        cards.add(new SetCardInfo("Aerie Mystics", 2, Rarity.UNCOMMON, mage.cards.a.AerieMystics.class));
        cards.add(new SetCardInfo("Aethermage's Touch", 176, Rarity.RARE, mage.cards.a.AethermagesTouch.class));
        cards.add(new SetCardInfo("Ajani's Pridemate", 3, Rarity.UNCOMMON, mage.cards.a.AjanisPridemate.class));
        cards.add(new SetCardInfo("Akoum Refuge", 272, Rarity.UNCOMMON, mage.cards.a.AkoumRefuge.class));
        cards.add(new SetCardInfo("Angel of Finality", 4, Rarity.RARE, mage.cards.a.AngelOfFinality.class));
        cards.add(new SetCardInfo("Annihilate", 68, Rarity.UNCOMMON, mage.cards.a.Annihilate.class));
        cards.add(new SetCardInfo("Arcane Denial", 28, Rarity.COMMON, mage.cards.a.ArcaneDenial.class));
        cards.add(new SetCardInfo("Arcane Melee", 29, Rarity.RARE, mage.cards.a.ArcaneMelee.class));
        cards.add(new SetCardInfo("Arcane Sanctum", 273, Rarity.UNCOMMON, mage.cards.a.ArcaneSanctum.class));
        cards.add(new SetCardInfo("Archangel", 5, Rarity.UNCOMMON, mage.cards.a.Archangel.class));
        cards.add(new SetCardInfo("Armillary Sphere", 235, Rarity.COMMON, mage.cards.a.ArmillarySphere.class));
        cards.add(new SetCardInfo("Army of the Damned", 69, Rarity.MYTHIC, mage.cards.a.ArmyOfTheDamned.class));
        cards.add(new SetCardInfo("Augur of Bolas", 30, Rarity.UNCOMMON, mage.cards.a.AugurOfBolas.class));
        cards.add(new SetCardInfo("Augury Adept", 227, Rarity.RARE, mage.cards.a.AuguryAdept.class));
        cards.add(new SetCardInfo("Avenger of Zendikar", 135, Rarity.MYTHIC, mage.cards.a.AvengerOfZendikar.class));
        cards.add(new SetCardInfo("Azami, Lady of Scrolls", 31, Rarity.RARE, mage.cards.a.AzamiLadyOfScrolls.class));
        cards.add(new SetCardInfo("Azorius Chancery", 274, Rarity.COMMON, mage.cards.a.AzoriusChancery.class));
        cards.add(new SetCardInfo("Azorius Guildgate", 275, Rarity.COMMON, mage.cards.a.AzoriusGuildgate.class));
        cards.add(new SetCardInfo("Azorius Herald", 6, Rarity.UNCOMMON, mage.cards.a.AzoriusHerald.class));
        cards.add(new SetCardInfo("Azorius Keyrune", 236, Rarity.UNCOMMON, mage.cards.a.AzoriusKeyrune.class));
        cards.add(new SetCardInfo("Baleful Force", 70, Rarity.RARE, mage.cards.b.BalefulForce.class));
        cards.add(new SetCardInfo("Baleful Strix", 177, Rarity.UNCOMMON, mage.cards.b.BalefulStrix.class));
        cards.add(new SetCardInfo("Baloth Woodcrasher", 136, Rarity.UNCOMMON, mage.cards.b.BalothWoodcrasher.class));
        cards.add(new SetCardInfo("Bane of Progress", 137, Rarity.RARE, mage.cards.b.BaneOfProgress.class));
        cards.add(new SetCardInfo("Bant Panorama", 276, Rarity.COMMON, mage.cards.b.BantPanorama.class));
        cards.add(new SetCardInfo("Barren Moor", 277, Rarity.COMMON, mage.cards.b.BarrenMoor.class));
        cards.add(new SetCardInfo("Basalt Monolith", 237, Rarity.UNCOMMON, mage.cards.b.BasaltMonolith.class));
        cards.add(new SetCardInfo("Behemoth Sledge", 178, Rarity.UNCOMMON, mage.cards.b.BehemothSledge.class));
        cards.add(new SetCardInfo("Blood Rites", 101, Rarity.UNCOMMON, mage.cards.b.BloodRites.class));
        cards.add(new SetCardInfo("Blue Sun's Zenith", 32, Rarity.RARE, mage.cards.b.BlueSunsZenith.class));
        cards.add(new SetCardInfo("Bojuka Bog", 278, Rarity.COMMON, mage.cards.b.BojukaBog.class));
        cards.add(new SetCardInfo("Boros Charm", 179, Rarity.UNCOMMON, mage.cards.b.BorosCharm.class));
        cards.add(new SetCardInfo("Boros Garrison", 279, Rarity.COMMON, mage.cards.b.BorosGarrison.class));
        cards.add(new SetCardInfo("Boros Guildgate", 280, Rarity.COMMON, mage.cards.b.BorosGuildgate.class));
        cards.add(new SetCardInfo("Borrowing 100,000 Arrows", 33, Rarity.UNCOMMON, mage.cards.b.Borrowing100000Arrows.class));
        cards.add(new SetCardInfo("Brilliant Plan", 34, Rarity.UNCOMMON, mage.cards.b.BrilliantPlan.class));
        cards.add(new SetCardInfo("Brooding Saurian", 138, Rarity.RARE, mage.cards.b.BroodingSaurian.class));
        cards.add(new SetCardInfo("Capricious Efreet", 102, Rarity.RARE, mage.cards.c.CapriciousEfreet.class));
        cards.add(new SetCardInfo("Carnage Altar", 238, Rarity.UNCOMMON, mage.cards.c.CarnageAltar.class));
        cards.add(new SetCardInfo("Charmbreaker Devils", 103, Rarity.RARE, mage.cards.c.CharmbreakerDevils.class));
        cards.add(new SetCardInfo("Charnelhoard Wurm", 180, Rarity.RARE, mage.cards.c.CharnelhoardWurm.class));
        cards.add(new SetCardInfo("Command Tower", 281, Rarity.COMMON, mage.cards.c.CommandTower.class));
        cards.add(new SetCardInfo("Conjurer's Closet", 239, Rarity.RARE, mage.cards.c.ConjurersCloset.class));
        cards.add(new SetCardInfo("Contested Cliffs", 282, Rarity.RARE, mage.cards.c.ContestedCliffs.class));
        cards.add(new SetCardInfo("Control Magic", 35, Rarity.UNCOMMON, mage.cards.c.ControlMagic.class));
        cards.add(new SetCardInfo("Cradle of Vitality", 7, Rarity.RARE, mage.cards.c.CradleOfVitality.class));
        cards.add(new SetCardInfo("Crater Hellion", 104, Rarity.RARE, mage.cards.c.CraterHellion.class));
        cards.add(new SetCardInfo("Crawlspace", 240, Rarity.RARE, mage.cards.c.Crawlspace.class));
        cards.add(new SetCardInfo("Crosis's Charm", 181, Rarity.UNCOMMON, mage.cards.c.CrosissCharm.class));
        cards.add(new SetCardInfo("Cruel Ultimatum", 182, Rarity.RARE, mage.cards.c.CruelUltimatum.class));
        cards.add(new SetCardInfo("Crumbling Necropolis", 283, Rarity.UNCOMMON, mage.cards.c.CrumblingNecropolis.class));
        cards.add(new SetCardInfo("Cultivate", 139, Rarity.COMMON, mage.cards.c.Cultivate.class));
        cards.add(new SetCardInfo("Curse of Chaos", 105, Rarity.UNCOMMON, mage.cards.c.CurseOfChaos.class));
        cards.add(new SetCardInfo("Curse of Inertia", 36, Rarity.UNCOMMON, mage.cards.c.CurseOfInertia.class));
        cards.add(new SetCardInfo("Curse of Predation", 140, Rarity.UNCOMMON, mage.cards.c.CurseOfPredation.class));
        cards.add(new SetCardInfo("Curse of Shallow Graves", 71, Rarity.UNCOMMON, mage.cards.c.CurseOfShallowGraves.class));
        cards.add(new SetCardInfo("Curse of the Forsaken", 8, Rarity.UNCOMMON, mage.cards.c.CurseOfTheForsaken.class));
        cards.add(new SetCardInfo("Darksteel Ingot", 241, Rarity.UNCOMMON, mage.cards.d.DarksteelIngot.class));
        cards.add(new SetCardInfo("Darksteel Mutation", 9, Rarity.UNCOMMON, mage.cards.d.DarksteelMutation.class));
        cards.add(new SetCardInfo("Deadwood Treefolk", 141, Rarity.UNCOMMON, mage.cards.d.DeadwoodTreefolk.class));
        cards.add(new SetCardInfo("Deathbringer Thoctar", 184, Rarity.RARE, mage.cards.d.DeathbringerThoctar.class));
        cards.add(new SetCardInfo("Death Grasp", 183, Rarity.RARE, mage.cards.d.DeathGrasp.class));
        cards.add(new SetCardInfo("Deceiver Exarch", 37, Rarity.UNCOMMON, mage.cards.d.DeceiverExarch.class));
        cards.add(new SetCardInfo("Decree of Pain", 72, Rarity.RARE, mage.cards.d.DecreeOfPain.class));
        cards.add(new SetCardInfo("Deep Analysis", 38, Rarity.COMMON, mage.cards.d.DeepAnalysis.class));
        cards.add(new SetCardInfo("Deepfire Elemental", 185, Rarity.UNCOMMON, mage.cards.d.DeepfireElemental.class));
        cards.add(new SetCardInfo("Derevi, Empyrial Tactician", 186, Rarity.MYTHIC, mage.cards.d.DereviEmpyrialTactician.class));
        cards.add(new SetCardInfo("Dimir Guildgate", 284, Rarity.COMMON, mage.cards.d.DimirGuildgate.class));
        cards.add(new SetCardInfo("Dirge of Dread", 73, Rarity.COMMON, mage.cards.d.DirgeOfDread.class));
        cards.add(new SetCardInfo("Disciple of Griselbrand", 74, Rarity.UNCOMMON, mage.cards.d.DiscipleOfGriselbrand.class));
        cards.add(new SetCardInfo("Dismiss", 39, Rarity.UNCOMMON, mage.cards.d.Dismiss.class));
        cards.add(new SetCardInfo("Diviner Spirit", 40, Rarity.UNCOMMON, mage.cards.d.DivinerSpirit.class));
        cards.add(new SetCardInfo("Divinity of Pride", 228, Rarity.RARE, mage.cards.d.DivinityOfPride.class));
        cards.add(new SetCardInfo("Djinn of Infinite Deceits", 41, Rarity.RARE, mage.cards.d.DjinnOfInfiniteDeceits.class));
        cards.add(new SetCardInfo("Drifting Meadow", 285, Rarity.COMMON, mage.cards.d.DriftingMeadow.class));
        cards.add(new SetCardInfo("Dromar's Charm", 187, Rarity.UNCOMMON, mage.cards.d.DromarsCharm.class));
        cards.add(new SetCardInfo("Druidic Satchel", 242, Rarity.RARE, mage.cards.d.DruidicSatchel.class));
        cards.add(new SetCardInfo("Drumhunter", 142, Rarity.UNCOMMON, mage.cards.d.Drumhunter.class));
        cards.add(new SetCardInfo("Dungeon Geists", 42, Rarity.RARE, mage.cards.d.DungeonGeists.class));
        cards.add(new SetCardInfo("Echo Mage", 43, Rarity.RARE, mage.cards.e.EchoMage.class));
        cards.add(new SetCardInfo("Elvish Skysweeper", 143, Rarity.COMMON, mage.cards.e.ElvishSkysweeper.class));
        cards.add(new SetCardInfo("Endless Cockroaches", 75, Rarity.RARE, mage.cards.e.EndlessCockroaches.class));
        cards.add(new SetCardInfo("Endrek Sahr, Master Breeder", 76, Rarity.RARE, mage.cards.e.EndrekSahrMasterBreeder.class));
        cards.add(new SetCardInfo("Esper Panorama", 286, Rarity.COMMON, mage.cards.e.EsperPanorama.class));
        cards.add(new SetCardInfo("Eternal Dragon", 10, Rarity.RARE, mage.cards.e.EternalDragon.class));
        cards.add(new SetCardInfo("Evolving Wilds", 287, Rarity.COMMON, mage.cards.e.EvolvingWilds.class));
        cards.add(new SetCardInfo("Eye of Doom", 243, Rarity.RARE, mage.cards.e.EyeOfDoom.class));
        cards.add(new SetCardInfo("Faerie Conclave", 288, Rarity.UNCOMMON, mage.cards.f.FaerieConclave.class));
        cards.add(new SetCardInfo("Famine", 77, Rarity.UNCOMMON, mage.cards.f.Famine.class));
        cards.add(new SetCardInfo("Farhaven Elf", 144, Rarity.COMMON, mage.cards.f.FarhavenElf.class));
        cards.add(new SetCardInfo("Fecundity", 145, Rarity.UNCOMMON, mage.cards.f.Fecundity.class));
        cards.add(new SetCardInfo("Fell Shepherd", 78, Rarity.RARE, mage.cards.f.FellShepherd.class));
        cards.add(new SetCardInfo("Fiend Hunter", 11, Rarity.UNCOMMON, mage.cards.f.FiendHunter.class));
        cards.add(new SetCardInfo("Fiery Justice", 188, Rarity.RARE, mage.cards.f.FieryJustice.class));
        cards.add(new SetCardInfo("Filigree Angel", 189, Rarity.RARE, mage.cards.f.FiligreeAngel.class));
        cards.add(new SetCardInfo("Fireball", 106, Rarity.UNCOMMON, mage.cards.f.Fireball.class));
        cards.add(new SetCardInfo("Fires of Yavimaya", 190, Rarity.UNCOMMON, mage.cards.f.FiresOfYavimaya.class));
        cards.add(new SetCardInfo("Fissure Vent", 107, Rarity.COMMON, mage.cards.f.FissureVent.class));
        cards.add(new SetCardInfo("Flickerform", 12, Rarity.RARE, mage.cards.f.Flickerform.class));
        cards.add(new SetCardInfo("Flickerwisp", 13, Rarity.UNCOMMON, mage.cards.f.Flickerwisp.class));
        cards.add(new SetCardInfo("Fog Bank", 44, Rarity.UNCOMMON, mage.cards.f.FogBank.class));
        cards.add(new SetCardInfo("Forest", 353, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 354, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 355, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 356, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forgotten Cave", 289, Rarity.COMMON, mage.cards.f.ForgottenCave.class));
        cards.add(new SetCardInfo("Foster", 146, Rarity.RARE, mage.cards.f.Foster.class));
        cards.add(new SetCardInfo("From the Ashes", 108, Rarity.RARE, mage.cards.f.FromTheAshes.class));
        cards.add(new SetCardInfo("Furnace Celebration", 109, Rarity.UNCOMMON, mage.cards.f.FurnaceCelebration.class));
        cards.add(new SetCardInfo("Gahiji, Honored One", 191, Rarity.MYTHIC, mage.cards.g.GahijiHonoredOne.class));
        cards.add(new SetCardInfo("Goblin Bombardment", 110, Rarity.UNCOMMON, mage.cards.g.GoblinBombardment.class));
        cards.add(new SetCardInfo("Goblin Sharpshooter", 111, Rarity.RARE, mage.cards.g.GoblinSharpshooter.class));
        cards.add(new SetCardInfo("Golgari Guildgate", 290, Rarity.COMMON, mage.cards.g.GolgariGuildgate.class));
        cards.add(new SetCardInfo("Golgari Guildmage", 229, Rarity.UNCOMMON, mage.cards.g.GolgariGuildmage.class));
        cards.add(new SetCardInfo("Golgari Rot Farm", 291, Rarity.COMMON, mage.cards.g.GolgariRotFarm.class));
        cards.add(new SetCardInfo("Grazing Gladehart", 147, Rarity.COMMON, mage.cards.g.GrazingGladehart.class));
        cards.add(new SetCardInfo("Greed", 79, Rarity.RARE, mage.cards.g.Greed.class));
        cards.add(new SetCardInfo("Grim Backwoods", 292, Rarity.RARE, mage.cards.g.GrimBackwoods.class));
        cards.add(new SetCardInfo("Grixis Charm", 192, Rarity.UNCOMMON, mage.cards.g.GrixisCharm.class));
        cards.add(new SetCardInfo("Grixis Panorama", 293, Rarity.COMMON, mage.cards.g.GrixisPanorama.class));
        cards.add(new SetCardInfo("Gruul Guildgate", 294, Rarity.COMMON, mage.cards.g.GruulGuildgate.class));
        cards.add(new SetCardInfo("Guard Gomazoa", 45, Rarity.UNCOMMON, mage.cards.g.GuardGomazoa.class));
        cards.add(new SetCardInfo("Guttersnipe", 112, Rarity.UNCOMMON, mage.cards.g.Guttersnipe.class));
        cards.add(new SetCardInfo("Hada Spy Patrol", 46, Rarity.UNCOMMON, mage.cards.h.HadaSpyPatrol.class));
        cards.add(new SetCardInfo("Harmonize", 148, Rarity.UNCOMMON, mage.cards.h.Harmonize.class));
        cards.add(new SetCardInfo("Homeward Path", 295, Rarity.RARE, mage.cards.h.HomewardPath.class));
        cards.add(new SetCardInfo("Hooded Horror", 80, Rarity.UNCOMMON, mage.cards.h.HoodedHorror.class));
        cards.add(new SetCardInfo("Hua Tuo, Honored Physician", 149, Rarity.RARE, mage.cards.h.HuaTuoHonoredPhysician.class));
        cards.add(new SetCardInfo("Hull Breach", 193, Rarity.COMMON, mage.cards.h.HullBreach.class));
        cards.add(new SetCardInfo("Hunted Troll", 150, Rarity.RARE, mage.cards.h.HuntedTroll.class));
        cards.add(new SetCardInfo("Illusionist's Gambit", 47, Rarity.RARE, mage.cards.i.IllusionistsGambit.class));
        cards.add(new SetCardInfo("Incendiary Command", 113, Rarity.RARE, mage.cards.i.IncendiaryCommand.class));
        cards.add(new SetCardInfo("Inferno Titan", 114, Rarity.MYTHIC, mage.cards.i.InfernoTitan.class));
        cards.add(new SetCardInfo("Infest", 81, Rarity.UNCOMMON, mage.cards.i.Infest.class));
        cards.add(new SetCardInfo("Island", 341, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 342, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 343, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 344, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Izzet Boilerworks", 296, Rarity.COMMON, mage.cards.i.IzzetBoilerworks.class));
        cards.add(new SetCardInfo("Izzet Guildgate", 297, Rarity.COMMON, mage.cards.i.IzzetGuildgate.class));
        cards.add(new SetCardInfo("Jace's Archivist", 48, Rarity.RARE, mage.cards.j.JacesArchivist.class));
        cards.add(new SetCardInfo("Jade Mage", 151, Rarity.UNCOMMON, mage.cards.j.JadeMage.class));
        cards.add(new SetCardInfo("Jar of Eyeballs", 244, Rarity.RARE, mage.cards.j.JarOfEyeballs.class));
        cards.add(new SetCardInfo("Jeleva, Nephalia's Scourge", 194, Rarity.MYTHIC, mage.cards.j.JelevaNephaliasScourge.class));
        cards.add(new SetCardInfo("Jund Charm", 195, Rarity.UNCOMMON, mage.cards.j.JundCharm.class));
        cards.add(new SetCardInfo("Jund Panorama", 298, Rarity.COMMON, mage.cards.j.JundPanorama.class));
        cards.add(new SetCardInfo("Jungle Shrine", 299, Rarity.UNCOMMON, mage.cards.j.JungleShrine.class));
        cards.add(new SetCardInfo("Jwar Isle Refuge", 300, Rarity.UNCOMMON, mage.cards.j.JwarIsleRefuge.class));
        cards.add(new SetCardInfo("Karmic Guide", 14, Rarity.RARE, mage.cards.k.KarmicGuide.class));
        cards.add(new SetCardInfo("Kazandu Refuge", 301, Rarity.UNCOMMON, mage.cards.k.KazanduRefuge.class));
        cards.add(new SetCardInfo("Kazandu Tuskcaller", 152, Rarity.RARE, mage.cards.k.KazanduTuskcaller.class));
        cards.add(new SetCardInfo("Khalni Garden", 302, Rarity.COMMON, mage.cards.k.KhalniGarden.class));
        cards.add(new SetCardInfo("Kher Keep", 303, Rarity.RARE, mage.cards.k.KherKeep.class));
        cards.add(new SetCardInfo("Kirtar's Wrath", 15, Rarity.RARE, mage.cards.k.KirtarsWrath.class));
        cards.add(new SetCardInfo("Kongming, 'Sleeping Dragon'", 16, Rarity.RARE, mage.cards.k.KongmingSleepingDragon.class));
        cards.add(new SetCardInfo("Krosan Grip", 153, Rarity.UNCOMMON, mage.cards.k.KrosanGrip.class));
        cards.add(new SetCardInfo("Krosan Tusker", 154, Rarity.COMMON, mage.cards.k.KrosanTusker.class));
        cards.add(new SetCardInfo("Krosan Warchief", 155, Rarity.UNCOMMON, mage.cards.k.KrosanWarchief.class));
        cards.add(new SetCardInfo("Leafdrake Roost", 196, Rarity.UNCOMMON, mage.cards.l.LeafdrakeRoost.class));
        cards.add(new SetCardInfo("Leonin Bladetrap", 245, Rarity.UNCOMMON, mage.cards.l.LeoninBladetrap.class));
        cards.add(new SetCardInfo("Lim-Dul's Vault", 197, Rarity.UNCOMMON, mage.cards.l.LimDulsVault.class));
        cards.add(new SetCardInfo("Llanowar Reborn", 304, Rarity.UNCOMMON, mage.cards.l.LlanowarReborn.class));
        cards.add(new SetCardInfo("Lonely Sandbar", 305, Rarity.COMMON, mage.cards.l.LonelySandbar.class));
        cards.add(new SetCardInfo("Lu Xun, Scholar General", 49, Rarity.RARE, mage.cards.l.LuXunScholarGeneral.class));
        cards.add(new SetCardInfo("Magus of the Arena", 115, Rarity.RARE, mage.cards.m.MagusOfTheArena.class));
        cards.add(new SetCardInfo("Marath, Will of the Wild", 198, Rarity.MYTHIC, mage.cards.m.MarathWillOfTheWild.class));
        cards.add(new SetCardInfo("Marrow Bats", 82, Rarity.UNCOMMON, mage.cards.m.MarrowBats.class));
        cards.add(new SetCardInfo("Mass Mutiny", 116, Rarity.RARE, mage.cards.m.MassMutiny.class));
        cards.add(new SetCardInfo("Mayael the Anima", 199, Rarity.MYTHIC, mage.cards.m.MayaelTheAnima.class));
        cards.add(new SetCardInfo("Mirari", 246, Rarity.RARE, mage.cards.m.Mirari.class));
        cards.add(new SetCardInfo("Mirror Entity", 17, Rarity.RARE, mage.cards.m.MirrorEntity.class));
        cards.add(new SetCardInfo("Mistmeadow Witch", 230, Rarity.UNCOMMON, mage.cards.m.MistmeadowWitch.class));
        cards.add(new SetCardInfo("Mnemonic Wall", 50, Rarity.COMMON, mage.cards.m.MnemonicWall.class));
        cards.add(new SetCardInfo("Mold Shambler", 156, Rarity.COMMON, mage.cards.m.MoldShambler.class));
        cards.add(new SetCardInfo("Molten Disaster", 117, Rarity.RARE, mage.cards.m.MoltenDisaster.class));
        cards.add(new SetCardInfo("Molten Slagheap", 306, Rarity.UNCOMMON, mage.cards.m.MoltenSlagheap.class));
        cards.add(new SetCardInfo("Mosswort Bridge", 307, Rarity.RARE, mage.cards.m.MosswortBridge.class));
        cards.add(new SetCardInfo("Mountain", 349, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 350, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 351, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 352, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Murkfiend Liege", 231, Rarity.RARE, mage.cards.m.MurkfiendLiege.class));
        cards.add(new SetCardInfo("Myr Battlesphere", 247, Rarity.RARE, mage.cards.m.MyrBattlesphere.class));
        cards.add(new SetCardInfo("Mystic Barrier", 18, Rarity.RARE, mage.cards.m.MysticBarrier.class));
        cards.add(new SetCardInfo("Naya Charm", 200, Rarity.UNCOMMON, mage.cards.n.NayaCharm.class));
        cards.add(new SetCardInfo("Naya Panorama", 308, Rarity.COMMON, mage.cards.n.NayaPanorama.class));
        cards.add(new SetCardInfo("Naya Soulbeast", 157, Rarity.RARE, mage.cards.n.NayaSoulbeast.class));
        cards.add(new SetCardInfo("Nekusar, the Mindrazer", 201, Rarity.MYTHIC, mage.cards.n.NekusarTheMindrazer.class));
        cards.add(new SetCardInfo("Nevinyrral's Disk", 248, Rarity.RARE, mage.cards.n.NevinyrralsDisk.class));
        cards.add(new SetCardInfo("New Benalia", 309, Rarity.UNCOMMON, mage.cards.n.NewBenalia.class));
        cards.add(new SetCardInfo("Nightscape Familiar", 83, Rarity.COMMON, mage.cards.n.NightscapeFamiliar.class));
        cards.add(new SetCardInfo("Night Soil", 158, Rarity.COMMON, NightSoil.class));
        cards.add(new SetCardInfo("Nihil Spellbomb", 249, Rarity.COMMON, mage.cards.n.NihilSpellbomb.class));
        cards.add(new SetCardInfo("Nivix Guildmage", 202, Rarity.UNCOMMON, mage.cards.n.NivixGuildmage.class));
        cards.add(new SetCardInfo("Obelisk of Esper", 250, Rarity.COMMON, mage.cards.o.ObeliskOfEsper.class));
        cards.add(new SetCardInfo("Obelisk of Grixis", 251, Rarity.COMMON, mage.cards.o.ObeliskOfGrixis.class));
        cards.add(new SetCardInfo("Obelisk of Jund", 252, Rarity.COMMON, mage.cards.o.ObeliskOfJund.class));
        cards.add(new SetCardInfo("Oloro, Ageless Ascetic", 203, Rarity.MYTHIC, mage.cards.o.OloroAgelessAscetic.class));
        cards.add(new SetCardInfo("One Dozen Eyes", 159, Rarity.UNCOMMON, mage.cards.o.OneDozenEyes.class));
        cards.add(new SetCardInfo("Opal Palace", 310, Rarity.COMMON, mage.cards.o.OpalPalace.class));
        cards.add(new SetCardInfo("Ophiomancer", 84, Rarity.RARE, mage.cards.o.Ophiomancer.class));
        cards.add(new SetCardInfo("Opportunity", 51, Rarity.UNCOMMON, mage.cards.o.Opportunity.class));
        cards.add(new SetCardInfo("Order of Succession", 52, Rarity.RARE, mage.cards.o.OrderOfSuccession.class));
        cards.add(new SetCardInfo("Orzhov Basilica", 311, Rarity.COMMON, mage.cards.o.OrzhovBasilica.class));
        cards.add(new SetCardInfo("Orzhov Guildgate", 312, Rarity.COMMON, mage.cards.o.OrzhovGuildgate.class));
        cards.add(new SetCardInfo("Phantom Nantuko", 160, Rarity.RARE, mage.cards.p.PhantomNantuko.class));
        cards.add(new SetCardInfo("Phthisis", 85, Rarity.UNCOMMON, mage.cards.p.Phthisis.class));
        cards.add(new SetCardInfo("Phyrexian Delver", 86, Rarity.RARE, mage.cards.p.PhyrexianDelver.class));
        cards.add(new SetCardInfo("Phyrexian Gargantua", 87, Rarity.UNCOMMON, mage.cards.p.PhyrexianGargantua.class));
        cards.add(new SetCardInfo("Phyrexian Reclamation", 88, Rarity.UNCOMMON, mage.cards.p.PhyrexianReclamation.class));
        cards.add(new SetCardInfo("Pilgrim's Eye", 253, Rarity.COMMON, mage.cards.p.PilgrimsEye.class));
        cards.add(new SetCardInfo("Plague Boiler", 254, Rarity.RARE, mage.cards.p.PlagueBoiler.class));
        cards.add(new SetCardInfo("Plains", 337, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 338, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 339, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 340, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Presence of Gond", 161, Rarity.COMMON, mage.cards.p.PresenceOfGond.class));
        cards.add(new SetCardInfo("Price of Knowledge", 89, Rarity.RARE, mage.cards.p.PriceOfKnowledge.class));
        cards.add(new SetCardInfo("Primal Vigor", 162, Rarity.RARE, mage.cards.p.PrimalVigor.class));
        cards.add(new SetCardInfo("Pristine Talisman", 255, Rarity.COMMON, mage.cards.p.PristineTalisman.class));
        cards.add(new SetCardInfo("Propaganda", 53, Rarity.UNCOMMON, mage.cards.p.Propaganda.class));
        cards.add(new SetCardInfo("Prosperity", 54, Rarity.UNCOMMON, mage.cards.p.Prosperity.class));
        cards.add(new SetCardInfo("Prossh, Skyraider of Kher", 204, Rarity.MYTHIC, mage.cards.p.ProsshSkyraiderOfKher.class));
        cards.add(new SetCardInfo("Quagmire Druid", 90, Rarity.COMMON, mage.cards.q.QuagmireDruid.class));
        cards.add(new SetCardInfo("Rain of Thorns", 163, Rarity.UNCOMMON, mage.cards.r.RainOfThorns.class));
        cards.add(new SetCardInfo("Rakdos Carnarium", 313, Rarity.COMMON, mage.cards.r.RakdosCarnarium.class));
        cards.add(new SetCardInfo("Rakdos Guildgate", 314, Rarity.COMMON, mage.cards.r.RakdosGuildgate.class));
        cards.add(new SetCardInfo("Rakeclaw Gargantuan", 205, Rarity.COMMON, mage.cards.r.RakeclawGargantuan.class));
        cards.add(new SetCardInfo("Rampaging Baloths", 164, Rarity.MYTHIC, mage.cards.r.RampagingBaloths.class));
        cards.add(new SetCardInfo("Raven Familiar", 55, Rarity.UNCOMMON, mage.cards.r.RavenFamiliar.class));
        cards.add(new SetCardInfo("Ravenous Baloth", 165, Rarity.RARE, mage.cards.r.RavenousBaloth.class));
        cards.add(new SetCardInfo("Razor Hippogriff", 19, Rarity.UNCOMMON, mage.cards.r.RazorHippogriff.class));
        cards.add(new SetCardInfo("Reckless Spite", 91, Rarity.UNCOMMON, mage.cards.r.RecklessSpite.class));
        cards.add(new SetCardInfo("Reincarnation", 166, Rarity.UNCOMMON, mage.cards.r.Reincarnation.class));
        cards.add(new SetCardInfo("Restore", 167, Rarity.UNCOMMON, mage.cards.r.Restore.class));
        cards.add(new SetCardInfo("Roon of the Hidden Realm", 206, Rarity.MYTHIC, mage.cards.r.RoonOfTheHiddenRealm.class));
        cards.add(new SetCardInfo("Rough // Tumble", 118, Rarity.UNCOMMON, mage.cards.r.RoughTumble.class));
        cards.add(new SetCardInfo("Rubinia Soulsinger", 207, Rarity.RARE, mage.cards.r.RubiniaSoulsinger.class));
        cards.add(new SetCardInfo("Rupture Spire", 315, Rarity.COMMON, mage.cards.r.RuptureSpire.class));
        cards.add(new SetCardInfo("Sakura-Tribe Elder", 168, Rarity.COMMON, mage.cards.s.SakuraTribeElder.class));
        cards.add(new SetCardInfo("Saltcrusted Steppe", 316, Rarity.UNCOMMON, mage.cards.s.SaltcrustedSteppe.class));
        cards.add(new SetCardInfo("Sanguine Bond", 92, Rarity.RARE, mage.cards.s.SanguineBond.class));
        cards.add(new SetCardInfo("Savage Lands", 317, Rarity.UNCOMMON, mage.cards.s.SavageLands.class));
        cards.add(new SetCardInfo("Savage Twister", 208, Rarity.UNCOMMON, mage.cards.s.SavageTwister.class));
        cards.add(new SetCardInfo("Scarland Thrinax", 209, Rarity.UNCOMMON, mage.cards.s.ScarlandThrinax.class));
        cards.add(new SetCardInfo("Seaside Citadel", 318, Rarity.UNCOMMON, mage.cards.s.SeasideCitadel.class));
        cards.add(new SetCardInfo("Secluded Steppe", 319, Rarity.COMMON, mage.cards.s.SecludedSteppe.class));
        cards.add(new SetCardInfo("Seer's Sundial", 256, Rarity.RARE, mage.cards.s.SeersSundial.class));
        cards.add(new SetCardInfo("Sejiri Refuge", 320, Rarity.UNCOMMON, mage.cards.s.SejiriRefuge.class));
        cards.add(new SetCardInfo("Sek'Kuar, Deathkeeper", 210, Rarity.RARE, mage.cards.s.SekKuarDeathkeeper.class));
        cards.add(new SetCardInfo("Selesnya Charm", 211, Rarity.UNCOMMON, mage.cards.s.SelesnyaCharm.class));
        cards.add(new SetCardInfo("Selesnya Guildgate", 321, Rarity.COMMON, mage.cards.s.SelesnyaGuildgate.class));
        cards.add(new SetCardInfo("Selesnya Guildmage", 232, Rarity.UNCOMMON, mage.cards.s.SelesnyaGuildmage.class));
        cards.add(new SetCardInfo("Selesnya Sanctuary", 322, Rarity.COMMON, mage.cards.s.SelesnyaSanctuary.class));
        cards.add(new SetCardInfo("Selesnya Signet", 257, Rarity.COMMON, mage.cards.s.SelesnyaSignet.class));
        cards.add(new SetCardInfo("Serene Master", 20, Rarity.RARE, mage.cards.s.SereneMaster.class));
        cards.add(new SetCardInfo("Serra Avatar", 21, Rarity.MYTHIC, mage.cards.s.SerraAvatar.class));
        cards.add(new SetCardInfo("Sharding Sphinx", 56, Rarity.RARE, mage.cards.s.ShardingSphinx.class));
        cards.add(new SetCardInfo("Sharuum the Hegemon", 212, Rarity.MYTHIC, mage.cards.s.SharuumTheHegemon.class));
        cards.add(new SetCardInfo("Shattergang Brothers", 213, Rarity.MYTHIC, mage.cards.s.ShattergangBrothers.class));
        cards.add(new SetCardInfo("Silklash Spider", 169, Rarity.RARE, mage.cards.s.SilklashSpider.class));
        cards.add(new SetCardInfo("Simic Guildgate", 323, Rarity.COMMON, mage.cards.s.SimicGuildgate.class));
        cards.add(new SetCardInfo("Simic Signet", 258, Rarity.COMMON, mage.cards.s.SimicSignet.class));
        cards.add(new SetCardInfo("Skyscribing", 57, Rarity.UNCOMMON, mage.cards.s.Skyscribing.class));
        cards.add(new SetCardInfo("Skyward Eye Prophets", 214, Rarity.UNCOMMON, mage.cards.s.SkywardEyeProphets.class));
        cards.add(new SetCardInfo("Slice and Dice", 119, Rarity.UNCOMMON, mage.cards.s.SliceAndDice.class));
        cards.add(new SetCardInfo("Slice in Twain", 170, Rarity.UNCOMMON, mage.cards.s.SliceinTwain.class));
        cards.add(new SetCardInfo("Slippery Karst", 324, Rarity.COMMON, mage.cards.s.SlipperyKarst.class));
        cards.add(new SetCardInfo("Smoldering Crater", 325, Rarity.COMMON, mage.cards.s.SmolderingCrater.class));
        cards.add(new SetCardInfo("Sol Ring", 259, Rarity.UNCOMMON, mage.cards.s.SolRing.class));
        cards.add(new SetCardInfo("Soul Manipulation", 215, Rarity.COMMON, mage.cards.s.SoulManipulation.class));
        cards.add(new SetCardInfo("Spawning Grounds", 171, Rarity.RARE, mage.cards.s.SpawningGrounds.class));
        cards.add(new SetCardInfo("Spellbreaker Behemoth", 216, Rarity.RARE, mage.cards.s.SpellbreakerBehemoth.class));
        cards.add(new SetCardInfo("Sphinx of the Steel Wind", 217, Rarity.MYTHIC, mage.cards.s.SphinxOfTheSteelWind.class));
        cards.add(new SetCardInfo("Spinal Embrace", 218, Rarity.RARE, mage.cards.s.SpinalEmbrace.class));
        cards.add(new SetCardInfo("Spine of Ish Sah", 260, Rarity.RARE, mage.cards.s.SpineOfIshSah.class));
        cards.add(new SetCardInfo("Spitebellows", 120, Rarity.UNCOMMON, mage.cards.s.Spitebellows.class));
        cards.add(new SetCardInfo("Spiteful Visions", 233, Rarity.RARE, mage.cards.s.SpitefulVisions.class));
        cards.add(new SetCardInfo("Spoils of Victory", 172, Rarity.UNCOMMON, mage.cards.s.SpoilsOfVictory.class));
        cards.add(new SetCardInfo("Springjack Pasture", 326, Rarity.RARE, mage.cards.s.SpringjackPasture.class));
        cards.add(new SetCardInfo("Sprouting Thrinax", 219, Rarity.UNCOMMON, mage.cards.s.SproutingThrinax.class));
        cards.add(new SetCardInfo("Sprouting Vines", 173, Rarity.COMMON, mage.cards.s.SproutingVines.class));
        cards.add(new SetCardInfo("Stalking Vengeance", 121, Rarity.RARE, mage.cards.s.StalkingVengeance.class));
        cards.add(new SetCardInfo("Starstorm", 122, Rarity.RARE, mage.cards.s.Starstorm.class));
        cards.add(new SetCardInfo("Stonecloaker", 22, Rarity.UNCOMMON, mage.cards.s.Stonecloaker.class));
        cards.add(new SetCardInfo("Stormscape Battlemage", 58, Rarity.UNCOMMON, mage.cards.s.StormscapeBattlemage.class));
        cards.add(new SetCardInfo("Strategic Planning", 59, Rarity.UNCOMMON, mage.cards.s.StrategicPlanning.class));
        cards.add(new SetCardInfo("Street Spasm", 123, Rarity.UNCOMMON, mage.cards.s.StreetSpasm.class));
        cards.add(new SetCardInfo("Stronghold Assassin", 93, Rarity.RARE, mage.cards.s.StrongholdAssassin.class));
        cards.add(new SetCardInfo("Sudden Demise", 124, Rarity.RARE, mage.cards.s.SuddenDemise.class));
        cards.add(new SetCardInfo("Sudden Spoiling", 94, Rarity.RARE, mage.cards.s.SuddenSpoiling.class));
        cards.add(new SetCardInfo("Sun Droplet", 261, Rarity.UNCOMMON, mage.cards.s.SunDroplet.class));
        cards.add(new SetCardInfo("Surveyor's Scope", 262, Rarity.RARE, mage.cards.s.SurveyorsScope.class));
        cards.add(new SetCardInfo("Survival Cache", 23, Rarity.UNCOMMON, mage.cards.s.SurvivalCache.class));
        cards.add(new SetCardInfo("Swamp", 345, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 346, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 347, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 348, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swiftfoot Boots", 263, Rarity.UNCOMMON, mage.cards.s.SwiftfootBoots.class));
        cards.add(new SetCardInfo("Sword of the Paruns", 264, Rarity.RARE, mage.cards.s.SwordOfTheParuns.class));
        cards.add(new SetCardInfo("Sydri, Galvanic Genius", 220, Rarity.MYTHIC, mage.cards.s.SydriGalvanicGenius.class));
        cards.add(new SetCardInfo("Temple Bell", 265, Rarity.RARE, mage.cards.t.TempleBell.class));
        cards.add(new SetCardInfo("Temple of the False God", 327, Rarity.UNCOMMON, mage.cards.t.TempleOfTheFalseGod.class));
        cards.add(new SetCardInfo("Tempt with Discovery", 174, Rarity.RARE, mage.cards.t.TemptWithDiscovery.class));
        cards.add(new SetCardInfo("Tempt with Glory", 24, Rarity.RARE, mage.cards.t.TemptWithGlory.class));
        cards.add(new SetCardInfo("Tempt with Immortality", 95, Rarity.RARE, mage.cards.t.TemptWithImmortality.class));
        cards.add(new SetCardInfo("Tempt with Reflections", 60, Rarity.RARE, mage.cards.t.TemptWithReflections.class));
        cards.add(new SetCardInfo("Tempt with Vengeance", 125, Rarity.RARE, mage.cards.t.TemptWithVengeance.class));
        cards.add(new SetCardInfo("Terramorphic Expanse", 328, Rarity.COMMON, mage.cards.t.TerramorphicExpanse.class));
        cards.add(new SetCardInfo("Terra Ravager", 126, Rarity.UNCOMMON, mage.cards.t.TerraRavager.class));
        cards.add(new SetCardInfo("Thopter Foundry", 234, Rarity.UNCOMMON, mage.cards.t.ThopterFoundry.class));
        cards.add(new SetCardInfo("Thornwind Faeries", 61, Rarity.COMMON, mage.cards.t.ThornwindFaeries.class));
        cards.add(new SetCardInfo("Thousand-Year Elixir", 266, Rarity.RARE, mage.cards.t.ThousandYearElixir.class));
        cards.add(new SetCardInfo("Thraximundar", 221, Rarity.MYTHIC, mage.cards.t.Thraximundar.class));
        cards.add(new SetCardInfo("Thunderstaff", 267, Rarity.UNCOMMON, mage.cards.t.Thunderstaff.class));
        cards.add(new SetCardInfo("Tidal Force", 62, Rarity.RARE, mage.cards.t.TidalForce.class));
        cards.add(new SetCardInfo("Tidehollow Strix", 222, Rarity.COMMON, mage.cards.t.TidehollowStrix.class));
        cards.add(new SetCardInfo("Tooth and Claw", 127, Rarity.RARE, mage.cards.t.ToothAndClaw.class));
        cards.add(new SetCardInfo("Tower Gargoyle", 223, Rarity.UNCOMMON, mage.cards.t.TowerGargoyle.class));
        cards.add(new SetCardInfo("Tower of Fortunes", 268, Rarity.RARE, mage.cards.t.TowerOfFortunes.class));
        cards.add(new SetCardInfo("Toxic Deluge", 96, Rarity.RARE, mage.cards.t.ToxicDeluge.class));
        cards.add(new SetCardInfo("Tranquil Thicket", 329, Rarity.COMMON, mage.cards.t.TranquilThicket.class));
        cards.add(new SetCardInfo("Transguild Promenade", 330, Rarity.COMMON, mage.cards.t.TransguildPromenade.class));
        cards.add(new SetCardInfo("True-Name Nemesis", 63, Rarity.RARE, mage.cards.t.TrueNameNemesis.class));
        cards.add(new SetCardInfo("Unexpectedly Absent", 25, Rarity.RARE, mage.cards.u.UnexpectedlyAbsent.class));
        cards.add(new SetCardInfo("Urza's Factory", 331, Rarity.UNCOMMON, mage.cards.u.UrzasFactory.class));
        cards.add(new SetCardInfo("Uyo, Silent Prophet", 64, Rarity.RARE, mage.cards.u.UyoSilentProphet.class));
        cards.add(new SetCardInfo("Valley Rannet", 224, Rarity.COMMON, mage.cards.v.ValleyRannet.class));
        cards.add(new SetCardInfo("Vampire Nighthawk", 97, Rarity.UNCOMMON, mage.cards.v.VampireNighthawk.class));
        cards.add(new SetCardInfo("Vile Requiem", 98, Rarity.UNCOMMON, mage.cards.v.VileRequiem.class));
        cards.add(new SetCardInfo("Viscera Seer", 99, Rarity.COMMON, mage.cards.v.VisceraSeer.class));
        cards.add(new SetCardInfo("Viseling", 269, Rarity.UNCOMMON, mage.cards.v.Viseling.class));
        cards.add(new SetCardInfo("Vision Skeins", 65, Rarity.COMMON, mage.cards.v.VisionSkeins.class));
        cards.add(new SetCardInfo("Vitu-Ghazi, the City-Tree", 332, Rarity.UNCOMMON, mage.cards.v.VituGhaziTheCityTree.class));
        cards.add(new SetCardInfo("Vivid Crag", 333, Rarity.UNCOMMON, mage.cards.v.VividCrag.class));
        cards.add(new SetCardInfo("Vivid Creek", 334, Rarity.UNCOMMON, mage.cards.v.VividCreek.class));
        cards.add(new SetCardInfo("Vivid Grove", 335, Rarity.UNCOMMON, mage.cards.v.VividGrove.class));
        cards.add(new SetCardInfo("Vivid Marsh", 336, Rarity.UNCOMMON, mage.cards.v.VividMarsh.class));
        cards.add(new SetCardInfo("Vizkopa Guildmage", 225, Rarity.UNCOMMON, mage.cards.v.VizkopaGuildmage.class));
        cards.add(new SetCardInfo("Walker of the Grove", 175, Rarity.UNCOMMON, mage.cards.w.WalkerOfTheGrove.class));
        cards.add(new SetCardInfo("Wall of Reverence", 26, Rarity.RARE, mage.cards.w.WallOfReverence.class));
        cards.add(new SetCardInfo("War Cadence", 128, Rarity.UNCOMMON, mage.cards.w.WarCadence.class));
        cards.add(new SetCardInfo("Warstorm Surge", 129, Rarity.RARE, mage.cards.w.WarstormSurge.class));
        cards.add(new SetCardInfo("Wash Out", 66, Rarity.UNCOMMON, mage.cards.w.WashOut.class));
        cards.add(new SetCardInfo("Wayfarer's Bauble", 270, Rarity.COMMON, mage.cards.w.WayfarersBauble.class));
        cards.add(new SetCardInfo("Well of Lost Dreams", 271, Rarity.RARE, mage.cards.w.WellOfLostDreams.class));
        cards.add(new SetCardInfo("Where Ancients Tread", 130, Rarity.RARE, mage.cards.w.WhereAncientsTread.class));
        cards.add(new SetCardInfo("Widespread Panic", 131, Rarity.RARE, mage.cards.w.WidespreadPanic.class));
        cards.add(new SetCardInfo("Wight of Precinct Six", 100, Rarity.UNCOMMON, mage.cards.w.WightOfPrecinctSix.class));
        cards.add(new SetCardInfo("Wild Ricochet", 132, Rarity.RARE, mage.cards.w.WildRicochet.class));
        cards.add(new SetCardInfo("Winged Coatl", 226, Rarity.COMMON, mage.cards.w.WingedCoatl.class));
        cards.add(new SetCardInfo("Witch Hunt", 133, Rarity.RARE, mage.cards.w.WitchHunt.class));
        cards.add(new SetCardInfo("Wonder", 67, Rarity.UNCOMMON, mage.cards.w.Wonder.class));
        cards.add(new SetCardInfo("Wrath of God", 27, Rarity.RARE, mage.cards.w.WrathOfGod.class));
    }

}
