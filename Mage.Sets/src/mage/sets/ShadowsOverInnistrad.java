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
import java.util.EnumMap;
import java.util.List;
import mage.cards.Card;
import mage.cards.CardGraphicInfo;
import mage.cards.ExpansionSet;
import mage.cards.repository.CardCriteria;
import mage.cards.repository.CardInfo;
import mage.cards.repository.CardRepository;
import mage.constants.Rarity;
import mage.constants.SetType;
import mage.util.RandomUtil;

/**
 *
 * @author fireshoes
 */
public class ShadowsOverInnistrad extends ExpansionSet {

    private static final ShadowsOverInnistrad instance = new ShadowsOverInnistrad();

    public static ShadowsOverInnistrad getInstance() {
        return instance;
    }

    protected final EnumMap<Rarity, List<CardInfo>> savedDoubleFacedCards;

    private ShadowsOverInnistrad() {
        super("Shadows over Innistrad", "SOI", ExpansionSet.buildDate(2016, 4, 8), SetType.EXPANSION);
        this.blockName = "Shadows over Innistrad";
        this.hasBoosters = true;
        this.hasBasicLands = true;
        this.numBoosterLands = 1;
        this.numBoosterCommon = 9;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 8;
        this.numBoosterDoubleFaced = 1;
        savedDoubleFacedCards = new EnumMap<>(Rarity.class);
        cards.add(new SetCardInfo("Aberrant Researcher", 49, Rarity.UNCOMMON, mage.cards.a.AberrantResearcher.class));
        cards.add(new SetCardInfo("Accursed Witch", 97, Rarity.UNCOMMON, mage.cards.a.AccursedWitch.class));
        cards.add(new SetCardInfo("Aim High", 193, Rarity.COMMON, mage.cards.a.AimHigh.class));
        cards.add(new SetCardInfo("Alms of the Vein", 98, Rarity.COMMON, mage.cards.a.AlmsOfTheVein.class));
        cards.add(new SetCardInfo("Altered Ego", 241, Rarity.RARE, mage.cards.a.AlteredEgo.class));
        cards.add(new SetCardInfo("Always Watching", 1, Rarity.RARE, mage.cards.a.AlwaysWatching.class));
        cards.add(new SetCardInfo("Ancient of the Equinox", 194, Rarity.UNCOMMON, mage.cards.a.AncientOfTheEquinox.class));
        cards.add(new SetCardInfo("Angelic Purge", 3, Rarity.COMMON, mage.cards.a.AngelicPurge.class));
        cards.add(new SetCardInfo("Angel of Deliverance", 2, Rarity.RARE, mage.cards.a.AngelOfDeliverance.class));
        cards.add(new SetCardInfo("Anguished Unmaking", 242, Rarity.RARE, mage.cards.a.AnguishedUnmaking.class));
        cards.add(new SetCardInfo("Apothecary Geist", 4, Rarity.COMMON, mage.cards.a.ApothecaryGeist.class));
        cards.add(new SetCardInfo("Archangel Avacyn", 5, Rarity.MYTHIC, mage.cards.a.ArchangelAvacyn.class));
        cards.add(new SetCardInfo("Arlinn, Embraced by the Moon", 243, Rarity.MYTHIC, mage.cards.a.ArlinnEmbracedByTheMoon.class));
        cards.add(new SetCardInfo("Arlinn Kord", 243, Rarity.MYTHIC, mage.cards.a.ArlinnKord.class));
        cards.add(new SetCardInfo("Ashmouth Blade", 260, Rarity.UNCOMMON, mage.cards.a.AshmouthBlade.class));
        cards.add(new SetCardInfo("Asylum Visitor", 99, Rarity.RARE, mage.cards.a.AsylumVisitor.class));
        cards.add(new SetCardInfo("Autumnal Gloom", 194, Rarity.UNCOMMON, mage.cards.a.AutumnalGloom.class));
        cards.add(new SetCardInfo("Avacynian Missionaries", 6, Rarity.UNCOMMON, mage.cards.a.AvacynianMissionaries.class));
        cards.add(new SetCardInfo("Avacyn's Judgment", 145, Rarity.RARE, mage.cards.a.AvacynsJudgment.class));
        cards.add(new SetCardInfo("Avacyn, the Purifier", 5, Rarity.MYTHIC, mage.cards.a.AvacynThePurifier.class));
        cards.add(new SetCardInfo("Awoken Horror", 92, Rarity.RARE, mage.cards.a.AwokenHorror.class));
        cards.add(new SetCardInfo("Bearer of Overwhelming Truths", 54, Rarity.UNCOMMON, mage.cards.b.BearerOfOverwhelmingTruths.class));
        cards.add(new SetCardInfo("Behind the Scenes", 100, Rarity.UNCOMMON, mage.cards.b.BehindTheScenes.class));
        cards.add(new SetCardInfo("Behold the Beyond", 101, Rarity.MYTHIC, mage.cards.b.BeholdTheBeyond.class));
        cards.add(new SetCardInfo("Biting Rain", 102, Rarity.UNCOMMON, mage.cards.b.BitingRain.class));
        cards.add(new SetCardInfo("Bloodmad Vampire", 146, Rarity.COMMON, mage.cards.b.BloodmadVampire.class));
        cards.add(new SetCardInfo("Bound by Moonsilver", 7, Rarity.UNCOMMON, mage.cards.b.BoundByMoonsilver.class));
        cards.add(new SetCardInfo("Brain in a Jar", 252, Rarity.RARE, mage.cards.b.BrainInAJar.class));
        cards.add(new SetCardInfo("Branded Howler", 149, Rarity.COMMON, mage.cards.b.BrandedHowler.class));
        cards.add(new SetCardInfo("Breakneck Rider", 147, Rarity.UNCOMMON, mage.cards.b.BreakneckRider.class));
        cards.add(new SetCardInfo("Briarbridge Patrol", 195, Rarity.UNCOMMON, mage.cards.b.BriarbridgePatrol.class));
        cards.add(new SetCardInfo("Broken Concentration", 50, Rarity.UNCOMMON, mage.cards.b.BrokenConcentration.class));
        cards.add(new SetCardInfo("Burn from Within", 148, Rarity.RARE, mage.cards.b.BurnFromWithin.class));
        cards.add(new SetCardInfo("Bygone Bishop", 8, Rarity.RARE, mage.cards.b.BygoneBishop.class));
        cards.add(new SetCardInfo("Byway Courier", 196, Rarity.COMMON, mage.cards.b.BywayCourier.class));
        cards.add(new SetCardInfo("Call the Bloodline", 103, Rarity.UNCOMMON, mage.cards.c.CallTheBloodline.class));
        cards.add(new SetCardInfo("Catalog", 51, Rarity.COMMON, mage.cards.c.Catalog.class));
        cards.add(new SetCardInfo("Cathar's Companion", 9, Rarity.COMMON, mage.cards.c.CatharsCompanion.class));
        cards.add(new SetCardInfo("Chaplain's Blessing", 10, Rarity.COMMON, mage.cards.c.ChaplainsBlessing.class));
        cards.add(new SetCardInfo("Choked Estuary", 270, Rarity.RARE, mage.cards.c.ChokedEstuary.class));
        cards.add(new SetCardInfo("Clip Wings", 197, Rarity.COMMON, mage.cards.c.ClipWings.class));
        cards.add(new SetCardInfo("Compelling Deterrence", 52, Rarity.UNCOMMON, mage.cards.c.CompellingDeterrence.class));
        cards.add(new SetCardInfo("Confirm Suspicions", 53, Rarity.RARE, mage.cards.c.ConfirmSuspicions.class));
        cards.add(new SetCardInfo("Confront the Unknown", 198, Rarity.COMMON, mage.cards.c.ConfrontTheUnknown.class));
        cards.add(new SetCardInfo("Convicted Killer", 149, Rarity.COMMON, mage.cards.c.ConvictedKiller.class));
        cards.add(new SetCardInfo("Corrupted Grafstone", 253, Rarity.RARE, mage.cards.c.CorruptedGrafstone.class));
        cards.add(new SetCardInfo("Crawling Sensation", 199, Rarity.UNCOMMON, mage.cards.c.CrawlingSensation.class));
        cards.add(new SetCardInfo("Creeping Dread", 104, Rarity.UNCOMMON, mage.cards.c.CreepingDread.class));
        cards.add(new SetCardInfo("Crow of Dark Tidings", 105, Rarity.COMMON, mage.cards.c.CrowOfDarkTidings.class));
        cards.add(new SetCardInfo("Cryptolith Rite", 200, Rarity.RARE, mage.cards.c.CryptolithRite.class));
        cards.add(new SetCardInfo("Cult of the Waxing Moon", 201, Rarity.UNCOMMON, mage.cards.c.CultOfTheWaxingMoon.class));
        cards.add(new SetCardInfo("Dance with Devils", 150, Rarity.UNCOMMON, mage.cards.d.DanceWithDevils.class));
        cards.add(new SetCardInfo("Daring Sleuth", 54, Rarity.UNCOMMON, mage.cards.d.DaringSleuth.class));
        cards.add(new SetCardInfo("Dauntless Cathar", 11, Rarity.COMMON, mage.cards.d.DauntlessCathar.class));
        cards.add(new SetCardInfo("Dead Weight", 106, Rarity.COMMON, mage.cards.d.DeadWeight.class));
        cards.add(new SetCardInfo("Deathcap Cultivator", 202, Rarity.RARE, mage.cards.d.DeathcapCultivator.class));
        cards.add(new SetCardInfo("Declaration in Stone", 12, Rarity.RARE, mage.cards.d.DeclarationInStone.class));
        cards.add(new SetCardInfo("Demon-Possessed Witch", 119, Rarity.UNCOMMON, mage.cards.d.DemonPossessedWitch.class));
        cards.add(new SetCardInfo("Deny Existence", 55, Rarity.COMMON, mage.cards.d.DenyExistence.class));
        cards.add(new SetCardInfo("Descend upon the Sinful", 13, Rarity.MYTHIC, mage.cards.d.DescendUponTheSinful.class));
        cards.add(new SetCardInfo("Devils' Playground", 151, Rarity.RARE, mage.cards.d.DevilsPlayground.class));
        cards.add(new SetCardInfo("Devilthorn Fox", 14, Rarity.COMMON, mage.cards.d.DevilthornFox.class));
        cards.add(new SetCardInfo("Diregraf Colossus", 107, Rarity.RARE, mage.cards.d.DiregrafColossus.class));
        cards.add(new SetCardInfo("Dissension in the Ranks", 152, Rarity.UNCOMMON, mage.cards.d.DissensionInTheRanks.class));
        cards.add(new SetCardInfo("Drogskol Cavalry", 15, Rarity.RARE, mage.cards.d.DrogskolCavalry.class));
        cards.add(new SetCardInfo("Drownyard Explorers", 56, Rarity.COMMON, mage.cards.d.DrownyardExplorers.class));
        cards.add(new SetCardInfo("Drownyard Temple", 271, Rarity.RARE, mage.cards.d.DrownyardTemple.class));
        cards.add(new SetCardInfo("Drunau Corpse Trawler", 57, Rarity.UNCOMMON, mage.cards.d.DrunauCorpseTrawler.class));
        cards.add(new SetCardInfo("Dual Shot", 153, Rarity.COMMON, mage.cards.d.DualShot.class));
        cards.add(new SetCardInfo("Duskwatch Recruiter", 203, Rarity.UNCOMMON, mage.cards.d.DuskwatchRecruiter.class));
        cards.add(new SetCardInfo("Eerie Interlude", 16, Rarity.RARE, mage.cards.e.EerieInterlude.class));
        cards.add(new SetCardInfo("Elusive Tormentor", 108, Rarity.RARE, mage.cards.e.ElusiveTormentor.class));
        cards.add(new SetCardInfo("Ember-Eye Wolf", 154, Rarity.COMMON, mage.cards.e.EmberEyeWolf.class));
        cards.add(new SetCardInfo("Emissary of the Sleepless", 17, Rarity.COMMON, mage.cards.e.EmissaryOfTheSleepless.class));
        cards.add(new SetCardInfo("Engulf the Shore", 58, Rarity.RARE, mage.cards.e.EngulfTheShore.class));
        cards.add(new SetCardInfo("Epiphany at the Drownyard", 59, Rarity.RARE, mage.cards.e.EpiphanyAtTheDrownyard.class));
        cards.add(new SetCardInfo("Epitaph Golem", 254, Rarity.UNCOMMON, mage.cards.e.EpitaphGolem.class));
        cards.add(new SetCardInfo("Equestrian Skill", 204, Rarity.COMMON, mage.cards.e.EquestrianSkill.class));
        cards.add(new SetCardInfo("Erdwal Illuminator", 60, Rarity.UNCOMMON, mage.cards.e.ErdwalIlluminator.class));
        cards.add(new SetCardInfo("Essence Flux", 61, Rarity.UNCOMMON, mage.cards.e.EssenceFlux.class));
        cards.add(new SetCardInfo("Ethereal Guidance", 18, Rarity.COMMON, mage.cards.e.EtherealGuidance.class));
        cards.add(new SetCardInfo("Ever After", 109, Rarity.RARE, mage.cards.e.EverAfter.class));
        cards.add(new SetCardInfo("Explosive Apparatus", 255, Rarity.COMMON, mage.cards.e.ExplosiveApparatus.class));
        cards.add(new SetCardInfo("Expose Evil", 19, Rarity.COMMON, mage.cards.e.ExposeEvil.class));
        cards.add(new SetCardInfo("Falkenrath Gorger", 155, Rarity.RARE, mage.cards.f.FalkenrathGorger.class));
        cards.add(new SetCardInfo("Farbog Revenant", 110, Rarity.COMMON, mage.cards.f.FarbogRevenant.class));
        cards.add(new SetCardInfo("Fevered Visions", 244, Rarity.RARE, mage.cards.f.FeveredVisions.class));
        cards.add(new SetCardInfo("Fiery Temper", 156, Rarity.COMMON, mage.cards.f.FieryTemper.class));
        cards.add(new SetCardInfo("Flameblade Angel", 157, Rarity.RARE, mage.cards.f.FlamebladeAngel.class));
        cards.add(new SetCardInfo("Flameheart Werewolf", 169, Rarity.UNCOMMON, mage.cards.f.FlameheartWerewolf.class));
        cards.add(new SetCardInfo("Fleeting Memories", 62, Rarity.UNCOMMON, mage.cards.f.FleetingMemories.class));
        cards.add(new SetCardInfo("Foreboding Ruins", 272, Rarity.RARE, mage.cards.f.ForebodingRuins.class));
        cards.add(new SetCardInfo("Forest", 295, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 296, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 297, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forgotten Creation", 63, Rarity.RARE, mage.cards.f.ForgottenCreation.class));
        cards.add(new SetCardInfo("Fork in the Road", 205, Rarity.COMMON, mage.cards.f.ForkInTheRoad.class));
        cards.add(new SetCardInfo("Forsaken Sanctuary", 273, Rarity.UNCOMMON, mage.cards.f.ForsakenSanctuary.class));
        cards.add(new SetCardInfo("Fortified Village", 274, Rarity.RARE, mage.cards.f.FortifiedVillage.class));
        cards.add(new SetCardInfo("Foul Orchard", 275, Rarity.UNCOMMON, mage.cards.f.FoulOrchard.class));
        cards.add(new SetCardInfo("From Under the Floorboards", 111, Rarity.RARE, mage.cards.f.FromUnderTheFloorboards.class));
        cards.add(new SetCardInfo("Furtive Homunculus", 64, Rarity.COMMON, mage.cards.f.FurtiveHomunculus.class));
        cards.add(new SetCardInfo("Game Trail", 276, Rarity.RARE, mage.cards.g.GameTrail.class));
        cards.add(new SetCardInfo("Gatstaf Arsonists", 158, Rarity.COMMON, mage.cards.g.GatstafArsonists.class));
        cards.add(new SetCardInfo("Gatstaf Ravagers", 158, Rarity.COMMON, mage.cards.g.GatstafRavagers.class));
        cards.add(new SetCardInfo("Geier Reach Bandit", 159, Rarity.RARE, mage.cards.g.GeierReachBandit.class));
        cards.add(new SetCardInfo("Geistblast", 160, Rarity.UNCOMMON, mage.cards.g.Geistblast.class));
        cards.add(new SetCardInfo("Geralf's Masterpiece", 65, Rarity.MYTHIC, mage.cards.g.GeralfsMasterpiece.class));
        cards.add(new SetCardInfo("Ghostly Wings", 66, Rarity.COMMON, mage.cards.g.GhostlyWings.class));
        cards.add(new SetCardInfo("Ghoulcaller's Accomplice", 112, Rarity.COMMON, mage.cards.g.GhoulcallersAccomplice.class));
        cards.add(new SetCardInfo("Ghoulsteed", 113, Rarity.UNCOMMON, mage.cards.g.Ghoulsteed.class));
        cards.add(new SetCardInfo("Gibbering Fiend", 161, Rarity.UNCOMMON, mage.cards.g.GibberingFiend.class));
        cards.add(new SetCardInfo("Gisa's Bidding", 114, Rarity.UNCOMMON, mage.cards.g.GisasBidding.class));
        cards.add(new SetCardInfo("Gloomwidow", 206, Rarity.UNCOMMON, mage.cards.g.Gloomwidow.class));
        cards.add(new SetCardInfo("Goldnight Castigator", 162, Rarity.MYTHIC, mage.cards.g.GoldnightCastigator.class));
        cards.add(new SetCardInfo("Gone Missing", 67, Rarity.COMMON, mage.cards.g.GoneMissing.class));
        cards.add(new SetCardInfo("Graf Mole", 207, Rarity.UNCOMMON, mage.cards.g.GrafMole.class));
        cards.add(new SetCardInfo("Grotesque Mutation", 115, Rarity.COMMON, mage.cards.g.GrotesqueMutation.class));
        cards.add(new SetCardInfo("Groundskeeper", 208, Rarity.UNCOMMON, mage.cards.g.Groundskeeper.class));
        cards.add(new SetCardInfo("Gryff's Boon", 20, Rarity.UNCOMMON, mage.cards.g.GryffsBoon.class));
        cards.add(new SetCardInfo("Hanweir Militia Captain", 21, Rarity.RARE, mage.cards.h.HanweirMilitiaCaptain.class));
        cards.add(new SetCardInfo("Harness the Storm", 163, Rarity.RARE, mage.cards.h.HarnessTheStorm.class));
        cards.add(new SetCardInfo("Harvest Hand", 256, Rarity.UNCOMMON, mage.cards.h.HarvestHand.class));
        cards.add(new SetCardInfo("Haunted Cloak", 257, Rarity.UNCOMMON, mage.cards.h.HauntedCloak.class));
        cards.add(new SetCardInfo("Heir of Falkenrath", 116, Rarity.UNCOMMON, mage.cards.h.HeirOfFalkenrath.class));
        cards.add(new SetCardInfo("Heir to the Night", 116, Rarity.UNCOMMON, mage.cards.h.HeirToTheNight.class));
        cards.add(new SetCardInfo("Hermit of the Natterknolls", 209, Rarity.UNCOMMON, mage.cards.h.HermitOfTheNatterknolls.class));
        cards.add(new SetCardInfo("Highland Lake", 277, Rarity.UNCOMMON, mage.cards.h.HighlandLake.class));
        cards.add(new SetCardInfo("Hinterland Logger", 210, Rarity.COMMON, mage.cards.h.HinterlandLogger.class));
        cards.add(new SetCardInfo("Hope Against Hope", 22, Rarity.UNCOMMON, mage.cards.h.HopeAgainstHope.class));
        cards.add(new SetCardInfo("Hound of the Farbogs", 117, Rarity.COMMON, mage.cards.h.HoundOfTheFarbogs.class));
        cards.add(new SetCardInfo("Howlpack Resurgence", 211, Rarity.UNCOMMON, mage.cards.h.HowlpackResurgence.class));
        cards.add(new SetCardInfo("Howlpack Wolf", 164, Rarity.COMMON, mage.cards.h.HowlpackWolf.class));
        cards.add(new SetCardInfo("Hulking Devil", 165, Rarity.COMMON, mage.cards.h.HulkingDevil.class));
        cards.add(new SetCardInfo("Humble the Brute", 23, Rarity.UNCOMMON, mage.cards.h.HumbleTheBrute.class));
        cards.add(new SetCardInfo("Incited Rabble", 46, Rarity.UNCOMMON, mage.cards.i.IncitedRabble.class));
        cards.add(new SetCardInfo("Incorrigible Youths", 166, Rarity.UNCOMMON, mage.cards.i.IncorrigibleYouths.class));
        cards.add(new SetCardInfo("Indulgent Aristocrat", 118, Rarity.UNCOMMON, mage.cards.i.IndulgentAristocrat.class));
        cards.add(new SetCardInfo("Inexorable Blob", 212, Rarity.RARE, mage.cards.i.InexorableBlob.class));
        cards.add(new SetCardInfo("Infectious Curse", 97, Rarity.UNCOMMON, mage.cards.i.InfectiousCurse.class));
        cards.add(new SetCardInfo("Inner Struggle", 167, Rarity.UNCOMMON, mage.cards.i.InnerStruggle.class));
        cards.add(new SetCardInfo("Inquisitor's Ox", 24, Rarity.COMMON, mage.cards.i.InquisitorsOx.class));
        cards.add(new SetCardInfo("Insidious Mist", 108, Rarity.RARE, mage.cards.i.InsidiousMist.class));
        cards.add(new SetCardInfo("Insolent Neonate", 168, Rarity.COMMON, mage.cards.i.InsolentNeonate.class));
        cards.add(new SetCardInfo("Inspiring Captain", 25, Rarity.COMMON, mage.cards.i.InspiringCaptain.class));
        cards.add(new SetCardInfo("Intrepid Provisioner", 213, Rarity.COMMON, mage.cards.i.IntrepidProvisioner.class));
        cards.add(new SetCardInfo("Invasive Surgery", 68, Rarity.UNCOMMON, mage.cards.i.InvasiveSurgery.class));
        cards.add(new SetCardInfo("Invocation of Saint Traft", 246, Rarity.RARE, mage.cards.i.InvocationOfSaintTraft.class));
        cards.add(new SetCardInfo("Island", 286, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 287, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 288, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Jace's Scrutiny", 70, Rarity.COMMON, mage.cards.j.JacesScrutiny.class));
        cards.add(new SetCardInfo("Jace, Unraveler of Secrets", 69, Rarity.MYTHIC, mage.cards.j.JaceUnravelerOfSecrets.class));
        cards.add(new SetCardInfo("Just the Wind", 71, Rarity.COMMON, mage.cards.j.JustTheWind.class));
        cards.add(new SetCardInfo("Kessig Dire Swine", 214, Rarity.COMMON, mage.cards.k.KessigDireSwine.class));
        cards.add(new SetCardInfo("Kessig Forgemaster", 169, Rarity.UNCOMMON, mage.cards.k.KessigForgemaster.class));
        cards.add(new SetCardInfo("Kindly Stranger", 119, Rarity.UNCOMMON, mage.cards.k.KindlyStranger.class));
        cards.add(new SetCardInfo("Krallenhorde Howler", 203, Rarity.UNCOMMON, mage.cards.k.KrallenhordeHowler.class));
        cards.add(new SetCardInfo("Lambholt Butcher", 215, Rarity.UNCOMMON, mage.cards.l.LambholtButcher.class));
        cards.add(new SetCardInfo("Lambholt Pacifist", 215, Rarity.UNCOMMON, mage.cards.l.LambholtPacifist.class));
        cards.add(new SetCardInfo("Lamplighter of Selhoff", 72, Rarity.COMMON, mage.cards.l.LamplighterOfSelhoff.class));
        cards.add(new SetCardInfo("Lightning Axe", 170, Rarity.UNCOMMON, mage.cards.l.LightningAxe.class));
        cards.add(new SetCardInfo("Liliana's Indignation", 120, Rarity.UNCOMMON, mage.cards.l.LilianasIndignation.class));
        cards.add(new SetCardInfo("Loam Dryad", 216, Rarity.COMMON, mage.cards.l.LoamDryad.class));
        cards.add(new SetCardInfo("Lone Wolf of the Natterknolls", 209, Rarity.UNCOMMON, mage.cards.l.LoneWolfOfTheNatterknolls.class));
        cards.add(new SetCardInfo("Lunarch Inquisitors", 6, Rarity.UNCOMMON, mage.cards.l.LunarchInquisitors.class));
        cards.add(new SetCardInfo("Macabre Waltz", 121, Rarity.COMMON, mage.cards.m.MacabreWaltz.class));
        cards.add(new SetCardInfo("Mad Prophet", 171, Rarity.UNCOMMON, mage.cards.m.MadProphet.class));
        cards.add(new SetCardInfo("Magmatic Chasm", 172, Rarity.COMMON, mage.cards.m.MagmaticChasm.class));
        cards.add(new SetCardInfo("Magnifying Glass", 258, Rarity.UNCOMMON, mage.cards.m.MagnifyingGlass.class));
        cards.add(new SetCardInfo("Malevolent Whispers", 173, Rarity.UNCOMMON, mage.cards.m.MalevolentWhispers.class));
        cards.add(new SetCardInfo("Manic Scribe", 73, Rarity.UNCOMMON, mage.cards.m.ManicScribe.class));
        cards.add(new SetCardInfo("Markov Dreadknight", 122, Rarity.RARE, mage.cards.m.MarkovDreadknight.class));
        cards.add(new SetCardInfo("Merciless Resolve", 123, Rarity.COMMON, mage.cards.m.MercilessResolve.class));
        cards.add(new SetCardInfo("Might Beyond Reason", 217, Rarity.COMMON, mage.cards.m.MightBeyondReason.class));
        cards.add(new SetCardInfo("Militant Inquisitor", 26, Rarity.COMMON, mage.cards.m.MilitantInquisitor.class));
        cards.add(new SetCardInfo("Mindwrack Demon", 124, Rarity.MYTHIC, mage.cards.m.MindwrackDemon.class));
        cards.add(new SetCardInfo("Moldgraf Scavenger", 218, Rarity.COMMON, mage.cards.m.MoldgrafScavenger.class));
        cards.add(new SetCardInfo("Moonlight Hunt", 219, Rarity.UNCOMMON, mage.cards.m.MoonlightHunt.class));
        cards.add(new SetCardInfo("Moonrise Intruder", 190, Rarity.UNCOMMON, mage.cards.m.MoonriseIntruder.class));
        cards.add(new SetCardInfo("Moorland Drifter", 27, Rarity.COMMON, mage.cards.m.MoorlandDrifter.class));
        cards.add(new SetCardInfo("Morkrut Necropod", 125, Rarity.UNCOMMON, mage.cards.m.MorkrutNecropod.class));
        cards.add(new SetCardInfo("Mountain", 292, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 293, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 294, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Murderer's Axe", 259, Rarity.UNCOMMON, mage.cards.m.MurderersAxe.class));
        cards.add(new SetCardInfo("Murderous Compulsion", 126, Rarity.COMMON, mage.cards.m.MurderousCompulsion.class));
        cards.add(new SetCardInfo("Nagging Thoughts", 74, Rarity.COMMON, mage.cards.n.NaggingThoughts.class));
        cards.add(new SetCardInfo("Nahiri's Machinations", 28, Rarity.UNCOMMON, mage.cards.n.NahirisMachinations.class));
        cards.add(new SetCardInfo("Nahiri, the Harbinger", 247, Rarity.MYTHIC, mage.cards.n.NahiriTheHarbinger.class));
        cards.add(new SetCardInfo("Nearheath Chaplain", 29, Rarity.UNCOMMON, mage.cards.n.NearheathChaplain.class));
        cards.add(new SetCardInfo("Neck Breaker", 147, Rarity.UNCOMMON, mage.cards.n.NeckBreaker.class));
        cards.add(new SetCardInfo("Neglected Heirloom", 260, Rarity.UNCOMMON, mage.cards.n.NeglectedHeirloom.class));
        cards.add(new SetCardInfo("Nephalia Moondrakes", 75, Rarity.RARE, mage.cards.n.NephaliaMoondrakes.class));
        cards.add(new SetCardInfo("Niblis of Dusk", 76, Rarity.COMMON, mage.cards.n.NiblisOfDusk.class));
        cards.add(new SetCardInfo("Not Forgotten", 30, Rarity.UNCOMMON, mage.cards.n.NotForgotten.class));
        cards.add(new SetCardInfo("Obsessive Skinner", 220, Rarity.UNCOMMON, mage.cards.o.ObsessiveSkinner.class));
        cards.add(new SetCardInfo("Odric, Lunarch Marshal", 31, Rarity.RARE, mage.cards.o.OdricLunarchMarshal.class));
        cards.add(new SetCardInfo("Olivia, Mobilized for War", 248, Rarity.MYTHIC, mage.cards.o.OliviaMobilizedForWar.class));
        cards.add(new SetCardInfo("Olivia's Bloodsworn", 127, Rarity.UNCOMMON, mage.cards.o.OliviasBloodsworn.class));
        cards.add(new SetCardInfo("One of the Pack", 229, Rarity.COMMON, mage.cards.o.OneOfThePack.class));
        cards.add(new SetCardInfo("Ongoing Investigation", 77, Rarity.UNCOMMON, mage.cards.o.OngoingInvestigation.class));
        cards.add(new SetCardInfo("Open the Armory", 32, Rarity.UNCOMMON, mage.cards.o.OpenTheArmory.class));
        cards.add(new SetCardInfo("Ormendahl, Profane Prince", 281, Rarity.RARE, mage.cards.o.OrmendahlProfanePrince.class));
        cards.add(new SetCardInfo("Pack Guardian", 221, Rarity.UNCOMMON, mage.cards.p.PackGuardian.class));
        cards.add(new SetCardInfo("Pale Rider of Trostad", 128, Rarity.UNCOMMON, mage.cards.p.PaleRiderOfTrostad.class));
        cards.add(new SetCardInfo("Paranoid Parish-Blade", 33, Rarity.UNCOMMON, mage.cards.p.ParanoidParishBlade.class));
        cards.add(new SetCardInfo("Perfected Form", 49, Rarity.UNCOMMON, mage.cards.p.PerfectedForm.class));
        cards.add(new SetCardInfo("Persistent Nightmare", 88, Rarity.MYTHIC, mage.cards.p.PersistentNightmare.class));
        cards.add(new SetCardInfo("Pick the Brain", 129, Rarity.UNCOMMON, mage.cards.p.PickTheBrain.class));
        cards.add(new SetCardInfo("Pieces of the Puzzle", 78, Rarity.COMMON, mage.cards.p.PiecesOfThePuzzle.class));
        cards.add(new SetCardInfo("Pious Evangel", 34, Rarity.UNCOMMON, mage.cards.p.PiousEvangel.class));
        cards.add(new SetCardInfo("Plains", 283, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 284, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 285, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Pore Over the Pages", 79, Rarity.UNCOMMON, mage.cards.p.PoreOverThePages.class));
        cards.add(new SetCardInfo("Port Town", 278, Rarity.RARE, mage.cards.p.PortTown.class));
        cards.add(new SetCardInfo("Press for Answers", 80, Rarity.COMMON, mage.cards.p.PressForAnswers.class));
        cards.add(new SetCardInfo("Prized Amalgam", 249, Rarity.RARE, mage.cards.p.PrizedAmalgam.class));
        cards.add(new SetCardInfo("Puncturing Light", 35, Rarity.COMMON, mage.cards.p.PuncturingLight.class));
        cards.add(new SetCardInfo("Pyre Hound", 174, Rarity.COMMON, mage.cards.p.PyreHound.class));
        cards.add(new SetCardInfo("Quilled Wolf", 222, Rarity.COMMON, mage.cards.q.QuilledWolf.class));
        cards.add(new SetCardInfo("Rabid Bite", 223, Rarity.COMMON, mage.cards.r.RabidBite.class));
        cards.add(new SetCardInfo("Rancid Rats", 130, Rarity.COMMON, mage.cards.r.RancidRats.class));
        cards.add(new SetCardInfo("Rattlechains", 81, Rarity.RARE, mage.cards.r.Rattlechains.class));
        cards.add(new SetCardInfo("Ravenous Bloodseeker", 175, Rarity.UNCOMMON, mage.cards.r.RavenousBloodseeker.class));
        cards.add(new SetCardInfo("Reaper of Flight Moonsilver", 36, Rarity.UNCOMMON, mage.cards.r.ReaperOfFlightMoonsilver.class));
        cards.add(new SetCardInfo("Reckless Scholar", 82, Rarity.UNCOMMON, mage.cards.r.RecklessScholar.class));
        cards.add(new SetCardInfo("Reduce to Ashes", 176, Rarity.COMMON, mage.cards.r.ReduceToAshes.class));
        cards.add(new SetCardInfo("Relentless Dead", 131, Rarity.MYTHIC, mage.cards.r.RelentlessDead.class));
        cards.add(new SetCardInfo("Rise from the Tides", 83, Rarity.UNCOMMON, mage.cards.r.RiseFromTheTides.class));
        cards.add(new SetCardInfo("Root Out", 224, Rarity.COMMON, mage.cards.r.RootOut.class));
        cards.add(new SetCardInfo("Rottenheart Ghoul", 132, Rarity.COMMON, mage.cards.r.RottenheartGhoul.class));
        cards.add(new SetCardInfo("Runaway Carriage", 261, Rarity.UNCOMMON, mage.cards.r.RunawayCarriage.class));
        cards.add(new SetCardInfo("Rush of Adrenaline", 177, Rarity.COMMON, mage.cards.r.RushOfAdrenaline.class));
        cards.add(new SetCardInfo("Sage of Ancient Lore", 225, Rarity.RARE, mage.cards.s.SageOfAncientLore.class));
        cards.add(new SetCardInfo("Sanguinary Mage", 178, Rarity.COMMON, mage.cards.s.SanguinaryMage.class));
        cards.add(new SetCardInfo("Sanitarium Skeleton", 133, Rarity.COMMON, mage.cards.s.SanitariumSkeleton.class));
        cards.add(new SetCardInfo("Scourge Wolf", 179, Rarity.RARE, mage.cards.s.ScourgeWolf.class));
        cards.add(new SetCardInfo("Scrounged Scythe", 256, Rarity.UNCOMMON, mage.cards.s.ScroungedScythe.class));
        cards.add(new SetCardInfo("Seagraf Skaab", 84, Rarity.COMMON, mage.cards.s.SeagrafSkaab.class));
        cards.add(new SetCardInfo("Seasons Past", 226, Rarity.MYTHIC, mage.cards.s.SeasonsPast.class));
        cards.add(new SetCardInfo("Second Harvest", 227, Rarity.RARE, mage.cards.s.SecondHarvest.class));
        cards.add(new SetCardInfo("Senseless Rage", 180, Rarity.COMMON, mage.cards.s.SenselessRage.class));
        cards.add(new SetCardInfo("Shamble Back", 134, Rarity.COMMON, mage.cards.s.ShambleBack.class));
        cards.add(new SetCardInfo("Shard of Broken Glass", 262, Rarity.COMMON, mage.cards.s.ShardOfBrokenGlass.class));
        cards.add(new SetCardInfo("Sigarda, Heron's Grace", 250, Rarity.MYTHIC, mage.cards.s.SigardaHeronsGrace.class));
        cards.add(new SetCardInfo("Silburlind Snapper", 85, Rarity.COMMON, mage.cards.s.SilburlindSnapper.class));
        cards.add(new SetCardInfo("Silent Observer", 86, Rarity.COMMON, mage.cards.s.SilentObserver.class));
        cards.add(new SetCardInfo("Silverfur Partisan", 228, Rarity.RARE, mage.cards.s.SilverfurPartisan.class));
        cards.add(new SetCardInfo("Silverstrike", 37, Rarity.UNCOMMON, mage.cards.s.Silverstrike.class));
        cards.add(new SetCardInfo("Sinister Concoction", 135, Rarity.UNCOMMON, mage.cards.s.SinisterConcoction.class));
        cards.add(new SetCardInfo("Sin Prodder", 181, Rarity.RARE, mage.cards.s.SinProdder.class));
        cards.add(new SetCardInfo("Skeleton Key", 263, Rarity.UNCOMMON, mage.cards.s.SkeletonKey.class));
        cards.add(new SetCardInfo("Skin Invasion", 182, Rarity.UNCOMMON, mage.cards.s.SkinInvasion.class));
        cards.add(new SetCardInfo("Skin Shedder", 182, Rarity.UNCOMMON, mage.cards.s.SkinShedder.class));
        cards.add(new SetCardInfo("Slayer's Plate", 264, Rarity.RARE, mage.cards.s.SlayersPlate.class));
        cards.add(new SetCardInfo("Sleep Paralysis", 87, Rarity.COMMON, mage.cards.s.SleepParalysis.class));
        cards.add(new SetCardInfo("Solitary Hunter", 229, Rarity.COMMON, mage.cards.s.SolitaryHunter.class));
        cards.add(new SetCardInfo("Sorin, Grim Nemesis", 251, Rarity.MYTHIC, mage.cards.s.SorinGrimNemesis.class));
        cards.add(new SetCardInfo("Soul Swallower", 230, Rarity.RARE, mage.cards.s.SoulSwallower.class));
        cards.add(new SetCardInfo("Spectral Shepherd", 38, Rarity.UNCOMMON, mage.cards.s.SpectralShepherd.class));
        cards.add(new SetCardInfo("Spiteful Motives", 183, Rarity.UNCOMMON, mage.cards.s.SpitefulMotives.class));
        cards.add(new SetCardInfo("Stallion of Ashmouth", 136, Rarity.COMMON, mage.cards.s.StallionOfAshmouth.class));
        cards.add(new SetCardInfo("Startled Awake", 88, Rarity.MYTHIC, mage.cards.s.StartledAwake.class));
        cards.add(new SetCardInfo("Stensia Masquerade", 184, Rarity.UNCOMMON, mage.cards.s.StensiaMasquerade.class));
        cards.add(new SetCardInfo("Stern Constable", 39, Rarity.COMMON, mage.cards.s.SternConstable.class));
        cards.add(new SetCardInfo("Stitched Mangler", 89, Rarity.COMMON, mage.cards.s.StitchedMangler.class));
        cards.add(new SetCardInfo("Stitchwing Skaab", 90, Rarity.UNCOMMON, mage.cards.s.StitchwingSkaab.class));
        cards.add(new SetCardInfo("Stoic Builder", 231, Rarity.COMMON, mage.cards.s.StoicBuilder.class));
        cards.add(new SetCardInfo("Stone Quarry", 279, Rarity.UNCOMMON, mage.cards.s.StoneQuarry.class));
        cards.add(new SetCardInfo("Stonewing Antagonizer", 266, Rarity.UNCOMMON, mage.cards.s.StonewingAntagonizer.class));
        cards.add(new SetCardInfo("Stormrider Spirit", 91, Rarity.COMMON, mage.cards.s.StormriderSpirit.class));
        cards.add(new SetCardInfo("Strength of Arms", 40, Rarity.COMMON, mage.cards.s.StrengthOfArms.class));
        cards.add(new SetCardInfo("Stromkirk Mentor", 137, Rarity.COMMON, mage.cards.s.StromkirkMentor.class));
        cards.add(new SetCardInfo("Structural Distortion", 185, Rarity.COMMON, mage.cards.s.StructuralDistortion.class));
        cards.add(new SetCardInfo("Survive the Night", 41, Rarity.COMMON, mage.cards.s.SurviveTheNight.class));
        cards.add(new SetCardInfo("Swamp", 289, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 290, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 291, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Tamiyo's Journal", 265, Rarity.RARE, mage.cards.t.TamiyosJournal.class));
        cards.add(new SetCardInfo("Tenacity", 42, Rarity.UNCOMMON, mage.cards.t.Tenacity.class));
        cards.add(new SetCardInfo("Thalia's Lieutenant", 43, Rarity.RARE, mage.cards.t.ThaliasLieutenant.class));
        cards.add(new SetCardInfo("The Gitrog Monster", 245, Rarity.MYTHIC, mage.cards.t.TheGitrogMonster.class));
        cards.add(new SetCardInfo("Thing in the Ice", 92, Rarity.RARE, mage.cards.t.ThingInTheIce.class));
        cards.add(new SetCardInfo("Thornhide Wolves", 232, Rarity.COMMON, mage.cards.t.ThornhideWolves.class));
        cards.add(new SetCardInfo("Thraben Gargoyle", 266, Rarity.UNCOMMON, mage.cards.t.ThrabenGargoyle.class));
        cards.add(new SetCardInfo("Thraben Inspector", 44, Rarity.COMMON, mage.cards.t.ThrabenInspector.class));
        cards.add(new SetCardInfo("Throttle", 138, Rarity.COMMON, mage.cards.t.Throttle.class));
        cards.add(new SetCardInfo("Timber Shredder", 210, Rarity.COMMON, mage.cards.t.TimberShredder.class));
        cards.add(new SetCardInfo("Tireless Tracker", 233, Rarity.RARE, mage.cards.t.TirelessTracker.class));
        cards.add(new SetCardInfo("Tooth Collector", 140, Rarity.UNCOMMON, mage.cards.t.ToothCollector.class));
        cards.add(new SetCardInfo("Topplegeist", 45, Rarity.UNCOMMON, mage.cards.t.Topplegeist.class));
        cards.add(new SetCardInfo("Tormenting Voice", 186, Rarity.COMMON, mage.cards.t.TormentingVoice.class));
        cards.add(new SetCardInfo("To the Slaughter", 139, Rarity.RARE, mage.cards.t.ToTheSlaughter.class));
        cards.add(new SetCardInfo("Town Gossipmonger", 46, Rarity.UNCOMMON, mage.cards.t.TownGossipmonger.class));
        cards.add(new SetCardInfo("Trail of Evidence", 93, Rarity.UNCOMMON, mage.cards.t.TrailOfEvidence.class));
        cards.add(new SetCardInfo("Traverse the Ulvenwald", 234, Rarity.RARE, mage.cards.t.TraverseTheUlvenwald.class));
        cards.add(new SetCardInfo("Triskaidekaphobia", 141, Rarity.RARE, mage.cards.t.Triskaidekaphobia.class));
        cards.add(new SetCardInfo("True-Faith Censer", 267, Rarity.COMMON, mage.cards.t.TrueFaithCenser.class));
        cards.add(new SetCardInfo("Twins of Maurer Estate", 142, Rarity.COMMON, mage.cards.t.TwinsOfMaurerEstate.class));
        cards.add(new SetCardInfo("Ulrich's Kindred", 187, Rarity.UNCOMMON, mage.cards.u.UlrichsKindred.class));
        cards.add(new SetCardInfo("Ulvenwald Hydra", 235, Rarity.MYTHIC, mage.cards.u.UlvenwaldHydra.class));
        cards.add(new SetCardInfo("Ulvenwald Mysteries", 236, Rarity.UNCOMMON, mage.cards.u.UlvenwaldMysteries.class));
        cards.add(new SetCardInfo("Uncaged Fury", 188, Rarity.COMMON, mage.cards.u.UncagedFury.class));
        cards.add(new SetCardInfo("Unimpeded Trespasser", 94, Rarity.UNCOMMON, mage.cards.u.UnimpededTrespasser.class));
        cards.add(new SetCardInfo("Uninvited Geist", 94, Rarity.UNCOMMON, mage.cards.u.UninvitedGeist.class));
        cards.add(new SetCardInfo("Unruly Mob", 47, Rarity.COMMON, mage.cards.u.UnrulyMob.class));
        cards.add(new SetCardInfo("Vampire Noble", 143, Rarity.COMMON, mage.cards.v.VampireNoble.class));
        cards.add(new SetCardInfo("Vessel of Ephemera", 48, Rarity.COMMON, mage.cards.v.VesselOfEphemera.class));
        cards.add(new SetCardInfo("Vessel of Malignity", 144, Rarity.COMMON, mage.cards.v.VesselOfMalignity.class));
        cards.add(new SetCardInfo("Vessel of Nascency", 237, Rarity.COMMON, mage.cards.v.VesselOfNascency.class));
        cards.add(new SetCardInfo("Vessel of Paramnesia", 95, Rarity.COMMON, mage.cards.v.VesselOfParamnesia.class));
        cards.add(new SetCardInfo("Vessel of Volatility", 189, Rarity.COMMON, mage.cards.v.VesselOfVolatility.class));
        cards.add(new SetCardInfo("Veteran Cathar", 238, Rarity.UNCOMMON, mage.cards.v.VeteranCathar.class));
        cards.add(new SetCardInfo("Vildin-Pack Alpha", 159, Rarity.RARE, mage.cards.v.VildinPackAlpha.class));
        cards.add(new SetCardInfo("Village Messenger", 190, Rarity.UNCOMMON, mage.cards.v.VillageMessenger.class));
        cards.add(new SetCardInfo("Voldaren Duelist", 191, Rarity.COMMON, mage.cards.v.VoldarenDuelist.class));
        cards.add(new SetCardInfo("Warped Landscape", 280, Rarity.COMMON, mage.cards.w.WarpedLandscape.class));
        cards.add(new SetCardInfo("Watcher in the Web", 239, Rarity.COMMON, mage.cards.w.WatcherInTheWeb.class));
        cards.add(new SetCardInfo("Wayward Disciple", 34, Rarity.UNCOMMON, mage.cards.w.WaywardDisciple.class));
        cards.add(new SetCardInfo("Weirding Wood", 240, Rarity.UNCOMMON, mage.cards.w.WeirdingWood.class));
        cards.add(new SetCardInfo("Welcome to the Fold", 96, Rarity.RARE, mage.cards.w.WelcomeToTheFold.class));
        cards.add(new SetCardInfo("Werewolf of Ancient Hunger", 225, Rarity.RARE, mage.cards.w.WerewolfOfAncientHunger.class));
        cards.add(new SetCardInfo("Westvale Abbey", 281, Rarity.RARE, mage.cards.w.WestvaleAbbey.class));
        cards.add(new SetCardInfo("Westvale Cult Leader", 21, Rarity.RARE, mage.cards.w.WestvaleCultLeader.class));
        cards.add(new SetCardInfo("Wicker Witch", 268, Rarity.COMMON, mage.cards.w.WickerWitch.class));
        cards.add(new SetCardInfo("Wild-Field Scarecrow", 269, Rarity.UNCOMMON, mage.cards.w.WildFieldScarecrow.class));
        cards.add(new SetCardInfo("Wolf of Devil's Breach", 192, Rarity.MYTHIC, mage.cards.w.WolfOfDevilsBreach.class));
        cards.add(new SetCardInfo("Woodland Stream", 282, Rarity.UNCOMMON, mage.cards.w.WoodlandStream.class));
    }

    /* add double faced card for SOI booster
     * add only common or uncommon
     */
    @Override
    public void addDoubleFace(List<Card> booster) {
        for (int i = 0; i < numBoosterDoubleFaced; i++) {
            List<CardInfo> doubleFacedCards;
            if (RandomUtil.nextInt(15) < 10) {
                doubleFacedCards = getDoubleFacedCardsByRarity(Rarity.COMMON);
            } else {
                doubleFacedCards = getDoubleFacedCardsByRarity(Rarity.UNCOMMON);
            }
            addToBooster(booster, doubleFacedCards);
        }
    }

    public List<CardInfo> getDoubleFacedCardsByRarity(Rarity rarity) {
        List<CardInfo> savedCardsInfos = savedDoubleFacedCards.get(rarity);
        if (savedCardsInfos == null) {
            CardCriteria criteria = new CardCriteria();
            criteria.setCodes(getCode());
            criteria.rarities(rarity);
            criteria.doubleFaced(true);
            savedCardsInfos = CardRepository.instance.findCards(criteria);
            savedDoubleFacedCards.put(rarity, savedCardsInfos);
        }
        // Return a copy of the saved cards information, as not to let modify the original.
        return new ArrayList<>(savedCardsInfos);
    }

    @Override
    public int getNumberOfSpecialCommons() {
        // Then about an eighth of the packs will have a second double-faced card, which will be a rare or mythic rare.
        return RandomUtil.nextInt(8) == 0 ? 1 : 0;
    }

    @Override
    public void addSpecialCommon(List<Card> booster, int number) {
        // number is here always 1
        List<CardInfo> doubleFacedCards;
        if (RandomUtil.nextInt(8) > 0) {
            doubleFacedCards = getDoubleFacedCardsByRarity(Rarity.RARE);
        } else {
            doubleFacedCards = getDoubleFacedCardsByRarity(Rarity.MYTHIC);
        }
        addToBooster(booster, doubleFacedCards);
    }

}
