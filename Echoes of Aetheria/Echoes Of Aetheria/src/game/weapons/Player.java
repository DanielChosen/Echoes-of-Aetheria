// PLAYER class to hold player stats and methods
public class Player {
    // Base Stats
    private int str = 5, vit = 5, agi = 5, intel = 5, cha = 5;
    private int maxHP = 100, currentHP = 100;
    private int maxMP = 50, currentMP = 50;

    // Combat Stats
    private double damage = 0, damageTaken = 0, dodge = 0, block = 0, crit = 0, accuracy = 0;
    private double frostResist = 0, fireResist = 0, corruptionResist = 0;
    private double magicResist = 0, autoDodge = 0, mpRegen = 0, manaCostReduction = 0, def = 0;

    // Enemy-specific Bonuses
    private double bonusBeasts = 0, bonusShadow = 0, bonusFrost = 0, bonusDesert = 0, bonusBoss = 0;
    private double bonusPlants = 0, bonusGolems = 0, bonusPanic = 0, bonusFinalBoss = 0;

    // GETTERS: BASE STATS
    public int getStr() { return str; }
    public int getVit() { return vit; }
    public int getAgi() { return agi; }
    public int getIntel() { return intel; }
    public int getCha() { return cha; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentMP() { return currentMP; }
    public int getMaxMP() { return maxMP; }

    //GETTERS: COMBAT STATS
    public double getDamage() { return damage; }
    public double increaseDamageTaken() { return damageTaken; }
    public double getDodge() { return dodge; }
    public double getBlock() { return block; }
    public double getCrit() { return crit; }
    public double getAccuracy() { return accuracy; }
    public double getFrostResist() { return frostResist; }
    public double getFireResist() { return fireResist; }
    public double getCorruptionResist() { return corruptionResist; }
    public double getMagicResist() { return magicResist; }
    public double getAutoDodge() { return autoDodge; }
    public double getMpRegen() { return mpRegen; }
    public double getManaCostReduction() { return manaCostReduction; }
    public double getDEF() { return def; }

    // GETTERS: ENEMY-SPECIFIC BONUSES
    public double getBonusBeasts() { return bonusBeasts; }
    public double getBonusShadow() { return bonusShadow; }
    public double getBonusFrost() { return bonusFrost; }
    public double getBonusDesert() { return bonusDesert; }
    public double getBonusBoss() { return bonusBoss; }
    public double getBonusPlants() { return bonusPlants; }
    public double getBonusGolems() { return bonusGolems; }
    public double getBonusPanic() { return bonusPanic; }
    public double getBonusFinalBoss() { return bonusFinalBoss; }

    // BASE STAT MODIFIERS
    public void increaseStr(int n) { str += n; }
    public void increaseVit(int n) { vit += n; maxHP += n * 10; currentHP += n * 10; }
    public void increaseAgi(int n) { agi += n; }
    public void increaseIntel(int n) { intel += n; }
    public void increaseCha(int n) { cha += n; }
    public void increaseHP(int n) { currentHP = Math.min(currentHP + n, maxHP); }
    public void increaseMP(int n) { currentMP = Math.min(currentMP + n, maxMP); }

    // COMBAT STAT MODIFIERS
    public void increaseDamage(double n) { damage += n; }
    public void increaseDamageTaken(double n) { damageTaken += n; }
    public void increaseDodge(double n) { dodge += n; }
    public void increaseBlockChance(double n) { block += n; }
    public void increaseCrit(double n) { crit += n; }
    public void increaseAccuracy(double n) { accuracy += n; }
    public void increaseFrostResist(double n) { frostResist += n; }
    public void increaseFireResist(double n) { fireResist += n; }
    public void increaseCorruptionResist(double n) { corruptionResist += n; }
    public void increaseMagicResist(double n) { magicResist += n; }
    public void increaseAutoDodge(double n) { autoDodge += n; }
    public void increaseMpRegen(double n) { mpRegen += n; }
    public void reduceManaCost(double n) { manaCostReduction += n; }
    public void increaseDEF(double n) { def += n; }

    // ENEMY-SPECIFIC BONUS MODIFIERS
    public void increaseBonusBeasts(double n) { bonusBeasts += n; }
    public void increaseBonusShadow(double n) { bonusShadow += n; }
    public void increaseBonusFrost(double n) { bonusFrost += n; }
    public void increaseBonusDesert(double n) { bonusDesert += n; }
    public void increaseBonusBoss(double n) { bonusBoss += n; }
    public void increaseBonusPlants(double n) { bonusPlants += n; }
    public void increaseBonusGolems(double n) { bonusGolems += n; }
    public void increaseBonusPanic(double n) { bonusPanic += n; }
    public void increaseBonusFinalBoss(double n) { bonusFinalBoss += n; }

    // COMBAT ACTIONS
    public void takeDamage(int dmg) {
        currentHP -= dmg;
        if(currentHP < 0) currentHP = 0;
        System.out.println("Player takes " + dmg + " damage! HP: " + currentHP + "/" + maxHP);
    }

    public void healHP(int amount) {
        currentHP = Math.min(currentHP + amount, maxHP);
        System.out.println("Player heals " + amount + " HP! HP: " + currentHP + "/" + maxHP);
    }

    public void restoreMP(int amount) {
        currentMP = Math.min(currentMP + amount, maxMP);
        System.out.println("Player restores " + amount + " MP! MP: " + currentMP + "/" + maxMP);
    }

    // DISPLAY STATS
    public void displayStats() {
        System.out.println("=== Player Stats ===");
        System.out.println("STR:" + str + " VIT:" + vit + " AGI:" + agi + " INT:" + intel + " CHA:" + cha);
        System.out.println("HP:" + currentHP + "/" + maxHP + " MP:" + currentMP + "/" + maxMP);
        System.out.printf("Damage: %.1f%% Damage Taken: %.1f%% Dodge: %.1f%% Block: %.1f%% Crit: %.1f%% Accuracy: %.1f%%\n",
                damage * 100, damageTaken * 100, dodge * 100, block * 100, crit * 100, accuracy * 100);
        System.out.printf("Resists -> Frost: %.1f%% Fire: %.1f%% Corruption: %.1f%% Magic: %.1f%%\n",
                frostResist * 100, fireResist * 100, corruptionResist * 100, magicResist * 100);
        System.out.printf("Special -> AutoDodge: %.1f%% MP Regen: %.1f%% ManaCostReduction: %.1f%% DEF: %.1f%%\n",
                autoDodge * 100, mpRegen * 100, manaCostReduction * 100, def * 100);
        System.out.printf("Enemy Bonuses -> Beasts: %.1f%% Shadow: %.1f%% Frost: %.1f%% Desert: %.1f%% Boss: %.1f%% Plants: %.1f%% Golems: %.1f%% Panic: %.1f%%\n Final Boss: %.1f%%\n",
                bonusBeasts * 100, bonusShadow * 100, bonusFrost * 100, bonusDesert * 100, bonusBoss * 100,
                bonusPlants * 100, bonusGolems * 100, bonusPanic * 100, bonusFinalBoss * 100);
    }
}


// ABSTRACT CLASSES 
abstract class Weapon {
    protected String name; protected int dmg, str, agi, intel, vit, cha;
    protected String skillDescription, enemyBonus;
    public Weapon(String name, int dmg, int str,int agi,int intel,int vit,int cha,String skill,String enemyBonus){
        this.name=name; this.dmg=dmg; this.str=str; this.agi=agi; this.intel=intel; this.vit=vit; this.cha=cha; this.skillDescription=skill; this.enemyBonus=enemyBonus;
    }
    public abstract void activate(Player player);
}

abstract class Armor {
    protected String name; protected int def, str, vit, agi, intel, cha;
    protected String skillDescription, enemyBonus;
    public Armor(String name,int def,int str,int vit,int agi,int intel,int cha,String skill,String enemyBonus){
        this.name=name; this.def=def; this.str=str; this.vit=vit; this.agi=agi; this.intel=intel; this.cha=cha; this.skillDescription=skill; this.enemyBonus=enemyBonus;
    }
    public abstract void activate(Player player);
}

abstract class Shield {
    protected String name; protected int def, str, vit, agi, intel, cha;
    protected String skillDescription, enemyBonus;
    public Shield(String name,int def,int str,int vit,int agi,int intel,int cha,String skill,String enemyBonus){
        this.name=name; this.def=def; this.str=str; this.vit=vit; this.agi=agi; this.intel=intel; this.cha=cha; this.skillDescription=skill; this.enemyBonus=enemyBonus;
    }
    public abstract void activate(Player player);
}

abstract class Accessory {
    protected String name; protected int str, vit, agi, intel, cha;
    protected String skillDescription, enemyBonus;
    public Accessory(String name,int str,int vit,int agi,int intel,int cha,String skill,String enemyBonus){
        this.name=name; this.str=str; this.vit=vit; this.agi=agi; this.intel=intel; this.cha=cha; this.skillDescription=skill; this.enemyBonus=enemyBonus;
    }
    public abstract void activate(Player player);
}

abstract class Consumable {
    protected String name; protected int hp, mp, str, vit, agi, intel, cha;
    protected String effect, enemyBonus;
    public Consumable(String name,int hp,int mp,int str,int vit,int agi,int intel,int cha,String effect,String enemyBonus){
        this.name=name; this.hp=hp; this.mp=mp; this.str=str; this.vit=vit; this.agi=agi; this.intel=intel; this.cha=cha; this.effect=effect; this.enemyBonus=enemyBonus;
    }
    public abstract void activate(Player player);
}

// WEAPONS
// COMMON TIER WEAPONS
class TrainingSword extends Weapon {
    public TrainingSword() { super("Training Sword", 5, 1, 1, 0, 0, 0, "Beginner's Courage: First attack +5% accuracy", "None"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(1);
        player.increaseAgi(1);
        player.increaseAccuracy(0.05);
        System.out.println("Training Sword activated! STR+1, AGI+1, +5% accuracy on first attack.");
    }
}

class IronShortblade extends Weapon {
    public IronShortblade() { super("Iron Shortblade", 8, 2, 1, 0, 0, 0, "Quick Jab: 10% chance to strike twice on turn 1", "+10% vs Beasts"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(2);
        player.increaseAgi(1);
        player.increaseBonusBeasts(0.10);
        System.out.println("Iron Shortblade activated! STR+2, AGI+1, +10% damage vs Beasts.");
    }
}

class HuntersBow extends Weapon {
    public HuntersBow() { super("Hunter's Bow", 7, 1, 2, 0, 0, 0, "Eagle Shot: +10% crit vs agile enemies", "+15% vs Beasts"); }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseIntel(2);
        player.increaseCha(1);
        player.increaseBonusShadow(0.10);
        System.out.println("Worn Staff activated! INT+2, CHA+1, first spell costs 1 less MP, +10% vs Shadow.");
    }
}

class RustySpear extends Weapon {
    public RustySpear() { super("Rusty Spear", 9, 2, 1, 0, 0, 0, "Long Reach: +5% chance to act first", "+10% vs Plants"); }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseStr(3);
        player.increaseVit(1);
        player.increaseBonusShadow(0.25);
        System.out.println("Spiritwood Sword activated! STR+3, VIT+1, +25% damage vs Shadow/Corrupted Wolves/Umbral.");
    }
}

class FangDagger extends Weapon {
    public FangDagger() { super("Fang Dagger", 12, 1, 3, 0, 0, 0, "Bleeding Edge: 20% chance to inflict bleed", "+20% vs Beasts"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(1);
        player.increaseAgi(3);
        player.increaseBonusBeasts(0.20);
        System.out.println("Fang Dagger activated! AGI+3, STR+1, +20% vs Beasts.");
    }
}

class VinecasterStaff extends Weapon {
    public VinecasterStaff() { super("Vinecaster Staff", 13, 0, 0, 3, 2, 0, "Nature's Renewal: Healing spells +20%", "+30% vs Plants"); }
    @Override
    public void activate(Player player) {
        player.increaseIntel(3);
        player.increaseVit(2);
        // Healing boost could be implemented separately
        System.out.println("Vinecaster Staff activated! INT+3, VIT+2, healing spells +20%, +30% vs Plants.");
    }
}

class GroveLongbow extends Weapon {
    public GroveLongbow() { super("Grove Longbow", 15, 0, 3, 0, 0, 0, "Forest Instinct: +20% crit in forest areas", "+20% vs Beasts/Plants"); }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseAgi(4);
        player.increaseBonusDesert(0.25);
        player.increaseBonusBoss(0.10);
        System.out.println("Frostbite Bow activated! AGI+4, inflicts Slow 2 turns, +25% vs Desert, +10% vs Boss.");
    }
}

// CRIMSON DESERT TIER WEAPONS
class ScorchedSaber extends Weapon {
    public ScorchedSaber() { super("Scorched Saber", 30, 4, 2, 0, 0, 0, "Ignite: 20% chance to Burn", "+30% vs Frost, +15% vs Golems"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(4);
        player.increaseAgi(2);
        player.increaseBonusFrost(0.30);
        player.increaseBonusGolems(0.15);
        System.out.println("Scorched Saber activated! STR+4, AGI+2, 20% chance to Burn, +30% vs Frost, +15% vs Golems.");
    }
}

class SandsteelKatana extends Weapon {
    public SandsteelKatana() { super("Sandsteel Katana", 34, 2, 5, 0, 0, 0, "Desert Mirage: +50% crit on first attack", "+20% vs Beasts"); }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseIntel(6);
        player.increaseBonusShadow(0.40);
        System.out.println("Sunfury Staff activated! INT+6, +25% fire damage during daytime, +40% vs Shadow.");
    }
}

class DunePiercerSpear extends Weapon {
    public DunePiercerSpear() { super("Dune Piercer Spear", 33, 5, 0, 0, 0, 0, "Armor Breaker: Bypasses 20% DEF", "+35% vs Golems/Knight Armor/Sandstone Knight"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(5);
        System.out.println("Dune Piercer Spear activated! STR+5, bypasses 20% enemy DEF, +35% vs Golems/Knight Armor/Sandstone Knight.");
    }
}

// RARE / BOSS WEAPONS
class GolemheartBlade extends Weapon {
    public GolemheartBlade() { super("Golemheart Blade", 40, 6, 0, 0, 3, 0, "Earthsplitter: 15% chance to stun stone enemies", "+50% vs Golems/Earthshake"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(6);
        player.increaseVit(3);
        System.out.println("Golemheart Blade activated! STR+6, VIT+3, 15% chance to stun stone enemies, +50% vs Golems/Earthshake.");
    }
}

class SynticesFangSpear extends Weapon {
    public SynticesFangSpear() { super("Syntice's Fang Spear", 42, 4, 3, 0, 0, 0, "Frostbite Lunge: Inflicts frostbite", "+40% vs Desert, +10% vs Beasts"); }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseStr(6);
        player.increaseAgi(5);
        player.increaseCha(2);
        player.increaseBonusBoss(0.20);
        player.increaseBonusShadow(-0.10);
        System.out.println("Shadowrend activated! STR+6, AGI+5, CHA+2, steals 10% damage as HP, +20% vs Boss, -10% vs Shadow.");
    }
}

class GuardiansRadiance extends Weapon {
    public GuardiansRadiance() { super("Guardian's Radiance", 58, 3, 0, 4, 6, 0, "Light's Blessing: +20% dmg to darkness, +10% DEF", "+60% vs Shadow/Final Boss P1 & P2"); }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
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

// ARMOR
// CLOTH / LIGHT ARMOR 
class WanderersTunic extends Armor {
    public WanderersTunic() { super("Wanderer's Tunic", 4, 0, 10, 1, 0, 0, "Quick Step: +3% dodge", "+10% vs Beasts"); }
    @Override
    public void activate(Player player) {
        player.increaseVit(1);
        player.increaseAgi(1);
        player.increaseDodge(0.03);
        player.increaseBonusBeasts(0.10);
        System.out.println("Wanderer's Tunic activated! VIT+1, AGI+1, +3% dodge, +10% vs Beasts.");
    }
}

class ForestcloakMantle extends Armor {
    public ForestcloakMantle() { super("Forestcloak Mantle", 6, 0, 15, 1, 2, 0, "Forest Veil: +10% evasion in forests", "+15% vs Plants"); }
    @Override
    public void activate(Player player) {
        player.increaseVit(1);
        player.increaseAgi(2);
        player.increaseDodge(0.10); 
        player.increaseBonusPlants(0.15);
        System.out.println("Forestcloak Mantle activated! VIT+1, AGI+2, +10% evasion in forests, +15% vs Plants.");
    }
}

class FrostweaveRobe extends Armor {
    public FrostweaveRobe() { super("Frostweave Robe", 5, 0, 20, 0, 1, 2, "Cold Resist: -10% frost dmg", "+20% vs Frost/White Wolves"); }
    @Override
    public void activate(Player player) {
        player.increaseVit(1);
        player.increaseIntel(2);
        player.increaseFrostResist(0.10);
        player.increaseBonusFrost(0.20);
        System.out.println("Frostweave Robe activated! VIT+1, INT+2, -10% frost dmg, +20% vs Frost/White Wolves.");
    }
}

class DesertNomadWraps extends Armor {
    public DesertNomadWraps() { super("Desert Nomad Wraps", 5, 0, 15, 2, 0, 0, "Heat Ward: -10% fire dmg", "+20% vs Desert enemies"); }
    @Override
    public void activate(Player player) {
        player.increaseVit(2);
        player.increaseFireResist(0.10);
        player.increaseBonusDesert(0.20);
        System.out.println("Desert Nomad Wraps activated! VIT+2, -10% fire dmg, +20% vs Desert.");
    }
}

class EtherealRobe extends Armor {
    public EtherealRobe() { super("Ethereal Robe", 8, 0, 25, 1, 3, 0, "Mana Shroud: +5 MP per battle", "+10% vs Shadow"); }
    @Override
    public void activate(Player player) {
        player.increaseVit(1);
        player.increaseIntel(3);
        player.increaseMP(5);
        player.increaseBonusShadow(0.10);
        System.out.println("Ethereal Robe activated! VIT+1, INT+3, +5 MP, +10% vs Shadow.");
    }
}

// MEDIUM ARMOR 
class IronAdventurersVest extends Armor {
    public IronAdventurersVest() { super("Iron Adventurer's Vest", 10, 1, 25, 2, 0, 0, "Steadfast: +5% DEF", "+10% vs Beasts"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(1);
        player.increaseVit(2);
        player.increaseBonusBeasts(0.10);
        System.out.println("Iron Adventurer's Vest activated! STR+1, VIT+2, +5% DEF, +10% vs Beasts.");
    }
}

class SpiritwoodJerkin extends Armor {
    public SpiritwoodJerkin() { super("Spiritwood Jerkin", 12, 2, 30, 1, 0, 0, "Grove's Harmony: +10% healing received", "+15% vs Plants"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(2);
        player.increaseVit(1);
        player.increaseBonusPlants(0.15);
        System.out.println("Spiritwood Jerkin activated! STR+2, VIT+1, +10% healing received, +15% vs Plants.");
    }
}

class FrostfurArmor extends Armor {
    public FrostfurArmor() { super("Frostfur Armor", 13, 0, 35, 3, 0, 0, "Chilled Hide: -20% ice dmg", "+25% vs Frost enemies"); }
    @Override
    public void activate(Player player) {
        player.increaseVit(3);
        player.increaseFrostResist(0.20);
        player.increaseBonusFrost(0.25);
        System.out.println("Frostfur Armor activated! VIT+3, -20% ice dmg, +25% vs Frost.");
    }
}

class SandsteelBreastplate extends Armor {
    public SandsteelBreastplate() { super("Sandsteel Breastplate", 14, 2, 40, 0, 1, 0, "Sun Guard: -20% burn chance", "+20% vs Desert enemies"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(2);
        player.increaseVit(1);
        player.increaseFireResist(0.20);
        player.increaseBonusDesert(0.20);
        System.out.println("Sandsteel Breastplate activated! STR+2, VIT+1, -20% burn chance, +20% vs Desert.");
    }
}

// HEAVY ARMOR 
class BronzePlate extends Armor {
    public BronzePlate() { super("Bronze Plate", 16, 3, 50, 0, 0, 0, "Harden: -10% phys dmg", "+15% vs Beasts"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(3);
        player.increaseVit(0); 
        player.increaseBonusBeasts(0.15);
        System.out.println("Bronze Plate activated! STR+3, -10% phys dmg, +15% vs Beasts.");
    }
}

class SilverwoodGuardianMail extends Armor {
    public SilverwoodGuardianMail() { super("Silverwood Guardian Mail", 20, 3, 60, 2, 0, 0, "Purity Aura: -15% corruption dmg", "+25% vs Shadow/Corrupted"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(3);
        player.increaseVit(2);
        player.increaseCorruptionResist(0.15);
        player.increaseBonusShadow(0.25);
        System.out.println("Silverwood Guardian Mail activated! STR+3, VIT+2, -15% corruption dmg, +25% vs Shadow/Corrupted.");
    }
}

class FrostboundArmor extends Armor {
    public FrostboundArmor() { super("Frostbound Armor", 22, 0, 70, 4, 0, 0, "Glacial Shell: 5% chance to nullify dmg", "+30% vs Frost"); }
    @Override
    public void activate(Player player) {
        player.increaseVit(4);
        player.increaseBonusFrost(0.30);
        System.out.println("Frostbound Armor activated! VIT+4, 5% chance to nullify damage, +30% vs Frost.");
    }
}

class SandstonePaladinArmor extends Armor {
    public SandstonePaladinArmor() { super("Sandstone Paladin Armor", 24, 4, 80, 0, 0, 0, "Desert Bulwark: +10% resist all", "+30% vs Desert"); }
    @Override
    public void activate(Player player) {
        player.increaseVit(4);
        player.increaseFireResist(0.10);
        player.increaseFrostResist(0.10);
        player.increaseBonusDesert(0.30);
        System.out.println("Sandstone Paladin Armor activated! VIT+4, +10% resist all, +30% vs Desert.");
    }
}

// LEGENDARY / ENDGAME ARMOR 
class ArmorOfTheFirstGuardian extends Armor {
    public ArmorOfTheFirstGuardian() { super("Armor of the First Guardian", 30, 3, 120, 3, 2, 2, "Primordial Shield: -15% dmg", "+50% vs Bosses"); }
    @Override
    public void activate(Player player) {
        player.increaseStr(3);
        player.increaseVit(3);
        player.increaseAgi(2);
        player.increaseIntel(2);
        player.increaseBonusBoss(0.50);
        System.out.println("Armor of the First Guardian activated! STR+3, VIT+3, AGI+2, INT+2, -15% dmg, +50% vs Bosses.");
    }
}

class TwilightCarapace extends Armor {
    public TwilightCarapace() { super("Twilight Carapace", 28, 0, 90, 2, 4, 0, "Shadow Slip: 20% dodge at night", "+50% vs Shadow"); }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseStr(2);
        player.increaseVit(2);
        player.increaseAgi(2);
        player.increaseIntel(2);
        player.increaseDamage(0.10);
        player.increaseDEF(0.10);
        player.increaseBonusBoss(0.30);
        System.out.println("Equinox Vestige activated! STR+2, VIT+2, AGI+2, INT+2, +10% dmg / +10% DEF, +30% vs Bosses.");
    }
}

// SHIELDS 
class WoodenBuckler extends Shield {
    public WoodenBuckler() {
        super("Wooden Buckler", 6, 0, 0, 1, 0, 0, "+3% block", "+10% vs Beasts");
    }
    @Override
    public void activate(Player player) {
        player.increaseBlockChance(0.03);
        System.out.println("Wooden Buckler activated! +3% block.");
    }
}

class IronRoundShield extends Shield {
    public IronRoundShield() {
        super("Iron Round Shield", 10, 0, 2, 0, 0, 0, "+5% block", "+15% vs Beasts");
    }
    @Override
    public void activate(Player player) {
        player.increaseBlockChance(0.05);
        System.out.println("Iron Round Shield activated! +5% block.");
    }
}

class SpiritwoodShield extends Shield {
    public SpiritwoodShield() {
        super("Spiritwood Shield", 12, 1, 2, 0, 0, 0, "+10% corruption resist", "+25% vs Shadow");
    }
    @Override
    public void activate(Player player) {
        player.increaseCorruptionResist(0.10);
        System.out.println("Spiritwood Shield activated! +10% corruption resist.");
    }
}

class FrostboundBarrier extends Shield {
    public FrostboundBarrier() {
        super("Frostbound Barrier", 15, 0, 3, 0, 0, 0, "+20% frost resist", "+30% vs Frost");
    }
    @Override
    public void activate(Player player) {
        player.increaseFrostResist(0.20);
        System.out.println("Frostbound Barrier activated! +20% frost resist.");
    }
}

class SandsteelTowerShield extends Shield {
    public SandsteelTowerShield() {
        super("Sandsteel Tower Shield", 18, 2, 0, 0, 0, 0, "+15% block", "+25% vs Desert");
    }
    @Override
    public void activate(Player player) {
        player.increaseBlockChance(0.15);
        System.out.println("Sandsteel Tower Shield activated! +15% block.");
    }
}

class GuardiansAegis extends Shield {
    public GuardiansAegis() {
        super("Guardian’s Aegis", 24, 2, 2, 1, 1, 0, "+25% block", "+50% vs Bosses");
    }
    @Override
    public void activate(Player player) {
        player.increaseBlockChance(0.25);
        System.out.println("Guardian’s Aegis activated! +25% block.");
    }
}


// ACCESSORIES
// RINGS 
class RingOfMinorProtection extends Accessory {
    public RingOfMinorProtection() {
        super("Ring of Minor Protection", 0, 1, 0, 0, 0, "+5% DEF", "+10% vs Beasts");
    }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseIntel(1);
        player.increaseBonusFrost(0.20);
        System.out.println("Frozen Tear Ring activated! INT+1, +10% frost dmg, +20% vs Frost/White Wolves.");
    }
}

class EmberheartRing extends Accessory {
    public EmberheartRing() {
        super("Emberheart Ring", 2, 0, 0, 0, 0, "10% burn chance", "+20% vs Frost/White Wolves");
    }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseStr(3);
        player.increaseDamage(0.20);
        player.increaseBonusShadow(0.40);
        player.increaseBonusBoss(0.40);
        System.out.println("Shadow's Whisper activated! STR+3, +20% dmg, -2% HP/turn, +40% vs Shadow/Bosses.");
    }
}

// CHARMS / TALISMANS 
class OldMansTalisman extends Accessory {
    public OldMansTalisman() {
        super("Old Man's Talisman", 0, 1, 0, 0, 0, "2% auto dodge", "+10% vs Beasts");
    }
    @Override
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
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
    public void activate(Player player) {
        player.increaseIntel(2);
        player.increaseMagicResist(0.15);
        player.increaseBonusBoss(0.30);
        System.out.println("Blessing of Syntice activated! INT+2, +15% magic resist, +30% vs Bosses.");
    }
}

// CONSUMABLES
// HEALING POTIONS 
class SmallHealingPotion extends Consumable {
    public SmallHealingPotion() {
        super("Small Healing Potion", 30, 0, 0, 0, 0, 0, 0, "None", "None");
    }
    @Override
    public void activate(Player player) {
        player.healHP(30);
        System.out.println("Small Healing Potion used! +30 HP.");
    }
}

class GreaterHealingPotion extends Consumable {
    public GreaterHealingPotion() {
        super("Greater Healing Potion", 80, 0, 0, 0, 0, 0, 0, "None", "None");
    }
    @Override
    public void activate(Player player) {
        player.healHP(80);
        System.out.println("Greater Healing Potion used! +80 HP.");
    }
}

class ManaPotion extends Consumable {
    public ManaPotion() {
        super("Mana Potion", 0, 40, 0, 0, 0, 0, 0, "None", "None");
    }
    @Override
    public void activate(Player player) {
        player.restoreMP(40);
        System.out.println("Mana Potion used! +40 MP.");
    }
}

class StaminaBrew extends Consumable {
    public StaminaBrew() {
        super("Stamina Brew", 20, 20, 0, 1, 0, 0, 0, "None", "None");
    }
    @Override
    public void activate(Player player) {
        player.increaseAgi(1);
        player.healHP(20);
        player.restoreMP(20);
        System.out.println("Stamina Brew used! +20 HP and MP, AGI+1.");
    }
}

// STATUS CURES 
class FrostbiteCure extends Consumable {
    public FrostbiteCure() {
        super("Frostbite Cure", 0, 0, 1, 0, 0, 0, 0, "VIT+1", "+20% vs Frost enemies temporarily");
    }
    @Override
    public void activate(Player player) {
        player.removeStatus("Frostbite"); //NEEDS FIXING
        player.increaseVit(1);
        player.increaseBonusFrost(0.20);
        System.out.println("Frostbite Cure used! Status removed, VIT+1, +20% vs Frost enemies temporarily.");
    }
}

class HeatResistanceElixir extends Consumable {
    public HeatResistanceElixir() {
        super("Heat Resistance Elixir", 0, 0, 1, 0, 0, 0, 0, "VIT+1", "+20% vs Desert enemies temporarily");
    }
    @Override
    public void activate(Player player) {
        player.applyTemporaryEffect("FireResist", 0.50, 5); // NEEDS FIXING
        player.increaseVit(1);
        player.increaseBonusDesert(0.20);
        System.out.println("Heat Resistance Elixir used! -50% fire dmg for 5 turns, VIT+1, +20% vs Desert temporarily.");
    }
}

// SCROLLS 
class ScrollOfFreeze extends Consumable {
    public ScrollOfFreeze() {
        super("Scroll of Freeze", 0, 0, 0, 0, 0, 0, 0, "None", "+25% dmg vs Frost/Beasts");
    }
    @Override
    public void activate(Player player) {
        player.applyFreeze(1); // NEEDS FIXING
        player.increaseBonusFrost(0.25);
        player.increaseBonusBeasts(0.25);
        System.out.println("Scroll of Freeze used! Freeze 1 turn, +25% dmg vs Frost/Beasts.");
    }
}

class ScrollOfFireburst extends Consumable {
    public ScrollOfFireburst() {
        super("Scroll of Fireburst", 0, 0, 0, 0, 1, 0, 0, "INT+1", "+25% dmg vs Shadow");
    }
    @Override
    public void activate(Player player) {
        player.increaseIntel(1);
        player.increaseBonusShadow(0.25);
        System.out.println("Scroll of Fireburst used! INT+1, Fire AoE, +25% dmg vs Shadow.");
    }
}

class ScrollOfBarrier extends Consumable {
    public ScrollOfBarrier() {
        super("Scroll of Barrier", 0, 0, 0, 0, 0, 0, 0, "None", "+15% vs Boss attacks");
    }
    @Override
    public void activate(Player player) {
        player.applyTemporaryEffect(0.25, 2); // NEEDS FIXING
        player.increaseBonusBoss(0.15);
        System.out.println("Scroll of Barrier used! +25% DEF for 2 turns, +15% vs Boss attacks.");
    }
}

// FOODS / ETC. 
class FrozenApple extends Consumable {
    public FrozenApple() {
        super("Frozen Apple", 10, 0, 1, 0, 0, 0, 0, "VIT+1", "None");
    }
    @Override
    public void activate(Player player) {
        player.healHP(10);
        player.increaseVit(1);
        System.out.println("Frozen Apple used! +10 HP, VIT+1.");
    }
}

class WolfPelts extends Consumable {
    public WolfPelts() {
        super("Wolf Pelts", 0, 0, 0, 0, 0, 0, 0, "None", "+10% dmg vs Beasts temporarily if used in crafting");
    }
    @Override
    public void activate(Player player) {
        player.increaseBonusBeasts(0.05);
        System.out.println("Wolf Pelts used! +5% dmg vs Beasts.");
    }
}

class CrystalFragments extends Consumable {
    public CrystalFragments() {
        super("Crystal Fragments", 0, 0, 1, 1, 1, 1, 1, "+1 all stats upon upgrade", "+50% dmg vs Bosses if Aetherblade equipped");
    }
    @Override
    public void activate(Player player) {
        player.increaseStr(1);
        player.increaseVit(1);
        player.increaseAgi(1);
        player.increaseIntel(1);
        player.increaseCha(1);
        player.increaseBonusBoss(0.50);
        System.out.println("Crystal Fragments used! +1 all stats, +50% dmg vs Bosses if Aetherblade equipped.");
    }
}

// EQUIPMENT MANAGER NEEDS FIXING

public class EquipmentManager {

    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private Shield equippedShield;
    private Accessory equippedAccessory;
    private Consumable heldConsumable;

