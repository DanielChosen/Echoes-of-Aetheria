package com.oopfinalproject.core.scenes;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.ShadowPhase1;
import com.oopfinalproject.core.Enemy.ShadowPhase2;
import com.oopfinalproject.core.Enemy.ShadowPhase3;
import com.oopfinalproject.game.storyscenes.act3.Act3Epilogue;
import com.oopfinalproject.game.storyscenes.act3.Act3TheBeginningofTheEnd;

public class Act3Scene4FinalBattle extends Scene {
    Act3TheBeginningofTheEnd act3TheBeginningofTheEnd;
    Act3Epilogue act3Epilogue;

    public Act3Scene4FinalBattle(String title, Player player, UI ui, Act3TheBeginningofTheEnd act3TheBeginningofTheEnd){
        super(title, player, ui);
        this.act3TheBeginningofTheEnd = act3TheBeginningofTheEnd;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("You enter the floating temple, the massive stone gates creaking open before you.");
        ui.updateCombatText("Inside, the air is thick with dark energy. The Entity, Shadow, stands before you, an embodiment of malice.");

        enemies.clear();
        enemies.add(new ShadowPhase1());
        enemies.add(new ShadowPhase2());
        enemies.add(new ShadowPhase3());
    }

    @Override
    protected void onVictory() {
        ui.updateCombatText("Shadow is defeated. The temple quakes, and a brilliant light fills the sky as darkness dissipates.");
        act3TheBeginningofTheEnd.gotoNextScene(() -> act3Epilogue.scene_theGuardianOfAetheria());
    }

    @Override
    protected void onDefeat() {
        System.out.println("Shadow’s darkness overwhelms you. The world is consumed by shadows.");
    }
}
