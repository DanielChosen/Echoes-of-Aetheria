package game;

import game.handlers.ChoiceHandler;

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
        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();
    }
}
