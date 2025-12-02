// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class ArmoredFennec extends Enemy {
   public ArmoredFennec() {
      super("Armored Fennec", 70, 30, 50, 5, 12, 0.8, "Beast");
      this.skills.add(SkillRegistry.get("Sand Dash"));
      this.skills.add(SkillRegistry.get("Sonic Bark"));
      this.skills.add(SkillRegistry.get("Quick Bite"));
   }
}
