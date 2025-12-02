// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class ShadowPhase1 extends Enemy {
   public ShadowPhase1() {
      super("Shadow - Phase 1", 1500, 220, 150, 26, 16, 2, "Boss");
      this.skills.add(SkillRegistry.get("Mirror Slash"));
      this.skills.add(SkillRegistry.get("Umbral Echo"));
      this.skills.add(SkillRegistry.get("Darkness Beam"));
   }
}
