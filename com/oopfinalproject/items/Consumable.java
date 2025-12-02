package com.oopfinalproject.items;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.Enemy;

public abstract class Consumable extends Item {
    protected int hp, mp;
    protected String effect;
    public Consumable(String name,int hp,int mp,int str,int vit,int agi,int intel,int cha,String effect,String enemyBonus){
        super(name, str, vit, agi, intel, cha, effect, enemyBonus);
        this.hp=hp; this.mp=mp; this.effect=effect;
    }
    public abstract void activate(Player player, Enemy enemy);
    public String getName() { return name; }
}

class SmallHealingPotion extends Consumable { public SmallHealingPotion() {
    super("Small Healing Potion", 30, 0, 0, 0, 0, 0, 0, "None", "None"); }
    @Override public void activate(Player player, Enemy enemy) {
        player.healHP(30);
        System.out.println("Small Healing Potion used! +30 HP.");
    }
}

class GreaterHealingPotion extends Consumable { public GreaterHealingPotion() {
    super("Greater Healing Potion", 80, 0, 0, 0, 0, 0, 0, "None", "None"); }
    @Override public void activate(Player player, Enemy enemy) {
        player.healHP(80);
        System.out.println("Greater Healing Potion used! +80 HP.");
    }
}

class ManaPotion extends Consumable { public ManaPotion() {
    super("Mana Potion", 0, 40, 0, 0, 0, 0, 0, "None", "None"); }
    @Override public void activate(Player player, Enemy enemy) {
        player.restoreMP(40);
        System.out.println("Mana Potion used! +40 MP.");
    }
}

class StaminaBrew extends Consumable { public StaminaBrew() {
    super("Stamina Brew", 20, 20, 0, 1, 0, 0, 0, "None", "None"); }
    @Override public void activate(Player player, Enemy enemy) {
        player.increaseAgi(1);
        player.healHP(20);
        player.restoreMP(20);
        System.out.println("Stamina Brew used! +20 HP and MP, AGI+1.");
    }
}

class FrostbiteCure extends Consumable { public FrostbiteCure() {
    super("Frostbite Cure", 0, 0, 1, 0, 0, 0, 0, "VIT+1", "+20% vs Frost enemies temporarily"); }
    @Override public void activate(Player player, Enemy enemy) {
        //player.removeStatus("Frostbite");
        player.increaseVit(1);
        player.increaseBonusFrost(0.20);
        System.out.println("Frostbite Cure used! Status removed, VIT+1, +20% vs Frost enemies temporarily.");
    }
}

class HeatResistanceElixir extends Consumable { public HeatResistanceElixir() {
    super("Heat Resistance Elixir", 0, 0, 1, 0, 0, 0, 0, "VIT+1", "+20% vs Desert enemies temporarily"); }
    @Override public void activate(Player player, Enemy enemy) {
       // player.applyTemporaryEffect("FireResist", 0.50, 5);
        player.increaseVit(1);
        player.increaseBonusDesert(0.20);
        System.out.println("Heat Resistance Elixir used! -50% fire dmg for 5 turns, VIT+1, +20% vs Desert temporarily.");
    }
}

class ScrollOfFreeze extends Consumable { public ScrollOfFreeze() {
    super("Scroll of Freeze", 0, 0, 0, 0, 0, 0, 0, "None", "+25% dmg vs Frost/Beasts"); }
    @Override public void activate(Player player, Enemy enemy) {
        //player.applyFreeze(1);
        player.increaseBonusFrost(0.25);
        player.increaseBonusBeasts(0.25);
        System.out.println("Scroll of Freeze used! Freeze 1 turn, +25% dmg vs Frost/Beasts.");
    }
}

class ScrollOfFireburst extends Consumable { public ScrollOfFireburst() {
    super("Scroll of Fireburst", 0, 0, 0, 0, 1, 0, 0, "INT+1", "+25% dmg vs Shadow"); }
    @Override public void activate(Player player, Enemy enemy) {
        player.increaseIntel(1);
        player.increaseBonusShadow(0.25);
        System.out.println("Scroll of Fireburst used! INT+1, Fire AoE, +25% dmg vs Shadow.");
    }
}

class ScrollOfBarrier extends Consumable { public ScrollOfBarrier() {
    super("Scroll of Barrier", 0, 0, 0, 0, 0, 0, 0, "None", "+15% vs Boss attacks"); }
    @Override public void activate(Player player, Enemy enemy) {
        //player.applyTemporaryEffect(0.25, 2);
        player.increaseBonusBoss(0.15);
        System.out.println("Scroll of Barrier used! +25% DEF for 2 turns, +15% vs Boss attacks.");
    }
}

class FrozenApple extends Consumable { public FrozenApple() {
    super("Frozen Apple", 10, 0, 1, 0, 0, 0, 0, "VIT+1", "None"); }
    @Override public void activate(Player player, Enemy enemy) {
        player.healHP(10); player.increaseVit(1);
        System.out.println("Frozen Apple used! +10 HP, VIT+1.");
    }
}

class WolfPelts extends Consumable { public WolfPelts() {
    super("Wolf Pelts", 0, 0, 0, 0, 0, 0, 0, "None", "+10% dmg vs Beasts temporarily if used in crafting"); }
    @Override public void activate(Player player, Enemy enemy) {
        player.increaseBonusBeasts(0.05);
        System.out.println("Wolf Pelts used! +5% dmg vs Beasts.");
    }
}

class CrystalFragments extends Consumable { public CrystalFragments() {
    super("Crystal Fragments", 0, 0, 1, 1, 1, 1, 1, "+1 all stats upon upgrade", "+50% dmg vs Bosses if Aetherblade equipped"); }
    @Override public void activate(Player player, Enemy enemy) {
        player.increaseStr(1);
        player.increaseVit(1);
        player.increaseAgi(1);
        player.increaseIntel(1);
        player.increaseCha(1);
        player.increaseBonusBoss(0.50);
        System.out.println("Crystal Fragments used! +1 all stats, +50% dmg vs Bosses if Aetherblade equipped.");
    }
}
