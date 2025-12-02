// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class UmbralCreep extends Enemy {
   public UmbralCreep() {
      super("Umbral Creep",64, 25, 7, 6, 9, 0.9, "Shadow");
      this.skills.add(SkillRegistry.get("Shadow Swipe"));
      this.skills.add(SkillRegistry.get("Leech Touch"));
      this.skills.add(SkillRegistry.get("Panic Burst"));
   }
}
