package com.oopfinalproject.core;

import com.oopfinalproject.game.UI;
import com.oopfinalproject.items.*;

public class Combat_System {
    private UI ui;
    private Player player;
    private Enemy enemy;
    private EquipmentManager equipmentManager;
    private Inventory inventory;

    private boolean dodgeMode = false;

    // ✅ THIS IS THE MISSING LINK
    private Runnable onVictoryCallback;

    public Combat_System(Player player, Enemy enemy,
                         EquipmentManager equipmentManager,
                         Inventory inventory, UI ui) {
        this.player = player;
        this.enemy = enemy;
        this.equipmentManager = equipmentManager;
        this.inventory = inventory;
        this.ui = ui;

        ui.updateCombatText("BATTLE START: " + enemy.getName() + " appears!");
        enablePlayerButtons(true);
    }

    // ✅ SCENE WILL ATTACH THIS
    public void setOnVictoryCallback(Runnable callback) {
        this.onVictoryCallback = callback;
    }

    private void enablePlayerButtons(boolean enable){
        ui.combat_action1.setEnabled(enable);
        ui.combat_action2.setEnabled(enable);
        ui.combat_action3.setEnabled(enable);
        ui.combat_action4.setEnabled(enable);
    }

    public void startBattle() {
    ui.updateCombatText("Battle started against " + enemy.getName());

    // Connect UI buttons to this combat instance
    ui.setCombatSystem(this);

    enablePlayerButtons(true);

    // ✅ Add this line to show the enemy immediately
    ui.updateEnemyPanel(enemy.getName(), enemy.getCurrentHP(), enemy.getMaxHP());

    // Optional: also show player panel immediately
    ui.updatePlayerPanel(player.getCurrentHP(), player.getMaxHP(), player.getCurrentMP(), player.getMaxMP());
}

