package com.oopfinalproject.items;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.StatusEffect;

public abstract class Accessory extends Item {
    public Accessory(String name,int str,int vit,int agi,int intel,int cha,String skill,String enemyBonus){
        super(name, str, vit, agi, intel, cha, skill, enemyBonus);
    }
}

// ACCESSORIES
// RINGS 
class RingOfMinorProtection extends Accessory {
    public RingOfMinorProtection() {
        super("Ring of Minor Protection", 0, 1, 0, 0, 0, "+5% DEF", "+10% vs Beasts");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(1);
        player.increaseDEF(0.05);
        player.increaseBonusBeasts(0.10);
        System.out.println("Ring of Minor Protection activated! VIT+1, +5% DEF, +10% vs Beasts.");
    }
}

class RingOfManaPulse extends Accessory {
    public RingOfManaPulse() {
        super("Ring of Mana Pulse", 0, 0, 0, 2, 0, "+5 MP regen", "+10% vs Shadow");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseIntel(2);
        player.increaseMpRegen(0.05);
        player.increaseBonusShadow(0.10);
        System.out.println("Ring of Mana Pulse activated! INT+2, +5% MP regen, +10% vs Shadow.");
    }
}

class FrozenTearRing extends Accessory {
    public FrozenTearRing() {
        super("Frozen Tear Ring", 0, 0, 0, 1, 0, "+10% frost dmg", "+20% vs Frost/White Wolves");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseIntel(1);
        player.increaseFrostDmg(0.10);
        player.increaseBonusFrost(0.20);
        System.out.println("Frozen Tear Ring activated! INT+1, +10% frost dmg, +20% vs Frost/White Wolves.");
    }
}

class EmberheartRing extends Accessory {
    public EmberheartRing() {
        super("Emberheart Ring", 2, 0, 0, 0, 0, "10% burn chance", "+20% vs Frost/White Wolves");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(2);
        player.increaseBonusFrost(0.20);
        System.out.println("Emberheart Ring activated! STR+2, 10% burn chance, +20% vs Frost/White Wolves.");
    }
}

class SandstormRing extends Accessory {
    public SandstormRing() {
        super("Sandstorm Ring", 0, 0, 2, 0, 0, "+10% dodge", "+20% vs Desert");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseAgi(2);
        player.increaseDodge(0.10);
        player.increaseBonusDesert(0.20);
        System.out.println("Sandstorm Ring activated! AGI+2, +10% dodge in desert, +20% vs Desert.");
    }
}

class CrystalMemoryRing extends Accessory {
    public CrystalMemoryRing() {
        super("Crystal Memory Ring", 0, 0, 0, 3, 0, "Boost shard resonance", "+15% vs Shadow/Bosses");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseIntel(3);
        player.increaseBonusShadow(0.15);
        player.increaseBonusBoss(0.15);
        System.out.println("Crystal Memory Ring activated! INT+3, boost shard resonance, +15% vs Shadow/Bosses.");
    }
}

// NECKLACES 
class PendantOfCourage extends Accessory {
    public PendantOfCourage() {
        super("Pendant of Courage", 0, 2, 0, 0, 1, "Resist Fear", "+10% vs Panic Burst enemies");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(2);
        player.increaseCha(1);
        player.increaseBonusPanic(0.10);
        System.out.println("Pendant of Courage activated! VIT+2, CHA+1, Resist Fear, +10% vs Panic Burst enemies.");
    }
}

class PendantOfAetherFlow extends Accessory {
    public PendantOfAetherFlow() {
        super("Pendant of Aether Flow", 0, 0, 0, 3, 0, "-10% mana cost", "+15% vs Shadow");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseIntel(3);
        player.reduceManaCost(0.10);
        player.increaseBonusShadow(0.15);
        System.out.println("Pendant of Aether Flow activated! INT+3, -10% mana cost, +15% vs Shadow.");
    }
}

