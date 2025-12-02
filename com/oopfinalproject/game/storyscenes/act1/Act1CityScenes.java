package com.oopfinalproject.game.storyscenes.act1;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;



public class Act1CityScenes {

    Game game;
    UI ui;
    Player player;

    public Act1CityScenes(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void gotoNextScene(Runnable nextScene){
        game.vm.titleToTown();
        nextScene.run();
    }

    public void city_MysteriousOldMan() {
        ui.mainTextArea.setText("You notice an old man sitting near a shadowy alley. His table is cluttered with trinkets and mysterious artifacts. He squints at you and smiles.\n" + //
                        "\n" + //
                        "Old Man: \"Hey there, traveler. Looking for something… special, maybe?\"");

        ui.choice1.setText("Browse his items"); ui.choice1.setActionCommand(""); //empty for now
        ui.choice2.setText("Ask for advice"); ui.choice2.setActionCommand(""); //empty for now
        ui.choice3.setText("Go back outside"); ui.choice3.setActionCommand("cityExploration");
        ui.choice4.setText("Continue to the forest"); ui.choice4.setActionCommand("scene_TheForest");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void city_BlackSmith() {
        ui.mainTextArea.setText("""
                                The rhythmic clang of hammer on metal fills the air. Behind the counter, a burly man pauses his work and wipes soot from his face.
                                
                                Blacksmith: "You here for a weapon or just looking around?\""""
        );

        ui.choice1.setText("Ask about himself"); ui.choice1.setActionCommand("");//empty for now
        ui.choice2.setText("Ask for an affordable sword"); ui.choice2.setActionCommand(""); //empty for now
        ui.choice3.setText("Go back outside"); ui.choice3.setActionCommand("cityExploration");
        ui.choice4.setText("Continue to the forest"); ui.choice4.setActionCommand("scene_TheForest");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void city_MageShop() {
        ui.mainTextArea.setText("""
                                You step into a small shop, filled with the scent of herbs and faintly glowing crystals. A mage peers over the counter, eyes sharp and curious.
                                
                                Mage: "Welcome. Potions, scrolls, grimoires\u2026 whatever you need for your adventures.\""""

        );

        ui.choice1.setText("Browse potions"); ui.choice1.setActionCommand(""); //empty for now
        ui.choice2.setText("Ask about magic lessons"); ui.choice2.setActionCommand(""); //empty for now
        ui.choice3.setText("Go back outside"); ui.choice3.setActionCommand("cityExploration");
        ui.choice4.setText("Continue to the forest"); ui.choice4.setActionCommand("scene_TheForest");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void city_Guild() {
        ui.mainTextArea.setText("The guild hall bustles with activity. A receptionist waves at you with a warm smile. The player can now register his class.\n" + //
                        "\n" + //
                        "Receptionist: \"Hey there! Looking for work? I’ve got a few mini quests that could earn you some gold and experience.\"");

        ui.choice1.setText("Join a mission"); ui.choice1.setActionCommand("");//empty for now
        ui.choice2.setText("Talk to the guild master"); ui.choice2.setActionCommand(""); //empty for now
        ui.choice3.setText("Go back outside"); ui.choice3.setActionCommand("cityExploration");
        ui.choice4.setText("Continue to the forest"); ui.choice4.setActionCommand("scene_TheForest");
    }
}
