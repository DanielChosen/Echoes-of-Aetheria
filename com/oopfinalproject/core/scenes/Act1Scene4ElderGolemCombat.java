package com.oopfinalproject.core.scenes;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.ElderGolem;
import com.oopfinalproject.game.storyscenes.act1.Act1DungeonScenes;

public class Act1Scene4ElderGolemCombat extends Scene {
    Act1DungeonScenes act1DungeonScenes;

    public Act1Scene4ElderGolemCombat(String title, Player player, UI ui, Act1DungeonScenes act1DungeonScenes) {
        super(title, player, ui);
        this.act1DungeonScenes = act1DungeonScenes;   
    }

    @Override
    protected void setup() {
        ui.updateCombatText("You face the Elder Golem, a giant stone creature awakened from its slumber.");
        enemies.clear();
        enemies.add(new ElderGolem());
    }

    @Override
    protected void onVictory() {
        //System.out.println("The Golem falls. You obtain a powerful artifact from its remains.");
        act1DungeonScenes.gotoNextScene(() -> act1DungeonScenes.success_theElderGolem());
    }

    @Override
    protected void onDefeat() {
        ui.updateCombatText("The Elder Golem proves too strong. Darkness closes in… Game Over.");
    }
}
