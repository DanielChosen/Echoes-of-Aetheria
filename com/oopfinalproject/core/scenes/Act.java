package com.oopfinalproject.core.scenes;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Act (Prologue / Act1 / Act2 ...). Each Act contains multiple scenes
 * which are executed in order.
 */
public class Act {
    private final String name;
    private final List<Scene> scenes = new ArrayList<>();

    public Act(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addScene(Scene scene) { scenes.add(scene); }

    public void addScenes(Scene... s) { for (Scene sc : s) scenes.add(sc); }

    public int sceneCount() { return scenes.size(); }

    public Scene getScene(int idx) { return scenes.get(idx); }

    /** Run all scenes contained in this Act. */
    public void start() {
        System.out.println("--- Starting Act: " + name + " ---");
        for (Scene s : scenes) {
            if (s.player.getCurrentHP() <= 0) {
                System.out.println("Player is dead — stopping act progression.");
                return;
            }

            s.start();
        }
        System.out.println("--- Act completed: " + name + " ---");
    }
}
