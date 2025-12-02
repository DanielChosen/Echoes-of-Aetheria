// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class SandstoneKnight extends Enemy {
   public SandstoneKnight() {
      super("Sandstone Knight", 900, 180, 200, 10, 11, 0.88, "Boss");
      this.skills.add(SkillRegistry.get("Judgement Cut"));
      this.skills.add(SkillRegistry.get("Shield Slam"));
      this.skills.add(SkillRegistry.get("Royal Guard"));
      this.skills.add(SkillRegistry.get("Desert Shockwave"));
      this.skills.add(SkillRegistry.get("Soul Test"));
   }
}
