package sort;

import java.util.*;

//동일한 숫자가 입력될 수 있다.
//테스트케이스 부족
public class sort_lev2_220621 {
    public static void main(String[] args) {//21,212], [30,303
        int[] numbers = { 34 , 3, 30};
        String[] nums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        //Arrays.sort(nums, Comparator.reverseOrder()); 내림차순
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String  a, String b) {
                //a: 3      30
                //b : 34    3
                String sum = a+b;
                String reverseSum=b+a;

                System.out.println("a +\", \"+b = " + a +", "+b);
                return reverseSum.compareTo(sum);//내림차순 98-89 > 0 : 9(b)가 뒤로 이동
                //return sum.compareTo(reverseSum);//오름차순 89-98 < 0 :  9(a)가 앞으로 이동
            }
        });
        String answer;
 
        if ("0".equals(nums[0])) { // means "0000"
            answer = "0";
        } else {
            StringBuilder sb = new StringBuilder();
 
            for (String num : nums) {
                sb.append(num);
            }
 
            answer = sb.toString();
        }
        System.out.println("answer = " + answer);
    }
}

//
// 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
// 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
// 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
//
// 제한 사항
// numbers의 길이는 1 이상 100,000 이하입니다.
// numbers의 원소는 0 이상 1,000 이하입니다.
// 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
// 입출력 예
// numbers	return
// [6, 10, 2]	"6210"
// [3, 30, 34, 5, 9]	"9534330"