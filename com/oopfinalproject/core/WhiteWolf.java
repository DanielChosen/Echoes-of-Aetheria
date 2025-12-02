package com.oopfinalproject.core;

class WhiteWolf extends Enemy {
   public WhiteWolf() {
      super("White Wolf", 84, 35, 9, 0, 16, 1.2, "Frost");
      this.skills.add(SkillRegistry.get("Pack Hunt"));
      this.skills.add(SkillRegistry.get("Frostfang Strike"));
      this.skills.add(SkillRegistry.get("Quick Lunge"));
   }
}
