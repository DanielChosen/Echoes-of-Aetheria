package com.oopfinalproject.core.scenes;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.game.UI;
import com.oopfinalproject.core.Enemy.IceDragonSyntice;
import com.oopfinalproject.game.storyscenes.act2.Act2EtherealBeauty;


public class Act2Scene4SynticeCombat extends Scene {
    Act2EtherealBeauty act2EtherealBeauty;

    public Act2Scene4SynticeCombat(String title,Player player,UI ui, Act2EtherealBeauty act2EtherealBeauty) {
        super(title, player,ui);
        this.act2EtherealBeauty = act2EtherealBeauty;
    }

    @Override
    protected void setup() {
        ui.updateCombatText("The Ice Dragon Syntice awakens in its icy lair, ready to defend its domain.");
        enemies.clear();
        enemies.add(new IceDragonSyntice());
    }

    @Override
    protected void onVictory() {
        act2EtherealBeauty.gotoNextScene(() -> act2EtherealBeauty.scene_defeatedtheIceDragon());
    }

    @Override
    protected void onDefeat() {
        System.out.println("The dragon overwhelms you. You retreat to regroup.");
    }
}
