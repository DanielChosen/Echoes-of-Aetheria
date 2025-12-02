// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class DarkWolfLeader extends Enemy {
   public DarkWolfLeader() {
      super("Dark Wolf Leader", 225, 60, 40, 0, 18, 0.9, "Shadow");
      this.skills.add(SkillRegistry.get("Pack Leader Roar"));
      this.skills.add(SkillRegistry.get("Double Bite"));
      this.skills.add(SkillRegistry.get("Darkness Veil"));
   }
}
