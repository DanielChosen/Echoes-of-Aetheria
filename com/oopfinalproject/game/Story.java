package com.oopfinalproject.game;


import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.*;
import com.oopfinalproject.items.*;
import com.oopfinalproject.game.handlers.ChoiceHandler;
import com.oopfinalproject.game.storyscenes.PrologueScenes;
import com.oopfinalproject.game.storyscenes.act1.*;
import com.oopfinalproject.game.storyscenes.act2.*;
import com.oopfinalproject.game.storyscenes.act3.*;



public class Story {

    Game game;
    UI ui;
    Player player;

    // Scene modules
    PrologueScenes prologue;
    Act1IntroScenes act1Intro;
    Act1CityScenes act1City;
    Act1ForestScenes act1Forest;
    Act1DungeonScenes act1Dungeon;

    Act2TheBlizzard act2Blizzard;
    Act2EtherealBeauty act2Ethereal;
    Act2SandWorms act2Worms;
    Act2ColdDesertNight act2coldnights;
    Act2SandStorm act2sandstorm;
    Act2TheKnight act2knight;
    Act2TheDarkStringOfFate act2darkstring;

    Act3TheAirship act3airship;
    Act3Preparation act3preparation;
    Act3OneLastFight act3onelastfight;
    Act3TheBeginningofTheEnd act3beginning;
    Act3TheAfterMathofShadow act3shadow;
    Act3Epilogue act3epilogue;

    public Story(Game g, UI userInterface){
        game = g;
        ui = userInterface;
        player = Player.getInstance();

        // Initialize scene modules
        prologue = new PrologueScenes(game, ui, player);
        act1Intro = new Act1IntroScenes(game, ui, player);
        act1City = new Act1CityScenes(game, ui, player);
        act1Forest = new Act1ForestScenes(game, ui, player);
        act1Dungeon = new Act1DungeonScenes(game, ui, player);
        
        

        //act 2
        act2Blizzard = new Act2TheBlizzard(game, ui, player);
        act2Ethereal = new Act2EtherealBeauty(game, ui, player);
        act2Worms = new Act2SandWorms(game, ui, player);
        act2coldnights = new Act2ColdDesertNight(game, ui, player);
        act2Worms = new Act2SandWorms(g, ui, player);
        act2sandstorm = new Act2SandStorm(game, ui, player);
        act2knight = new Act2TheKnight(game, ui, player);
        act2darkstring = new Act2TheDarkStringOfFate(game, ui, player);

        act3airship = new Act3TheAirship(game, ui, player);
        act3preparation = new Act3Preparation(game, ui, player);
        act3onelastfight = new Act3OneLastFight(game, ui, player);
        act3beginning = new Act3TheBeginningofTheEnd(game, ui, player);
        act3shadow = new Act3TheAfterMathofShadow(game, ui, player);
        act3epilogue = new Act3Epilogue(game, ui, player);
    }

    public void defaultSetup(){
        
    }

