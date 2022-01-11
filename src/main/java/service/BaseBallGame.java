package service;

import common.util.BaseBallCalculator;
import common.util.BaseBallNumGenerator;
import dto.BaseBallScore;
import nextstep.utils.Console;

/**
 * 숫자야구 게임실행 클래스
 * (하나의 게임에는 여러 라운드가 존재)
 */
public class BaseBallGame {

    public void play() {
        while (true) {
            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String startNum = Console.readLine();
            if (startNum.equals("2")) {
                break;
            }
        }
    }

    /**
     * 단일 게임 실행
     */
    private void playGame() {
        String randomNum = BaseBallNumGenerator.generate();
        System.out.println("origin: " + randomNum);

        while (true) {
            GameStatus gameStatus = playRound(randomNum);

            if (gameStatus == GameStatus.SUCCESS) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
                break;
            }
        }
    }

    /**
     * 게임 속 하나의 라운드 실행.
     * (주어진 숫자에 대한 사용자 입력을 받고 정답 여부 반환)
     *
     * @param randomNum 맞추고자 하는 숫자
     * @return 정답 여부 반환
     */
    private GameStatus playRound(String randomNum) {
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
