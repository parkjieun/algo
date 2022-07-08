package hash;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class hash_test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        //map.getOrDefault('key','기본값'); //- 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
        Map<Integer,Integer> map2 = new HashMap<>();
        int max = Collections.max(map2.keySet());//달받은 Set에서 가장 큰 값을 찾아서 리턴
        Collections.max(map2.values());//가장 큰 value 값을 찾아서 출력

    }
}
