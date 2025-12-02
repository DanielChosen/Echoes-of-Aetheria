package com.oopfinalproject.core.scenes;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.DarkWolfLeader;
import com.oopfinalproject.game.storyscenes.act1.Act1DungeonScenes;

public class Act1Scene3DarkWolvesCombat2 extends Scene {

    Act1DungeonScenes act1DungeonScenes;

    public Act1Scene3DarkWolvesCombat2(String title, Player player, UI ui, Act1DungeonScenes act1DungeonScenes) {
        super(title, player, ui);
        this.act1DungeonScenes = act1DungeonScenes;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("You encounter the Dark Wolf Leader, its pack surrounding you.");
        enemies.clear();
        enemies.add(new DarkWolfLeader());
    }

    @Override
    protected void onVictory() {
        act1DungeonScenes.gotoNextScene(() -> act1DungeonScenes.scene_ruinedChurch());
    }
}
