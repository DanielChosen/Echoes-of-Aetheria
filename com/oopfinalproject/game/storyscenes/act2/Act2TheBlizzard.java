//no combat

package com.oopfinalproject.game.storyscenes.act2;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;



public class Act2TheBlizzard {
    Game game;
    UI ui;
    Player player;

    public Act2TheBlizzard(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }


    public void scene_theHero(){
        ui.mainTextArea.setText("Weeks have passed, and the story of your victory over the guardian in Silverwood spreads across the kingdom. Your name becomes known among villagers and travellers alike.\r\n" + //
                        "A wandering trader has set up a colourful stall near the market square, calling out to passersby. \"Fresh supplies! Rare gear! Everything an adventurer could need!\" he shouts, giving you the first chance to buy equipment and items directly from him.\r\n" + //
                        "Lyra nudges you with a grin. \"Looks like it’s time to gear up. Don’t tell me you’re skipping this one!\"\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_hiddenClues");
        ui.choice2.setText("Buy Items from the Trader"); 
        ui.choice2.setActionCommand("SHOP");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
        
    }

    public void scene_hiddenClues(){
        ui.mainTextArea.setText("You went to visit the Mage Shop, you hand over the book you found in Silverwood to the mage, asking her to decrypt the mysterious text.\r\n" + //
                        "You: \"Can you decipher this? I have a feeling it holds important information.\"\r\n" + //
                        "Mage: \"It will take some time. You can leave it with me for now, and I will let you know once I uncover its secrets.\"\r\n" + //
                        "Lyra smirks lightly. \"Well, while she works her magic, we might as well kill some time. Let’s go somewhere else.\"\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_theClimb");
        ui.choice2.setText("Find clues at the library");
        ui.choice2.setActionCommand("scene_library");
        ui.choice3.setText("Buy Items from the Trader");
        ui.choice3.setActionCommand("scene_trader");
        ui.choice4.setText("Visit the Guild"); 
        ui.choice4.setActionCommand("Guild");//not final
        
    }

    //need ui for shop(general)

    public void scene_trader(){
        ui.mainTextArea.setText("You find the trader in the market square, his colorful stall overflowing with weapons, armor, and rare items.\r\n" + //
                        "");

        ui.choice1.setText("Buy Items");
        ui.choice1.setActionCommand("SHOP");

        ui.choice2.setText("Go to the library");
        ui.choice2.setActionCommand("scene_library");
        ui.choice3.setText("Go to the Guild"); 
        ui.choice3.setActionCommand("Guild");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");

    }
        

    public void scene_library(){
        ui.mainTextArea.setText("You both head to the library. As you scour ancient tomes and scrolls, you find clues about Frostpire Peaks.\r\n" + //
                        "You (muttering to yourself): \"Frostpire Peaks… it's not just a mountain… it’s the lair of a giant ice dragon?\"\r\n" + //
                        "You: \"Its roars create extreme blizzards… no wonder travelers vanish there. I need to be prepared before I go.\"\r\n" + //
                        "");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_theClimb");
        ui.choice2.setText("Buy Items from the Trader");
        ui.choice2.setActionCommand("SHOP");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }
    
