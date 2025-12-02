//prob lyra not appearing after fight fix
//done

package com.oopfinalproject.game.storyscenes.act1;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act1Scene1Combat;
import com.oopfinalproject.core.scenes.Act1Scene2ForestCombat;
import com.oopfinalproject.core.scenes.Act1Scene3DarkWolvesCombat;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;

public class Act1IntroScenes {

    Game game;
    UI ui;
    Player player;

    public Act1IntroScenes(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void gotoNextScene(Runnable nextScene) {
        game.vm.titleToTown();
        nextScene.run();
}

    public void scene_theCrystal() {
        ui.mainTextArea.setText("""
                                Exhausted from training, the young man lay beneath a swaying oak tree. The breeze cooled his skin, carrying the scent of fresh bread and pine.
                                
                                As he rested, a massive structure suddenly appeared in the sky, unlike anything he had seen before. It blocked your view of the sun, and then suddenly the day turned into night. You heard screams from the village; the immense plea for help reached your ears, urging you to rush forward.""" //
        //
        );
        ui.choice1.setText("Run Back to the village");
        ui.choice1.setActionCommand("villageFight");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
    }

    public void scene_villageFight() {
        ui.mainTextArea.setText("He arrived to see his village in chaos: buildings crumbled, smoke rising from rooftops, and villagers running in terror. Monsters stalked through the streets, leaving destruction in their wake.");
        ui.choice1.setText("Fight immediately"); ui.choice1.setActionCommand("firstBattle");
        ui.choice2.setText("Look for Survivors"); ui.choice2.setActionCommand("firstBattle2");

        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
    }

    public void scene_firstBattle() {
        game.vm.showCombatUI();  //shows combat ui
        Act1Scene2ForestCombat act1Scene2ForestCombat = new Act1Scene2ForestCombat("Act 1 - Scene 1: Silverwood Forest", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act1Scene2ForestCombat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act1Scene2ForestCombat.start();

        ui.choice1.setText("after battle"); ui.choice1.setActionCommand("afterBattle");
        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
    }

    public void scene_firstBattle2() {
        game.vm.showCombatUI();  //shows combat ui
        Act1Scene3DarkWolvesCombat act1Scene3DarkWolvesCombat = new Act1Scene3DarkWolvesCombat ("Act 1 - Scene 2: Silverwood Forest", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act1Scene3DarkWolvesCombat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act1Scene3DarkWolvesCombat.start();

        ui.choice1.setText("after battle"); ui.choice1.setActionCommand("afterBattle");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
    }

    public void scene_firstBattle_outcome() {
        ui.mainTextArea.setText("After saving the village of Windrest, you took a moment to catch your breath, watching the villagers express their gratitude. You realized that to truly restore peace to Aetheria, you needed to grow stronger. Inspired by the stories of past heroes, you decided to travel to the city and become an adventurer. This journey would be your first step toward gaining the experience needed to face stronger opponents and protect the realm from darkness.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("theBeginningOfAJourney");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
    }

    public void scene_theBeginningOfAJourney() {
        game.updatePlayerPanel();
        ui.mainTextArea.setText("""
                                He walked the main road for days. Ahead, shrieks echoed. A girl in white, shimmering faintly, was surrounded by monsters.
                                
                                The chaos of the moment pressed on him; the urgency was clear, and he had to act.""" //
        //
        );
        ui.choice1.setText("Save her"); ui.choice1.setActionCommand("saveHerBattle");
        ui.choice2.setText("Ignore her"); ui.choice2.setActionCommand("ignoreHerOutcome");

        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");

    }

    public void scene_saveHerBattle() {
        
        game.vm.showCombatUI();  //shows combat ui
        Act1Scene1Combat act1Scene1Combat = new Act1Scene1Combat("Act 1 - Scene 3: Save Lyra", player, ui,this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act1Scene1Combat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act1Scene1Combat.start();

        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("saveHerOutcome");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        
    }

    public void scene_saveHerOutcome() {
        ui.mainTextArea.setText("After the fight, Lyra stands before you, her form shimmering with the wind. \"Thank you. My name is Lyra. I am a wind spirit. As a thanks, I will be your guide and help you on this journey.\" She becomes your companion.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("cityExploration");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
    }

    public void scene_ignoreHerOutcome() {
        ui.mainTextArea.setText("You hesitate and continue on your path, leaving Lyra to fend for herself.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("cityExploration");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
    }

    public void scene_cityExploration() {
        ui.mainTextArea.setText("You are in the city, where would you like to go?");
        ui.choice1.setText("Mysterious Old Man"); ui.choice1.setActionCommand("MysteriousOldMan");
        ui.choice2.setText("Black Smith"); ui.choice2.setActionCommand("BlackSmith");
        ui.choice3.setText("Mage Shop"); ui.choice3.setActionCommand("MageShop");
        ui.choice4.setText("Guild"); ui.choice4.setActionCommand("Guild");
    }

    public void gotoNextScene(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gotoNextScene'");
    }

    
}
