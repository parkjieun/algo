package dfsBfs;

import java.util.Arrays;

public class dfsBfs_lev2_210722 {
    static int answer, len, resultSum, arr[] ;

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        len = numbers.length;
        resultSum = target;
        arr = Arrays.copyOf(numbers,len);

        dfs(0,0);

        System.out.println(answer);
    }

    private static void dfs(int sum, int idx) {

        //중단
        if(idx == len){
            if(sum == resultSum) {
                answer++;
            }
            return;
        }

        //반복
        dfs(sum+arr[idx],idx+1);
        dfs(sum-arr[idx],idx+1);
    }
}
