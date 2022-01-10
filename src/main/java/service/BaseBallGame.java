package service;

import common.util.BaseBallCalculator;
import common.util.BaseBallNumGenerator;
import dto.BaseBallScore;
import nextstep.utils.Console;

public class BaseBallGame {

    public void play() {
        String randomNum = BaseBallNumGenerator.generate();

        System.out.println("origin: " + randomNum);

        System.out.println("숫자를 입력해 주세요 : ");

        String inputNum = Console.readLine();

        BaseBallScore score = BaseBallCalculator.getScore(randomNum, inputNum);

        System.out.println(score);
    }
}
