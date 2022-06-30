package string;

import java.util.Arrays;
import java.util.Collections;

public class stringSort_test {
    public static void main(String[] args) {
        String number ="1231234";
        //1.문자열 내림차순정렬
        char[] arr = number.toCharArray();
        Arrays.sort(arr);

        String sorted = new StringBuilder(new String(arr)).reverse().toString();
        //String sorted = new String(arr);
        //String sorted = String.valueOf(arr);
        System.out.println(sorted);

        //2.문자열 내림차순정렬
        String[] arr2 = number.split("");
        Arrays.sort(arr2);
        Collections.reverse(Arrays.asList(arr2));
        System.out.println(String.join("",arr2));

        //3.문자열 내림차순정렬
        String[] arr3 = number.split("");
        Arrays.sort(arr3, Collections.reverseOrder());
        System.out.println(String.join("",arr3));
    }
}
