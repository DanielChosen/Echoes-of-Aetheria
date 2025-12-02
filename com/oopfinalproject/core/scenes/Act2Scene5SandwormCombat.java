package com.oopfinalproject.core.scenes;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.Sandworm;
import com.oopfinalproject.game.storyscenes.act2.Act2SandWorms;
import com.oopfinalproject.game.storyscenes.act2.Act2ColdDesertNight;

public class Act2Scene5SandwormCombat extends Scene {
    Act2SandWorms act2SandWorms;

    public Act2Scene5SandwormCombat(String title, Player player, UI ui, Act2SandWorms act2SandWorms) {
        super(title, player, ui);
        this.act2SandWorms = act2SandWorms;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("You step into the sandy lair of the desert worms. They are not happy to see you.");
        enemies.clear();
        enemies.add(new Sandworm());
        enemies.add(new Sandworm());
    }

    @Override
    protected void onVictory() {
        ui.updateCombatText("The sandworms are defeated, but the heat in the cave is unbearable. You must press on.");
        act2SandWorms.gotoNextScene(() -> act2SandWorms.scene_sandwormAttackVictory());
    }
}
