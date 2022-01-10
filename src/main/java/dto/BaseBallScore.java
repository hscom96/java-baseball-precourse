package dto;

/**
 * 숫자야구 점수 클래스
 */
public class BaseBallScore {

    private final int strikeCnt;

    private final int ballCnt;

    private static final int SUCCESS_STRIKE_CNT = 3;

    public BaseBallScore(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public boolean isSuccess() {
        return strikeCnt == SUCCESS_STRIKE_CNT;
    }

    @Override
    public String toString() {
        String result = "";

        if (strikeCnt == 0 && ballCnt == 0) {
            return "낫싱";
        }

        if (strikeCnt > 0) {
            result += strikeCnt + "스트라이크 ";
        }

        if (ballCnt > 0) {
            result += ballCnt + "볼 ";
        }

        return result.strip();
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }
}
