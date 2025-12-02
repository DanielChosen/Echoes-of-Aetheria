package com.oopfinalproject.game.storyscenes.act2;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act2Scene6FennecAmbushCombat;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;



public class Act2ColdDesertNight {
    Game game;
    UI ui;
    Player player;

    public Act2ColdDesertNight(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }
    public void gotoNextScene(Runnable nextScene) {
        game.vm.titleToTown();
        nextScene.run();
}

    public void scene_coldDesertNight(){
        ui.mainTextArea.setText("While sleeping under the desert sky, you let your guard down. Suddenly, a pack of armoured fennec circles your camp, eyes glinting in the moonlight.\n" + //
                        "\n" + //
                        "Player: \"Quicksand was bad enough… now this?\"\n" + //
                        "\n" + //
                        "Lyra: \"Looks like we’re not getting any rest tonight. Let’s deal with them quickly.\"\n" + //
                        "\n" + //
                        "How will you handle the ambush?");
        ui.choice1.setText("Fight Head On");
        ui.choice1.setActionCommand("");
        ui.choice2.setText("Set a Trap");
        ui.choice2.setActionCommand("scene_setTrap");
        ui.choice3.setText("Scare them Away");
        ui.choice3.setActionCommand("scene_scareThemAway");
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);
    }


    public void scene_fightheadon(){
        game.vm.showCombatUI();  //shows combat ui
        Act2Scene6FennecAmbushCombat act2Scene6FennecAmbushCombat = new Act2Scene6FennecAmbushCombat("Act 2 - Scene 6: Fennec Ambush", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act2Scene6FennecAmbushCombat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act2Scene6FennecAmbushCombat.start();
    }

    public void scene_setTrap(){
        ui.mainTextArea.setText("The trap works; some fennec are caught or slowed, allowing selective engagement.\r\n" + //
                        "You: \"Perfect, we can handle them one by one.\"\r\n" + //
                        " Lyra: \"Good thinking. Let’s take it slow and careful.\"\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_sandStorm");


    }

    public void scene_scareThemAway(){
        ui.mainTextArea.setText("The fennec hesitate, then slowly back away into the sand.\n" + //
                        "\n" + //
                        "“Back off… now!”\n" + //
                        "“It worked. Looks like your voice is more useful than I thought.”");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_sandStorm");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }
}



/*      ui.mainTextArea.setText("");
        ui.choice1.setText("");
        ui.choice1.setActionCommand("");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand(""); */