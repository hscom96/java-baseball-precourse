package common.util;

import java.util.HashSet;
import java.util.Set;
import nextstep.utils.Randoms;

/**
 * 숫자야구 게임 랜덤 숫자 생성 클래스
 */
public class BaseBallNumGenerator {

    private BaseBallNumGenerator() {
    }

    private static final int LENGTH_NUM = 3;
    private static final int START_EACH_NUM = 1;
    private static final int END_EACH_NUM = 9;

    /**
     * 숫자야구 랜덤한 숫자 생성한다.
     *
     * @return 1부터 9까지의 서로 다른 수로 이루어진 3 자리의 수
     */
    public static String generate() {
        StringBuilder result = new StringBuilder();
        Set<Integer> duplicate = new HashSet<>();

        generateInRange(result, 0, duplicate);

        return result.toString();
    }

    private static StringBuilder generateInRange(StringBuilder num, int depth, Set<Integer> duplicate) {
        if (depth == LENGTH_NUM) {
            return num;
        }

        int randomNum = Randoms.pickNumberInRange(START_EACH_NUM, END_EACH_NUM);

        if(duplicate.contains(randomNum)){
            return null;
        }

        num.append(randomNum);
        duplicate.add(randomNum);

        StringBuilder result = null;
        while (result == null){
            result = generateInRange(num, depth + 1, duplicate);
        }

        return result;
    }
}
