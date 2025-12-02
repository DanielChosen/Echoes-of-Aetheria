// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class ElderGolem extends Enemy {
   public ElderGolem() {
      super("Elder Golem", 600, 200, 150, 4, 5, 2, "Boss");
      this.skills.add(SkillRegistry.get("Stonequake"));
      this.skills.add(SkillRegistry.get("Golem Fist"));
      this.skills.add(SkillRegistry.get("Earth Pulse"));
      this.skills.add(SkillRegistry.get("Crystal Beam"));
   }
}