    public void playerTurn(String action){
    if(player.getCurrentHP() <= 0 || enemy.isDead()) return;

    player.tickStatusEffects();

    switch(action){
        case "Attack" -> attackEnemy();
        case "Skill" -> useSkill();
        case "Dodge" -> dodge();
        case "Item" -> useItem();
        default -> ui.updateCombatText("Invalid action!");
    }

    // Update player and enemy UI panels AFTER the action
    ui.updatePlayerPanel(player.getCurrentHP(), player.getMaxHP(), player.getCurrentMP(), player.getMaxMP());
    ui.updateEnemyPanel(enemy.getName(), enemy.getCurrentHP(), enemy.getMaxHP()); //cannot find symbol

        if(enemy.isDead()){
        ui.updateCombatText("Enemy defeated!");
        // Auto-upgrade / auto-equip logic
        boolean isMiniBoss = enemy instanceof Enemy.DarkWolfLeader || enemy instanceof Enemy.GolemFragment;
        boolean isBoss = enemy instanceof Enemy.ElderGolem || enemy instanceof Enemy.IceDragonSyntice || enemy instanceof Enemy.SandstormGuardian || enemy instanceof Enemy.SandstoneKnight ||
                enemy instanceof Enemy.ShadowPhase1 || enemy instanceof Enemy.ShadowPhase2 || enemy instanceof Enemy.ShadowPhase3;

        boolean promoteToHigherTier = isMiniBoss || isBoss;

        // Capture newly equipped items to display in loot UI
        java.util.List<com.oopfinalproject.items.Item> newLoots = new java.util.ArrayList<>();

        // Upgrade main hand weapon
        Weapon currentMain = equipmentManager.getEquippedWeaponMainHand();
        if (currentMain != null) {
            Weapon replacement = null;
            if (promoteToHigherTier) replacement = ItemsFactory.getUpgradeWeaponNextTier(currentMain);
            else replacement = ItemsFactory.getBetterWeaponSameTier(currentMain);

            if (replacement != null && !replacement.getClass().equals(currentMain.getClass())) {
                equipmentManager.equipMainHandWeapon(replacement);
                ui.updateCombatText("Your weapon improved to: " + replacement.getName());
                ui.mainHandNameLabel.setText(equipmentManager.getEquippedWeaponMainHand() != null ? equipmentManager.getEquippedWeaponMainHand().getName() : "None");
                newLoots.add(replacement);
            }
        }

        // Upgrade armor
        Armor currentArmor = equipmentManager.getEquippedArmor();
        if (currentArmor != null) {
            Armor replacement = null;
            if (promoteToHigherTier) replacement = ItemsFactory.getUpgradeArmorNextTier(currentArmor);
            else replacement = ItemsFactory.getBetterArmorSameTier(currentArmor);
            if (replacement != null && !replacement.getClass().equals(currentArmor.getClass())) {
                equipmentManager.equipArmor(replacement);
                ui.updateCombatText("Your armor upgraded to: " + replacement.getName());
                ui.armorNameLabel.setText(equipmentManager.getEquippedArmor() != null ? equipmentManager.getEquippedArmor().getName() : "None");
                newLoots.add(replacement);
            }
        }

        // Upgrade shield
        Shield currentShield = equipmentManager.getEquippedShield();
        if (currentShield != null) {
            Shield replacement = null;
            if (promoteToHigherTier) replacement = ItemsFactory.getUpgradeShieldNextTier(currentShield);
            else replacement = ItemsFactory.getBetterShieldSameTier(currentShield);
            if (replacement != null && !replacement.getClass().equals(currentShield.getClass())) {
                equipmentManager.equipShield(replacement);
                ui.updateCombatText("Your shield upgraded to: " + replacement.getName());
                ui.offHandNameLabel.setText(equipmentManager.getEquippedWeaponOffhand() != null ? equipmentManager.getEquippedWeaponOffhand().getName() : (equipmentManager.getEquippedShield() != null ? equipmentManager.getEquippedShield().getName() : "None"));
                newLoots.add(replacement);
            }
        }

        // Upgrade accessory
        Accessory currentAccessory = equipmentManager.getEquippedAccessory();
        if (currentAccessory != null) {
            Accessory replacement = null;
            if (promoteToHigherTier) replacement = ItemsFactory.getUpgradeAccessoryNextTier(currentAccessory);
            else replacement = ItemsFactory.getBetterAccessorySameTier(currentAccessory);
            if (replacement != null && !replacement.getClass().equals(currentAccessory.getClass())) {
                equipmentManager.equipAccessory(replacement);
                ui.updateCombatText("Your accessory changed to: " + replacement.getName());
                ui.accessoryNameLabel.setText(equipmentManager.getEquippedAccessory() != null ? equipmentManager.getEquippedAccessory().getName() : "None");
                newLoots.add(replacement);
            }
        }

        // --- Give a random consumable reward at the end of combat ---
        com.oopfinalproject.items.Consumable reward = com.oopfinalproject.items.ItemsFactory.getRandomConsumable();
        if (reward != null) {
            player.getInventory().addItem(reward);
            ui.updatedamageTextArea("You received a consumable: " + reward.getName());
            newLoots.add(reward);
        }

        // --- Display equipment and consumable stats to the player ---
        ui.updatedamageTextArea("=== Equipment Summary ===");
        com.oopfinalproject.items.Weapon eqMain = equipmentManager.getEquippedWeaponMainHand();
        com.oopfinalproject.items.Weapon eqOff = equipmentManager.getEquippedWeaponOffhand();
        com.oopfinalproject.items.Armor eqArmor = equipmentManager.getEquippedArmor();
        com.oopfinalproject.items.Shield eqShield = equipmentManager.getEquippedShield();
        com.oopfinalproject.items.Accessory eqAccessory = equipmentManager.getEquippedAccessory();

        if (eqMain != null) ui.updatedamageTextArea("Main: " + eqMain.getName() + " (DMG: " + eqMain.getDmg() + ") - " + eqMain.getSkillDescription());
        else ui.updatedamageTextArea("Main: None");

        if (eqOff != null) ui.updatedamageTextArea("Offhand: " + eqOff.getName() + " (DMG: " + eqOff.getDmg() + ") - " + eqOff.getSkillDescription());
        else ui.updatedamageTextArea("Offhand: " + (eqShield != null ? eqShield.getName() + " (DEF: " + eqShield.getDef() + ") - " + eqShield.getSkillDescription() : "None"));

        if (eqArmor != null) ui.updatedamageTextArea("Armor: " + eqArmor.getName() + " (DEF: " + eqArmor.getDef() + ") - " + eqArmor.getSkillDescription());
        else ui.updatedamageTextArea("Armor: None");

        if (eqAccessory != null) ui.updatedamageTextArea("Accessory: " + eqAccessory.getName() + " - " + eqAccessory.getSkillDescription());
        else ui.updatedamageTextArea("Accessory: None");

        // list consumables in inventory
        ui.updatedamageTextArea("=== Consumables in Inventory ===");
        boolean hasAny = false;
        for (com.oopfinalproject.items.Item it : player.getInventory().getItems()) {
            if (it instanceof com.oopfinalproject.items.Consumable) {
                hasAny = true;
                ui.updatedamageTextArea("- " + it.getName() + " -> " + it.getSkillDescription());
            }
        }
        if (!hasAny) ui.updatedamageTextArea("None");

        // Ensure the player panel labels are refreshed in the UI so the new items are visible
        try { ui.refreshEquipmentLabels(); } catch (Exception ignore) {}

        // Show a modal loot summary for newly-equipped items and received consumables
        if (!newLoots.isEmpty()) {
            try { ui.showLootSummary(newLoots); } catch (Exception ignore) {}
        }

        // Also refresh the player panel values (HP/MP) so labels update reliably across UI states
        try { ui.updatePlayerPanel(player.getCurrentHP(), player.getMaxHP(), player.getCurrentMP(), player.getMaxMP()); } catch (Exception ignore) {}
        enablePlayerButtons(false);

        if(onVictoryCallback != null){
            onVictoryCallback.run();
        }
        return;
    }

    enemyTurn();

    // Update panels again after enemy turn
    ui.updatePlayerPanel(player.getCurrentHP(), player.getMaxHP(), player.getCurrentMP(), player.getMaxMP());
    ui.updateEnemyPanel(enemy.getName(), enemy.getCurrentHP(), enemy.getMaxHP()); //same here

    if(player.getCurrentHP() <= 0){
        ui.updateCombatText("You have died...");
        enablePlayerButtons(false);
    }
}

