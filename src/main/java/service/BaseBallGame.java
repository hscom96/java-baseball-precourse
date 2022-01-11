package service;

import common.util.BaseBallCalculator;
import common.util.BaseBallNumGenerator;
import dto.BaseBallScore;
import java.util.NoSuchElementException;
import nextstep.utils.Console;

/**
 * 숫자야구 게임실행 클래스
 * (하나의 게임에는 여러 라운드가 존재)
 */
public class BaseBallGame {

    /**
     * 숫자야구 게임 실행
     */
    public void play() {
        while (true) {
            playGame();

            String startNum = inputReStart();
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
     * 단일 게임 속 하나의 라운드 실행.
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

    private String inputReStart(){
        String startInput = "";

        try{
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            startInput = Console.readLine();
            int startNum = Integer.parseInt(startInput);

            if (startInput.length() != 1 || !(startNum == 1 || startNum == 2)){
                System.out.println("[ERROR]");
                inputReStart();
            }
        }catch (NoSuchElementException | IllegalStateException | NumberFormatException ex){
            System.out.println("[ERROR]");
            inputReStart();
        }

        return startInput;
    }

    private String inputBallNum(){
        String ballInput = "";

        try{
            System.out.print("숫자를 입력해 주세요 : ");
            ballInput = Console.readLine();
            int ballNum = Integer.parseInt(ballInput);

            if (ballInput.length() != 3 || !(100 <= ballNum && ballNum <= 999)){
                System.out.println("[ERROR]");
                inputBallNum();
            }
        }catch (NoSuchElementException | IllegalStateException | NumberFormatException ex){
            System.out.println("[ERROR]");
            inputBallNum();
        }

        return ballInput;
    }

    private enum GameStatus {
        SUCCESS,
        FAIL
    }
}
