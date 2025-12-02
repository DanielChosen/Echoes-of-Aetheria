//no combat

package com.oopfinalproject.game.storyscenes.act2;
import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act2Scene4SynticeCombat;
import com.oopfinalproject.game.UI;



public class Act2EtherealBeauty {
    Game game;
    UI ui;
    Player player;

    public Act2EtherealBeauty(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void gotoNextScene(Runnable nextScene) {
        game.vm.titleToTown();
        nextScene.run();
}

    public void scene_theIceDragon(){
        ui.mainTextArea.setText("After the gruelling climb, you take a moment to catch your breath and prepare yourself. You sneak a glance at the dragon’s nest, and suddenly you are frozen—not by ice or fear, but by the sheer beauty of the majestic creature.\r\n" + //
                        "You feel a deep sense of empathy towards this guardian.\r\n" + //
                        "“It’s a shame such a magnificent creature has been corrupted,” you say.\r\n" + //
                        "Lyra gazes at the beast with awe. “It’s incredible… but we need to be careful. That storm isn’t going to let us fight easily.”\r\n" + //
                        "The dragon screams, unleashing a violent blizzard that lashes against you, the storm biting into your strength and reducing your power.\r\n" + //
                        "“Its roar… the storm weakens me, but I cannot falter!” you declare, bracing yourself against the icy winds.\r\n" + //
                        "“Stay sharp!” Lyra calls out, her voice cutting through the storm. “Watch its movements and strike when you can!”\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_iceDragonBattle");
        ui.choice2.setText("");
        ui.choice2.setActionCommand(null);
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);
    }

    public void scene_iceDragonBattle(){
        game.vm.showCombatUI();  //shows combat ui
        Act2Scene4SynticeCombat act2Scene4SynticeCombat = new Act2Scene4SynticeCombat("Act 2 - Scene 4: Ethereal Beauty",player,ui,this);
        act2Scene4SynticeCombat.start();
    }

    public void scene_defeatedtheIceDragon(){
        ui.mainTextArea.setText("The dragon collapses, then slowly transforms back to its true form, eyes calm and radiant.\n" + //
                        "\n" + //
                        "Syntice: \"You have fought with courage and respect. The corruption within me is now gone, thanks to your strength.\"\n" + //
                        "\n" + //
                        "Player: \"I… I couldn’t have done it without you, Lyra.\"\n" + //
                        "\n" + //
                        "Lyra: \"We make a pretty good team, even if this is our first time facing something like this.\"\n" + //
                        "\n" + //
                        "You receive a buff called ‘The Dragon’s Blessing’, reducing magical attack damage received.");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_sandworms");
        ui.choice2.setText("");
        ui.choice2.setActionCommand(null);
        ui.choice3.setText("");
        ui.choice3.setActionCommand(null);
        ui.choice4.setText("");
        ui.choice4.setActionCommand(null);
        
    }

    
}