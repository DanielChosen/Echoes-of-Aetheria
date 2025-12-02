//no combat

package com.oopfinalproject.game.storyscenes.act3;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;


public class Act3Preparation {
    Game game;
    UI ui;
    Player player;

    public Act3Preparation(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void scene_preparation(){
        ui.mainTextArea.setText("With all obtainable materials gathered, you return to the forge. The blacksmith takes each item, carefully examining the condition.\n" + //
                        "\n" + //
                        "Blacksmith: \"Some of these will need work, but they’re enough. I’ll bring these to Garron immediately. He’ll start repairs on the airship. Give me a bit of time.\"\n" + //
                        "\n" + //
                        "Lyra exhales slightly, tension easing.  \n" + //
                        "Lyra: \"Good… The Floating Temple is next. We’re almost there.\"\n" + //
                        "\n" + //
                        "You step back outside. The city is busy, lanterns shimmering as the wind picks up. You have some time before the airship is ready—time you can use to prepare for what’s ahead.\n" + //
                        "\n" + //
                        "Where will you go while waiting?");

        ui.choice1.setText("Trader");
        ui.choice1.setActionCommand("scene_wanderingTraderAct3");
        ui.choice2.setText("Mage Shop");
        ui.choice2.setActionCommand("scene_mageshopAct3");
        ui.choice3.setText("Mysterious Oldman"); 
        ui.choice3.setActionCommand("scene_mysteriousOldmanAct3");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_wanderingTraderAct3(){
        ui.mainTextArea.setText("shop here");

        ui.choice1.setText("Go to the Blacksmith");
        ui.choice1.setActionCommand("scene_airshipRepairs");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_mageshopAct3(){
        ui.mainTextArea.setText("shop here");

        ui.choice1.setText("Go to the Blacksmith");
        ui.choice1.setActionCommand("scene_airshipRepairs");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_mysteriousOldmanAct3(){
        ui.mainTextArea.setText("shop here");

        ui.choice1.setText("Go to the Blacksmith");
        ui.choice1.setActionCommand("scene_airshipRepairs");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_airshipRepairs(){
        ui.mainTextArea.setText(" \"Good timing. I’ve got most of the repairs done. With what you brought, we can get the airship running again. Go on—help me with the last few parts.\"\r\n" + //
                        "You step inside, ready to assist and finally prepare the airship for the journey to the floating temple.\r\n" + //
                        "");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_upInTheClouds");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }
}
