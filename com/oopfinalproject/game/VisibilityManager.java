package com.oopfinalproject.game;

import com.oopfinalproject.game.UI;

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userInterface){
        ui = userInterface;
    }

    public void showTitleScreen(){
        ui.GameTitlePanel.setVisible(true);
        ui.StartButtonPanel.setVisible(true);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        ui.combat_titlePanel.setVisible(false);
        ui.combat_playerPanel.setVisible(false);
        ui.combat_enemyPanel.setVisible(false);
        ui.combat_TextArea.setVisible(false);
        ui.combat_choicePanel.setVisible(false);
        ui.damageScrollArea.setVisible(false);
    }

    public void titleToTown(){
        ui.GameTitlePanel.setVisible(false);
        ui.StartButtonPanel.setVisible(false);
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);

        ui.combat_titlePanel.setVisible(false);
        ui.combat_playerPanel.setVisible(false);
        ui.combat_enemyPanel.setVisible(false);
        ui.combat_TextArea.setVisible(false);
        ui.combat_choicePanel.setVisible(false);
        ui.damageScrollArea.setVisible(false);
    }

    public void showGameOverScreen(){
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void showCombatUI(){
        ui.damageTextArea.setText("");
        ui.GameTitlePanel.setVisible(false);
        ui.StartButtonPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        ui.combat_titlePanel.setVisible(true);
        ui.combat_playerPanel.setVisible(true);
        ui.combat_enemyPanel.setVisible(true);
        ui.combat_TextArea.setVisible(true);
        ui.combat_choicePanel.setVisible(true);
        ui.damageScrollArea.setVisible(true);
    }

    
}
