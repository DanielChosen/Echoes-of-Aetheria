//done

package com.oopfinalproject.game.storyscenes.act2;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act1Scene2ForestCombat;
import com.oopfinalproject.core.scenes.Act2Scene7SandstormGuardianCombat;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;



public class Act2SandStorm{
    Game game;
    UI ui;
    Player player;

    public Act2SandStorm(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void gotoNextScene(Runnable nextScene) {
        game.vm.titleToTown();
        nextScene.run();
    }

    public void scene_sandStorm(){
        ui.mainTextArea.setText("You continue to advance towards the ruined temple, but it seems as though the wind itself is trying to stop you. Blinding sand swirls around, making every step a struggle.\n" + //
                        "\n" + //
                        "You (determined): \"The wind won’t stop me. I’ve come too far to turn back now.\"\n" + //
                        "\n" + //
                        "An entity within the sandstorm emerges, preparing to fight you.\n" + //
                        "\n" + //
                        "Entity: \"Go back where you came from mortal…, this area of the desert is forbidden!\"");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_followtheFennec");
        ui.choice2.setText("the knight");
        ui.choice2.setActionCommand("scene_theKnight");
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);  
    }

    public void scene_sandStormFight(){

        game.vm.showCombatUI();  //shows combat ui
        Act2Scene7SandstormGuardianCombat act2Scene7SandstormGuardianCombat = new Act2Scene7SandstormGuardianCombat ("Act 2 - Scene 7: Sandstorm Guardian", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act2Scene7SandstormGuardianCombat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act2Scene7SandstormGuardianCombat.start();

    }

    public void scene_followtheFennec(){
        ui.mainTextArea.setText("You followed the Fennecs that you defeated earlier. They lead you to a ruined temple, hidden deep in the desert.\n" + //
                        "\n" + //
                        "Player: \"Convenient… or suspicious. Either way, this must be our next stop.\"\n" + //
                        "\n" + //
                        "Lyra: \"I’ll admit it—these little guys are surprisingly helpful.\"");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_theKnight");
        ui.choice2.setText("");
        ui.choice2.setActionCommand(null);
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);
    }

}