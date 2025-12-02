package com.oopfinalproject.game.storyscenes.act3;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;


public class Act3TheAirship {
    Game game;
    UI ui;
    Player player;

    public Act3TheAirship(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void scene_Airship(){
        ui.mainTextArea.setText("You return to the guild and inquire once more about transportation to the floating temple. The receptionist shakes her head.\r\n" + //
                        "Receptionist: \"The only way to reach it is by airship… but no one here operates regular trips to the temple. You might want to speak with the blacksmith—he could have a solution.\"\r\n" + //
                        "Lyra glances at you, frowning slightly: \"Airship, huh? Looks like we’re going to need more than climbing gear for this one.\"\r\n" + //
                        "");

        ui.choice1.setText("Go to the blacksmith");
        ui.choice1.setActionCommand("scene_blacksmithAirship");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_blacksmithAirship(){
        ui.mainTextArea.setText("You and Lyra weave through the busy streets until the rhythmic clang of metal leads you to a blacksmith’s workshop. After hearing your request, he lowers his hammer and sighs.\n" + //
                        "\n" + //
                        "“An airship? I don’t build those—but I know the only man who does. Garron. His ship’s been broken for months.”\n" + //
                        "\n" + //
                        "He leans in slightly. “If you want to reach the Floating Temple, you’ll need to help gather the materials to fix it. He’s too old to collect them himself.”\n" + //
                        "\n" + //
                        "Lyra nods without hesitation. “Then tell us where to start.”\n" + //
                        "\n" + //
                        "The blacksmith hands over a short list. “Bring these back, and Garron can get that airship flying again.”");

        ui.choice1.setText("Go to arcane supply shop");
        ui.choice1.setActionCommand("scene_arcaneSupplyshop");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");

    }

    public void scene_arcaneSupplyshop(){
        ui.mainTextArea.setText("Shelves packed with glowing tubes and humming artifacts line the shop. Mana pulses softly through the air as merchants shout prices over one another.");

        ui.choice1.setText("Explore the metalworks district");
        ui.choice1.setActionCommand("scene_metalworksDistrict");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_metalworksDistrict(){
        ui.mainTextArea.setText("Sparks fly as massive machines grind and hammer metal into shape. The air is thick with heat, smoke, and the sound of industry.");

        ui.choice1.setText("Go to the underground market");
        ui.choice1.setActionCommand("scene_undergroundMarket");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_undergroundMarket(){
        ui.mainTextArea.setText("Dim lanterns flicker over hidden stalls as shady merchants whisper deals from behind stacked crates of scrap and relics.");

        ui.choice1.setText("Go to the merchant plaza");
        ui.choice1.setActionCommand("scene_merchantPlaza");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_merchantPlaza(){
        ui.mainTextArea.setText("Crowds surge through colorful tents and banners as merchants shout over one another, selling rare fabrics and enchanted goods.");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_preparation");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }
}
