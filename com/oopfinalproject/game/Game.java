package com.oopfinalproject.game;

import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.EquipmentManager;
import com.oopfinalproject.items.ItemsFactory;
import com.oopfinalproject.game.handlers.ChoiceHandler;

public class Game {
    
    public UI ui = new UI();
    public VisibilityManager vm = new VisibilityManager(ui);
    public Story story = new Story(this, ui);

    public String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        ChoiceHandler cHandler = new ChoiceHandler(this);

        // Equip default items BEFORE creating the UI
        Player player = Player.getInstance();
        EquipmentManager eq = EquipmentManager.getInstance();

        eq.equipWeapon(ItemsFactory.TrainingSword());
        eq.equipArmor(ItemsFactory.wanderersTunic());
        eq.equipShield(ItemsFactory.woodenBuckler());
        eq.equipAccessory(ItemsFactory.shadowsWhisper());

        // Create the UI
        ui.createUI(cHandler);

        // Show title screen
        vm.showTitleScreen();

        // Update the player panel labels to reflect the equipped items
        updatePlayerPanel();
    }

    public void updatePlayerPanel() {
        Player player = Player.getInstance();
        player.setUI(ui);
        EquipmentManager eq = EquipmentManager.getInstance();

        // Update HP and MP
        ui.hpNumberLabel.setText(player.getCurrentHP() + "/" + player.getMaxHP());
        ui.mpNumberLabel.setText(player.getCurrentMP() + "/" + player.getMaxMP());

        // Update equipment
        ui.mainHandNameLabel.setText(eq.getEquippedWeaponMainHand() != null ?
                eq.getEquippedWeaponMainHand().getName() : "None");

        ui.offHandNameLabel.setText(eq.getEquippedWeaponOffhand() != null ?
                eq.getEquippedWeaponOffhand().getName() :
                (eq.getEquippedShield() != null ? eq.getEquippedShield().getName() : "None"));

        ui.armorNameLabel.setText(eq.getEquippedArmor() != null ?
                eq.getEquippedArmor().getName() : "None");

        ui.accessoryNameLabel.setText(eq.getEquippedAccessory() != null ?
                eq.getEquippedAccessory().getName() : "None");
    }


}
