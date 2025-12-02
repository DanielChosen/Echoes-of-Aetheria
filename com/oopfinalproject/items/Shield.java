package com.oopfinalproject.items;

import com.oopfinalproject.core.Player;

public abstract class Shield extends Item {
    protected int def;
    public Shield(String name,int def,int str,int vit,int agi,int intel,int cha,String skill,String enemyBonus){
        super(name, str, vit, agi, intel, cha, skill, enemyBonus);
        this.def = def;
    }
    public int getDef() { return def; }
}

// SHIELDS 
class WoodenBuckler extends Shield {
    public WoodenBuckler() {
        super("Wooden Buckler", 6, 0, 0, 1, 0, 0, "+3% block", "+10% vs Beasts");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseAgi(1);
        player.increaseBlockChance(0.03);
        player.increaseBonusBeasts(0.10);
        System.out.println("Wooden Buckler activated! AGI+1, +3% block, +10% vs Beasts.");
    }
}

class IronRoundShield extends Shield {
    public IronRoundShield() {
        super("Iron Round Shield", 10, 0, 2, 0, 0, 0, "+5% block", "+15% vs Beasts");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(2);
        player.increaseBlockChance(0.05);
        player.increaseBonusBeasts(0.15);
        System.out.println("Iron Round Shield activated! VIT+2, +5% block, +15% vs Beasts.");
    }
}

class SpiritwoodShield extends Shield {
    public SpiritwoodShield() {
        super("Spiritwood Shield", 12, 1, 2, 0, 0, 0, "+10% corruption resist", "+25% vs Shadow");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(1);
        player.increaseVit(2);
        player.increaseCorruptionResist(0.10);
        player.increaseBonusShadow(0.25);
        System.out.println("Spiritwood Shield activated! STR+1, VIT+2, +10% corruption resist, +25% vs Shadow.");
    }
}

class FrostboundBarrier extends Shield {
    public FrostboundBarrier() {
        super("Frostbound Barrier", 15, 0, 3, 0, 0, 0, "+20% frost resist", "+30% vs Frost");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseFrostResist(0.20);
        System.out.println("Frostbound Barrier activated! +20% frost resist.");
    }
}

class SandsteelTowerShield extends Shield {
    public SandsteelTowerShield() {
        super("Sandsteel Tower Shield", 18, 2, 0, 0, 0, 0, "+15% block", "+25% vs Desert");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(2);
        player.increaseBlockChance(0.15);
        player.increaseBonusDesert(0.25);
        System.out.println("Sandsteel Tower Shield activated! STR+2, +15% block, +25% vs Desert.");
    }
}

class GuardiansAegis extends Shield {
    public GuardiansAegis() {
        super("Guardian’s Aegis", 24, 2, 2, 1, 1, 0, "+25% block", "+50% vs Bosses");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseBlockChance(0.25);
        System.out.println("Guardian’s Aegis activated! +25% block.");
    }
}
