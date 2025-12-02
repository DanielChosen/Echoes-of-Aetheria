// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class Sandworm extends Enemy {
   public Sandworm() {
      super("Sandworm", 140, 40, 18, 0, 11, 0.85, "Desert");
      this.skills.add(SkillRegistry.get("Sand Dive"));
      this.skills.add(SkillRegistry.get("Acid Spit"));
      this.skills.add(SkillRegistry.get("Armor Crush"));
      this.skills.add(SkillRegistry.get("Earthshake"));
   }
}
