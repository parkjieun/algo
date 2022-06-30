package greedy;

import java.util.HashMap;
import java.util.HashSet;

public class pgm_greedy_lev1_210721_체육복_up {
    public static void main(String[] args) {
        int n = 10; //학생수
        int[] lost = {5,4,3,2,1}; //잃어버린 학생
        int[] reserve = {3,1,2,5,4}; //여벌 학생
        //int answer = n; //최대 학생수
        int answer = n-lost.length; //전체 - 잃어버린

        HashSet<Integer> reserveSet = new HashSet<>();

        for(int i: reserve){
            reserveSet.add(i);
        }

        for(int i=0; i<lost.length; i++){
            //내껀내가
            if(reserveSet.contains(lost[i])) {
                reserveSet.remove(lost[i]); //지워
                lost[i] = -1; //없는값으로 변경
                answer++;//구한학생
            }
        }

        for(int i=0; i<lost.length ; i++){
            if(lost[i] == -1) continue;

            if(reserveSet.contains(lost[i]-1)){
                reserveSet.remove(lost[i]-1);
                answer++;//구한학생
                //lost[i] = -1;
            }
            else if(reserveSet.contains(lost[i]+1)){
                reserveSet.remove(lost[i]+1);
                answer++;//구한학생
               // lost[i] = -1;
            }
        }

        /*for (int i : lost){
            if(i != -1) answer--;
        }*/


        System.out.println(answer);

    }
}
