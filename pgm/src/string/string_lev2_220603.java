package string;

public class string_lev2_220603 {
    public static void main(String[] args) {
        //문자열
        String str = "abcabcabcabcdededededede"; //24
        int result = 1000;

        int splitSize= str.length()/2; //반복 최소 500개 ~ 최대 1000개   //12

        //큰거부터 잘라서 찾기
        for(int end = splitSize ; end> 1 ; end--){

            String startStr = str.substring(0,end);
            int endIdx = end;
            int len = 1; //문자열 길이 계산
            int lenCnt= 1;//문자열 반복 갯수 저장
            int remainStr = str.length()  - end;  //남은문자열

            while (endIdx < str.length()) //문자열 길이 끝날때 까지
            {
                String nextStr = str.substring(endIdx,endIdx*2);
                if(startStr.equals(nextStr)) {
                    lenCnt++;
                    remainStr -= end;
                }else{
                    len = lenCnt + ; // 달라졌을 때 길이 저장
                    startStr = nextStr; //비교대상 변경
                    lenCnt = 0;
                }
                endIdx *= 2;
            }//end while

            result = Math.min(len, result);
            System.out.println(end +">>>> " + result);

        }//end for

        System.out.println("result >> " + result);
    }
}