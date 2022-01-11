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

    /**
     * 정답 여부를 반환한다.
     */
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

        return result.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseBallScore)) {
            return false;
        }
        BaseBallScore score = (BaseBallScore) o;
        return score.strikeCnt == strikeCnt && score.ballCnt == ballCnt;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(strikeCnt);
        result += 31 * result + Integer.hashCode(ballCnt);
        return result;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }
}
