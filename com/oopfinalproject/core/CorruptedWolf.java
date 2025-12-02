package com.oopfinalproject.core;

class CorruptedWolf extends Enemy {
   public CorruptedWolf() {
      super("Corrupted Wolf", 80, 30, 10, 0, 10, 0.90, "Shadow");
      this.skills.add(SkillRegistry.get("Fang Rush"));
      this.skills.add(SkillRegistry.get("Howl of Fear"));
      this.skills.add(SkillRegistry.get("Dark Bite"));
   }
}
