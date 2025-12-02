// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class GolemFragment extends Enemy {
   public GolemFragment() {
      super("Golem Fragment", 300, 85, 40, 0, 5, 0.9, "Golem");
      this.skills.add(SkillRegistry.get("Boulder Throw"));
      this.skills.add(SkillRegistry.get("Stone Skin"));
      this.skills.add(SkillRegistry.get("Tremor"));
   }
}
