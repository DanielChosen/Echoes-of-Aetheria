package com.oopfinalproject.game.storyscenes.act3;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;


public class Act3TheAfterMathofShadow {
    Game game;
    UI ui;
    Player player;

    public Act3TheAfterMathofShadow(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }
    
    public void scene_FinalDecision(){
        ui.mainTextArea.setText("With Shadow defeated, the darkness he once held surges uncontrollably, twisting the world around you.\r\n" + //
                        "Lyra floats beside you, calm yet tense:\r\n" + //
                        " Lyra: “This is it. You have the shards… how you choose to use them will decide everything. Be certain of your choice.”\r\n" + //
                        "");
        ui.choice1.setText("Stand And Fight");
        ui.choice1.setActionCommand("scene_GoodEnding");
        ui.choice2.setText("Take The Burden");
        ui.choice2.setActionCommand("scene_BadEnding");
        ui.choice3.setText("Seperate the World");
        ui.choice3.setActionCommand("scene_NormalEnding");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_GoodEnding(){
        ui.mainTextArea.setText("You clutch the shards tightly, feeling their immense power surging through you, almost overwhelming your senses.\r\n" + //
                        "You: “I can feel it… the darkness is relentless, but I’ve come too far to falter now. I won’t let it survive another moment. Not after everything.”\r\n" + //
                        "You pour all your strength into the shards, letting them radiate pure light. The darkness screams, twisting and lashing at you, but you hold your ground.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_GoodEnding2");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_GoodEnding2(){
        ui.mainTextArea.setText(" The shadows scream and fracture under the force of the shards. Light floods the skies as the darkness shatters into nothingness. The world sighs in relief as the land, the cities, and the forests begin to heal.\r\n" + //
                        "Lyra:\r\n" + //
                        "\t “You… you’ve done it. Truly… Aetheria is finally safe because of you. You stood when all hope seemed lost… you carried the world in your hands, and you didn’t falter.”");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_theGuardianOfAetheria");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_BadEnding(){
        ui.mainTextArea.setText("Lyra floats forward, her light flaring brighter than ever.\r\n" + //
                        "“I’ve failed once before… I can’t let history repeat itself. If one of us must fall, let it be me. I’ve carried regret for too long… this time, I will hold it!”\r\n" + //
                        "She strikes at the heart of the darkness, her spirit straining against its infinite corruption. For a fleeting moment, it seems she might succeed—but the darkness roars back violently, overwhelming her fragile form.\r\n" + //
                        "“…It’s… too strong… I can’t… hold it… I’m sorry…”\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_BadEnding2");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_BadEnding2(){
        ui.mainTextArea.setText("Forced to act, you hurl yourself into the void, pouring your soul into the shards to anchor the darkness. Corruption gnaws at your essence as you fight to contain it.\r\n" + //
                        "“No… I can’t let her sacrifice be in vain! I’ll bear this burden… even if it costs me everything!”\r\n" + //
                        "The darkness is contained within your soul, but the rest of the world is consumed. Cities crumble, forests burn, and the lands are swallowed by endless shadow. Lyra’s light fades, leaving only a faint echo of her voice\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_FailedHero");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_NormalEnding(){
        ui.mainTextArea.setText("You lift the shards, feeling their power thrumming through every fiber of your being.\r\n" + //
                        "“If the world cannot be saved as one… then we will save what we can. I will do what must be done, even if it means splitting everything apart.”\r\n" + //
                        "The shards pulse violently, tearing reality in two. One realm of light remains intact, while a parallel realm falls into darkness, isolating the corrupted forever.\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_NormalEnding2");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    public void scene_NormalEnding2(){
        ui.mainTextArea.setText("The realms separate. The light realm thrives, safe from corruption, while the dark realm becomes a desolate prison, holding the corrupted. Balance is preserved, but the cost of division is permanent.\r\n" + //
                        "“It’s not perfect… nothing ever is. But it’s enough. Those in the light will live and grow… and perhaps, one day, those in the dark may find redemption. We’ve done what we had to do… no more, no less.”\r\n" + //
                        "");
        ui.choice1.setText("Continue");
        ui.choice1.setActionCommand("scene_EchoesOfAetheria");
        ui.choice2.setText("");
        ui.choice2.setActionCommand("");
        ui.choice3.setText("");
        ui.choice3.setActionCommand("");
        ui.choice4.setText("");
        ui.choice4.setActionCommand("");
    }

    

}
