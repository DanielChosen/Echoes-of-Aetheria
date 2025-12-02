package com.oopfinalproject.core.scenes;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.SandstormGuardian;
import com.oopfinalproject.game.storyscenes.act2.Act2SandStorm;

public class Act2Scene7SandstormGuardianCombat extends Scene {
    Act2SandStorm act2SandStorm;

    public Act2Scene7SandstormGuardianCombat(String title, Player player, UI ui, Act2SandStorm act2SandStorm) {
        super(title, player, ui);
        this.act2SandStorm = act2SandStorm;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("An ethereal sandstorm entity emerges before you, commanding the desert.");
        enemies.clear();
        enemies.add(new SandstormGuardian());
    }

    @Override
    protected void onVictory() {
        System.out.println("The sandstorm clears as you defeat the Guardian. A passage opens before you.");
        act2SandStorm.gotoNextScene(() -> act2SandStorm.scene_followtheFennec());
    }

    @Override
    protected void onDefeat() {
        System.out.println("The sandstorm overwhelms you. You struggle to breathe as you retreat.");
    }
}
