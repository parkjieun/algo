package dfsBfs;

import java.util.Arrays;

public class dfsBfs_lev2_210722_up {
    static int resultSum, arr[] ;

    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        int target = 1;
        int answer = 0;

        arr = Arrays.copyOf(numbers,numbers.length);
        resultSum = target;

        answer = dfs(0,0);

        System.out.println(answer);
    }

    private static int dfs(int sum, int idx) {

        //중단
        if(idx == arr.length){
            if(sum == resultSum) {
               return 1;
            }
            return 0;
        }

        //반복
        //dfs(sum+arr[idx],idx+1);
        //dfs(sum-arr[idx],idx+1);

        return dfs(sum + arr[idx],idx+1) +  dfs(sum - arr[idx],idx+1);
    }
}
