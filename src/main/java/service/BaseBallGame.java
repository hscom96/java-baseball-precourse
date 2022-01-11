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

            String startNum = inputStart();
            if ("2".equals(startNum)) {
                break;
            }
        }
    }

    /**
     * 단일 게임 실행
     */
    private void playGame() {
        String randomNum = BaseBallNumGenerator.generate();

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
        String inputBallNum = inputBallNum();

        BaseBallScore score = BaseBallCalculator.calScore(randomNum, inputBallNum);

        System.out.println(score);

        if (score.isSuccess()) {
            return GameStatus.SUCCESS;
        }

        return GameStatus.FAIL;
    }

    private String inputStart(){
        String startNum;
        while(true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            startNum = Console.readLine();

            if (startNum.length() == 1)
                break;

            System.out.println("[ERROR]");
        }
        return startNum;
    }

    private String inputBallNum(){
        String ballNum;
        while(true) {
            System.out.print("숫자를 입력해 주세요 : ");

            ballNum = Console.readLine();

            if (ballNum.length() == 3)
                break;

            System.out.println("[ERROR]");
        }
        return ballNum;
    }

    private enum GameStatus {
        SUCCESS,
        FAIL
    }
}
