package game.storyscenes;

import game.Game;
import game.Player;
import game.UI;

public class PrologueScenes {

    Game game;
    UI ui;
    Player player;

    public PrologueScenes(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void Village() {
        ui.mainTextArea.setText("The village of Windrest buzzed with warmth and color. Banners fluttered over the streets as villagers carried baskets of fruits and firewood, preparing for the annual Festival of Winds. Children ran past, laughing, while musicians tuned their wooden flutes near the fountain.\n" + //
                        "\n" + //
                        "Away from the noise, a young man practiced sword swings behind his home. Sweat dripped down his cheek as his wooden blade struck a training dummy.");

        ui.choice1.setText("Keep Practicing");
        ui.choice1.setActionCommand("Tutorial");

        ui.choice2.setText("Rest under the tree");
        ui.choice2.setActionCommand("rest");

        // Clear unused buttons
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_Tutorial() {
        ui.mainTextArea.setText("COMBAT UI HERE");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("rest");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_rest() {
        ui.mainTextArea.setText("You wiped the sweat from your brow and muttered to yourself, \"I want to leave this village and see the world. If I can become an adventurer, I can learn to handle danger, earn a living, and make something of myself.\"");

        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("theCrystal");

        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }
}
