package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class greedy_lev1_210721 {
    public static void main(String[] args) {
        int n = 10; //학생수
        int[] lost = {5,4,3,2,1}; //잃어버린 학생
        int[] reserve = {3,1,2,5,4}; //여벌 학생
        int answer = n; //최대 학생수

        //여벌학생 = 잃어버린학생 잇으면 각각 빼기
        for(int i=0 ; i<lost.length; i++){
            for(int j=0 ; j<reserve.length; j++){
                if(reserve[j] == -1)    continue; //break 였는데 continue로 변경! 왜냐면, 배열값은 정렬되있지않기때문에!!!!!

                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        //2. lost for문 > +1-1 해서 reserve 값 잇는지 찾기
        for(int i=0 ; i<lost.length; i++){
            if(lost[i] == -1)   continue;

            for(int j=0 ; j<reserve.length; j++){
                if(reserve[j] == -1)   continue;

                if((lost[i]+1) == reserve[j] || (lost[i]-1) == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        //남은 lost 구하기
        int cnt = 0;
        for(int i : lost){
            if(i != -1) cnt++;
        }
        answer -= cnt;
        System.out.println(answer);

    }
}
