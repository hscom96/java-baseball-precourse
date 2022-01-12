package baseball;

import service.BaseBallGame;

public class Application {

    public static void main(String[] args) {
        BaseBallGame baseBallGame = BaseBallGame.getInstance();

        baseBallGame.play();
    }
}
