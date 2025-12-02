package com.oopfinalproject.items;

import java.util.ArrayList;
import java.util.List;
import com.oopfinalproject.core.Player;
import com.oopfinalproject.core.Enemy;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    private final int MAX_CAPACITY = 10;

    public void addItem(Item item) {
        if (items.size() >= MAX_CAPACITY) {
            System.out.println("Inventory is full. Cannot add: " + item.getName());
            return;
        }
        items.add(item);
    }

    public void showItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + items.get(i).getName());
        }
    }

    public void useItem(int index, Player player, Enemy enemy) {
        if (index >= 0 && index < items.size()) {
            Item item = items.get(index);
            item.activate(player, enemy);
            if (item instanceof Consumable) {
                items.remove(index);
            }
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public List<Item> getItems() {
        return items;
    }

    public void showConsumables() {
        System.out.println("Current Consumables:");
        boolean hasConsumables = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Consumable) {
                System.out.println((i+1) + ". " + items.get(i).getName());
                hasConsumables = true;
            }
        }
        if (!hasConsumables) {
            System.out.println("None");
        }
    }
}
