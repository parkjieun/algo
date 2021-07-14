package sort;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sort_lev1_210714 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        List<Integer> resultList = new ArrayList<>();
        List<Integer> copyList ;
        int start=0,end=0,k=0 ;

        //////////////////////////
        for(int i=0; i<commands.length; i++){
            copyList = new ArrayList<>(); //초기화

            //대입
            start = commands[i][0];
            end = commands[i][1];
            k = commands[i][2];

            //i-1~j-1까지 데이터 자르기
            for(int j=start-1; j<end ; j++){
                copyList.add(array[j]);
            }

            //정렬
            Collections.sort(copyList);

            //k-1뽑고 담기
            resultList.add(copyList.get(k-1));
        }

        //////////////////////////
        int[] answer = new int[resultList.size()];

        for(int i=0; i<resultList.size(); i++){
            answer[i] = resultList.get(i);
        }

        for(int i: answer){
            System.out.println(i);
        }
    }
}
