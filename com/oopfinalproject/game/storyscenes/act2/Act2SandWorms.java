//done

package com.oopfinalproject.game.storyscenes.act2;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act2Scene5SandwormCombat;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;



public class Act2SandWorms {
    Game game;
    UI ui;
    Player player;

    public Act2SandWorms(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void gotoNextScene(Runnable nextScene) {
        game.vm.titleToTown();
        nextScene.run();
}

    public void scene_sandworms(){
        ui.mainTextArea.setText("After defeating Syntice, you and Lyra make your way to the guild. You approach the receptionist and ask if there’s a way to travel quickly to the Crimson Desert.\r\n" + //
                        "Receptionist: \"There is a method… but unfortunately, no one is traveling right now.\"\r\n" + //
                        "Player: \"So… we have to walk all the way?\"\r\n" + //
                        " Lyra sighs, brushing snow off her cloak. \"Looks like it. Guess we’ll have to make the journey the old-fashioned way.\"\r\n" + //
                        "Left with no choice, you continue the journey on foot, the vast landscape stretching before you as you and Lyra prepare for whatever dangers the Crimson Desert may hold.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_journeyToTheDesert");
        ui.choice2.setText("");
        ui.choice2.setActionCommand(null);
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);  
    }

    public void scene_journeyToTheDesert(){
        ui.mainTextArea.setText("As you traverse the scorching sands, you are suddenly caught in quicksand and plummet into a nest of sand worms.\n" + //
                        "\n" + //
                        "You: \"Quicksand?! How did I not see this coming…?\"\n" + //
                        "\n" + //
                        "Lyra, peering down at the worms: \"Okay… here’s an idea. Let’s see if they’re napping. I'll throw that rock over there and see if they wake up!\" She picks up a rock and hurls it toward the worms.");

        ui.choice1.setText("Let Lyra throw Rocks");
        ui.choice1.setActionCommand("scene_letLyraThrowRocks");
        ui.choice2.setText("Don't Let Lyra throw Rocks");
        ui.choice2.setActionCommand("scene_dontLetLyraThrowRocks");
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
    }

    public void scene_letLyraThrowRocks(){
        ui.mainTextArea.setText("Lyra scoops up a rock and casually tosses it straight into the nest. It clatters against the hardened sand walls and drops out of sight.\n" + //
                        "\n" + //
                        "For a brief second, everything stays quiet.\n" + //
                        "\n" + //
                        "Then the nest begins to churn as massive worm shapes twist beneath the surface.\n" + //
                        "\n" + //
                        "Lyra slowly steps back.\n" + //
                        "“…Yep. That did it.”");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_sandwormAttack");
        ui.choice2.setText("");
        ui.choice2.setActionCommand(null);
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);
        
    }

    public void scene_sandwormAttack(){
        game.vm.showCombatUI();  //shows combat ui
        Act2Scene5SandwormCombat act2Scene5SandwormCombat = new Act2Scene5SandwormCombat("Act 2 - Scene 3: Sandworm's Nest", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); 
        act2Scene5SandwormCombat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act2Scene5SandwormCombat.start();
    }

    public void scene_dontLetLyraThrowRocks(){
        ui.mainTextArea.setText("The worms remain asleep for now, giving you and Lyra a small window to quietly escape the nest and go back to the surface.\n" + //
                        "\n" + //
                        "Player: \"Good… at least they’re still asleep.\"\n" + //
                        "\n" + //
                        "Lyra: \"Ugh, fine. No rock-throwing. Boring! But okay, we’ll sneak past them… for now.\"");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_coldDesertNight");
        ui.choice2.setText("");
        ui.choice2.setActionCommand(null);
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);
    }

    public void scene_sandwormAttackVictory(){
        ui.mainTextArea.setText("The final sandworm lets out a deep, rumbling cry before sinking beneath the shifting dunes.\n" + //
                        "\n" + //
                        "The nest falls silent, the only sound the slow hiss of settling sand.\n" + //
                        "\n" + //
                        "Lyra lowers her weapon and exhales shakily.\n" + //
                        "“…Guess they didn’t like visitors after all.”\n" + //
                        "\n" + //
                        "Heat presses in from every side as the tunnel ahead begins to glow faintly.\n" + //
                        "\n" + //
                        "With one last glance at the ruined nest, Lyra tightens her grip and steps forward into the desert night.");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_coldDesertNight");
        ui.choice2.setText("");
        ui.choice2.setActionCommand(null);
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);
    }
    



}