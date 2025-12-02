//no combat

package com.oopfinalproject.game.storyscenes.act2;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;



public class Act2TheDarkStringOfFate {
    Game game;
    UI ui;
    Player player;

    public Act2TheDarkStringOfFate(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void scene_darkStringofFate(){
        ui.mainTextArea.setText("Having finally collected all the fragments of the crystal, everything suddenly goes black.\n" + //
                        "\n" + //
                        "You notice a dark string connecting you to the entity, sending a chill crawling through your mind. Its presence is heavy and suffocating.\n" + //
                        "\n" + //
                        "A dark figure manifests within your consciousness, standing face to face. Its gaze pierces you, unblinking, and a mockingly confident smile twists across its shadowed visage, as if claiming you.\n" + //
                        "\n" + //
                        "Paralysis grips you utterly—you cannot move, speak, or even blink.");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_flashback");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    public void scene_flashback(){
        ui.mainTextArea.setText("A montage floods your consciousness: every battle, every struggle, every failure. Moments of pain, fear, and despair flash by. And yet… despite it all, you overcame every trial, step by step.\n" + //
                        "\n" + //
                        "Summoning all the courage buried deep within, you declare silently in your mind:  \n" + //
                        "\"No matter what, I will come for you and defeat you, even if it costs my life.\"\n" + //
                        "\n" + //
                        "The figure slowly steps back, still smiling. Then, in a voice that reverberates inside your consciousness, it speaks a single, cryptic sentence:  \n" + //
                        "\"╎ꖎꖎ ʖᒷ ∴ᔑ╎ℸ ̣ ╎リ⊣\"");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_afterConfrontation");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

    

    public void scene_afterConfrontation(){
        ui.mainTextArea.setText("And then, as suddenly as it appeared, the entity vanishes, leaving only the echo of its presence. The dark string lingers for a moment before dissolving, leaving your mind heavy with unease.\n" + //
                        "\n" + //
                        "Lyra, noticing your tense posture and pale expression, finally speaks:  \n" + //
                        "\"Hey… are you okay?\"\n" + //
                        "\n" + //
                        "Player (breathing heavily): \"Yeah… I think so…\"");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_Airship");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText(""); 
        ui.choice3.setActionCommand("");    
        ui.choice4.setText(""); 
        ui.choice4.setActionCommand("");
    }

}