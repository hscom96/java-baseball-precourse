package dto;

public class BaseBallScore {

    private final int strikeCnt;

    private final int ballCnt;

    public BaseBallScore(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    @Override
    public String toString() {
        String result = "";

        if(strikeCnt == 0 || ballCnt == 0){
            return "낫싱";
        }

        if(strikeCnt > 0){
            result += strikeCnt + "스트라이크 ";
        }

        if(ballCnt > 0){
            result += ballCnt + "볼 ";
        }

        return result;
    }
}
