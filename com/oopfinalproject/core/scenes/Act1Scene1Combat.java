package com.oopfinalproject.core.scenes;

import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.Enemy.CorruptedWolf;
import com.oopfinalproject.game.storyscenes.act1.Act1IntroScenes;

import java.util.ArrayList;

public class Act1Scene1Combat extends Scene {
	Act1IntroScenes act1IntroScenes;

    public Act1Scene1Combat(String title, Player player, UI ui, Act1IntroScenes act1IntroScenes) {
        super(title, player, ui);
        this.act1IntroScenes = act1IntroScenes;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("You see Lyra surrounded by corrupted wolves. You rush to defend her!");

        enemies = new ArrayList<>();
        enemies.add(new CorruptedWolf());
        enemies.add(new CorruptedWolf());
    }

	@Override
	protected void onVictory() {
    act1IntroScenes.gotoNextScene(() -> act1IntroScenes.scene_saveHerOutcome());
}

}



