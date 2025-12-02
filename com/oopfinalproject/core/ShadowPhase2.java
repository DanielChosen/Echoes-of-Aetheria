// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class ShadowPhase2 extends Enemy {
   public ShadowPhase2() {
      super("Shadow - Phase 2", 2000, 260, 190, 32, 17, 0.5, "Boss");
      this.skills.add(SkillRegistry.get("Blackfire Burst"));
      this.skills.add(SkillRegistry.get("Soul Reap"));
      this.skills.add(SkillRegistry.get("Nightmare Projection"));
      this.skills.add(SkillRegistry.get("Shadow Bind"));
   }
}
