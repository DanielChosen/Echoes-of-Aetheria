//no combat

package com.oopfinalproject.game.storyscenes.act3;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;



public class Act3Epilogue {
    Game game;
    UI ui;
    Player player;

    public Act3Epilogue(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    
    public void scene_theGuardianOfAetheria(){
        ui.mainTextArea.setText("Years pass, and Aetheria flourishes under the watch of the hero, now celebrated as the Guardian of the realm. Cities bustle, forests thrive, and rivers sparkle under the sun. Villagers speak your name with reverence, and songs of your deeds echo through every town and village.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_theGuardianOfAetheria2");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_theGuardianOfAetheria2(){
        ui.mainTextArea.setText("Lyra:\r\n" + //
                        "“You’ve done more than I ever imagined… Aetheria is alive because of you. The people you’ve saved, the hope you’ve carried… it will endure for generations.”\r\n" + //
                        "The hero’s presence inspires new generations of adventurers, known as the Echoes of Aetheria, who carry forward the legacy of courage, sacrifice, and protection. Peace and order endure, and the hero’s name becomes legend.\r\n" + //
                        "");
        ui.choice1.setText("The End");
        ui.choice1.setActionCommand("show");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_FailedHero(){
        ui.mainTextArea.setText("The world is gone. Cities lie in ruin, forests are ash, and rivers have dried into shadows of their former selves. The hero’s soul is bound to the darkness, a lone sentinel in a land consumed by corruption. Lyra’s spirit lingers as a faint whisper, mourning the loss of all that once was.");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_FailedHero2");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_FailedHero2(){
        ui.mainTextArea.setText("No one remains to sing of your deeds. Aetheria exists only as a hollow memory, a cautionary tale of heroism and sacrifice. Shadows roam the lands unchecked, and the hero, now a vessel of the darkness, watches over the remnants, forever imprisoned by the very evil they fought to contain.\r\n" + //
                        "");
        ui.choice1.setText("The End");
        ui.choice1.setActionCommand("");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_EchoesOfAetheria(){
        ui.mainTextArea.setText("The world exists in two halves. In the light realm, Aetheria thrives: villages prosper, heroes rise, and communities flourish. Life continues with hope, though scars of the past remain. In the dark realm, the corrupted are contained, a grim but necessary prison to keep evil from spreading. Generations later, a new wave of heroes emerges from the light realm, inspired by the deeds of the past.");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_EchoesOfAetheria2");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_EchoesOfAetheria2(){
        ui.mainTextArea.setText("They are called the Echoes of Aetheria, carrying the lessons of courage, vigilance, and sacrifice. Though the two realms are divided, life endures—and the story of the shards and the hero’s journey lives on as a legacy for the future.\r\n" + //
                        "");
        ui.choice1.setText("The End");
        ui.choice1.setActionCommand("");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }
}