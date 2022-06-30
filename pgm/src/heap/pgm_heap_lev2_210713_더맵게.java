package heap;

import java.util.*;


public class pgm_heap_lev2_210713_더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        int cnt =0; //섞은 횟수

        //PQ 값 삽입, 작은순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : scoville){
            pq.offer(i);
        }

        while(!pq.isEmpty()) {
            //LOW = 맨앞값 빼기
            int low = pq.poll();
            //K <= LOW 끝
            if (K <= low) {
                break;
            }else{
                //K > LOW, NEXT = 다음값빼기 > CNT++ > LOW + NEXT*2 = NEW 스코빌지수 PQ에 넣기(정렬)
                if(!pq.isEmpty()) {
                    int next = pq.poll();
                    cnt++;
                    pq.offer(low + next * 2);
                }else{
                    cnt = -1;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}