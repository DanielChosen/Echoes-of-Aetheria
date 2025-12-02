package com.oopfinalproject.core.scenes;


import com.oopfinalproject.game.UI;
import java.util.ArrayList;
import java.util.List;
import com.oopfinalproject.items.*;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.Enemy;
import com.oopfinalproject.core.Combat_System;
import com.oopfinalproject.core.EquipmentManager;

public abstract class Scene {
    protected UI ui;
    protected String title;
    protected Player player;
    protected List<Enemy> enemies = new ArrayList<>();
    protected EquipmentManager equipmentManager = EquipmentManager.getInstance();

    protected Weapon weapon;
    protected Armor armor;
    protected Shield shield;
    protected Accessory accessory;

    private int currentEnemyIndex = 0;

    public Scene(String title, Player player, UI ui) {
        this.title = title;
        this.player = player;
        this.ui = ui;
    }

    public void setLoadout(Weapon w, Armor a, Shield s, Accessory ac) {
        this.weapon = w;
        this.armor = a;
        this.shield = s;
        this.accessory = ac;
    }

    /** Called by the game to start the scene */
    public void start() {
        ui.updateCombatTitle("=== " + title + " ===");
        setup();

        if (enemies.isEmpty()) {
            // Non-combat scene: run victory callback immediately
            onVictory();
        } else {
            // Start the first enemy encounter
            currentEnemyIndex = 0;
            startNextEnemy();
        }
    }

    /** Start the next enemy in the list asynchronously */
    private void startNextEnemy() {
        if (currentEnemyIndex >= enemies.size()) {
            onVictory();
            return;
        }

        Enemy enemy = enemies.get(currentEnemyIndex);

        Combat_System combat = new Combat_System(
                player,
                enemy,
                equipmentManager,
                player.getInventory(),
                ui
        );

        // When this enemy is defeated, move to the next one
        combat.setOnVictoryCallback(() -> {
            currentEnemyIndex++;
            startNextEnemy();
        });

        combat.startBattle();
    }

    protected abstract void setup();

    /** Called when all enemies in the scene are defeated */
    protected void onVictory() {}

    /** Called if player is defeated (optional) */
    protected void onDefeat() {}
}