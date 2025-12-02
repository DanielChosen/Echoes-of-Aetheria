package com.oopfinalproject.items;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.Enemy;

public abstract class Armor extends Item {
    protected int def;
    public Armor(String name,int def,int str,int vit,int agi,int intel,int cha,String skill,String enemyBonus){
        super(name, str, vit, agi, intel, cha, skill, enemyBonus);
        this.def = def;
    }
    public int getDef() { return def; }
}

// ARMOR
// CLOTH / LIGHT ARMOR 
class WanderersTunic extends Armor {
    public WanderersTunic() { super("Wanderer's Tunic", 4, 0, 10, 1, 0, 0, "Quick Step: +3% dodge", "+10% vs Beasts"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseVit(10);
        player.increaseAgi(1);
        player.increaseDodge(0.03);
        player.increaseBonusBeasts(0.10);
        System.out.println("Wanderer's Tunic activated! VIT+10, AGI+1, +3% dodge, +10% vs Beasts.");
    }
}

class ForestcloakMantle extends Armor {
    public ForestcloakMantle() { super("Forestcloak Mantle", 6, 0, 15, 1, 2, 0, "Forest Veil: +10% evasion in forests", "+15% vs Plants"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(15);
        player.increaseAgi(1);
        player.increaseIntel(2);
        player.increaseDodge(0.10);
        player.increaseBonusPlants(0.15);
        System.out.println("Forestcloak Mantle activated! VIT+15, AGI+1, INT+2, +10% evasion in forests, +15% vs Plants.");
    }
}

class FrostweaveRobe extends Armor {
    public FrostweaveRobe() { super("Frostweave Robe", 5, 0, 20, 0, 1, 2, "Cold Resist: -10% frost dmg", "+20% vs Frost/White Wolves"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(20);
        player.increaseIntel(1);
        player.increaseCha(2);
        player.increaseFrostResist(0.10);
        player.increaseBonusFrost(0.20);
        System.out.println("Frostweave Robe activated! VIT+20, INT+1, CHA+2, -10% frost dmg, +20% vs Frost/White Wolves.");
    }
}

class DesertNomadWraps extends Armor {
    public DesertNomadWraps() { super("Desert Nomad Wraps", 5, 0, 15, 2, 0, 0, "Heat Ward: -10% fire dmg", "+20% vs Desert enemies"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(15);
        player.increaseAgi(2);
        player.increaseFireResist(0.10);
        player.increaseBonusDesert(0.20);
        System.out.println("Desert Nomad Wraps activated! VIT+15, AGI+2, -10% fire dmg, +20% vs Desert.");
    }
}

class EtherealRobe extends Armor {
    public EtherealRobe() { super("Ethereal Robe", 8, 0, 25, 1, 3, 0, "Mana Shroud: +5 MP per battle", "+10% vs Shadow"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(25);
        player.increaseAgi(1);
        player.increaseIntel(3);
        player.increaseMP(5);
        player.increaseBonusShadow(0.10);
        System.out.println("Ethereal Robe activated! VIT+25, AGI+1, INT+3, +5 MP, +10% vs Shadow.");
    }
}

// MEDIUM ARMOR 
class IronAdventurersVest extends Armor {
    public IronAdventurersVest() { super("Iron Adventurer's Vest", 10, 1, 25, 2, 0, 0, "Steadfast: +5% DEF", "+10% vs Beasts"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(1);
        player.increaseVit(25);
        player.increaseAgi(2);
        player.increaseBonusBeasts(0.10);
        System.out.println("Iron Adventurer's Vest activated! STR+1, VIT+25, AGI+2, +5% DEF, +10% vs Beasts.");
    }
}

class SpiritwoodJerkin extends Armor {
    public SpiritwoodJerkin() { super("Spiritwood Jerkin", 12, 2, 30, 1, 0, 0, "Grove's Harmony: +10% healing received", "+15% vs Plants"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(2);
        player.increaseVit(30);
        player.increaseAgi(1);
        player.increaseBonusPlants(0.15);
        System.out.println("Spiritwood Jerkin activated! STR+2, VIT+30, AGI+1, +10% healing received, +15% vs Plants.");
    }
}

class FrostfurArmor extends Armor {
    public FrostfurArmor() { super("Frostfur Armor", 13, 0, 35, 3, 0, 0, "Chilled Hide: -20% ice dmg", "+25% vs Frost enemies"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(35);
        player.increaseAgi(3);
        player.increaseFrostResist(0.20);
        player.increaseBonusFrost(0.25);
        System.out.println("Frostfur Armor activated! VIT+35, AGI+3, -20% ice dmg, +25% vs Frost.");
    }
}

class SandsteelBreastplate extends Armor {
    public SandsteelBreastplate() { super("Sandsteel Breastplate", 14, 2, 40, 0, 1, 0, "Sun Guard: -20% burn chance", "+20% vs Desert enemies"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(2);
        player.increaseVit(40);
        player.increaseIntel(1);
        player.increaseFireResist(0.20);
        player.increaseBonusDesert(0.20);
        System.out.println("Sandsteel Breastplate activated! STR+2, VIT+40, INT+1, -20% burn chance, +20% vs Desert.");
    }
}

// HEAVY ARMOR 
class BronzePlate extends Armor {
    public BronzePlate() { super("Bronze Plate", 16, 3, 50, 0, 0, 0, "Harden: -10% phys dmg", "+15% vs Beasts"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(3);
        player.increaseVit(50);
        player.increaseBonusBeasts(0.15);
        System.out.println("Bronze Plate activated! STR+3, VIT+50, -10% phys dmg, +15% vs Beasts.");
    }
}

class SilverwoodGuardianMail extends Armor {
    public SilverwoodGuardianMail() { super("Silverwood Guardian Mail", 20, 3, 60, 2, 0, 0, "Purity Aura: -15% corruption dmg", "+25% vs Shadow/Corrupted"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(3);
        player.increaseVit(60);
        player.increaseAgi(2);
        player.increaseCorruptionResist(0.15);
        player.increaseBonusShadow(0.25);
        System.out.println("Silverwood Guardian Mail activated! STR+3, VIT+60, AGI+2, -15% corruption dmg, +25% vs Shadow/Corrupted.");
    }
}

class FrostboundArmor extends Armor {
    public FrostboundArmor() { super("Frostbound Armor", 22, 0, 70, 4, 0, 0, "Glacial Shell: 5% chance to nullify dmg", "+30% vs Frost"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(70);
        player.increaseAgi(4);
        player.increaseBonusFrost(0.30);
        System.out.println("Frostbound Armor activated! VIT+70, AGI+4, 5% chance to nullify damage, +30% vs Frost.");
    }
}

class SandstonePaladinArmor extends Armor {
    public SandstonePaladinArmor() { super("Sandstone Paladin Armor", 24, 4, 80, 0, 0, 0, "Desert Bulwark: +10% resist all", "+30% vs Desert"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(4);
        player.increaseVit(80);
        player.increaseFireResist(0.10);
        player.increaseFrostResist(0.10);
        player.increaseBonusDesert(0.30);
        System.out.println("Sandstone Paladin Armor activated! STR+4, VIT+80, +10% resist all, +30% vs Desert.");
    }
}

// LEGENDARY / ENDGAME ARMOR 
class ArmorOfTheFirstGuardian extends Armor {
    public ArmorOfTheFirstGuardian() { super("Armor of the First Guardian", 30, 3, 120, 3, 2, 2, "Primordial Shield: -15% dmg", "+50% vs Bosses"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(3);
        player.increaseVit(120);
        player.increaseAgi(3);
        player.increaseIntel(2);
        player.increaseCha(2);
        player.increaseBonusBoss(0.50);
        System.out.println("Armor of the First Guardian activated! STR+3, VIT+120, AGI+3, INT+2, CHA+2, -15% dmg, +50% vs Bosses.");
    }
}

class TwilightCarapace extends Armor {
    public TwilightCarapace() { super("Twilight Carapace", 28, 0, 90, 2, 4, 0, "Shadow Slip: 20% dodge at night", "+50% vs Shadow"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(2);
        player.increaseAgi(4);
        player.increaseDodge(0.20);
        player.increaseBonusShadow(0.50);
        System.out.println("Twilight Carapace activated! VIT+2, AGI+4, +20% dodge at night, +50% vs Shadow.");
    }
}

class EquinoxVestige extends Armor {
    public EquinoxVestige() { super("Equinox Vestige", 26, 2, 100, 2, 2, 2, "Balanced Aura: +10% dmg / +10% DEF", "+30% vs Bosses"); }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(2);
        player.increaseVit(100);
        player.increaseAgi(2);
        player.increaseIntel(2);
        player.increaseCha(2);
        player.increaseDamage(0.10);
        player.increaseDEF(0.10);
        player.increaseBonusBoss(0.30);
        System.out.println("Equinox Vestige activated! STR+2, VIT+100, AGI+2, INT+2, CHA+2, +10% dmg / +10% DEF, +30% vs Bosses.");
    }
}
