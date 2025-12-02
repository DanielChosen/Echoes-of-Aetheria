package com.oopfinalproject.core;

import com.oopfinalproject.game.UI;
import java.util.*;
import com.oopfinalproject.items.Inventory;

public class Player {

    private UI ui; // UI reference for combat text
    private static Player instance = new Player();

    private Player() { }

    // Base Stats
    private int str = 5, vit = 5, agi = 5, intel = 5, cha = 5;
    private int maxHP = 100, currentHP = 100;
    private int maxMP = 50, currentMP = 50;

    // Combat Stats
    private double damage = 0, damageTaken = 0, dodge = 0, block = 0, crit = 0, accuracy = 0;
    private double frostResist = 0, fireResist = 0, corruptionResist = 0, frostDmg = 0;
    private double magicResist = 0, autoDodge = 0, mpRegen = 0, manaCostReduction = 0, def = 0;

    // Enemy-specific Bonuses
    private double bonusBeasts = 0, bonusShadow = 0, bonusFrost = 0, bonusDesert = 0, bonusBoss = 0;
    private double bonusPlants = 0, bonusGolems = 0, bonusPanic = 0, bonusFinalBoss = 0;

    // Inventory
    private Inventory inventory = new Inventory();

    // Status effects
    private List<StatusEffect> effects = new ArrayList<>();

    // -------------------------
    // Singleton helper
    // -------------------------
    public static Player getInstance() { return instance; }

    // -------------------------
    // UI setter
    // -------------------------
    public void setUI(UI ui) {
        this.ui = ui;
    }