class FrostDragonAmulet extends Accessory {
    public FrostDragonAmulet() {
        super("Frost Dragon Amulet", 1, 0, 0, 2, 0, "+20% frost dmg", "+25% vs Frost enemies");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(1);
        player.increaseIntel(2);
        player.increaseBonusFrost(0.25);
        System.out.println("Frost Dragon Amulet activated! STR+1, INT+2, +20% frost dmg, +25% vs Frost enemies.");
    }
}

class DesertWindTalisman extends Accessory {
    public DesertWindTalisman() {
        super("Desert Wind Talisman", 0, 0, 3, 0, 0, "+10% speed", "+20% vs Desert enemies");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseAgi(3);
        player.increaseBonusDesert(0.20);
        System.out.println("Desert Wind Talisman activated! AGI+3, +10% speed, +20% vs Desert enemies.");
    }
}

class ShadowsWhisper extends Accessory {
    public ShadowsWhisper() {
        super("Shadow's Whisper", 3, 0, 0, 0, 0, "+20% dmg", "+40% vs Shadow/Bosses");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(3);
        player.increaseDamage(0.20);
        player.increaseBonusShadow(0.40);
        player.increaseBonusBoss(0.40);
        // This accessory grants power at a cost: small HP drain per turn for 3 turns
        StatusEffect drain = new StatusEffect("Whisper Drain", 3);
        drain.setPerTurnHP(2); // 2 HP damage per turn
        player.applyStatus(drain);
        System.out.println("Shadow's Whisper activated! STR+3, +20% dmg, -2 HP/turn for 3 turns, +40% vs Shadow/Bosses.");
    }
}

// CHARMS / TALISMANS 
class OldMansTalisman extends Accessory {
    public OldMansTalisman() {
        super("Old Man's Talisman", 0, 1, 0, 0, 0, "2% auto dodge", "+10% vs Beasts");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseVit(1);
        player.increaseAutoDodge(0.02);
        player.increaseBonusBeasts(0.10);
        System.out.println("Old Man's Talisman activated! VIT+1, 2% auto dodge, +10% vs Beasts.");
    }
}

class LuckyWolfFang extends Accessory {
    public LuckyWolfFang() {
        super("Lucky Wolf Fang", 0, 0, 2, 0, 0, "+5% crit", "+15% vs Beasts");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseAgi(2);
        player.increaseCrit(0.05);
        player.increaseBonusBeasts(0.15);
        System.out.println("Lucky Wolf Fang activated! AGI+2, +5% crit, +15% vs Beasts.");
    }
}

class CorruptedCoreFragment extends Accessory {
    public CorruptedCoreFragment() {
        super("Corrupted Core Fragment", 3, 0, 0, 0, 0, "+10% dmg, +5% dmg taken", "+25% vs Shadow");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseStr(3);
        player.increaseBonusShadow(0.25);
        player.increaseDamage(0.10);
        player.increaseDamageTaken(0.05);
        System.out.println("Corrupted Core Fragment activated! STR+3, +10% dmg, +5% dmg taken, +25% vs Shadow.");
    }
}

class LyrasFeather extends Accessory {
    public LyrasFeather() {
        super("Lyra's Feather", 0, 0, 3, 0, 0, "+15% evasion", "+20% vs Beasts");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseAgi(3);
        player.increaseDodge(0.15);
        player.increaseBonusBeasts(0.20);
        System.out.println("Lyra's Feather activated! AGI+3, +15% evasion, +20% vs Beasts.");
    }
}

class BlessingOfSyntice extends Accessory {
    public BlessingOfSyntice() {
        super("Blessing of Syntice", 0, 0, 0, 2, 0, "+15% magic resist", "+30% vs Bosses");
    }
    @Override
    public void activate(Player player, com.oopfinalproject.core.Enemy enemy) {
        player.increaseIntel(2);
        player.increaseMagicResist(0.15);
        player.increaseBonusBoss(0.30);
        System.out.println("Blessing of Syntice activated! INT+2, +15% magic resist, +30% vs Bosses.");
    }
}
