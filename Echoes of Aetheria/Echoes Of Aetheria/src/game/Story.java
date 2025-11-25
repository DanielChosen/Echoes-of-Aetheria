package game;

import game.storyscenes.PrologueScenes;
import game.storyscenes.act1.*;
import game.weapons.WeaponTrainingSword;

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

    public Story(Game g, UI userInterface){
        game = g;
        ui = userInterface;
        player = new Player();

        // Initialize scene modules
        prologue = new PrologueScenes(game, ui, player);
        act1Intro = new Act1IntroScenes(game, ui, player);
        act1City = new Act1CityScenes(game, ui, player);
        act1Forest = new Act1ForestScenes(game, ui, player);
        act1Dungeon = new Act1DungeonScenes(game, ui, player);
    }

    public void defaultSetup(){
        player.hp = 50;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new WeaponTrainingSword();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
    }

    public void selectPosition(String nextPosition){
        switch(nextPosition){

            // Start the game
            case "START":
                game.vm.titleToTown(); // switch UI to main game
                prologue.Village();     // start first scene
                break;

            // Prologue
            case "Village": prologue.Village(); break;
            case "Tutorial": prologue.scene_Tutorial(); break;
            case "rest": prologue.scene_rest(); break;

            // Act1 Intro
            case "theCrystal": act1Intro.scene_theCrystal(); break;
            case "villageFight": act1Intro.scene_villageFight(); break;
            case "firstBattle": act1Intro.scene_firstBattle(); break;
            case "firstBattle2": act1Intro.scene_firstBattle2(); break;
            case "afterBattle": act1Intro.scene_firstBattle_outcome(); break;
            case "theBeginningOfAJourney": act1Intro.scene_theBeginningOfAJourney(); break;
            case "saveHerBattle": act1Intro.scene_saveHerBattle(); break;
            case "saveHerOutcome": act1Intro.scene_saveHerOutcome(); break;
            case "ignoreHerOutcome": act1Intro.scene_ignoreHerOutcome(); break;
            case "cityExploration": act1Intro.scene_cityExploration(); break;

            // Act1 City
            case "MysteriousOldMan": act1City.city_MysteriousOldMan(); break;
            case "BlackSmith": act1City.city_BlackSmith(); break;
            case "MageShop": act1City.city_MageShop(); break;
            case "Guild": act1City.city_Guild(); break;

            // Act1 Forest
            case "scene_TheForest": act1Forest.scene_TheForest(); break;
            case "scene_theGraveyard": act1Forest.scene_theGraveyard(); break;
            case "success_fightTheGhouls": act1Forest.success_fightTheGhouls(); break;
            case "success_escapeTheGhouls": act1Forest.success_escapeTheGhouls(); break;
            case "failure_escapeTheGhouls": act1Forest.failure_escapeTheGhouls(); break;

            // Act1 Dungeon
            case "scene_hiddenDungeon": act1Dungeon.scene_hiddenDungeon(); break;
            case "success_inspectTheArea": act1Dungeon.success_inspectTheArea(); break;
            case "failure_inspectTheArea": act1Dungeon.failure_inspectTheArea(); break;
            case "success_inspectTheSkeletons": act1Dungeon.success_inspectTheSkeletons(); break;
            case "failure_inspectTheSkeletons": act1Dungeon.failure_inspectTheSkeletons(); break;
            case "scene_continueExploring": act1Dungeon.scene_continueExploring(); break;
            case "scene_goLeft": act1Dungeon.scene_goLeft(); break;
            case "scene_darkWolves": act1Dungeon.scene_darkWolves(); break;
            case "scene_ruinedChurch": act1Dungeon.scene_ruinedChurch(); break;
            case "failure_inspectTheRuinedChurchArea": act1Dungeon.failure_inspectTheRuinedChurchArea(); break;
            case "scene_passageOfThePast": act1Dungeon.scene_passageOfThePast(); break;
            case "scene_theElderGolem": act1Dungeon.scene_theElderGolem(); break;
            case "success_theElderGolem": act1Dungeon.success_theElderGolem(); break;
            case "scene_darkness": act1Dungeon.scene_darkness(); break;

            default:
                ui.mainTextArea.setText("Unknown scene: " + nextPosition);
                break;
        }
    }
}
