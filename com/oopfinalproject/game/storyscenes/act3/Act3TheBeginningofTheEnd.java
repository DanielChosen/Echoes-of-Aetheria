package com.oopfinalproject.game.storyscenes.act3;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act2Scene6FennecAmbushCombat;
import com.oopfinalproject.core.scenes.Act3Scene4FinalBattle;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;


public class Act3TheBeginningofTheEnd {
    Game game;
    UI ui;
    Player player;

    public Act3TheBeginningofTheEnd(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void gotoNextScene(Runnable nextScene){
        game.vm.titleToTown();
        nextScene.run();
    }

    public void scene_Shadow(){
        ui.mainTextArea.setText("There, beyond the opened gate, you stand before Shadow, the Embodiment of Darkness.\r\n" + //
                        "The air hangs heavy, suffocating, and the dark string connecting you to him pulses like a living thing.\r\n" + //
                        "A deep, commanding voice resonates through the temple, cold as the void itself.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_Lyra");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_Lyra(){
        ui.mainTextArea.setText("Shadow:\r\n" + //
                        " “Behold… the heir of my blood. So, you have come. Do you feel it? The weight of centuries… the despair of heroes lost, the corruption that seeps into every heart. You dare stand before me, thinking you can undo what has festered since the fall of Aetheria?”\r\n" + //
                        "Lyra floats calmly beside you, her ethereal presence a small light in the overwhelming darkness.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_regret");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_regret(){
        ui.mainTextArea.setText("Lyra:\r\n" + //
                        " “I should have stopped this… before it consumed him, before it consumed everything. But I have one chance left. I found the hero strong enough to end what I could not.”\r\n" + //
                        "Shadow’s eyes, black as the void, fix on Lyra, and his laugh is a slow, echoing growl that chills the soul.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_Mocking");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_Mocking(){
        ui.mainTextArea.setText("Shadow:\r\n" + //
                        " “Lyra… spirit of the hero who failed. Regret clings to you like chains of ice. You could not save Aetheria, and yet here I stand, unbroken, eternal… darkness incarnate. You dare hope again?”");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_resolve");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_resolve(){
        ui.mainTextArea.setText("Lyra:\r\n" + //
                        " “I failed once… but I will not fail again. This hero carries the hope I could not protect. They will finish what I could not.”\r\n" + //
                        "Shadow turns to you, his presence suffocating, as if the very air rejects life.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_thisIsIt");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_thisIsIt(){
        ui.mainTextArea.setText("Shadow:\r\n" + //
                        " “Then come forth… and tremble beneath the weight of true darkness. Let the world witness your feeble courage crumble before me. You are but a spark, and I am the endless night that consumes all.”\r\n" + //
                        "The shadows around him surge violently, writhing like living serpents.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_LastStand");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_LastStand(){
        ui.mainTextArea.setText("Every breath tastes of ash and despair. Every step forward feels like wading through the void itself. The culmination of your journey, every battle, every sacrifice, leads to this single moment.\r\n" + //
                        "The final fight begins.\r\n" + //
                        "");
        ui.choice1.setText("Fight Shadow");
        ui.choice1.setActionCommand("scene_Shadowbattle");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_Shadowbattle(){
        game.vm.showCombatUI();  //shows combat ui
        Act3Scene4FinalBattle act3Scene4FinalBattle = new Act3Scene4FinalBattle("Act 3 - Scene 4: Final Battle", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act3Scene4FinalBattle.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );        
        
        act3Scene4FinalBattle.start();

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_FinalDecision");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }
}
