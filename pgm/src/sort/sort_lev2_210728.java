package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sort_lev2_210728 {
    public static void main(String[] args) {
        int[] numbers={3, 30, 34, 5, 9};
        String[] g = {"3","30","303"};
        //330303
        //330330

        //9, 91, 915,

        //9 91 915 *
        //9 915 91

        //3, 30, 303
        //3 30 303
        //3 303 30 *

        //3, 30, 302
        //3 30 302 *
        //3 302 30

        //큰숫자가 앞에
        //앞 동일한 숫자일 경우, 다음 숫자 비교해서 큰게 앞에, 같으면 길이가 짧은게 앞에 오게

        String answer= ""; //9534330
        Arrays.sort(g);

        System.out.println(Arrays.toString(g));

    }
}
