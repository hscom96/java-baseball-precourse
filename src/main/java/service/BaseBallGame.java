package service;

import common.util.BaseBallCalculator;
import common.util.BaseBallNumGenerator;
import dto.BaseBallScore;
import nextstep.utils.Console;

public class BaseBallGame {

    public void play() {
        String randomNum = BaseBallNumGenerator.generate();
        System.out.println("origin: " + randomNum);

        while (true) {
            GameStatus gameStatus = playOneRound(randomNum);

            if (gameStatus == GameStatus.SUCCESS) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
                break;
            }
        }
    }

    private GameStatus playOneRound(String randomNum) {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputNum = Console.readLine();

        BaseBallScore score = BaseBallCalculator.calScore(randomNum, inputNum);

        System.out.println(score);

        if (score.isSuccess()) {
            return GameStatus.SUCCESS;
        }

        return GameStatus.FAIL;
    }

    private enum GameStatus {
        SUCCESS,
        FAIL
    }
}
