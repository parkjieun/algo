package heap;

import java.util.PriorityQueue;


public class heap_lev2_210713_up {
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        int cnt =0; //섞은 횟수

        //PQ 값 삽입, 작은순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : scoville){
            pq.offer(i);
        }

        while(pq.size() > 1 && pq.peek() < K) {
            pq.offer(pq.poll() + pq.poll() * 2);
            cnt++;
        }

        cnt = pq.peek() < K ? -1 : cnt;

        System.out.println(cnt);
    }
}