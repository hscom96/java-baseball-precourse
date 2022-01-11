package service;

import common.util.BaseBallCalculator;
import common.util.BaseBallNumGenerator;
import dto.Score;
import nextstep.utils.Console;

/**
 * 숫자야구 게임실행 클래스 (하나의 게임에는 여러 라운드가 존재)
 */
public class BaseBallGame {

    /**
     * 숫자야구 게임 실행
     */
    public void play() {
        playGame();

        String startNum = inputReStart();
        if ("1".equals(startNum)) {
            play();
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
     * 단일 게임 안에서 하나의 라운드 실행. (주어진 숫자에 대한 사용자 입력을 받고 정답 여부 반환)
     *
     * @param randomNum 맞추고자 하는 숫자
     * @return 정답 여부 반환
     */
    private GameStatus playRound(String randomNum) {
        String inputBallNum = inputBallNum();

        Score score = BaseBallCalculator.calScore(randomNum, inputBallNum);

        System.out.println(score);

        if (score.isSuccess()) {
            return GameStatus.SUCCESS;
        }

        return GameStatus.FAIL;
    }

    private String inputReStart() {
        String startInput = "";

        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            startInput = Console.readLine();

            verifyInputReStart(startInput);
        } catch (IllegalStateException | IllegalArgumentException ex) {
            System.out.println("[ERROR]");
            inputReStart();
        }

        return startInput;
    }

    private void verifyInputReStart(String startInput) {
        int startNum = Integer.parseInt(startInput);

        if (startInput.length() != 1 || !(startNum == 1 || startNum == 2)) {
            throw new IllegalArgumentException();
        }
    }

    private String inputBallNum() {
        String ballInput = "";

        try {
            System.out.print("숫자를 입력해 주세요 : ");
            ballInput = Console.readLine();

            verifyInputBallNum(ballInput);
        } catch (IllegalStateException | IllegalArgumentException ex) {
            System.out.println("[ERROR]");
            inputBallNum();
        }

        return ballInput;
    }

    private void verifyInputBallNum(String ballInput) {
        int ballNum = Integer.parseInt(ballInput);

        if (ballInput.length() != 3 || !(111 <= ballNum && ballNum <= 999)) {
            throw new IllegalArgumentException();
        }
    }

    private enum GameStatus {
        SUCCESS,
        FAIL
    }
}
