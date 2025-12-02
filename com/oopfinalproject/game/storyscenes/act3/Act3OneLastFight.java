//no combat

package com.oopfinalproject.game.storyscenes.act3;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;


public class Act3OneLastFight {
    Game game;
    UI ui;
    Player player;

    public Act3OneLastFight(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void scene_upInTheClouds(){
        ui.mainTextArea.setText("As the airship cuts through the clouds and approaches the floating temple, a quiet moment settles in. You find yourself staring at the sky, reflecting on everything that brought you here. The battles, the failures, the moments you almost gave up—yet somehow, you pushed through them all.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_gratitude");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_gratitude(){
        ui.mainTextArea.setText("Faces of those who supported you along the way appear in your mind: the blacksmith, the mage, the guild members… even Lyra, silently standing beside you now as the wind blows through her hair.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_gratitude2");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_gratitude2(){
        ui.mainTextArea.setText("\"I’ve come this far… because of everyone who believed in me. I won’t let their efforts go to waste.\"\r\n" + //
                        "The airship finally reaches the docking platform. The old man who piloted it gives you a firm nod.\r\n" + //
                        "");
        ui.choice1.setText("Get off");
        ui.choice1.setActionCommand("scene_Dock");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_Dock(){
        ui.mainTextArea.setText("“End of the line. Go finish what you started.”\r\n" + //
                        "You thank him sincerely before stepping off.\r\n" + //
                        "Standing before the enormous stone gate of the floating temple, a heavy silence surrounds you. The air is unnaturally still. Lyra tightens her grip on her weapon, glancing at you—but says nothing. She doesn’t have to. You both know what comes next.\r\n" + //
                        "");
        ui.choice1.setText("Go to the Gate");
        ui.choice1.setActionCommand("scene_Gate");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

     public void scene_Gate(){
        ui.mainTextArea.setText("Gate Opens\r\n" + //
                        "The massive gate slowly begins to open, stone grinding against stone.\r\n" + //
                        "The sound echoes across the floating island as a chill crawls up your spine.\r\n" + //
                        "This is it. The Beginning of the End.\r\n" + //
                        "");
        ui.choice1.setText("Enter");
        ui.choice1.setActionCommand("scene_Shadow");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }
}
