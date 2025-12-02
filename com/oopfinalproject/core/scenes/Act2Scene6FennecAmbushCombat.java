package com.oopfinalproject.core.scenes;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.ArmoredFennec;
import com.oopfinalproject.game.storyscenes.act2.Act2ColdDesertNight;

public class Act2Scene6FennecAmbushCombat extends Scene {

    private final Act2ColdDesertNight act2ColdDesertNight;

    public Act2Scene6FennecAmbushCombat(String title, Player player, UI ui, Act2ColdDesertNight act2ColdDesertNight) {
        super(title, player, ui);
        this.act2ColdDesertNight = act2ColdDesertNight;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("In the desert night, you’re ambushed by the swift Armored Fennec.");
        enemies.clear();
        enemies.add(new ArmoredFennec());
        enemies.add(new ArmoredFennec());
    }

    @Override
    protected void onVictory() {
        ui.updateCombatText("You defeat the Fennecs, their bodies lying in the sand. The desert night is still once more.");

        // depending on your signature:
        act2ColdDesertNight.gotoNextScene(() -> act2ColdDesertNight.scene_setTrap());
    }
}
