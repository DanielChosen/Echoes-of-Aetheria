package com.oopfinalproject.core.scenes;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.ArmoredFennec;
import com.oopfinalproject.core.Enemy.SandstoneKnight;
import com.oopfinalproject.game.storyscenes.act2.Act2TheKnight;

public class Act2Scene8KnightCombat extends Scene {

    Act2TheKnight act2TheKnight;

    public Act2Scene8KnightCombat(String title, Player player, UI ui, Act2TheKnight act2TheKnight) {
        super(title, player, ui);
        this.act2TheKnight = act2TheKnight;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("You face the legendary Sandstone Knight, its minions rising from the sand.");

        enemies.clear();
        enemies.add(new ArmoredFennec());
        enemies.add(new ArmoredFennec());
        enemies.add(new SandstoneKnight());
    }

    @Override
    protected void onVictory() {
        ui.updateCombatText("The Sandstone Knight falls. The temple’s secrets are now within your grasp.");
        act2TheKnight.gotoNextScene(() -> act2TheKnight.scene_minionKnightVictory());
    }

    @Override
    protected void onDefeat() {
        ui.updateCombatText("You fall before the Knight’s might. Your journey ends here."
        );
    }
}
