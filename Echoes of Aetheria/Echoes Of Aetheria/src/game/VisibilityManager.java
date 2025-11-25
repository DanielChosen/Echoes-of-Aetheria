package game;

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
    }

    public void titleToTown(){
        ui.GameTitlePanel.setVisible(false);
        ui.StartButtonPanel.setVisible(false);
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }

    public void showGameOverScreen(){
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }
}
