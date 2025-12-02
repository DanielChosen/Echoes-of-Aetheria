//done

package com.oopfinalproject.game.storyscenes.act2;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act1Scene2ForestCombat;
import com.oopfinalproject.core.scenes.Act2Scene8KnightCombat;
import com.oopfinalproject.core.scenes.Act2Scene8KnightCombat2;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;



public class Act2TheKnight {
    Game game;
    UI ui;
    Player player;

    public Act2TheKnight(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }
    
    public void gotoNextScene(Runnable nextScene) {
        game.vm.titleToTown();
        nextScene.run();
}

    public void scene_theKnight(){
        ui.mainTextArea.setText("You step cautiously into the ruined temple. Towering sandstone knights line the hall, their silent forms imposing. One, larger than the others, stands at the center. Its helmet resembles a crown, and an aura of authority radiates from it.\r\n" + //
                        "Suddenly, the massive knight moves. You raise your sword, ready to fight, but it does not attack immediately. You stay on guard, tense and alert.\r\n" + //
                        "");
        ui.choice1.setText("continue");
        ui.choice1.setActionCommand("scene_beforeKnightBattle");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");

    }

    public void scene_beforeKnightBattle(){
        ui.mainTextArea.setText("Knight: \"THE HERO OF AETHERIA, I COMMEND YOU FOR COMING THIS FAR. YOU HAVE INDEED PROVEN YOURSELF STRONG AND WORTHY TO POSSESS THE CRYSTAL, BUT I HAVE NOT YET DEEMED YOU WORTHY.\"\n" + //
                        "\n" + //
                        "Knight: \"I WILL GIVE YOU A CHANCE TO SHOW ME YOUR STRENGTH.\"\n" + //
                        "\n" + //
                        "Lyra (whispering): \"Well… looks like we’re about to find out how tough these guys really are.\"\n" + //
                        "\n" + //
                        "Player: \"Let’s hope we’re ready.\"");
        ui.choice1.setText("fight the minions");
        ui.choice1.setActionCommand("scene_minionKnightBattle");
        ui.choice2.setText("Challenge the Knight    ");
        ui.choice2.setActionCommand("scene_KnightBattle");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    //combat scenes
    public void scene_minionKnightBattle(){
        game.vm.showCombatUI();  //shows combat ui
        Act2Scene8KnightCombat act2Scene8KnightCombat = new Act2Scene8KnightCombat("Act 2 - Scene ?: Silverwood Forest", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act2Scene8KnightCombat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act2Scene8KnightCombat.start();
        
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_minionKnightVictory");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_minionKnightVictory(){
        ui.mainTextArea.setText("You defeat the smaller sandstone knights. The main knight nods approvingly and grants you the final crystal shard. You gain immense experience points.\n" + //
                        "\n" + //
                        "Knight: \"You have shown strategy and skill. The final shard is yours.\"\n" + //
                        "\n" + //
                        "Player: \"Finally… we did it.\"\n" + //
                        "\n" + //
                        "Lyra: \"Not bad… I was expecting this to be harder.\"");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_postKnightBattle");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_KnightBattle(){
        game.vm.showCombatUI();  //shows combat ui
        Act2Scene8KnightCombat2 act2Scene8KnightCombat2 = new Act2Scene8KnightCombat2("Act 2 - Scene ?: Silverwood Forest", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act2Scene8KnightCombat2.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act2Scene8KnightCombat2.start();
        
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_KnightBattleVictory");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_KnightBattleVictory(){
        ui.mainTextArea.setText("You defeat the central sandstone knight in a fierce battle. You receive the final crystal shard and immense experience points.\n" + //
                        "\n" + //
                        "Knight: \"You have proven your courage and strength. Take the final shard.\"\n" + //
                        "\n" + //
                        "Player: \"We… did it. All the shards are ours.\"\n" + //
                        "\n" + //
                        "Lyra: \"I have to admit… that was impressive.\"");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_postKnightBattle");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_postKnightBattle(){
        ui.mainTextArea.setText("You notice that the central knight shows no signs of corruption.\n" + //
                        "\n" + //
                        "Lyra: \"Wait… how come you don’t look corrupted at all? Most guardians we fought were twisted by the crystal’s power.\"\n" + //
                        "\n" + //
                        "Knight: \"Because true strength does not succumb to corruption. It is not the crystal that defines one, but the soul within.\"");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_darkStringofFate");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }
}