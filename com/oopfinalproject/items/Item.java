package com.oopfinalproject.items;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.Enemy;

public abstract class Item {
    protected String name;
    protected int str, vit, agi, intel, cha;
    protected String skillDescription, enemyBonus;

    public Item(String name, int str, int vit, int agi, int intel, int cha, String skillDescription, String enemyBonus) {
        this.name = name;
        this.str = str;
        this.vit = vit;
        this.agi = agi;
        this.intel = intel;
        this.cha = cha;
        this.skillDescription = skillDescription;
        this.enemyBonus = enemyBonus;
    }

    public abstract void activate(Player player, Enemy enemy);

    public String getName() {
        return name;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public String getEnemyBonus() {
        return enemyBonus;
    }
}
