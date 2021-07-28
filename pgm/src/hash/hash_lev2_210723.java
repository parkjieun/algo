package hash;

import java.util.*;

public class hash_lev2_210723 {
    public static void main(String[] args) {
        String[] phone_book = {"41146", "411467"}; //41146 length: 5
        boolean answer = true;

        HashSet<String> set = new HashSet<String>();
        for (String s: phone_book){
            set.add(s);
        }

      end:
        for(int i=0; i < phone_book.length; i++) {
            for(int j=0; j < phone_book[i].length(); j++) {
                if(set.contains(phone_book[i].substring(0,j))) {  //같은 전화번호가 중복해서 들어있지 않습니다.
                    answer = false;
                    break end;
                }
            }
        }

        System.out.println(answer);
    }
}

