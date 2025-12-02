package com.oopfinalproject.items;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.Enemy;
import com.oopfinalproject.core.StatusEffect;

public abstract class Weapon extends Item {
    protected int dmg;
    public Weapon(String name, int dmg, int str,int vit,int agi,int intel,int cha,String skill,String enemyBonus){
        super(name, str, vit, agi, intel, cha, skill, enemyBonus);
        this.dmg = dmg;
    }
    // Expose name/damage for external systems
    public int getDmg() { return dmg; }
}

// COMMON TIER WEAPONS
class TrainingSword extends Weapon {
    public TrainingSword() { super("Training Sword", 5, 1, 1, 0, 0, 0, "Beginner's Courage: First attack +5% accuracy", "None"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(1);
        player.increaseAgi(1);
        player.increaseAccuracy(0.05);
        System.out.println("Training Sword activated! STR+1, AGI+1, +5% accuracy on first attack.");
    }
}

class IronShortblade extends Weapon {
    public IronShortblade() { super("Iron Shortblade", 8, 2, 1, 0, 0, 0, "Quick Jab: 10% chance to strike twice on turn 1", "+10% vs Beasts"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(2);
        player.increaseAgi(1);
        player.increaseBonusBeasts(0.10);
        System.out.println("Iron Shortblade activated! STR+2, AGI+1, +10% damage vs Beasts.");
    }
}

class HuntersBow extends Weapon {
    public HuntersBow() { super("Hunter's Bow", 7, 1, 2, 0, 0, 0, "Eagle Shot: +10% crit vs agile enemies", "+15% vs Beasts"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(1);
        player.increaseAgi(2);
        player.increaseCrit(0.10);
        player.increaseBonusBeasts(0.15);
        System.out.println("Hunter's Bow activated! AGI+2, STR+1, +10% crit vs agile enemies, +15% vs Beasts.");
    }
}

class WornStaff extends Weapon {
    public WornStaff() { super("Worn Staff", 6, 0, 0, 2, 0, 1, "Spark of Focus: First spell costs 1 less MP", "+10% vs Shadow"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseIntel(2);
        player.increaseCha(1);
        player.increaseBonusShadow(0.10);
        System.out.println("Worn Staff activated! INT+2, CHA+1, first spell costs 1 less MP, +10% vs Shadow.");
    }
}

class RustySpear extends Weapon {
    public RustySpear() { super("Rusty Spear", 9, 2, 1, 0, 0, 0, "Long Reach: +5% chance to act first", "+10% vs Plants"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(2);
        player.increaseAgi(1);
        player.increaseAccuracy(0.05);
        player.increaseBonusPlants(0.10);
        System.out.println("Rusty Spear activated! STR+2, AGI+1, +5% chance to act first, +10% vs Plants.");
    }
}

// SILVERWOOD TIER WEAPONS
class SpiritwoodSword extends Weapon {
    public SpiritwoodSword() { super("Spiritwood Sword", 14, 3, 0, 0, 1, 0, "Purify Slash: Cleanses minor debuffs", "+25% vs Shadow/Corrupted Wolves/Umbral"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(3);
        player.increaseVit(1);
        player.increaseBonusShadow(0.25);
        System.out.println("Spiritwood Sword activated! STR+3, VIT+1, +25% damage vs Shadow/Corrupted Wolves/Umbral.");
    }
}

class FangDagger extends Weapon {
    public FangDagger() { super("Fang Dagger", 12, 1, 3, 0, 0, 0, "Bleeding Edge: 20% chance to inflict bleed", "+20% vs Beasts"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(1);
        player.increaseAgi(3);
        player.increaseBonusBeasts(0.20);
        System.out.println("Fang Dagger activated! AGI+3, STR+1, +20% vs Beasts.");
        // 20% chance to inflict Bleed on the target
        if (enemy != null && Math.random() < 0.20) {
            StatusEffect bleed = new StatusEffect("Bleed", 3);
            bleed.setPerTurnHP(3);
            enemy.applyStatus(bleed);
        }
    }
}

class VinecasterStaff extends Weapon {
    public VinecasterStaff() { super("Vinecaster Staff", 13, 0, 0, 3, 2, 0, "Nature's Renewal: Healing spells +20%", "+30% vs Plants"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseIntel(3);
        player.increaseVit(2);
        // Healing boost could be implemented separately
        System.out.println("Vinecaster Staff activated! INT+3, VIT+2, healing spells +20%, +30% vs Plants.");
    }
}

class GroveLongbow extends Weapon {
    public GroveLongbow() { super("Grove Longbow", 15, 0, 3, 0, 0, 0, "Forest Instinct: +20% crit in forest areas", "+20% vs Beasts/Plants"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseAgi(3);
        player.increaseCrit(0.20);
        player.increaseBonusBeasts(0.20);
        player.increaseBonusPlants(0.20);
        System.out.println("Grove Longbow activated! AGI+3, +20% crit in forest, +20% vs Beasts/Plants.");
    }
}

// FROSTSPIRE TIER WEAPONS
class FrozenOreSword extends Weapon {
    public FrozenOreSword() { super("Frozen Ore Sword", 20, 4, 0, 0, 2, 0, "Cold Edge: 20% chance to inflict chill", "+30% vs Desert"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(4);
        player.increaseVit(2);
        player.increaseBonusDesert(0.30);
        System.out.println("Frozen Ore Sword activated! STR+4, VIT+2, 20% chance to chill, +30% vs Desert.");
    }
}

// FROSTSPIRE TIER WEAPONS
class IcebrandGreatsword extends Weapon {
    public IcebrandGreatsword() { super("Icebrand Greatsword", 28, 6, 0, 0, 3, 0, "Glacial Impact: Heavy strike +50% dmg, -10% accuracy", "+20% vs Beasts"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(6);
        player.increaseVit(3);
        player.increaseBonusBeasts(0.20);
        player.increaseAccuracy(-0.10);
        System.out.println("Icebrand Greatsword activated! STR+6, VIT+3, heavy strike +50% dmg, -10% accuracy, +20% vs Beasts.");
    }
}

class BlizzardStaff extends Weapon {
    public BlizzardStaff() { super("Blizzard Staff", 22, 0, 1, 5, 0, 0, "Mana Drift: +10% MP regen/turn", "+30% vs Fire/Desert"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseAgi(1);
        player.increaseIntel(5);
        player.increaseBonusDesert(0.30);
        // MP regen can be implemented in combat system
        System.out.println("Blizzard Staff activated! INT+5, AGI+1, +10% MP regen, +30% vs Fire/Desert.");
    }
}

class FrostbiteBow extends Weapon {
    public FrostbiteBow() { super("Frostbite Bow", 21, 0, 4, 0, 0, 0, "Chilling Arrow: Inflicts Slow 2 turns", "+25% vs Desert, +10% vs Boss"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseAgi(4);
        player.increaseBonusDesert(0.25);
        player.increaseBonusBoss(0.10);
        System.out.println("Frostbite Bow activated! AGI+4, inflicts Slow 2 turns, +25% vs Desert, +10% vs Boss.");
        if (enemy != null) {
            StatusEffect slow = new StatusEffect("Slow", 2);
            slow.setDeltaAccuracy(-0.15); // reduces enemy accuracy by 15%
            slow.setDeltaSpd(-2); // small slow to speed as well
            enemy.applyStatus(slow);
        }
    }
}

// CRIMSON DESERT TIER WEAPONS
class ScorchedSaber extends Weapon {
    public ScorchedSaber() { super("Scorched Saber", 30, 4, 2, 0, 0, 0, "Ignite: 20% chance to Burn", "+30% vs Frost, +15% vs Golems"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(4);
        player.increaseAgi(2);
        player.increaseBonusFrost(0.30);
        player.increaseBonusGolems(0.15);
        System.out.println("Scorched Saber activated! STR+4, AGI+2, 20% chance to Burn, +30% vs Frost, +15% vs Golems.");
        if (enemy != null && Math.random() < 0.20) {
            StatusEffect burn = new StatusEffect("Burn", 3);
            burn.setPerTurnHP(4);
            enemy.applyStatus(burn);
        }
    }
}

class SandsteelKatana extends Weapon {
    public SandsteelKatana() { super("Sandsteel Katana", 34, 2, 5, 0, 0, 0, "Desert Mirage: +50% crit on first attack", "+20% vs Beasts"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(2);
        player.increaseAgi(5);
        player.increaseCrit(0.50);
        player.increaseBonusBeasts(0.20);
        System.out.println("Sandsteel Katana activated! AGI+5, STR+2, +50% crit first attack, +20% vs Beasts.");
    }
}

class SunfuryStaff extends Weapon {
    public SunfuryStaff() { super("Sunfury Staff", 32, 0, 0, 6, 0, 0, "Solar Burst: +25% fire damage during daytime", "+40% vs Shadow"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseIntel(6);
        player.increaseBonusShadow(0.40);
        System.out.println("Sunfury Staff activated! INT+6, +25% fire damage during daytime, +40% vs Shadow.");
    }
}

class DunePiercerSpear extends Weapon {
    public DunePiercerSpear() { super("Dune Piercer Spear", 33, 5, 0, 0, 0, 0, "Armor Breaker: Bypasses 20% DEF", "+35% vs Golems/Knight Armor/Sandstone Knight"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(5);
        System.out.println("Dune Piercer Spear activated! STR+5, bypasses 20% enemy DEF, +35% vs Golems/Knight Armor/Sandstone Knight.");
    }
}

// RARE / BOSS WEAPONS
class GolemheartBlade extends Weapon {
    public GolemheartBlade() { super("Golemheart Blade", 40, 6, 0, 0, 3, 0, "Earthsplitter: 15% chance to stun stone enemies", "+50% vs Golems/Earthshake"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(6);
        player.increaseVit(3);
        System.out.println("Golemheart Blade activated! STR+6, VIT+3, 15% chance to stun stone enemies, +50% vs Golems/Earthshake.");
        if (enemy != null && Math.random() < 0.15) {
            StatusEffect stun = new StatusEffect("Stunned", 1);
            stun.setStunned(true);
            enemy.applyStatus(stun);
        }
    }
}

class SynticesFangSpear extends Weapon {
    public SynticesFangSpear() { super("Syntice's Fang Spear", 42, 4, 3, 0, 0, 0, "Frostbite Lunge: Inflicts frostbite", "+40% vs Desert, +10% vs Beasts"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(4);
        player.increaseAgi(3);
        player.increaseBonusDesert(0.40);
        player.increaseBonusBeasts(0.10);
        System.out.println("Syntice's Fang Spear activated! STR+4, AGI+3, inflicts frostbite, +40% vs Desert, +10% vs Beasts.");
    }
}

class KnightsOathClaymore extends Weapon {
    public KnightsOathClaymore() { super("Knight's Oath Claymore", 47, 7, 0, 0, 4, 0, "Sacred Vow: Survive lethal damage once (1 HP)", "+25% vs Shadow, +20% vs Boss"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(7);
        player.increaseVit(4);
        player.increaseBonusShadow(0.25);
        player.increaseBonusBoss(0.20);
        System.out.println("Knight's Oath Claymore activated! STR+7, VIT+4, survive lethal damage once, +25% vs Shadow, +20% vs Boss.");
    }
}

class Aetherblade extends Weapon {
    private int crystalsAwakened;
    public Aetherblade(int crystals) {
        super("Aetherblade", 35 + 25 * crystals, crystals, crystals, crystals, crystals, crystals,
                "Shard Resonance: Skills evolve depending on story arc",
                "+10% vs ALL, +50% vs Final Boss");
        this.crystalsAwakened = crystals;
    }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(crystalsAwakened);
        player.increaseVit(crystalsAwakened);
        player.increaseAgi(crystalsAwakened);
        player.increaseIntel(crystalsAwakened);
        player.increaseCha(crystalsAwakened);
        System.out.println("Aetherblade activated! +1 to ALL stats per crystal awakened. Crystals: " + crystalsAwakened);
    }
}

// LEGENDARY WEAPONS
class Shadowrend extends Weapon {
    public Shadowrend() { super("Shadowrend", 65, 6, 5, 0, 0, 2, "Umbral Devour: Steals 10% of damage as HP", "+20% vs Boss, -10% vs Shadow"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(6);
        player.increaseAgi(5);
        player.increaseCha(2);
        player.increaseBonusBoss(0.20);
        player.increaseBonusShadow(-0.10);
        System.out.println("Shadowrend activated! STR+6, AGI+5, CHA+2, steals 10% damage as HP, +20% vs Boss, -10% vs Shadow.");
        // Give player a single-use 10% lifesteal status
        StatusEffect life = new StatusEffect("Lifesteal", 1);
        life.setLifestealPercent(0.10);
        player.applyStatus(life);
    }
}

class GuardiansRadiance extends Weapon {
    public GuardiansRadiance() { super("Guardian's Radiance", 58, 3, 0, 4, 6, 0, "Light's Blessing: +20% dmg to darkness, +10% DEF", "+60% vs Shadow/Final Boss P1 & P2"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(3);
        player.increaseVit(6);
        player.increaseIntel(4);
        player.increaseDEF(0.10);
        player.increaseBonusShadow(0.60);
        player.increaseBonusFinalBoss(0.60);
        System.out.println("Guardian's Radiance activated! STR+3, VIT+6, INT+4, +20% dmg to darkness, +10% DEF, +60% vs Shadow/Final Boss.");
    }
}

class EclipseEdge extends Weapon {
    public EclipseEdge() { super("Eclipse Edge", 62, 4, 4, 4, 4, 4, "Duality Slash: Deals Light + Shadow simultaneously, cannot be resisted", "+30% vs Boss, +10% vs everything else"); }
    @Override
    public void activate(Player player, Enemy enemy) {
        player.increaseStr(4);
        player.increaseVit(4);
        player.increaseAgi(4);
        player.increaseIntel(4);
        player.increaseCha(4);
        player.increaseBonusBoss(0.30);
        player.increaseBonusBeasts(0.10);
        player.increaseBonusShadow(0.10);
        player.increaseBonusFrost(0.10);
        player.increaseBonusDesert(0.10);
        player.increaseBonusPlants(0.10);
        player.increaseBonusGolems(0.10);
        player.increaseBonusPanic(0.10);
        player.increaseBonusFinalBoss(0.30);
        System.out.println("Eclipse Edge activated! +4 to ALL stats, deals Light+Shadow, +30% vs Boss, +10% vs everything else.");
    }
}
