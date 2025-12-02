package com.oopfinalproject.core.scenes;

import com.oopfinalproject.game.UI;//temp
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.Enemy.UmbralCreep;
import com.oopfinalproject.game.storyscenes.PrologueScenes;
import java.util.ArrayList;

public class PrologueScene1Combat extends Scene {
    PrologueScenes prologueScenes;
    
    public PrologueScene1Combat(String title,Player player,UI ui,PrologueScenes prologueScenes) {
        super(title, player,ui);
        this.prologueScenes = prologueScenes;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("You practice your swings on a shadow creature summoned from the festival magic.");
        //System.out.println("You practice your swings on a shadow creature summoned from the festival magic.");
        enemies = new ArrayList<>();
        enemies.add(new UmbralCreep());
    }

    @Override
    protected void onVictory() {
        prologueScenes.gotoNextScene(() -> prologueScenes.scene_rest()); //cannot find symbol
        //prologueScenes.game.vm.titleToTown();
        //ui.updateCombatText("You finish your practice session, feeling a little more confident.");//after victory should go to scene_rest();
        //prologueScenes.gotoNextScene(() -> prologueScenes.scene_rest()); //cannot find symbol
        //System.out.println("You finish your practice session, feeling a little more confident.");
    }
}