    // EQUIP METHODS 
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        System.out.println("Equipped weapon: " + weapon.getName());
        weapon.activate(Player.getInstance());
    }

    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
        System.out.println("Equipped armor: " + armor.getName());
        armor.activate(Player.getInstance());
    }

    public void equipShield(Shield shield) {
        this.equippedShield = shield;
        System.out.println("Equipped shield: " + shield.getName());
        shield.activate(Player.getInstance());
    }

    public void equipAccessory(Accessory accessory) {
        this.equippedAccessory = accessory;
        System.out.println("Equipped accessory: " + accessory.getName());
        accessory.activate(Player.getInstance());
    }

    public void holdConsumable(Consumable consumable) {
        this.heldConsumable = consumable;
        System.out.println("Holding consumable: " + consumable.getName());
    }

    // USE CONSUMABLE 
    public void useConsumable() {
        if (heldConsumable != null) {
            heldConsumable.activate(Player.getInstance());
            System.out.println("Consumable " + heldConsumable.getName() + " used!");
            heldConsumable = null; // Remove after use
        } else {
            System.out.println("No consumable held.");
        }
    }

    // UNEQUIP METHODS 
    public void unequipWeapon() {
        if (equippedWeapon != null) {
            System.out.println("Unequipped weapon: " + equippedWeapon.getName());
            equippedWeapon = null;
        }
    }

    public void unequipArmor() {
        if (equippedArmor != null) {
            System.out.println("Unequipped armor: " + equippedArmor.getName());
            equippedArmor = null;
        }
    }

    public void unequipShield() {
        if (equippedShield != null) {
            System.out.println("Unequipped shield: " + equippedShield.getName());
            equippedShield = null;
        }
    }

    public void unequipAccessory() {
        if (equippedAccessory != null) {
            System.out.println("Unequipped accessory: " + equippedAccessory.getName());
            equippedAccessory = null;
        }
    }

    // DISPLAY EQUIPPED ITEMS 
    public void displayEquipped() {
        System.out.println("===== Equipped Items =====");
        System.out.println("Weapon: " + (equippedWeapon != null ? equippedWeapon.getName() : "None"));
        System.out.println("Armor: " + (equippedArmor != null ? equippedArmor.getName() : "None"));
        System.out.println("Shield: " + (equippedShield != null ? equippedShield.getName() : "None"));
        System.out.println("Accessory: " + (equippedAccessory != null ? equippedAccessory.getName() : "None"));
        System.out.println("Consumable: " + (heldConsumable != null ? heldConsumable.getName() : "None"));
        System.out.println("==========================");
    }
}
