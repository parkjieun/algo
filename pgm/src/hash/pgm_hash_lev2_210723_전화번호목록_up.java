package hash;

import java.util.Arrays;

public class pgm_hash_lev2_210723_전화번호목록_up {
    public static void main(String[] args) {
        String[] phone_book = {"11", "13", "114", "125"};
        boolean answer = true;

        Arrays.sort(phone_book); // 효율성!!!!!!!!!! string 정렬 하면 11, 114, 125, 13 이렇게 나옴

        for(int i=0; i< phone_book.length-1; i++){
            String target = phone_book[i];
            if(phone_book[i+1].indexOf(target) == 0){
                answer = false;
                break;
            }
        }

        System.out.println(answer);
    }
}
