package common.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import dto.BaseBallScore;
import org.junit.jupiter.api.Test;

class BaseBallCalculatorTest {

    @Test
    void 스트라이크1_볼1() {
        BaseBallScore score = BaseBallCalculator.calScore("123", "135");

        assertThat(score.getStrikeCnt()).isEqualTo(1);
        assertThat(score.getBallCnt()).isEqualTo(1);
    }

    @Test
    void 스트라이크2() {
        BaseBallScore score = BaseBallCalculator.calScore("123", "125");

        assertThat(score.getStrikeCnt()).isEqualTo(2);
        assertThat(score.getBallCnt()).isZero();
    }

    @Test
    void 볼2() {
        BaseBallScore score = BaseBallCalculator.calScore("123", "315");

        assertThat(score.getStrikeCnt()).isZero();
        assertThat(score.getBallCnt()).isEqualTo(2);
    }
}