    private void enemyTurn(){
        ui.updateCombatText("--- ENEMY TURN ---");
        enemy.tickStatusEffects(player);
        enemy.attack(player);

        if(dodgeMode){
            ui.updateCombatText("Dodge bonus expired.");
            player.increaseDodge(-0.25);
            dodgeMode = false;
        }
    }

    private void attackEnemy(){
        Weapon mainHand = equipmentManager.getEquippedWeaponMainHand();
        if(mainHand == null){
            ui.updateCombatText("No weapon equipped!");
            return;
        }

        int baseDamage = mainHand.getDmg() + player.getStr();
        double bonusDamage = baseDamage * player.getDamage();
        int totalDamage = baseDamage + (int)bonusDamage;

        if(Math.random() < player.getCrit()){
            totalDamage *= 2;
            ui.updateCombatText("Critical Hit!");
        }

        enemy.takeDamage(totalDamage);
        player.onDealDamage(totalDamage);
    }

    private void useSkill(){
        // Use 1 or 2 skills randomly chosen from equipped items (weapon, offhand/shield, armor, accessory)
        ui.updateCombatText("You attempt to use a skill from your equipped gear...");

        java.util.List<com.oopfinalproject.items.Item> candidates = new java.util.ArrayList<>();
        com.oopfinalproject.items.Weapon main = equipmentManager.getEquippedWeaponMainHand();
        com.oopfinalproject.items.Weapon off = equipmentManager.getEquippedWeaponOffhand();
        com.oopfinalproject.items.Shield sh = equipmentManager.getEquippedShield();
        com.oopfinalproject.items.Armor ar = equipmentManager.getEquippedArmor();
        com.oopfinalproject.items.Accessory ac = equipmentManager.getEquippedAccessory();

        if (main != null) candidates.add(main);
        if (off != null) candidates.add(off);
        // include shield as a separate candidate only if offhand weapon absent
        if (sh != null && off == null) candidates.add(sh);
        if (ar != null) candidates.add(ar);
        if (ac != null) candidates.add(ac);

        if (candidates.isEmpty()) {
            ui.updateCombatText("No equipped items with skills to use.");
            return;
        }

        int toUse = candidates.size() == 1 ? 1 : (Math.random() < 0.5 ? 1 : 2);

        java.util.List<com.oopfinalproject.items.Item> chosen = new java.util.ArrayList<>();
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < toUse; i++) {
            // pick a unique candidate
            if (candidates.isEmpty()) break;
            int idx = r.nextInt(candidates.size());
            chosen.add(candidates.remove(idx));
        }

