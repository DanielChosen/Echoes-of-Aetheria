// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class HornedWhiteRabbit extends Enemy {
   public HornedWhiteRabbit() {
      super("Horned White Rabbit", 80, 28, 15, 0, 14, 1.0, "Beast");
      this.skills.add(SkillRegistry.get("Sprint"));
      this.skills.add(SkillRegistry.get("Headbutt"));
      this.skills.add(SkillRegistry.get("Burrow Dodge"));
   }
}
