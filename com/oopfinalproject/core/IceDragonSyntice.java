// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class IceDragonSyntice extends Enemy {
   public IceDragonSyntice() {
      super("Ice Dragon Syntice", 1500, 150, 140, 15, 15, 2, "Boss");
      this.skills.add(SkillRegistry.get("Blizzard Roar"));
      this.skills.add(SkillRegistry.get("Ice Breath"));
      this.skills.add(SkillRegistry.get("Wing Cyclone"));
      this.skills.add(SkillRegistry.get("Tail Sweep"));
      this.skills.add(SkillRegistry.get("Crystal Freeze"));
      this.skills.add(SkillRegistry.get("Frost Nova"));
   }
}