    public void selectPosition(String nextPosition){
        switch(nextPosition){
            case "START" -> {
                game.vm.titleToTown(); // switch UI to main game
                prologue.Village();     // start first scene
            }
            case "Village" -> prologue.Village();
            case "Tutorial" -> prologue.scene_Tutorial();
            case "rest" -> prologue.scene_rest();
            case "theCrystal" -> act1Intro.scene_theCrystal();
            case "villageFight" -> act1Intro.scene_villageFight();
            case "firstBattle" -> act1Intro.scene_firstBattle();
            case "firstBattle2" -> act1Intro.scene_firstBattle2();
            case "afterBattle" -> act1Intro.scene_firstBattle_outcome();
            case "theBeginningOfAJourney" -> act1Intro.scene_theBeginningOfAJourney();
            case "saveHerBattle" -> act1Intro.scene_saveHerBattle();
            case "saveHerOutcome" -> act1Intro.scene_saveHerOutcome();
            case "ignoreHerOutcome" -> act1Intro.scene_ignoreHerOutcome();
            case "cityExploration" -> act1Intro.scene_cityExploration();
            case "MysteriousOldMan" -> act1City.city_MysteriousOldMan();
            case "BlackSmith" -> act1City.city_BlackSmith();
            case "MageShop" -> act1City.city_MageShop();
            case "Guild" -> act1City.city_Guild();
            case "scene_TheForest" -> act1Forest.scene_TheForest();
            case "scene_theGraveyard" -> act1Forest.scene_theGraveyard();
            case "success_fightTheGhouls" -> act1Forest.success_fightTheGhouls();
            case "success_escapeTheGhouls" -> act1Forest.success_escapeTheGhouls();
            case "failure_escapeTheGhouls" -> act1Forest.failure_escapeTheGhouls();
            case "scene_hiddenDungeon" -> act1Dungeon.scene_hiddenDungeon();
            case "success_inspectTheArea" -> act1Dungeon.success_inspectTheArea();
            case "failure_inspectTheArea" -> act1Dungeon.failure_inspectTheArea();
            case "success_inspectTheSkeletons" -> act1Dungeon.success_inspectTheSkeletons();
            case "failure_inspectTheSkeletons" -> act1Dungeon.failure_inspectTheSkeletons();
            case "scene_continueExploring" -> act1Dungeon.scene_continueExploring();
            case "scene_goLeft" -> act1Dungeon.scene_goLeft();
            case "scene_darkWolves" -> act1Dungeon.scene_darkWolves();
            case "scene_ruinedChurch" -> act1Dungeon.scene_ruinedChurch();
            case "failure_inspectTheRuinedChurchArea" -> act1Dungeon.failure_inspectTheRuinedChurchArea();
            case "scene_passageOfThePast" -> act1Dungeon.scene_passageOfThePast();
            case "scene_theElderGolem" -> act1Dungeon.scene_theElderGolem();
            case "success_theElderGolem" -> act1Dungeon.success_theElderGolem();
            case "scene_darkness" -> act1Dungeon.scene_darkness();

            //act 2 case
            // messy ahh code
            case "scene_theHero" -> act2Blizzard.scene_theHero();
            case "scene_hiddenClues" -> act2Blizzard.scene_hiddenClues();
            case "scene_library" -> act2Blizzard.scene_library();
            case "scene_theClimb" -> act2Blizzard.scene_theClimb();
            case "scene_theClimbBlacksmith" -> act2Blizzard.scene_theClimbBlacksmith();
            case "scene_theMountainPath" -> act2Blizzard.scene_theMountainPath();
            case "scene_inspectTheEnvironment" -> act2Blizzard.scene_inspectTheEnvironment();
            case "scene_narrowIceTunnel" -> act2Blizzard.scene_narrowIceTunnel();
            case "scene_windSweptRidge" -> act2Blizzard.scene_windSweptRidge();
            case "scene_frozenLedge" -> act2Blizzard.scene_frozenLedge();
            //
            //case "SHOP" -> game.vm.showShop();

            //act2 ethereal and sand worms
            case "scene_theIceDragon" -> act2Ethereal.scene_theIceDragon();
            case "scene_sandworms" -> act2Worms.scene_sandworms();
            case "scene_letLyraThrowRocks" -> act2Worms.scene_letLyraThrowRocks();
            case "scene_journeyToTheDesert" -> act2Worms.scene_journeyToTheDesert();
            case "scene_sandwormAttack" -> act2Worms.scene_sandwormAttack();
            case "scene_sandwordAttackVictory" -> act2Worms.scene_sandwormAttackVictory();
            case "scene_dontLetLyraThrowRocks" -> act2Worms.scene_dontLetLyraThrowRocks();
            case "scene_iceDragonBattle" -> act2Ethereal.scene_iceDragonBattle();
            case "scene_defeatedtheIceDragon" -> act2Ethereal.scene_defeatedtheIceDragon();

            //act 2 cold desert nights
            case "scene_coldDesertNight" -> act2coldnights.scene_coldDesertNight();
            case "scene_fightheadon" -> act2coldnights.scene_fightheadon();
            case "scene_setTrap" -> act2coldnights.scene_setTrap();
            case "scene_scareThemAway" -> act2coldnights.scene_scareThemAway();




            //act 2 sandstorm 
            case "scene_sandStorm" -> act2sandstorm.scene_sandStorm();

            //act 2 the knight
            case "scene_theKnight" -> act2knight.scene_theKnight();
            case "scene_beforeKnightBattle" -> act2knight.scene_beforeKnightBattle();
            case "scene_minionKnightBattle" -> act2knight.scene_minionKnightBattle();
            case "scene_minionKnightVictory" -> act2knight.scene_minionKnightVictory();
            case "scene_KnightBattle" -> act2knight.scene_KnightBattle();
            case "scene_KnightBattleVictory" -> act2knight.scene_KnightBattleVictory();
            case "scene_postKnightBattle" -> act2knight.scene_postKnightBattle();

            // act 2 dark string of fate
            case "scene_darkStringofFate" -> act2darkstring.scene_darkStringofFate();
            case "scene_flashback" -> act2darkstring.scene_flashback();
            case "scene_afterConfrontation" -> act2darkstring.scene_afterConfrontation();

            //act 3 airship
            case "scene_Airship" -> act3airship.scene_Airship();
            case "scene_blacksmithAirship" -> act3airship.scene_blacksmithAirship();
            case "scene_arcaneSupplyshop" -> act3airship.scene_arcaneSupplyshop();
            case "scene_metalworksDistrict" -> act3airship.scene_metalworksDistrict();
            case "scene_undergroundMarket" -> act3airship.scene_undergroundMarket();
            case "scene_merchantPlaza" -> act3airship.scene_merchantPlaza();

            // act 3 preparation
            case "scene_preparation" -> act3preparation.scene_preparation();
            case "scene_wanderingTraderAct3" -> act3preparation.scene_wanderingTraderAct3();
            case "scene_mageshopAct3" -> act3preparation.scene_mageshopAct3();
            case "scene_mysteriousOldmanAct3" -> act3preparation.scene_mysteriousOldmanAct3();
            case "scene_airshipRepairs" -> act3preparation.scene_airshipRepairs();

            case "scene_upInTheClouds" -> act3onelastfight.scene_upInTheClouds();
            case "scene_gratitude" -> act3onelastfight.scene_gratitude();
            case "scene_gratitude2" -> act3onelastfight.scene_gratitude2();
            case "scene_Dock" -> act3onelastfight.scene_Dock();
            case "scene_Gate" -> act3onelastfight.scene_Gate();

            // the beginning of the end
            case "scene_Shadow" -> act3beginning.scene_Shadow();
            case "scene_Lyra" -> act3beginning.scene_Lyra();
            case "scene_regret" -> act3beginning.scene_regret();
            case "scene_Mocking" -> act3beginning.scene_Mocking();
            case "scene_resolve" -> act3beginning.scene_resolve();
            case "scene_thisIsIt" -> act3beginning.scene_thisIsIt();
            case "scene_LastStand" -> act3beginning.scene_LastStand();
            case "scene_Shadowbattle" -> act3beginning.scene_Shadowbattle();

            //act 3 aftermath of shadow
            case "scene_FinalDecision" -> act3shadow.scene_FinalDecision();
            case "scene_GoodEnding" -> act3shadow.scene_GoodEnding();
            case "scene_GoodEnding2" -> act3shadow.scene_GoodEnding2();
            case "scene_BadEnding" -> act3shadow.scene_BadEnding();
            case "scene_BadEnding2" -> act3shadow.scene_BadEnding2();
            case "scene_NormalEnding" -> act3shadow.scene_NormalEnding();
            case "scene_NormalEnding2" -> act3shadow.scene_NormalEnding2();


            //epilogue
            case "scene_theGuardianOfAetheria" -> act3epilogue.scene_theGuardianOfAetheria();
            case "scene_theGuardianOfAetheria2" -> act3epilogue.scene_theGuardianOfAetheria2();
            case "scene_EchoesOfAetheria" -> act3epilogue.scene_EchoesOfAetheria();
            case "scene_EchoesOfAetheria2" -> act3epilogue.scene_EchoesOfAetheria2();
            case "scene_FailedHero" -> act3epilogue.scene_FailedHero();
            case "scene_FailedHero2" -> act3epilogue.scene_FailedHero2();

            //default -> ui.mainTextArea.setText("Unknown scene: " + nextPosition);
        }
        
            }
}
