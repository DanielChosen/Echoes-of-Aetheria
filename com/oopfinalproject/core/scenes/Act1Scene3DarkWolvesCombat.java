package com.oopfinalproject.core.scenes;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.DarkWolfLeader;
import com.oopfinalproject.game.storyscenes.act1.Act1IntroScenes;

public class Act1Scene3DarkWolvesCombat extends Scene {

    Act1IntroScenes act1IntroScenes;

    public Act1Scene3DarkWolvesCombat(String title, Player player, UI ui, Act1IntroScenes act1IntroScenes) {
        super(title, player, ui);
        this.act1IntroScenes = act1IntroScenes;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("You encounter the Dark Wolf Leader, its pack surrounding you.");
        enemies.clear();
        enemies.add(new DarkWolfLeader());
    }

    @Override
    protected void onVictory() {
        act1IntroScenes.gotoNextScene(() -> act1IntroScenes.scene_theBeginningOfAJourney());
    }
}
