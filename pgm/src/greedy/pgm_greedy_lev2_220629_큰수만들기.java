package greedy;

import java.util.*;

public class pgm_greedy_lev2_220629_큰수만들기 {
    public static void main(String[] args) {
        String number ="4177252841";
        int k = 4;
        String answer = "";

        StringBuilder sb = new StringBuilder();
        sb.append(number);
        int len = number.length() - k; //return될 숫자

        List<String> sList = new ArrayList<String> (Arrays.asList(number.split("")));        //정렬
        Collections.sort(sList,Collections.reverseOrder());

        while (answer.length() < number.length() - k) {
            int idx = 0;

            while (true) {
                //  가장 큰 숫자 선택(앞에서부터)
                String max = sList.get(idx);

                //number 위치 찾기
                int nIdx = sb.indexOf(max);

                //  뒤에 남은자릿수 >= return될 숫자
                if (sb.length() - nIdx > len && !max.equals("-1") && nIdx>-1 ) {
                    //  맞으면, 첫쨰자릿수 3 (앞에제거)     x1324(7)   X123
                    sb.replace(0,nIdx+1,"X");
                    answer += max;
                    sList.remove(idx);
                    len--;
                    break;
                }else if(sb.length() - nIdx == len){ //x1234
                    answer += sb.replace(0,nIdx,"").toString();
                    break;
                }
                idx++;
                System.out.println("sb.toString() = " + sb.toString());
            }
        }
        System.out.println(">>answer = " + answer);

    }
}

/*
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건           87,754,422
number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.

입출력 예
number	        k	return
"1924"	        2	"94"
"1231234"	    3	"3234"
"4177252841"	4	"775841"
 */


//
//k개 카운트 3
//number의 길이  7
//return될 숫자 4(7-3)
//정렬 4332211
//
//    가장 큰 숫자 선택(앞에서부터) 4 > 3
//    뒤에 남은자릿수 >= return될 숫자3 (4-1)
//    맞으면, 첫쨰자릿수 3 (앞에제거) >
//    아니면, 3으로 넘어가
//    자릿수 꽉차면 끝
//