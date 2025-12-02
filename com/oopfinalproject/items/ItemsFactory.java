package com.oopfinalproject.items;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ItemsFactory {
    private static final Random random = new Random();

    // Existing methods
    public static Weapon TrainingSword() {return new TrainingSword(); }
    public static Weapon EclipseEdge() { return new EclipseEdge(); }
    public static Weapon FangDagger() { return new FangDagger(); }
    public static Weapon FrostbiteBow() { return new FrostbiteBow(); }
    public static Weapon ScorchedSaber() { return new ScorchedSaber(); }
    public static Weapon GolemheartBlade() { return new GolemheartBlade(); }
    public static Weapon Shadowrend() { return new Shadowrend(); }
    public static Armor wanderersTunic() { return new WanderersTunic(); }
    public static Armor EquinoxVestige() { return new EquinoxVestige(); }
    public static Shield woodenBuckler() { return new WoodenBuckler(); }
    public static Accessory ringOfMinorProtection() { return new RingOfMinorProtection(); }
    public static Accessory shadowsWhisper() { return new ShadowsWhisper(); }
    public static Inventory defaultInventory() {
        Inventory inv = new Inventory();
        inv.addItem(new SmallHealingPotion());
        inv.addItem(new ManaPotion());
        return inv;
    }

    // Lists of all items for randomization
    // Tiered lists for predictable upgrades (keeps original factory ordering intact)
    private static final List<Weapon> commonWeapons = Arrays.asList(
        new TrainingSword(), new IronShortblade(), new HuntersBow(), new WornStaff(), new RustySpear()
    );

    private static final List<Weapon> silverwoodWeapons = Arrays.asList(
        new SpiritwoodSword(), new FangDagger(), new VinecasterStaff(), new GroveLongbow()
    );

    private static final List<Weapon> frostspireWeapons = Arrays.asList(
        new FrozenOreSword(), new IcebrandGreatsword(), new BlizzardStaff(), new FrostbiteBow()
    );

    private static final List<Weapon> crimsonWeapons = Arrays.asList(
        new ScorchedSaber(), new SandsteelKatana(), new SunfuryStaff(), new DunePiercerSpear()
    );

    private static final List<Weapon> rareWeapons = Arrays.asList(
        new GolemheartBlade(), new SynticesFangSpear(), new KnightsOathClaymore(), new Aetherblade(0)
    );

    private static final List<Weapon> legendaryWeapons = Arrays.asList(
        new Shadowrend(), new GuardiansRadiance(), new EclipseEdge()
    );

    // Combined list for backwards compatibility
    private static final List<Weapon> allWeapons = new java.util.ArrayList<>();
    static { allWeapons.addAll(commonWeapons); allWeapons.addAll(silverwoodWeapons); allWeapons.addAll(frostspireWeapons); allWeapons.addAll(crimsonWeapons); allWeapons.addAll(rareWeapons); allWeapons.addAll(legendaryWeapons); }

    private static final List<Armor> commonArmors = Arrays.asList(
        new WanderersTunic(), new ForestcloakMantle(), new FrostweaveRobe(), new DesertNomadWraps(), new EtherealRobe()
    );

    private static final List<Armor> mediumArmors = Arrays.asList(
        new IronAdventurersVest(), new SpiritwoodJerkin(), new FrostfurArmor(), new SandsteelBreastplate()
    );

    private static final List<Armor> heavyArmors = Arrays.asList(
        new BronzePlate(), new SilverwoodGuardianMail(), new FrostboundArmor(), new SandstonePaladinArmor()
    );

    private static final List<Armor> legendaryArmors = Arrays.asList(
        new ArmorOfTheFirstGuardian(), new TwilightCarapace(), new EquinoxVestige()
    );

    private static final List<Armor> allArmors = new java.util.ArrayList<>();
    static { allArmors.addAll(commonArmors); allArmors.addAll(mediumArmors); allArmors.addAll(heavyArmors); allArmors.addAll(legendaryArmors); }

    private static final List<Shield> commonShields = Arrays.asList(
        new WoodenBuckler(), new IronRoundShield()
    );

    private static final List<Shield> advancedShields = Arrays.asList(
        new SpiritwoodShield(), new SandsteelTowerShield()
    );

    private static final List<Shield> legendaryShields = Arrays.asList(
        new GuardiansAegis()
    );

    private static final List<Shield> allShields = new java.util.ArrayList<>();
    static { allShields.addAll(commonShields); allShields.addAll(advancedShields); allShields.addAll(legendaryShields); }

    private static final List<Accessory> commonAccessories = Arrays.asList(
        new RingOfMinorProtection(), new RingOfManaPulse(), new FrozenTearRing(), new EmberheartRing(), new SandstormRing(), new OldMansTalisman(), new LuckyWolfFang(), new LyrasFeather()
    );

    private static final List<Accessory> advancedAccessories = Arrays.asList(
        new CrystalMemoryRing(), new PendantOfCourage(), new PendantOfAetherFlow(), new FrostDragonAmulet(), new DesertWindTalisman(), new ShadowsWhisper(), new BlessingOfSyntice(), new CorruptedCoreFragment()
    );

    private static final List<Accessory> allAccessories = new java.util.ArrayList<>();
    static { allAccessories.addAll(commonAccessories); allAccessories.addAll(advancedAccessories); }

    private static final List<Consumable> allConsumables = Arrays.asList(
        new SmallHealingPotion(), new GreaterHealingPotion(), new ManaPotion(), new StaminaBrew(),
        new FrostbiteCure(), new HeatResistanceElixir(), new ScrollOfFreeze(), new ScrollOfFireburst(),
        new ScrollOfBarrier(), new FrozenApple(), new WolfPelts(), new CrystalFragments()
    );

    // Random selection methods
    public static Weapon getRandomWeapon() {
        return allWeapons.get(random.nextInt(allWeapons.size()));
    }

    // --- New helpers for upgrade logic ---
    // Find a same-tier weapon that has higher damage than the provided weapon.
    // Returns null if none found.
    public static Weapon getBetterWeaponSameTier(Weapon current) {
        if (current == null) return null;
        List<Weapon> tier = getWeaponTier(current);
        if (tier == null || tier.isEmpty()) return null;
        Weapon best = null;
        for (Weapon w : tier) {
            if (w.getDmg() > current.getDmg()) {
                if (best == null || w.getDmg() > best.getDmg()) best = w;
            }
        }
        return best;
    }

    // Find a weapon in the next higher tier. Returns null if none.
    public static Weapon getUpgradeWeaponNextTier(Weapon current) {
        if (current == null) return null;
        List<Weapon> tier = getWeaponTier(current);
        if (tier == null) return null;
        if (tier == commonWeapons) return pickRandomFromList(silverwoodWeapons);
        if (tier == silverwoodWeapons) return pickRandomFromList(frostspireWeapons);
        if (tier == frostspireWeapons) return pickRandomFromList(crimsonWeapons);
        if (tier == crimsonWeapons) return pickRandomFromList(rareWeapons);
        if (tier == rareWeapons) return pickRandomFromList(legendaryWeapons);
        return null;
    }

    private static Weapon pickRandomFromList(List<Weapon> list) {
        if (list == null || list.isEmpty()) return null;
        return list.get(random.nextInt(list.size()));
    }

    private static List<Weapon> getWeaponTier(Weapon w) {
        if (w == null) return null;
        if (commonWeapons.stream().anyMatch(c -> c.getClass().equals(w.getClass()))) return commonWeapons;
        if (silverwoodWeapons.stream().anyMatch(c -> c.getClass().equals(w.getClass()))) return silverwoodWeapons;
        if (frostspireWeapons.stream().anyMatch(c -> c.getClass().equals(w.getClass()))) return frostspireWeapons;
        if (crimsonWeapons.stream().anyMatch(c -> c.getClass().equals(w.getClass()))) return crimsonWeapons;
        if (rareWeapons.stream().anyMatch(c -> c.getClass().equals(w.getClass()))) return rareWeapons;
        if (legendaryWeapons.stream().anyMatch(c -> c.getClass().equals(w.getClass()))) return legendaryWeapons;
        return null;
    }

    // Armor helpers
    public static Armor getBetterArmorSameTier(Armor current) {
        if (current == null) return null;
        List<Armor> tier = getArmorTier(current);
        if (tier == null || tier.isEmpty()) return null;
        Armor best = null;
        for (Armor a : tier) {
            if (a.getDef() > current.getDef()) {
                if (best == null || a.getDef() > best.getDef()) best = a;
            }
        }
        return best;
    }

    public static Armor getUpgradeArmorNextTier(Armor current) {
        if (current == null) return null;
        if (commonArmors.stream().anyMatch(c -> c.getClass().equals(current.getClass()))) return pickRandomArmorFromList(mediumArmors);
        if (mediumArmors.stream().anyMatch(c -> c.getClass().equals(current.getClass()))) return pickRandomArmorFromList(heavyArmors);
        if (heavyArmors.stream().anyMatch(c -> c.getClass().equals(current.getClass()))) return pickRandomArmorFromList(legendaryArmors);
        return null;
    }

    private static Armor pickRandomArmorFromList(List<Armor> list) {
        if (list == null || list.isEmpty()) return null;
        return list.get(random.nextInt(list.size()));
    }

    private static List<Armor> getArmorTier(Armor a) {
        if (a == null) return null;
        if (commonArmors.stream().anyMatch(c -> c.getClass().equals(a.getClass()))) return commonArmors;
        if (mediumArmors.stream().anyMatch(c -> c.getClass().equals(a.getClass()))) return mediumArmors;
        if (heavyArmors.stream().anyMatch(c -> c.getClass().equals(a.getClass()))) return heavyArmors;
        if (legendaryArmors.stream().anyMatch(c -> c.getClass().equals(a.getClass()))) return legendaryArmors;
        return null;
    }

    // Shield helpers
    public static Shield getBetterShieldSameTier(Shield current) {
        if (current == null) return null;
        List<Shield> tier = getShieldTier(current);
        if (tier == null || tier.isEmpty()) return null;
        Shield best = null;
        for (Shield s : tier) {
            if (s.getDef() > current.getDef()) {
                if (best == null || s.getDef() > best.getDef()) best = s;
            }
        }
        return best;
    }

    public static Shield getUpgradeShieldNextTier(Shield current) {
        if (current == null) return null;
        if (commonShields.stream().anyMatch(c -> c.getClass().equals(current.getClass()))) return pickRandomShieldFromList(advancedShields);
        if (advancedShields.stream().anyMatch(c -> c.getClass().equals(current.getClass()))) return pickRandomShieldFromList(legendaryShields);
        return null;
    }

    private static Shield pickRandomShieldFromList(List<Shield> list) {
        if (list == null || list.isEmpty()) return null;
        return list.get(random.nextInt(list.size()));
    }

    private static List<Shield> getShieldTier(Shield s) {
        if (s == null) return null;
        if (commonShields.stream().anyMatch(c -> c.getClass().equals(s.getClass()))) return commonShields;
        if (advancedShields.stream().anyMatch(c -> c.getClass().equals(s.getClass()))) return advancedShields;
        if (legendaryShields.stream().anyMatch(c -> c.getClass().equals(s.getClass()))) return legendaryShields;
        return null;
    }

    // Accessory helpers (no numeric stat exposed - use tier promotion and random better choice)
    public static Accessory getBetterAccessorySameTier(Accessory current) {
        if (current == null) return null;
        List<Accessory> tier = getAccessoryTier(current);
        if (tier == null || tier.isEmpty()) return null;
        // try to pick a different accessory in the same tier
        for (Accessory a : tier) {
            if (!a.getClass().equals(current.getClass())) return a; // return first different candidate
        }
        return null;
    }

    public static Accessory getUpgradeAccessoryNextTier(Accessory current) {
        if (current == null) return null;
        if (commonAccessories.stream().anyMatch(c -> c.getClass().equals(current.getClass()))) return pickRandomAccessoryFromList(advancedAccessories);
        return null; // there's no higher beyond advancedAccessories in current factory
    }

    private static Accessory pickRandomAccessoryFromList(List<Accessory> list) {
        if (list == null || list.isEmpty()) return null;
        return list.get(random.nextInt(list.size()));
    }

    private static List<Accessory> getAccessoryTier(Accessory a) {
        if (a == null) return null;
        if (commonAccessories.stream().anyMatch(c -> c.getClass().equals(a.getClass()))) return commonAccessories;
        if (advancedAccessories.stream().anyMatch(c -> c.getClass().equals(a.getClass()))) return advancedAccessories;
        return null;
    }


    public static Armor getRandomArmor() {
        return allArmors.get(random.nextInt(allArmors.size()));
    }

    public static Shield getRandomShield() {
        return allShields.get(random.nextInt(allShields.size()));
    }

    public static Accessory getRandomAccessory() {
        return allAccessories.get(random.nextInt(allAccessories.size()));
    }

    public static Consumable getRandomConsumable() {
        return allConsumables.get(random.nextInt(allConsumables.size()));
    }

    // Get multiple random items
    public static List<Weapon> getRandomWeapons(int count) {
        List<Weapon> selected = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            selected.add(getRandomWeapon());
        }
        return selected;
    }

    public static List<Armor> getRandomArmors(int count) {
        List<Armor> selected = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            selected.add(getRandomArmor());
        }
        return selected;
    }

    public static List<Shield> getRandomShields(int count) {
        List<Shield> selected = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            selected.add(getRandomShield());
        }
        return selected;
    }

    public static List<Accessory> getRandomAccessories(int count) {
        List<Accessory> selected = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            selected.add(getRandomAccessory());
        }
        return selected;
    }

    public static List<Consumable> getRandomConsumables(int count) {
        List<Consumable> selected = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            selected.add(getRandomConsumable());
        }
        return selected;
    }
}
