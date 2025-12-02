//done

package com.oopfinalproject.game.storyscenes.act1;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act1Scene2ForestCombat2;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;


public class Act1ForestScenes {

    Game game;
    UI ui;
    Player player;

    public Act1ForestScenes(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void gotoNextScene(Runnable nextScene) {
        game.vm.titleToTown();
        nextScene.run();
    }

    public void scene_TheForest() {
        ui.mainTextArea.setText("""
                                You enter Silverwood. The forest is dense, shadows dancing on the mossy ground. Near the entrance, a girl wanders. Guilt hits\u2014you saw her attacked earlier and did nothing.
                                
                                "Hey, what are you doing here all alone?" you call.
                                
                                She looks up, smiling faintly. "I\u2019m looking for the crystal\u2026 Can\u2019t exactly do it by myself."
                                
                                "I\u2019m looking for it too," you say. "Maybe we can help each other\u2014two sets of eyes are better than one."
                                
                                Lyra nods. "Yeah, that sounds good. Let\u2019s do it together."
                                
                                You step deeper into the forest, shadows stretching as your search begins.""" //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        );
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_theGraveyard");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void scene_theGraveyard() {
        ui.mainTextArea.setText("The ground is littered with cracked tombstones and wilted flowers. The air is heavy with decay. Amid the graves, a cluster of ghouls prowls quietly, unaware of your presence. They shuffle between tombstones and sniff at the ground, preoccupied with their own dark business.\n" + //
                        "\n" + //
                        "Lyra’s eyes narrow as she notices them. \"We can’t just let them roam freely,\" she says, her voice firm but calm. \"Come on, we’ll take them down together.\"");
        ui.choice1.setText("Fight the ghouls"); ui.choice1.setActionCommand("success_fightTheGhouls");
        ui.choice2.setText("Escape"); ui.choice2.setActionCommand("success_escapeTheGhouls");

        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void success_fightTheGhouls() {

        
        game.vm.showCombatUI();  //shows combat ui
        Act1Scene2ForestCombat2 act1Scene2ForestCombat2 = new Act1Scene2ForestCombat2("Act 1 - Scene 5: Silverwood Forest", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act1Scene2ForestCombat2.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act1Scene2ForestCombat2.start();        
        
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_hiddenDungeon");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void success_escapeTheGhouls() {
        ui.mainTextArea.setText("You carefully slip between the tombstones, avoiding the ghouls without drawing their attention. The sound of their moans fades behind you as you put distance between yourself and the graveyard’s dark predators.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_hiddenDungeon");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void failure_escapeTheGhouls() {
        ui.mainTextArea.setText("You misstep among the rubble, and a loose stone clatters loudly. The ghouls immediately turn toward you, their hollow eyes locking on your position. You have no choice but to fight—or risk being cornered.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("success_fightTheGhouls");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }
}
