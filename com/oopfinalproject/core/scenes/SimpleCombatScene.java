package com.oopfinalproject.core.scenes;

import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy;
import com.oopfinalproject.core.Player;

/**
 * SimpleCombatScene: small helper scene that runs specified enemies in order.
 */
public class SimpleCombatScene extends Scene {
    private final Enemy[] sceneEnemies;

    public SimpleCombatScene(String title, Player player, UI ui, Enemy... enemies) {
        super(title, player, ui);
        this.sceneEnemies = enemies;
    }

    @Override
    protected void setup() {
        enemies.clear();
        for (Enemy e : sceneEnemies) {
            enemies.add(e);
        }
    }

    @Override
    protected void onVictory() {
        ui.updateCombatText("You cleared the scene: " + title);
    }
}