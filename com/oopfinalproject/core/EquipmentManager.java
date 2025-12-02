package com.oopfinalproject.core;

import com.oopfinalproject.items.*;

public class EquipmentManager {

    private static EquipmentManager instance = new EquipmentManager();

    public static EquipmentManager getInstance() { return instance; }

    private Weapon equippedWeaponMainHand;
    private Weapon equippedWeaponOffhand;
    private Armor equippedArmor;
    private Shield equippedShield;
    private Accessory equippedAccessory;
    private Consumable heldConsumable;

    // EQUIP METHODS
    public void equipWeapon(Weapon weapon) {
        // If no main hand weapon, put it there
        if (equippedWeaponMainHand == null) {
            equippedWeaponMainHand = weapon;
            System.out.println("Equipped main hand weapon: " + weapon.getName());
            weapon.activate(Player.getInstance(), null);
            return;
        }

        // If we have a main hand but no offhand, try to equip offhand
        if (equippedWeaponOffhand == null) {
            // cannot dual-wield if a shield is currently equipped
            if (equippedShield != null) {
                System.out.println("Cannot equip a second weapon while a shield is equipped.\nPlease unequip the shield first if you want to dual-wield.");
                return;
            }

            equippedWeaponOffhand = weapon;
            System.out.println("Equipped offhand weapon: " + weapon.getName());
            weapon.activate(Player.getInstance(), null);
            return;
        }

        // If both weapon slots are taken, replace the offhand by default
        System.out.println("Offhand weapon slot was occupied (" + equippedWeaponOffhand.getName() + ") — replacing with " + weapon.getName());
        equippedWeaponOffhand = weapon;
        weapon.activate(Player.getInstance(), null);
    }

    public void equipMainHandWeapon(Weapon weapon) {
        // Always equip to main hand slot, replacing if necessary
        if (equippedWeaponMainHand != null) {
            System.out.println("Main hand weapon slot was occupied (" + equippedWeaponMainHand.getName() + ") — replacing with " + weapon.getName());
        } else {
            System.out.println("Equipped main hand weapon: " + weapon.getName());
        }
        equippedWeaponMainHand = weapon;
        weapon.activate(Player.getInstance(), null);

        
    }

    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
        System.out.println("Equipped armor: " + armor.getName());
        armor.activate(Player.getInstance(), null);
    }

    public void equipShield(Shield shield) {
        // Cannot equip a shield if player currently has an offhand weapon equipped
        if (equippedWeaponOffhand != null) {
            System.out.println("Cannot equip a shield while two weapons are equipped. Unequip the offhand weapon first.");
            return;
        }

        this.equippedShield = shield;
        System.out.println("Equipped shield: " + shield.getName());
        shield.activate(Player.getInstance(), null);
    }

    public void equipAccessory(Accessory accessory) {
        this.equippedAccessory = accessory;
        System.out.println("Equipped accessory: " + accessory.getName());
        accessory.activate(Player.getInstance(), null);
    }

    public void holdConsumable(Consumable consumable) {
        this.heldConsumable = consumable;
        System.out.println("Holding consumable: " + consumable.getName());
    }

    // USE CONSUMABLE
    public void useConsumable() {
        if (heldConsumable != null) {
            heldConsumable.activate(Player.getInstance(), null);
            System.out.println("Consumable " + heldConsumable.getName() + " used!");
            heldConsumable = null; // Remove after use
        } else {
            System.out.println("No consumable held.");
        }
    }

    // UNEQUIP METHODS
    public void unequipMainHandWeapon() {
        if (equippedWeaponMainHand != null) {
            System.out.println("Unequipped main hand weapon: " + equippedWeaponMainHand.getName());
            equippedWeaponMainHand = null;
        }
    }

    public void unequipOffhandWeapon() {
        if (equippedWeaponOffhand != null) {
            System.out.println("Unequipped offhand weapon: " + equippedWeaponOffhand.getName());
            equippedWeaponOffhand = null;
        }
    }

    public void unequipArmor() {
        if (equippedArmor != null) {
            System.out.println("Unequipped armor: " + equippedArmor.getName());
            equippedArmor = null;
        }
    }

    public void unequipShield() {
        if (equippedShield != null) {
            System.out.println("Unequipped shield: " + equippedShield.getName());
            equippedShield = null;
        }
    }

    public void unequipAccessory() {
        if (equippedAccessory != null) {
            System.out.println("Unequipped accessory: " + equippedAccessory.getName());
            equippedAccessory = null;
        }
    }


    // GETTERS
    public Weapon getEquippedWeaponMainHand() { return equippedWeaponMainHand; }
    public Weapon getEquippedWeaponOffhand() { return equippedWeaponOffhand; }
    public Armor getEquippedArmor() { return equippedArmor; }
    public Shield getEquippedShield() { return equippedShield; }
    public Accessory getEquippedAccessory() { return equippedAccessory; }

    // DISPLAY LOADOUT
    public void displayLoadout() {
        System.out.println("===== Current Loadout =====");
        System.out.println("Main Hand: " + (equippedWeaponMainHand != null ? equippedWeaponMainHand.getName() : "None"));
        System.out.println("Offhand: " + (equippedWeaponOffhand != null ? equippedWeaponOffhand.getName() : (equippedShield != null ? equippedShield.getName() : "None")));
        System.out.println("Armor: " + (equippedArmor != null ? equippedArmor.getName() : "None"));
        System.out.println("Accessory: " + (equippedAccessory != null ? equippedAccessory.getName() : "None"));
        System.out.println("===========================");
        System.out.println();
    }
}
