package common.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseBallNumGeneratorTest {

    @Test
    void 랜덤숫자생성_성공(){
        String randomNum = BaseBallNumGenerator.generate();

        assertThat(randomNum).hasSize(3);
        assertThat(Integer.valueOf(randomNum.substring(0,1))).isBetween(1, 9);
        assertThat(Integer.valueOf(randomNum.substring(1,2))).isBetween(1, 9);
        assertThat(Integer.valueOf(randomNum.substring(2,3))).isBetween(1, 9);
    }
}
