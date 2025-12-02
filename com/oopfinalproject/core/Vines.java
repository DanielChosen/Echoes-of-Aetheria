// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class Vines extends Enemy {
   public Vines() {
       super("Vines", 70, 30, 9, 6, 7, 0.85, "Plant");
        skills.add(SkillRegistry.get("Root Trap"));
        skills.add(SkillRegistry.get("Poison Sap"));
        skills.add(SkillRegistry.get("Whiplash"));
   }
}
