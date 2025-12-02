package com.oopfinalproject.core.scenes;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.game.storyscenes.act1.Act1ForestScenes;
import com.oopfinalproject.core.Enemy.UmbralCreep;

public class Act1Scene2ForestCombat2 extends Scene {

    Act1ForestScenes act1ForestScenes;

    public Act1Scene2ForestCombat2(String title, Player player, UI ui, Act1ForestScenes act1ForestScenes) {
        super(title, player, ui);
        this.act1ForestScenes = act1ForestScenes;
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
        act1ForestScenes.gotoNextScene(() -> act1ForestScenes.success_escapeTheGhouls());
    }
}
