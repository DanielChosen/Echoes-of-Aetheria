package com.oopfinalproject.core;

import java.util.Map;
import java.util.HashMap;

//Central registry of skill definitions. New skills can be added here and tuned.
public class SkillRegistry {
    private static final Map<String, SkillDefinition> registry = new HashMap<>();

    static {
        // Umbral / small enemies
        register(new SkillDefinition("Shadow Swipe", 4, false, "Weak physical hit", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Leech Touch", 2, false, "Deals 2, heals 2", SkillDefinition.Kind.HEAL));
        register(new SkillDefinition("Panic Burst", 3, true, "Tiny AOE shadow burst", SkillDefinition.Kind.DEBUFF));

        // Fennec / fast enemies
        register(new SkillDefinition("Sand Dash", 6, false, "Quick crit strike", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Sonic Bark", 4, true, "Interrupting AOE", SkillDefinition.Kind.CONTROL));
        register(new SkillDefinition("Quick Bite", 4, false, "2-hit attack", SkillDefinition.Kind.PHYSICAL));

        // Wolves
        register(new SkillDefinition("Fang Rush", 7, false, "Fast bite attack", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Howl of Fear", 2, false, "ATK debuff", SkillDefinition.Kind.DEBUFF));
        register(new SkillDefinition("Dark Bite", 9, false, "Shadow bite", SkillDefinition.Kind.MAGIC));

        // Rabbit
        register(new SkillDefinition("Sprint", 0, false, "Self SPD buff", SkillDefinition.Kind.BUFF));
        register(new SkillDefinition("Headbutt", 4, false, "Small stagger chance", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Burrow Dodge", 0, false, "45% dodge next hit", SkillDefinition.Kind.BUFF));

        // Sandworm
        register(new SkillDefinition("Sand Dive", 0, false, "Untargetable 1 turn", SkillDefinition.Kind.CONTROL));
        register(new SkillDefinition("Acid Spit", 9, false, "DEF-ignoring hit", SkillDefinition.Kind.MAGIC));
        register(new SkillDefinition("Armor Crush", 6, false, "Reduces DEF", SkillDefinition.Kind.DEBUFF));
        register(new SkillDefinition("Earthshake", 10, true, "Weak AOE", SkillDefinition.Kind.AOE));

        // Vines
        register(new SkillDefinition("Root Trap", 0, false, "20% immobilise", SkillDefinition.Kind.CONTROL));
        register(new SkillDefinition("Poison Sap", 1, false, "1 dmg/turn x3", SkillDefinition.Kind.DEBUFF));
        register(new SkillDefinition("Whiplash", 5, false, "Simple vine strike", SkillDefinition.Kind.PHYSICAL));

        // White Wolf
        register(new SkillDefinition("Pack Hunt", 4, false, "Multi-hit per wolf", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Frostfang Strike", 8, false, "Chance to slow", SkillDefinition.Kind.MAGIC));
        register(new SkillDefinition("Quick Lunge", 6, false, "Fast priority hit", SkillDefinition.Kind.PHYSICAL));

        // Wolf leader
        register(new SkillDefinition("Pack Leader Roar", 0, true, "Buffs wolf allies", SkillDefinition.Kind.BUFF));
        register(new SkillDefinition("Double Bite", 7, false, "Hits twice", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Darkness Veil", 3, false, "Reduces accuracy", SkillDefinition.Kind.DEBUFF));

        // Golem fragment
        register(new SkillDefinition("Boulder Throw", 10, false, "Ranged hit", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Stone Skin", 0, false, "Small DEF buff", SkillDefinition.Kind.BUFF));
        register(new SkillDefinition("Tremor", 8, true, "AOE tremor", SkillDefinition.Kind.AOE));

        // Elder Golem
        register(new SkillDefinition("Stonequake", 14, true, "AOE slam", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Golem Fist", 12, false, "Heavy strike", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Earth Pulse", 10, false, "Magic earth dmg", SkillDefinition.Kind.MAGIC));
        register(new SkillDefinition("Crystal Beam", 11, false, "Magic beam", SkillDefinition.Kind.MAGIC));

        // Ice Dragon
        register(new SkillDefinition("Blizzard Roar", 12, true, "AOE ice roar", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Ice Breath", 17, true, "Magic cone attack", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Wing Cyclone", 12, true, "Knockback AOE", SkillDefinition.Kind.CONTROL));
        register(new SkillDefinition("Tail Sweep", 10, false, "Row-target sweep", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Crystal Freeze", 10, false, "Small freeze chance", SkillDefinition.Kind.CONTROL));
        register(new SkillDefinition("Frost Nova", 18, true, "Late-phase AOE", SkillDefinition.Kind.AOE));

        // Sandstone Knight
        register(new SkillDefinition("Judgement Cut", 18, false, "High-crit slash", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Shield Slam", 12, false, "Stun chance", SkillDefinition.Kind.CONTROL));
        register(new SkillDefinition("Royal Guard", 0, false, "Negates next hit", SkillDefinition.Kind.BUFF));
        register(new SkillDefinition("Desert Shockwave", 16, true, "AOE sand wave", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Soul Test", 0, false, "Summons adds", SkillDefinition.Kind.CONTROL));

        // Sandstorm Guardian
        register(new SkillDefinition("Sand Maelstrom", 14, true, "Blind AOE", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Wind Scream", 10, false, "Silence magic", SkillDefinition.Kind.CONTROL));
        register(new SkillDefinition("Storm Barrier", 0, false, "DEF + evasion buff", SkillDefinition.Kind.BUFF));

        // Shadow phases
        register(new SkillDefinition("Mirror Slash", 0, false, "Deals 50% of last ability's base power.", SkillDefinition.Kind.PHYSICAL));
        register(new SkillDefinition("Umbral Echo", 12, true, "Shadow clone AOE", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Darkness Beam", 15, false, "High magic hit", SkillDefinition.Kind.MAGIC));

        register(new SkillDefinition("Blackfire Burst", 18, true, "Dark-fire AOE", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Soul Reap", 10, false, "Life drain", SkillDefinition.Kind.HEAL));
        register(new SkillDefinition("Nightmare Projection", 12, true, "Chance to inflict Fear/Sleep", SkillDefinition.Kind.CONTROL));
        register(new SkillDefinition("Shadow Bind", 12, false, "20% chance to immobilise", SkillDefinition.Kind.CONTROL));

        // Shadow final
        register(new SkillDefinition("World Shatter", 25, true, "Ultimate AOE", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Eclipse Storm", 20, true, "Multi-hit AOE", SkillDefinition.Kind.AOE));
        register(new SkillDefinition("Fate Strings", 18, false, "Unavoidable hit", SkillDefinition.Kind.MAGIC));
        register(new SkillDefinition("Despair Howl", 10, true, "AOE + debuff", SkillDefinition.Kind.DEBUFF));
    }

    private static void register(SkillDefinition def) {
        registry.put(def.getName(), def);
    }

    public static SkillDefinition get(String name) {
        SkillDefinition s = registry.get(name);
        if (s == null) {
            // return a safe fallback skill definition
            return new SkillDefinition(name, 5, false, "Fallback skill", SkillDefinition.Kind.PHYSICAL);
        }
        return s;
    }
}
