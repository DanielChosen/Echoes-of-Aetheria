// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class SandstormGuardian extends Enemy {
   public SandstormGuardian() {
      super("Sandstorm Guardian", 800, 90, 65, 10, 15, 7, "Boss");
      this.skills.add(SkillRegistry.get("Sand Maelstrom"));
      this.skills.add(SkillRegistry.get("Wind Scream"));
      this.skills.add(SkillRegistry.get("Storm Barrier"));
   }
}
