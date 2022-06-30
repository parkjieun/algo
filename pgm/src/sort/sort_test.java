package sort;

import java.util.Arrays;
import java.util.Comparator;

/*
omparable / Comparator 는 모두 객체를 비교하기 위한 기능의 인터페이스

두 인터페이스는 비교하는 대상이 다르다
Comparable : 호출한 자신과 매개변수 객체의 비교
Comparator : 매개변수 객체 2개 간 비교

정렬(sort)와 함께 사용 될 때
Comparable : 오름차순 정렬만 할 때 주로 사용
Comparator : 내림차순이나 특별한 기준에 따라 비교할 때 주로 사용

음수 or 0 : 교환 X
양수 : 교환 O

첫 번째 매개변수가 더 작으면 음의정수, 같으면 0, 더 크면 양의정수를 반환시키도록 한다.	(오름차순)

 */
public class sort_test {
    public static void main(String[] args) {
        String[] nums={"3", "30", "34", "5", "9"};

        Arrays.sort(nums); //오름차순
        Arrays.sort(nums, Comparator.reverseOrder()); //내림차순
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {  //o1:앞  o2:뒤
                return o1.compareTo(o2);                //오름차순
            }
        });


        System.out.println(Arrays.toString(nums));

    }
}
