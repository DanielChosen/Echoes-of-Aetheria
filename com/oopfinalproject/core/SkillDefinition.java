package com.oopfinalproject.core;

public class SkillDefinition {
    public enum Kind { PHYSICAL, MAGIC, AOE, HEAL, DEBUFF, BUFF, CONTROL }

    private final String name;
    private final int basePower;
    private final boolean aoe;
    private final String note;
    private final Kind kind;

    public SkillDefinition(String name, int basePower, boolean aoe, String note, Kind kind) {
        this.name = name;
        this.basePower = basePower;
        this.aoe = aoe;
        this.note = note;
        this.kind = kind;
    }

    public String getName() { return name; }
    public int getBasePower() { return basePower; }
    public boolean isAoe() { return aoe; }
    public String getNote() { return note; }
    public Kind getKind() { return kind; }

    @Override
    public String toString() { return name + " (" + kind + ")"; }
}
