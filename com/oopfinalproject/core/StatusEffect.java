package com.oopfinalproject.core;

/**
 * Simple, flexible status effect container used by Player and Enemy.
 * Contains an effect name, remaining duration, and several fields
 * that encode what this effect modifies or does each tick
 */
public class StatusEffect {
    private final String name;
    private int remainingTurns;

    // Per-turn damage/heal (positive -> damage, negative -> heal)
    private int perTurnHP = 0;

    // Temporary stat deltas (applied immediately and reverted on expiry)
    private double deltaDodge = 0.0;
    private double deltaDEF = 0.0;    // additive percent DEF
    private double deltaDamage = 0.0; // multiplicative damage (e.g. +0.20 => +20%)
    private double deltaAccuracy = 0.0; // -0.1 => -10% accuracy
    private double deltaSpd = 0.0; // modify speed (flat)
    private double deltaFireResist = 0.0; // additive percent fire resist

    // Flags
    private boolean frozen = false;   // skip turns
    private boolean stunned = false;  // skip turns
    private double lifestealPercent = 0.0; // optional - heal attacker by percent of damage dealt

    public StatusEffect(String name, int duration) {
        this.name = name;
        this.remainingTurns = duration;
    }

    public StatusEffect name(String n) { return new StatusEffect(n, this.remainingTurns); }

    public String getName() { return name; }
    public int getRemainingTurns() { return remainingTurns; }

    public void setPerTurnHP(int v) { perTurnHP = v; }
    public int getPerTurnHP() { return perTurnHP; }

    public void setDeltaDodge(double v) { deltaDodge = v; }
    public double getDeltaDodge() { return deltaDodge; }

    public void setDeltaDEF(double v) { deltaDEF = v; }
    public double getDeltaDEF() { return deltaDEF; }

    public void setDeltaDamage(double v) { deltaDamage = v; }
    public double getDeltaDamage() { return deltaDamage; }

    public void setDeltaAccuracy(double v) { deltaAccuracy = v; }
    public double getDeltaAccuracy() { return deltaAccuracy; }

    public void setDeltaSpd(double v) { deltaSpd = v; }
    public double getDeltaSpd() { return deltaSpd; }

    public void setDeltaFireResist(double v) { deltaFireResist = v; }
    public double getDeltaFireResist() { return deltaFireResist; }

    public void setFrozen(boolean b) { frozen = b; }
    public boolean isFrozen() { return frozen; }

    public void setStunned(boolean b) { stunned = b; }
    public boolean isStunned() { return stunned; }

    public void setLifestealPercent(double p) { lifestealPercent = p; }
    public double getLifestealPercent() { return lifestealPercent; }

    // tick: apply per-turn damage & decrement remaining turns
    public void tick() {
        if (remainingTurns > 0) remainingTurns--;
    }

    public boolean isExpired() { return remainingTurns <= 0; }
}
