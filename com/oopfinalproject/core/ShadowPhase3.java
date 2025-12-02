// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.oopfinalproject.core;

class ShadowPhase3 extends Enemy {
   private int turnCount = 0;
   private boolean enraged = false;

   public ShadowPhase3() {
      super("Shadow - Phase 3", 3000, 100, 300, 40, 20, 0.7, "Boss");
      this.skills.add(SkillRegistry.get("World Shatter"));
      this.skills.add(SkillRegistry.get("Eclipse Storm"));
      this.skills.add(SkillRegistry.get("Fate Strings"));
      this.skills.add(SkillRegistry.get("Despair Howl"));
   }

   public void attack(Player var1) {
      ++this.turnCount;
      if (!this.enraged && (double)this.getHp() / (double)this.maxHp <= 0.25) {
         this.enraged = true;
         this.atk += 6;
         this.mag += 10;
         System.out.println(this.name + " enters a frenzied state! Attacks become more brutal!");
      }

      double var2 = Math.random();
      if (var2 < 0.1) {
         this.worldShatter(var1);
      } else if (var2 < 0.25) {
         this.eclipseStorm(var1);
      } else if (var2 < 0.5) {
         this.fateStrings(var1);
      } else if (var2 < 0.75) {
         this.despairHowl(var1);
      } else {
         this.basicHit(var1);
      }
   }

   private void worldShatter(Player var1) {
      System.out.println(this.name + " gathers shadow energy â€” World Shatter! (Unavoidable)");
      if (Math.random() < var1.getAutoDodge()) {
         System.out.println("Player's auto-dodge narrowly avoids the catastrophic blow!");
      } else {
         int var2 = (int)((double)this.mag * 1.5 + (double)this.atk * 0.5 + 20.0);
         var1.takeDamage(Math.max(0, var2));
      }
   }

   private void eclipseStorm(Player var1) {
      System.out.println(this.name + " unleashes Eclipse Storm â€” multiple shadow strikes!");
      int var2 = 3 + this.turnCount / 5;

      for(int var3 = 0; var3 < var2; ++var3) {
         if (Math.random() > this.accuracy) {
            System.out.println("A shadow strike misses!");
         } else if (Math.random() < var1.getAutoDodge()) {
            System.out.println("Player's auto-dodge avoids a shadow strike!");
         } else if (Math.random() < var1.getDodge()) {
            System.out.println("Player dodges a shadow strike!");
         } else {
            int var4 = Math.max(0, (int)((double)this.mag * 0.45 + (double)this.atk * 0.15));
            var1.takeDamage(var4);
         }
      }

   }

   private void fateStrings(Player var1) {
      System.out.println(this.name + " whispers the Fate Strings â€” an inevitable strike...");
      if (Math.random() < var1.getAutoDodge()) {
         System.out.println("Player's reflexes tear the strings and avoid the blow!");
      } else {
         int var2 = (int)((double)this.mag * 0.8 + (double)this.atk * 0.5 + 8.0 + (double)(this.turnCount / 2));
         var1.takeDamage(Math.max(0, var2));
      }
   }

   private void despairHowl(Player var1) {
      System.out.println(this.name + " howls, sending ripples of despair through the air!");
      if (Math.random() < this.accuracy) {
         if (Math.random() < var1.getAutoDodge()) {
            System.out.println("Player resists the worst of the Howl thanks to reflexes!");
            return;
         }

         int var2 = (int)((double)this.mag * 0.6 + (double)this.atk * 0.25);
         var1.takeDamage(Math.max(0, var2));
         StatusEffect var3 = new StatusEffect("Despair Mark", 2);
         var3.setDeltaDodge(-0.2);
         var1.applyStatus(var3);
      } else {
         System.out.println("Despair Howl fails to fully land.");
      }

   }

   private void basicHit(Player var1) {
      System.out.println(this.name + " strikes with heavy shadow claws.");
      if (Math.random() > this.accuracy) {
         System.out.println(this.name + " misses the heavy strike!");
      } else if (Math.random() < var1.getAutoDodge()) {
         System.out.println("Player's reflexes avoid the heavy strike!");
      } else if (Math.random() < var1.getDodge()) {
         System.out.println("Player dodges the heavy strike!");
      } else {
         int var2 = this.atk;
         if (Math.random() < var1.getBlock()) {
            var2 = Math.max(0, (int)((double)var2 * 0.5 - var1.getDEF()));
            System.out.println("Player partially blocks the attack!");
         } else {
            var2 = Math.max(0, (int)((double)var2 - var1.getDEF()));
         }

         var1.takeDamage(var2);
      }
   }
}
