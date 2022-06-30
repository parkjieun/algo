package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pgm_sort_lev1_210714_K번째수_up {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int start=0,end=0,k=0,idx=0 ;
        int[] answer = new int[commands.length];
        int[] copyArr;

        //////////////////////////
        for(int[] arr : commands){
            //대입
            start = arr[0];
            end = arr[1];
            k = arr[2];

            copyArr = Arrays.copyOfRange(array,start-1,end);
            Arrays.sort(copyArr);
            answer[idx] = copyArr[k-1];
            idx++;
        }
        //////////////////////////
        for(int i: answer){
            System.out.println(i);
        }
    }
}
