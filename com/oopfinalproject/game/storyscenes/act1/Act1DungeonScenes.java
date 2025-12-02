//done

package com.oopfinalproject.game.storyscenes.act1;

import com.oopfinalproject.game.Game;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.scenes.Act1Scene3DarkWolvesCombat2;
import com.oopfinalproject.core.scenes.Act1Scene4ElderGolemCombat;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.ItemsFactory;



public class Act1DungeonScenes {

    Game game;
    UI ui;
    Player player;

    public Act1DungeonScenes(Game g, UI u, Player p){
        game = g;
        ui = u;
        player = p;
    }

    public void gotoNextScene(Runnable nextScene){
        game.vm.titleToTown();
        nextScene.run();
    }

    public void scene_hiddenDungeon() {
        ui.mainTextArea.setText("You found a hidden dungeon. The entrance is covered in ivy and dust. Silence hangs thick.\n" + //
                        "\n" + //
                        "You notice skeletons—remnants of adventurers who didn’t survive. Their armour and weapons are rusted, a silent warning.\n" + //
                        "\n" + //
                        "Lyra peers at the remains and says softly, \"Looks like they weren’t as lucky as us… we should be careful.\"");

        ui.choice1.setText("Inspect the area"); ui.choice1.setActionCommand("success_inspectTheArea");
        ui.choice2.setText("Inspect the skeletons"); ui.choice2.setActionCommand("success_inspectTheSkeletons");
        ui.choice3.setText("Continue"); ui.choice3.setActionCommand("failure_inspectTheArea");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void success_inspectTheArea() {
        ui.mainTextArea.setText("You discovered traps and disabled them.\n" + //
                        "\n" + //
                        "\"One wrong step could be my last...\"");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_continueExploring");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void failure_inspectTheArea() {
        ui.mainTextArea.setText("You hear a faint click beneath your foot before the floor suddenly gives way, sending you crashing into a shallow trap lined with old, jagged wood. Pain shoots through your body as dust settles around you.\n" + //
                        "\n" + //
                        "\"Ugh… I got careless. These ruins aren’t going to let me off easy.\"");
        player.takeDamage(50);
        //ui.player.updatePlayerHpLabel(player.getCurrentHP(), player.getMaxHp());
        
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_continueExploring");
        
        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void success_inspectTheSkeletons() {
        ui.mainTextArea.setText("You carefully search through the skeletons and find a rusty but usable dagger and a small pouch of coins. These items could prove useful on your journey ahead.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_continueExploring");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void failure_inspectTheSkeletons() {
        ui.mainTextArea.setText("You search through the skeletons, but everything crumbles to dust before you can retrieve anything useful. No items are found.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_continueExploring");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void scene_continueExploring() {
        ui.mainTextArea.setText("Continue exploring the dungeon...");
        ui.choice1.setText("Go left"); ui.choice1.setActionCommand("scene_goLeft");
        ui.choice2.setText("Go right"); ui.choice2.setActionCommand("scene_darkWolves");

        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void scene_goLeft() {
        ui.mainTextArea.setText("You pull an old, cracked book from the shelf. Its pages are filled with strange, unreadable symbols that make no sense to you.\n" + //
                        "\n" + //
                        "\"There must be secrets hidden here… I need someone who can read this,\" you say, studying the mysterious text.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_ruinedChurch");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void scene_darkWolves() {
        ui.mainTextArea.setText("You encountered a pack of Dark wolves!.");
        game.vm.showCombatUI();  //shows combat ui
        Act1Scene3DarkWolvesCombat2 act1Scene3DarkWolvesCombat2 = new Act1Scene3DarkWolvesCombat2("Act 1 - Scene 1: Silverwood Forest", player, ui, this);
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act1Scene3DarkWolvesCombat2.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act1Scene3DarkWolvesCombat2.start();
        
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_ruinedChurch");
        ui.choice2.setText("Go Left"); ui.choice2.setActionCommand("scene_goLeft");

        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void scene_ruinedChurch() {
        ui.mainTextArea.setText("Sunlight streams through broken stained glass, scattering shards of color across the dust-choked floor. Rubble crunches beneath your feet, and the scent of damp wood and stone fills the air.");
        ui.choice1.setText("Inspect the area"); ui.choice1.setActionCommand("failure_inspectTheRuinedChurchArea");
        ui.choice2.setText("Continue"); ui.choice2.setActionCommand("scene_passageOfThePast");

        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void failure_inspectTheRuinedChurchArea() {
        ui.mainTextArea.setText("Nothing but debris. 'Nothing but echoes of the past…'");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_passageOfThePast");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void scene_passageOfThePast() {
        ui.mainTextArea.setText("After exploring nearly all of the dungeon passage, you find yourself in a giant room. At its center lies a gigantic dark rock with glowing purple fractures. The air hums with energy, and a chill runs down your spine.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_theElderGolem");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void scene_theElderGolem() {
        ui.mainTextArea.setText("As you step closer, the “rock” trembles—then unfolds into the hulking form of a corrupted Elder Golem. Its massive body looms above you, vines and stone shifting with each movement.");
        game.vm.showCombatUI();  //shows combat ui
        Act1Scene4ElderGolemCombat act1Scene4ElderGolemCombat = new Act1Scene4ElderGolemCombat("Act 1 - Scene 4: Silverwood Forest", player,ui, this);        
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic."); //doesnt show
        act1Scene4ElderGolemCombat.setLoadout(
            ItemsFactory.TrainingSword(),
            ItemsFactory.wanderersTunic(),
            ItemsFactory.woodenBuckler(),
            ItemsFactory.shadowsWhisper()
        );

        act1Scene4ElderGolemCombat.start();
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("success_theElderGolem");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void success_theElderGolem() {
        game.updatePlayerPanel();
        //ItemsFactory.EclipseEdge(); //temp
        ui.mainTextArea.setText("You fight with precision and determination. After a tense struggle, the golem collapses, its corruption fading, returning it to the guardian of Spiritwood. (You gain rewards.)");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_darkness");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }

    public void scene_darkness() {
        ui.mainTextArea.setText("After celebrating with Lyra, exhaustion drags you into a deep sleep.\n" + //
                        "\n" + //
                        "You had a Nightmare:\n" + //
                        "Windrest lies in ruins. Shadows twist through the wreckage, whispering and warping your memories.\n" + //
                        "\n" + //
                        "You wake up sweating, heart pounding.\n" + //
                        "\"Why did it feel so real…? I can’t remember…\" you mutter.");
        ui.choice1.setText("Continue"); ui.choice1.setActionCommand("scene_theHero");

        ui.choice2.setText(""); ui.choice2.setActionCommand("");
        ui.choice3.setText(""); ui.choice3.setActionCommand("");
        ui.choice4.setText(""); ui.choice4.setActionCommand("");
        ui.choice5.setText(""); ui.choice5.setActionCommand("");
    }
}
