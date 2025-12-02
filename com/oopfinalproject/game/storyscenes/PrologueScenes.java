package com.oopfinalproject.game.storyscenes;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.PrologueScene1Combat;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;

public class PrologueScenes {

    Game game;
    UI ui;
    Player player;

    public PrologueScenes(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }
    
    //next scene
    public void gotoNextScene(Runnable nextScene){
        game.vm.titleToTown();
        nextScene.run();
    }

    public void Village() {
        ui.mainTextArea.setText("""
                                The village of Windrest buzzed with warmth and color. Banners fluttered over the streets as villagers carried baskets of fruits and firewood, preparing for the annual Festival of Winds. Children ran past, laughing, while musicians tuned their wooden flutes near the fountain.
                                
                                Away from the noise, a young man practiced sword swings behind his home. Sweat dripped down his cheek as his wooden blade struck a training dummy.""" //
        //
        );

        ui.choice1.setText("Keep Practicing");
        ui.choice1.setActionCommand("Tutorial");

        ui.choice2.setText("Rest under the tree");
        ui.choice2.setActionCommand("rest");

        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
        
    }


    //guide
    public void scene_Tutorial() {
        game.vm.showCombatUI();  //shows combat ui
        PrologueScene1Combat prologueScene1Combat = new PrologueScene1Combat("Prologue - Scene 1: The Festival",player, ui,this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        prologueScene1Combat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        prologueScene1Combat.start();

    }

    public void scene_rest() {
        game.updatePlayerPanel();  //ilagay sa next scene after combat
        ui.mainTextArea.setText("You wiped the sweat from your brow and muttered to yourself, \"I want to leave this village and see the world. If I can become an adventurer, I can learn to handle danger, earn a living, and make something of myself.\"");

        
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("theCrystal");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");

    }


}