        for (com.oopfinalproject.items.Item item : chosen) {
            String skillText = item.getSkillDescription();
            if (skillText == null || skillText.isEmpty()) skillText = "uses an odd effect";
            ui.updateCombatText("You use " + item.getName() + " skill -> " + skillText);
            // Also show the skill usage in the damage/log area so it's persistently visible
            ui.updatedamageTextArea("Skill used: " + item.getName() + " -> " + skillText);

            try {
                // Many items encode combat-y effects inside activate(player, enemy)
                // invoke it so items may apply status or other effects to the current enemy
                item.activate(player, enemy);
            } catch (Exception ex) {
                // ensure unexpected item code doesn't break combat
                ui.updateCombatText("Skill attempt failed for " + item.getName());
                ui.updatedamageTextArea("Skill error on " + item.getName() + ": " + ex.getMessage());
                System.err.println("Skill use error: " + ex);
            }
        }

        // refresh UI panels after skill effects
        ui.updatePlayerPanel(player.getCurrentHP(), player.getMaxHP(), player.getCurrentMP(), player.getMaxMP());
        ui.updateEnemyPanel(enemy.getName(), enemy.getCurrentHP(), enemy.getMaxHP());
    }

    private void dodge(){
        ui.updateCombatText("Player prepares to dodge!");
        player.increaseDodge(0.25);
        dodgeMode = true;
    }

    private void useItem(){
        // Auto-use first consumable found in player's inventory (if any)
        com.oopfinalproject.items.Inventory inv = player.getInventory();
        boolean found = false;
        // collect indices of consumables in inventory
        java.util.List<Integer> consumableIndices = new java.util.ArrayList<>();
        for (int i = 0; i < inv.size(); i++) {
            if (inv.getItems().get(i) instanceof com.oopfinalproject.items.Consumable) {
                consumableIndices.add(i);
            }
        }

        if (!consumableIndices.isEmpty()) {
            // pick a random consumable index and use it
            java.util.Random rnd = new java.util.Random();
            int pickPos = rnd.nextInt(consumableIndices.size());
            int invIndex = consumableIndices.get(pickPos);
            String usedName = inv.getItems().get(invIndex).getName();
            ui.updateCombatText("Using consumable: " + usedName);
            // useItem will remove the consumable from inventory
            inv.useItem(invIndex, player, enemy);
            ui.updatedamageTextArea("Used consumable: " + usedName);
            found = true;
        }

        if (!found) {
            // No consumable — show friendly UI notice in the damage/log area
            ui.updateCombatText("No consumables available to use.");
            ui.updatedamageTextArea("No consumable item available in your inventory.");
        }

        // Refresh panels
        ui.updatePlayerPanel(player.getCurrentHP(), player.getMaxHP(), player.getCurrentMP(), player.getMaxMP());
        ui.updateEnemyPanel(enemy.getName(), enemy.getCurrentHP(), enemy.getMaxHP());

        // Show remaining consumables to the player after use (or show none)
        ui.updatedamageTextArea("=== Consumables after use ===");
        boolean any = false;
        for (com.oopfinalproject.items.Item it : player.getInventory().getItems()) {
            if (it instanceof com.oopfinalproject.items.Consumable) {
                any = true;
                ui.updatedamageTextArea("- " + it.getName() + " -> " + it.getSkillDescription());
            }
        }
        if (!any) ui.updatedamageTextArea("None");
    }

}
