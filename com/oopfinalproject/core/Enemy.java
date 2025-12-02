package com.oopfinalproject.core;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class Enemy {
    protected String name;
    protected int maxHp;
    protected int hp;
    protected int atk;
    protected int def;
    protected int mag;
    protected int spd;
    protected double accuracy;
    protected String type;
    protected List<SkillDefinition> skills = new ArrayList<>();
    protected List<StatusEffect> effects = new ArrayList<>();
    protected JTextArea combatTextArea; // UI reference

    public Enemy(String name, int maxHp, int atk, int def, int mag, int spd, double accuracy, String type) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.def = def;
        this.mag = mag;
        this.spd = spd;
        this.accuracy = accuracy;
        this.type = type;
    }

    // UI Setter
    public void setCombatTextArea(JTextArea textArea) {
        this.combatTextArea = textArea;
    }

    // Helper to display messages in the UI
    protected void display(String message) {
        if (combatTextArea != null) {
            combatTextArea.append(message + "\n");
            combatTextArea.setCaretPosition(combatTextArea.getDocument().getLength()); // auto-scroll
        }
    }

    // -------------------- Getters -------------------- //
    public int getCurrentHP() { return hp; }
    public int getMaxHP() { return maxHp; }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAtk() { return atk; }
    public int getDef() { return def; }
    public int getMag() { return mag; }
    public int getSpd() { return spd; }
    public double getAccuracy() { return accuracy; }
    public String getType() { return type; }
    public List<SkillDefinition> getSkills() { return skills; }

    // -------------------- Combat -------------------- //
    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
        display(name + " takes " + dmg + " damage! HP: " + hp);
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
        display(name + " healed " + amount + " HP.");
    }

    public void attack(Player player) {
        for (StatusEffect s : effects) {
            if (!s.isExpired() && (s.isFrozen() || s.isStunned())) {
                display(name + " is unable to act due to " + s.getName() + "!");
                return;
            }
        }

        if (!skills.isEmpty() && Math.random() < 0.35) {
            int idx = (int) (Math.random() * skills.size());
            useSkill(skills.get(idx), player);
            return;
        }

        // Basic physical attack
        if (Math.random() > accuracy) {
            display(name + " tried to attack but missed!");
            return;
        }

        int dmgFallback = atk;

        if (Math.random() < player.getAutoDodge()) {
            display("Player's auto-dodge avoids the attack!");
            return;
        }

        if (Math.random() < player.getDodge()) {
            display("Player dodged the attack!");
            return;
        }

        if (Math.random() < player.getBlock()) {
            dmgFallback = Math.max(0, (int)(dmgFallback * 0.5 - player.getDEF()));
            display("Player blocked the attack!");
        } else {
            dmgFallback = Math.max(0, (int)(dmgFallback - player.getDEF()));
        }

        player.takeDamage(dmgFallback);
    }

    public void applyStatus(StatusEffect s) {
        effects.add(s);
        display(name + " afflicted with status '" + s.getName() + "' for " + s.getRemainingTurns() + " turn(s).");
        if (s.getDeltaAccuracy() != 0.0) accuracy += s.getDeltaAccuracy();
        if (s.getDeltaSpd() != 0.0) spd += (int) s.getDeltaSpd();
    }

    public void tickStatusEffects(Player player) {
        if (effects.isEmpty()) return;

        List<StatusEffect> expired = new ArrayList<>();
        for (StatusEffect s : effects) {
            if (s.getPerTurnHP() > 0) player.takeDamage(s.getPerTurnHP());
            else if (s.getPerTurnHP() < 0) heal(-s.getPerTurnHP());

            s.tick();
            if (s.isExpired()) {
                if (s.getDeltaAccuracy() != 0.0) accuracy -= s.getDeltaAccuracy();
                if (s.getDeltaSpd() != 0.0) spd -= (int) s.getDeltaSpd();
                expired.add(s);
                display(name + "'s " + s.getName() + " effect ended.");
            }
        }
        effects.removeAll(expired);
    }

    protected void useSkill(SkillDefinition skill, Player player) {
        String key = skill.getName().toLowerCase();
        int dmg = atk + skill.getBasePower();
        display(name + " uses " + skill.getName() + "!");

        if (Math.random() > accuracy) {
            display(name + "'s skill missed!");
            return;
        }

        switch (skill.getKind()) {
            case HEAL:
                int healAmt = Math.max(1, (dmg + mag / 2) / 2);
                player.takeDamage(dmg);
                this.heal(healAmt);
                display(name + " heals " + healAmt + " HP from " + skill.getName());
                break;

            case DEBUFF:
                if (key.contains("panic") || key.contains("fear") || key.contains("bark") || key.contains("howl")) {
                    StatusEffect shaken = new StatusEffect("Shaken", 2);
                    shaken.setDeltaDamage(-0.10);
                    player.applyStatus(shaken);
                    display(name + " reduces player's damage for 2 turns!");
                } else if (key.contains("poison") || key.contains("sap")) {
                    StatusEffect poison = new StatusEffect("Poison", 3);
                    poison.setPerTurnHP(1);
                    player.applyStatus(poison);
                    display(name + " applies poison to the player.");
                }
                break;

            case CONTROL:
                if (key.contains("stun") || key.contains("headbutt")) {
                    if (Math.random() < 0.25) {
                        StatusEffect stun = new StatusEffect("Stunned", 1);
                        stun.setStunned(true);
                        player.applyStatus(stun);
                        display(name + " stuns the player!");
                    } else {
                        player.takeDamage(Math.max(0, (int)(atk - player.getDEF())));
                    }
                }
                break;

            case PHYSICAL:
                int hits = key.contains("double") ? 2 : 1;
                for (int i = 0; i < hits; i++) {
                    int hitDmg = Math.max(0, (int)(atk - player.getDEF()));
                    player.takeDamage(hitDmg);
                }
                break;
        }
    }


    // BASIC ENEMIES
    public static class UmbralCreep extends Enemy {
        public UmbralCreep() {
            super("Umbral Creep", 28, 4, 1, 2, 5, 0.80, "Shadow");
            skills.add(SkillRegistry.get("Shadow Swipe"));
            skills.add(SkillRegistry.get("Leech Touch"));
            skills.add(SkillRegistry.get("Panic Burst"));
        }
    }

    public static class CorruptedWolf extends Enemy {
        public CorruptedWolf() {
            super("Corrupted Wolf", 40, 7, 2, 0, 6, 0.80, "Beast");
            skills.add(SkillRegistry.get("Fang Rush"));
            skills.add(SkillRegistry.get("Howl of Fear"));
            skills.add(SkillRegistry.get("Dark Bite"));
        }
    }

    public static class Vines extends Enemy {
        public Vines() {
            super("Vines", 35, 6, 3, 2, 3, 0.75, "Plant");
            skills.add(SkillRegistry.get("Root Trap"));
            skills.add(SkillRegistry.get("Poison Sap"));
            skills.add(SkillRegistry.get("Whiplash"));
        }
    }

    public static class WhiteWolf extends Enemy {
        public WhiteWolf() {
            super("White Wolf", 42, 9, 3, 0, 12, 0.85, "Frost");
            skills.add(SkillRegistry.get("Pack Hunt"));
            skills.add(SkillRegistry.get("Frostfang Strike"));
            skills.add(SkillRegistry.get("Quick Lunge"));
        }
    }

    public static class HornedWhiteRabbit extends Enemy {
        public HornedWhiteRabbit() {
            super("Horned White Rabbit", 30, 4, 2, 0, 10, 0.90, "Beast");
            skills.add(SkillRegistry.get("Sprint"));
            skills.add(SkillRegistry.get("Headbutt"));
            skills.add(SkillRegistry.get("Burrow Dodge"));
        }
    }

    public static class Sandworm extends Enemy {
        public Sandworm() {
            super("Sandworm", 70, 10, 5, 0, 7, 0.75, "Desert");
            skills.add(SkillRegistry.get("Sand Dive"));
            skills.add(SkillRegistry.get("Acid Spit"));
            skills.add(SkillRegistry.get("Armor Crush"));
            skills.add(SkillRegistry.get("Earthshake"));
        }
    }

    public static class ArmoredFennec extends Enemy {
        public ArmoredFennec() {
            super("Armored Fennec", 35, 6, 3, 1, 8, 0.85, "Beast");
            skills.add(SkillRegistry.get("Sand Dash"));
            skills.add(SkillRegistry.get("Sonic Bark"));
            skills.add(SkillRegistry.get("Quick Bite"));
        }
    }

    // MINI-BOSSES
    public static class DarkWolfLeader extends Enemy {
        public DarkWolfLeader() {
            super("Dark Wolf Leader", 75, 10, 4, 0, 12, 0.85, "Shadow");
            skills.add(SkillRegistry.get("Pack Leader Roar"));
            skills.add(SkillRegistry.get("Double Bite"));
            skills.add(SkillRegistry.get("Darkness Veil"));
        }
    }

    public static class GolemFragment extends Enemy {
        public GolemFragment() {
            super("Golem Fragment", 100, 9, 8, 0, 4, 0.70, "Golem");
            skills.add(SkillRegistry.get("Boulder Throw"));
            skills.add(SkillRegistry.get("Stone Skin"));
            skills.add(SkillRegistry.get("Tremor"));
        }
    }

    // BOSSES
    public static class ElderGolem extends Enemy {
        public ElderGolem() {
            super("Elder Golem", 150, 12, 10, 4, 5, 0.70, "Golem");
            skills.add(SkillRegistry.get("Stonequake"));
            skills.add(SkillRegistry.get("Golem Fist"));
            skills.add(SkillRegistry.get("Earth Pulse"));
            skills.add(SkillRegistry.get("Crystal Beam"));
        }
    }

    public static class IceDragonSyntice extends Enemy {
        public IceDragonSyntice() {
            super("Ice Dragon Syntice", 260, 18, 14, 15, 10, 0.75, "Frost");
            skills.add(SkillRegistry.get("Blizzard Roar"));
            skills.add(SkillRegistry.get("Ice Breath"));
            skills.add(SkillRegistry.get("Wing Cyclone"));
            skills.add(SkillRegistry.get("Tail Sweep"));
            skills.add(SkillRegistry.get("Crystal Freeze"));
            skills.add(SkillRegistry.get("Frost Nova"));
        }
    }

    public static class SandstormGuardian extends Enemy {
        public SandstormGuardian() {
            super("Sandstorm Guardian", 190, 15, 10, 9, 15, 0.80, "Desert");
            skills.add(SkillRegistry.get("Sand Maelstrom"));
            skills.add(SkillRegistry.get("Wind Scream"));
            skills.add(SkillRegistry.get("Storm Barrier"));
        }
    }

    public static class SandstoneKnight extends Enemy {
        public SandstoneKnight() {
            super("Sandstone Knight", 230, 18, 14, 10, 10, 0.85, "Desert");
            skills.add(SkillRegistry.get("Judgement Cut"));
            skills.add(SkillRegistry.get("Shield Slam"));
            skills.add(SkillRegistry.get("Royal Guard"));
            skills.add(SkillRegistry.get("Desert Shockwave"));
            skills.add(SkillRegistry.get("Soul Test"));
        }
    }

    // FINAL BOSS (3 PHASES)
    public static class ShadowPhase1 extends Enemy {
        public ShadowPhase1() {
            super("Shadow - Phase 1", 500, 22, 18, 26, 16, 0.85, "Shadow");
            skills.add(SkillRegistry.get("Mirror Slash"));
            skills.add(SkillRegistry.get("Umbral Echo"));
            skills.add(SkillRegistry.get("Darkness Beam"));
        }
    }

    public static class ShadowPhase2 extends Enemy {
        public ShadowPhase2() {
            super("Shadow - Phase 2", 300, 26, 20, 32, 17, 0.90, "Shadow");
            skills.add(SkillRegistry.get("Blackfire Burst"));
            skills.add(SkillRegistry.get("Soul Reap"));
            skills.add(SkillRegistry.get("Nightmare Projection"));
            skills.add(SkillRegistry.get("Shadow Bind"));
        }
    }

    public static class ShadowPhase3 extends Enemy {
        public ShadowPhase3() {
            super("Shadow - Phase 3", 120, 30, 22, 40, 20, 0.95, "Shadow");
            skills.add(SkillRegistry.get("World Shatter"));
            skills.add(SkillRegistry.get("Eclipse Storm"));
            skills.add(SkillRegistry.get("Fate Strings"));
            skills.add(SkillRegistry.get("Despair Howl"));
        }
    }
}



    

    // You can continue adding all other subclasses as in your original code.

