package dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class BaseBallScoreTest {

    @Test
    void 스트라이크1(){
        BaseBallScore baseBallScore = new BaseBallScore(1,0);

        assertThat(baseBallScore.toString()).isEqualTo("1스트라이크");
    }

    @Test
    void 볼1(){
        BaseBallScore baseBallScore = new BaseBallScore(0, 1);

        assertThat(baseBallScore.toString()).isEqualTo("1볼");
    }

    @Test
    void 스트라이크1_볼2(){
        BaseBallScore baseBallScore = new BaseBallScore(1,2);

        assertThat(baseBallScore.toString()).isEqualTo("1스트라이크 2볼");
    }

    @Test
    void 낫싱(){
        BaseBallScore baseBallScore = new BaseBallScore(0,0);

        assertThat(baseBallScore.toString()).isEqualTo("낫싱");
    }
}
