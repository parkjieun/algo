package hash;

import java.util.HashMap;

//String[] array = map.keySet().toArray(new String[map.size()]);

//a:2 b:1 c:2
//3(사용안함포함)*2(사용안함포함)*3(사용안함포함) -1(전체사용안함)

public class pgm_hash_lev2_220617_위장 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "headgear2"}, {"green_turban", "headgear"}};
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            String gubun = clothes[i][1];
            map.put(gubun,(map.containsKey(gubun)?map.get(gubun)+1:2)); //초기값 2!!!!!!!사용안했을 경우!!!
        }
        System.out.println("map.toString() = " + map.toString());
        //map = {headgear=3, headgear2=2}

        for (String key:map.keySet()) {
            answer *= map.get(key);
        }
        answer--; //전체 다 사용 안할 경우
        System.out.println("ans = " + answer);

    }
}

