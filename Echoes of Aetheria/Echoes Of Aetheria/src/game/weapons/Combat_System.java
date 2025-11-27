import java.util.Scanner;
import java.util.ArrayList;

public class Combat_System {

    private Player player;
    private Enemy enemy;
    private Weapon weapon;
    private Armor armor;
    private Shield shield;
    private Accessory accessory;
    private Inventory inventory;

    private boolean dodgeMode = false;

    public Combat_System(Player player, Enemy enemy,
                        Weapon weapon, Armor armor,
                        Shield shield, Accessory accessory,
                        Inventory inventory) {
        this.player = player;
        this.enemy = enemy;
        this.weapon = weapon;
        this.armor = armor;
        this.shield = shield;
        this.accessory = accessory;
        this.inventory = inventory;
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("⚔️ BATTLE START: " + enemy.getName() + " appears!");

        while (player.getCurrentHP() > 0 && !enemy.isDead()) {
            System.out.println("\n--- PLAYER TURN ---");
            System.out.println("1. Attack");
            System.out.println("2. Skill");
            System.out.println("3. Dodge");
            System.out.println("4. Item");
            System.out.print("Choose action: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> attackEnemy();
                case 2 -> useSkill(scanner);
                case 3 -> dodge();
                case 4 -> useItem(scanner);
                default -> System.out.println("Invalid choice!");
            }

            if (enemy.isDead()) {
                System.out.println("\nEnemy defeated!");
                break;
            }

            // Enemy Turn
            System.out.println("\n--- ENEMY TURN ---");
            enemy.attack(player);

            if (dodgeMode) {
                System.out.println("Dodge bonus expired.");
                player.increaseDodge(-0.25);
                dodgeMode = false;
            }

            if (player.getCurrentHP() <= 0) {
                System.out.println("\nYou have died...");
            }
        }
    }

    private void attackEnemy() {
        int baseDamage = weapon.dmg + player.getStr();
        double bonusDamage = baseDamage * player.getDamage();

        int totalDamage = baseDamage + (int) bonusDamage;

        // Critical hit
        if (Math.random() < player.getCrit()) {
            totalDamage *= 2;
            System.out.println("Critical Hit!");
        }

        enemy.takeDamage(totalDamage);
    }

    private void useSkill(Scanner scanner) {
        System.out.println("Choose skill source:");
        System.out.println("1. Weapon");
        System.out.println("2. Armor");
        System.out.println("3. Shield");
        System.out.println("4. Accessory");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> weapon.activate(player);
            case 2 -> armor.activate(player);
            case 3 -> shield.activate(player);
            case 4 -> accessory.activate(player);
            default -> System.out.println("Invalid skill choice.");
        }
    }

    private void dodge() {
        System.out.println("Player prepares to dodge!");
        player.increaseDodge(0.25);
        dodgeMode = true;
    }

    private void useItem(Scanner scanner) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("Choose item:");
        inventory.showItems();

        int choice = scanner.nextInt();
        inventory.useItem(choice - 1, player);
    }
}

// Inventory class
public class Inventory {
    private ArrayList<Consumable> items = new ArrayList<>();

    public void addItem(Consumable item) {
        items.add(item);
    }

    public void showItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + items.get(i).name);
        }
    }

    public void useItem(int index, Player player) {
        if (index >= 0 && index < items.size()) {
            items.get(index).activate(player);
            items.remove(index);
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

//Add na lang enemy class rito