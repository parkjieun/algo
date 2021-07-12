package hash;

import java.util.HashMap;
import java.util.Map;

public class hash_lev1_210708 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = "";
        String name = "";
        int pNum = participant.length;
        int cNum = completion.length;
        Map<String,Integer> pMap = new HashMap<String,Integer>();

        for(int i=0; i<pNum ; i++){
            name = participant[i];
            if(!pMap.containsKey(name)){
                pMap.put(name,1);
            }else{
                pMap.put(name,pMap.get(name)+1);
            }
        }

        for(int i=0; i<cNum; i++){
            name = completion[i];
            pMap.put(name,pMap.get(name)-1);
        }

        for (String n : pMap.keySet()) {
            if(pMap.get(n) >= 1){
                answer = n;
                break;
            }
        }
        System.out.println(answer);


    }
}
