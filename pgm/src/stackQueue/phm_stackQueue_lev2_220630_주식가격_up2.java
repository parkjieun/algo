package stackQueue;

import java.util.Arrays;
import java.util.Stack;

public class phm_stackQueue_lev2_220630_주식가격_up2 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] answer = new int[prices.length];

        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        beginIdxs.push(i);

        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                answer[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);//0 1
        }

        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            answer[beginIdx] = i - beginIdx - 1;
        }


        System.out.println("answer = " + Arrays.toString(answer));
    }
}
