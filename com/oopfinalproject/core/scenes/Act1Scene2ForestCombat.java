package com.oopfinalproject.core.scenes;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.game.storyscenes.act1.Act1IntroScenes;
import com.oopfinalproject.core.Enemy.UmbralCreep;

public class Act1Scene2ForestCombat extends Scene {

    Act1IntroScenes act1IntroScenes;

    public Act1Scene2ForestCombat(String title, Player player, UI ui, Act1IntroScenes act1IntroScenes) {
        super(title, player, ui);
        this.act1IntroScenes = act1IntroScenes;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("In Silverwood forest, you encounter shadow creatures.");

        enemies.clear();
        enemies.add(new UmbralCreep());
        enemies.add(new UmbralCreep());
    }

    @Override
    protected void onVictory() {
        act1IntroScenes.gotoNextScene(() -> act1IntroScenes.scene_firstBattle2());
    }
}