    public void scene_theClimb(){
        ui.mainTextArea.setText("Lyra: \"The crystal is pointing… Frostpire Peaks. That’s where we need to go next.\"\r\n" + //
                        " You: \"Are you sure? It feels so far, and the mountains look… dangerous.\"\r\n" + //
                        " Lyra: \"I’m sure. This crystal doesn’t lie. We’ll need to be prepared, but it’s the only lead we have.\"\r\n" + //
                        "Before venturing into the snowy mountains, you visit the blacksmith to buy climbing gear and a tent, ensuring you can safely traverse the harsh terrain.\r\n" + //
                        "");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_theClimbBlacksmith");//next scene to be added
        ui.choice2.setText("");        
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_theClimbBlacksmith(){
        ui.mainTextArea.setText("You: \"I need the best climbing gear and a sturdy tent. The mountains are unforgiving.\"\r\n" + //
                        "Blacksmith: \"You’ll need more than gear to survive up there. Keep your wits sharp and don’t underestimate the cold.\"\r\n" + //
                        "");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_theMountainPath");//next scene to be added
        ui.choice2.setText("");        
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_theMountainPath(){
        ui.mainTextArea.setText("You and Lyra struggle upward, climbing the treacherous slopes of Frostpire Peaks. The extreme weather in the mountains has forced the environment to evolve into an extremely harsh and unforgiving landscape. Jagged ice cliffs rise above, and fierce winds whip snow into blinding flurries, making every grip and foothold a battle against both the mountain and the elements.");

        ui.choice1.setText("Inspect the environment");
        ui.choice1.setActionCommand("scene_inspectTheEnvironment");//next scene to be added
        ui.choice2.setText("Take a Narrow Ice Tunnel");        
        ui.choice2.setActionCommand("scene_narrowIceTunnel");
        ui.choice3.setText("Follow the Wind-Swept Ridge");
        ui.choice3.setActionCommand("scene_windSweptRidge");
        ui.choice4.setText("Search a Frozen Ledge");
        ui.choice4.setActionCommand("scene_frozenLedge");
    }

    public void scene_inspectTheEnvironment(){
        ui.mainTextArea.setText("You find items such as frozen apples and frozen ore.\r\n" + //
                        " \"These frozen apples might not taste good, but they’ll keep us alive.\"\r\n" + //
                        "Lyra: \"Not much to work with, but every little bit helps. Grab what you can and let’s keep moving.\"\r\n" + //
                        "");

        ui.choice1.setText("Keep climbing");
        ui.choice1.setActionCommand("scene_theIceDragon");
        ui.choice2.setText("");        
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_narrowIceTunnel(){
        ui.mainTextArea.setText("You find a slithering Ice Serpent, its scales glinting in the icy light.\r\n" + //
                        "You fend off the serpent and gain +10 gold and +2 Strength. \r\n" + //
                        "Player: \"That was close… but we did it!\"  \r\n" + //
                        "Lyra: \"Nice reflexes! That serpent won’t be bothering anyone en(else.\"\r\n" + //
                        "");
        /*  ui.mainTextArea.setText("You find a slithering Ice Serpent, its scales glinting in the icy light.
    The serpent strikes, leaving you 25% health damage.
    Player: "Ugh… that hurt more than I expected!"
    Lyra: "Stay focused! We can’t afford another hit like that."
    Regardless, you continue climbing.
    "); */

        ui.choice1.setText("Keep climbing");
        ui.choice1.setActionCommand("scene_theIceDragon");
        ui.choice2.setText("");        
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_windSweptRidge(){
        ui.mainTextArea.setText("You and Lyra move quickly along the ridge, saving time and spotting a clear path ahead.\r\n" + //
                        "Player: \"This was faster than I thought!\"\r\n" + //
                        "Lyra: \"Smooth move! We’re making good progress.\"\r\n" + //
                        "");
        //failure case
        /*ui.mainTextArea.setText("A sudden gust slows you, costing some stamina, but you still make it forward.
    Player: "These winds are brutal!"
    Lyra: "Keep your balance… we’ll get there!"
    "); */
        ui.choice1.setText("Keep climbing");
        ui.choice1.setActionCommand("scene_theIceDragon");
        ui.choice2.setText("");        
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
        
    }

    public void scene_frozenLedge(){
        ui.mainTextArea.setText("You find frozen herbs and ore, useful for crafting and survival.\r\n" + //
                        "Player: \"Finally, something useful!\"\r\n" + //
                        "Lyra: \"Not bad! Grab as much as you can—we’ll need it soon.\"\r\n" + //
                        ""); //success case

        /*  ui.mainTextArea.setText("You find nothing, just icy rocks.
Player: "Nothing here… just ice and more ice."
Lyra: "Don’t worry, it’s all part of the climb. Onward!"
"); */ // this is for failure case
        
        ui.choice1.setText("Keep climbing");
        ui.choice1.setActionCommand("scene_theIceDragon");
        ui.choice2.setText("");        
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }
}