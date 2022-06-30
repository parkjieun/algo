package stackQueue;

import java.util.Arrays;

public class phm_stackQueue_lev2_220630_주식가격_up {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i] > prices[j]){
                    answer[i] = j-i;
                    break;
                }
            }
        }

        System.out.println("answer = " + Arrays.toString(answer));
    }
}
