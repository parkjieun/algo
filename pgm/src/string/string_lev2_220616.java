package string;
//https://programmers.co.kr/learn/courses/30/lessons/60057
public class string_lev2_220616 {
    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";
        int len = s.length();
        int loopLen = s.length()/2;
        int answer = len;

        for(int i = 1; i < loopLen+1; i ++){
            String tgt = s.substring(0,i);
            String next = "";
            int cnt = 1;
            StringBuilder ans = new StringBuilder();

            for(int j=i; j<len ; j+=i){

                if(j+i > len){ //부족한경우
                    ans.append(tgt);
                    tgt = s.substring(j);
                    break;
                }
                next = s.substring(j,j+i);

                if(tgt.equals(next)){ //계속 같은 경우
                    cnt ++;
                }else{
                    ans.append(cnt > 1 ? cnt : "").append(tgt);
                    tgt = next;
                    cnt = 1;
                }
            }//end j for

            ans.append(cnt > 1 ? cnt : "").append(tgt);

            System.out.println("반복문자열: "+i+"\t 결과:" + ans.toString());
            answer = Math.min(answer,ans.length());
        }

        System.out.println("answer" + answer);
    }
}
//
//"aabbaccc"	7 - 1개 2a2ba3c
//"ababcdcdababcdcd"	9 -8개
//"abcabcdede"	8 -3개
//"abcabcabcabcdededededede"	14 -6
//"xababcdcdababcdcd"	17 -x  x/ ababcdcd / ababcdcd 로 자르는 것은 불가능


