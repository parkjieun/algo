package sort;

import com.sun.management.VMOption;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.String.*;

//동일한 숫자가 입력될 수 있다.
//테스트케이스 부족
public class sort_lev2_220621 {
    public static void main(String[] args) {
//        999 9 34 3 30 1 1000 0
//        9 999 34 3 30 1 1000 0
        //{34, 342} 34234 < 34342
        //{3, 330} 3303 < 3330
        //a,b
        //c= b.substring(a.length,a.length+1)
        //a > c 내림차순
        //{3, 300} 3003 < 3300
        //{3, 30} 303 < 330
        //{3, 34} 343 > 334
        //{4, 43} 434 < 443
        //{40, 403} 40340 < 40403
        //{40, 404}
        //{40, 405} 40540 > 40405
        //{12, 121} 12112  > 12121
        //{2, 22, 223}
        //{21, 212}
        //{41, 415}
        //{0, 0, 0, 0}

        int[] numbers = {  30  ,    34, 3};
        Arrays.sort(numbers); //3, 30 ,34
        String answer = "";
        List<Pair> list = new ArrayList<>();
        for(int cur : numbers){
            int len = valueOf(cur).length();

            if(cur<10) cur*=1000;
            else if(cur<100) cur*=100;
            else if(cur<1000) cur*=10;

            Pair p = new Pair(valueOf(cur==0?"0000":cur),len);
            list.add(p);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        boolean chk = true;

        for(Pair p : list) {
            String num = valueOf(p.num).substring(0,p.origin);
            sb.append(num);
            if(!num.equals("0")){
                chk=false;
            }
        }

        System.out.println(chk?"0":sb.toString());
    }

    public static class Pair implements Comparable<Pair>{
        String num;
        int origin;

        Pair(String num, int origin){
            this.num = num;
            this.origin = origin;
        }

        public String getNum(){
            return num;
        }


        public int getOrigin(){
            return origin;
        }
//3     30      34
//3000  3000    3400
        //30 3 34
        @Override
        public int compareTo(Pair o) {
            String a = o.getNum(); //3 30
            String b = this.getNum(); //30 34

            //3000,2 3400,2
            if(a.substring(0,1) != b.substring(0,1)){
                return b-a;  // return값이 0이나 음수이면 자리바꿈을 하지 않고(내림차순정렬), 양수이면 자리바꿈을 수행(오름차순정렬)
            }
            //3 32      3 34
            //3|32      34|3
            //32 321    32 324
            //32|321    32432
           if (a/1000 == b/1000) {//3000 3400
               b = Integer.parseInt(getNum().substring(0, 1)); //3 3
               a = Integer.parseInt(o.getNum().substring(o.getOrigin()-1, o.getOrigin()));//3 0
                System.out.println("b = " + b); //0
            }
            return b-a;
        }
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