package com.oopfinalproject.core.scenes;

import java.util.ArrayList;
import java.util.List;

/**
 * SceneManager keeps an ordered list of scenes and runs them in sequence.
 * If the player dies during any scene the manager stops progression.
 */
public class SceneManager {
    private final List<Scene> scenes = new ArrayList<>();

    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    public void addScenes(Scene... toAdd) {
        for (Scene s : toAdd) scenes.add(s);
    }

    /** Run all scenes in order using the current scenes' loadouts. If player dies, stop. */
    public void startAll() {
        if (scenes.isEmpty()) {
            System.out.println("No scenes registered.");
            return;
        }

        for (Scene s : scenes) {
            // stop if player is dead
            if (s.player.getCurrentHP() <= 0) {
                System.out.println("Player is dead — stopping scene progression.");
                return;
            }

            s.start();
        }

        System.out.println("All scenes completed.");
    }

    public int sceneCount() { return scenes.size(); }

    public Scene getScene(int index) { return scenes.get(index); }
}
