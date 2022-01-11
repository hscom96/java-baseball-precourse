package common.util;

import dto.BaseBallScore;
import java.util.HashSet;
import java.util.Set;

/**
 * 숫자야구 정답 계산 클래스
 */
public class BaseBallCalculator {

    private BaseBallCalculator() {
    }

    /**
     * 숫자 야구 정답을 계산한다.
     *
     * @param randomNum    컴퓨터가 계산한 랜덤 숫자
     * @param userInputNum 사용자가 선택한 숫자
     * @return 숫자 야구 정답
     */
    public static BaseBallScore calScore(String randomNum, String userInputNum) {
        int strikeCnt = countStrike(randomNum, userInputNum);
        int ballCnt = countBall(randomNum, userInputNum);

        return new BaseBallScore(strikeCnt, ballCnt);
    }

    /**
     * 스트라이크 숫자 계산
     */
    private static int countStrike(String randomNum, String userInputNum) {
        int strikeCnt = 0;

        for (int i = 0; i < randomNum.length(); i++) {
            String rand = randomNum.substring(i, i + 1);
            String user = userInputNum.substring(i, i + 1);

            if (rand.equals(user)) {
                strikeCnt++;
            }
        }

        return strikeCnt;
    }

    /**
     * 볼 숫자 계산
     */
    private static int countBall(String randomNum, String userInputNum) {
        int ballCnt = 0;
        Set<String> ball = new HashSet<>();

        for (int i = 0; i < randomNum.length(); i++) {
            ball.add(randomNum.substring(i, i + 1));
        }

        for (int i = 0; i < randomNum.length(); i++) {
            String rand = randomNum.substring(i, i + 1);
            String user = userInputNum.substring(i, i + 1);

            if (rand.equals(user)) {
                continue;
            }

            if (ball.contains(user)) {
                ballCnt++;
            }
        }

        return ballCnt;
    }
}