    // -------------------------
    // GETTERS
    // -------------------------
    public int getStr() { return str; }
    public int getVit() { return vit; }
    public int getAgi() { return agi; }
    public int getIntel() { return intel; }
    public int getCha() { return cha; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentMP() { return currentMP; }
    public int getMaxMP() { return maxMP; }

    public double getDamage() { return damage; }
    public double getDamageTaken() { return damageTaken; }
    public double getDodge() { return dodge; }
    public double getBlock() { return block; }
    public double getCrit() { return crit; }
    public double getAccuracy() { return accuracy; }
    public double getFrostResist() { return frostResist; }
    public double getFireResist() { return fireResist; }
    public double getCorruptionResist() { return corruptionResist; }
    public double getFrostDmg() { return frostDmg; }
    public double getMagicResist() { return magicResist; }
    public double getAutoDodge() { return autoDodge; }
    public double getMpRegen() { return mpRegen; }
    public double getManaCostReduction() { return manaCostReduction; }
    public double getDEF() { return def; }

    // -------------------------
    // Inventory
    // -------------------------
    public Inventory getInventory() { return inventory; }
    public void setInventory(Inventory inv) { this.inventory = inv; }

    // -------------------------
    // BASE STAT MODIFIERS
    // -------------------------
    public void increaseStr(int n) { str += n; }
    public void increaseVit(int n) { vit += n; maxHP += n * 10; currentHP += n * 10; }
    public void increaseAgi(int n) { agi += n; }
    public void increaseIntel(int n) { intel += n; }
    public void increaseCha(int n) { cha += n; }
    public void increaseHP(int n) { 
        currentHP = Math.min(currentHP + n, maxHP); 
        if(ui != null) ui.updatedamageTextArea("Player heals " + n + " HP! HP: " + currentHP + "/" + maxHP);
    }
    public void increaseMP(int n) { 
        currentMP = Math.min(currentMP + n, maxMP); 
        if(ui != null) ui.updatedamageTextArea("Player restores " + n + " MP! MP: " + currentMP + "/" + maxMP);
    }

    // -------------------------
    // COMBAT STAT MODIFIERS
    // -------------------------
    public void increaseDamage(double n) { damage += n; }
    public void increaseDamageTaken(double n) { damageTaken += n; }
    public void increaseDodge(double n) { dodge += n; }
    public void increaseBlockChance(double n) { block += n; }
    public void increaseCrit(double n) { crit += n; }
    public void increaseAccuracy(double n) { accuracy += n; }
    public void increaseFrostResist(double n) { frostResist += n; }
    public void increaseFireResist(double n) { fireResist += n; }
    public void increaseCorruptionResist(double n) { corruptionResist += n; }
    public void increaseFrostDmg(double n) { frostDmg += n; }
    public void increaseMagicResist(double n) { magicResist += n; }
    public void increaseAutoDodge(double n) { autoDodge += n; }
    public void increaseMpRegen(double n) { mpRegen += n; }
    public void reduceManaCost(double n) { manaCostReduction += n; }
    public void increaseDEF(double n) { def += n; }

    // -------------------------
    // ENEMY-SPECIFIC BONUS MODIFIERS
    // -------------------------
    public void increaseBonusBeasts(double n) { bonusBeasts += n; }
    public void increaseBonusShadow(double n) { bonusShadow += n; }
    public void increaseBonusFrost(double n) { bonusFrost += n; }
    public void increaseBonusDesert(double n) { bonusDesert += n; }
    public void increaseBonusBoss(double n) { bonusBoss += n; }
    public void increaseBonusPlants(double n) { bonusPlants += n; }
    public void increaseBonusGolems(double n) { bonusGolems += n; }
    public void increaseBonusPanic(double n) { bonusPanic += n; }
    public void increaseBonusFinalBoss(double n) { bonusFinalBoss += n; }

    // -------------------------
    // COMBAT ACTIONS
    // -------------------------
    public void takeDamage(int dmg) {
        currentHP -= dmg;
        if(currentHP < 0) currentHP = 0;
        if(ui != null) {
            ui.updatedamageTextArea("Player takes " + dmg + " damage! HP: " + currentHP + "/" + maxHP);
        }
    }

    public void healHP(int amount) {
        currentHP = Math.min(currentHP + amount, maxHP);
        if(ui != null) {
            ui.updatedamageTextArea("Player heals " + amount + " HP! HP: " + currentHP + "/" + maxHP);
        }
    }

    public void restoreMP(int amount) {
        currentMP = Math.min(currentMP + amount, maxMP);
        if(ui != null) {
            ui.updatedamageTextArea("Player restores " + amount + " MP! MP: " + currentMP + "/" + maxMP);
        }
    }

    public void onDealDamage(int damageDealt) {
        List<StatusEffect> toRemove = new ArrayList<>();
        for (StatusEffect s : effects) {
            if (s.getLifestealPercent() > 0) {
                int heal = (int)(damageDealt * s.getLifestealPercent());
                if(heal > 0) healHP(heal);
                toRemove.add(s);
                if(ui != null) ui.updatedamageTextArea("Lifesteal: player recovers " + heal + " HP.");
            }
        }
        effects.removeAll(toRemove);
    }

    // -------------------------
    // STATUS EFFECTS
    // -------------------------
    public void applyStatus(StatusEffect effect) {
        if(effect.getDeltaDodge() != 0.0) increaseDodge(effect.getDeltaDodge());
        if(effect.getDeltaDEF() != 0.0) increaseDEF(effect.getDeltaDEF());
        if(effect.getDeltaDamage() != 0.0) increaseDamage(effect.getDeltaDamage());

        effects.add(effect);
        if(ui != null) ui.updatedamageTextArea("Applied status '" + effect.getName() + "' for " + effect.getRemainingTurns() + " turn(s).");
    }

    public void tickStatusEffects() {
        if(effects.isEmpty()) return;

        List<StatusEffect> expired = new ArrayList<>();
        for(StatusEffect s : effects) {
            if(s.getPerTurnHP() != 0) {
                if(s.getPerTurnHP() > 0) takeDamage(s.getPerTurnHP());
                else healHP(-s.getPerTurnHP());
            }

            s.tick();
            if(s.isExpired()) {
                if(s.getDeltaDodge() != 0.0) increaseDodge(-s.getDeltaDodge());
                if(s.getDeltaDEF() != 0.0) increaseDEF(-s.getDeltaDEF());
                if(s.getDeltaDamage() != 0.0) increaseDamage(-s.getDeltaDamage());
                if(s.getDeltaFireResist() != 0.0) increaseFireResist(-s.getDeltaFireResist());
                expired.add(s);
                if(ui != null) ui.updatedamageTextArea("Status '" + s.getName() + "' expired.");
            }
        }

        effects.removeAll(expired);
    }

    // -------------------------
    // Helper methods
    // -------------------------
    public boolean isUnableToAct() {
        return effects.stream().anyMatch(e -> !e.isExpired() && (e.isFrozen() || e.isStunned()));
    }

    public boolean hasStatus(String statusName) {
        return effects.stream().anyMatch(e -> !e.isExpired() && e.getName().equalsIgnoreCase(statusName));
    }
}
