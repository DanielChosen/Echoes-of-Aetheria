package com.oopfinalproject.game.handlers;

import com.oopfinalproject.game.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandler implements ActionListener {

    Game game;

    public ChoiceHandler(Game gameInstance){
        this.game = gameInstance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        if (yourChoice != null && !yourChoice.isEmpty()) {
            game.story.selectPosition(yourChoice);
        }
    }
}
