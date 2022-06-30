package greedy;

import java.util.*;

// 해당 문제는 주어진 k 만큼 왼쪽 부터 제거해서 나온 큰 수를 구하는 문제입니다.
public class pgm_greedy_lev2_220630_큰수만들기_up {
    public static void main(String[] args) {
        String number ="12435234";
        int k = 4;

        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);  //1 2 3 1 2
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {//2 1 0
                stack.pop(); //1 2 2
            }
            stack.push(c);//1 2 3 1
        }

        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }

        System.out.println("result = " + new String(result));
    }
}