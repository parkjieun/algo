package stackQueue;

import java.util.*;


public class stackQueue_lev2_210728 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i< priorities.length; i++){
            if(i==location) q.offer(-1);
            else q.offer(priorities[i]);
            list.add(priorities[i]);
        }
        Collections.sort(list);

        int answer = 0;
        int val = priorities[location];

        while(!q.isEmpty()){

            //q뽑고 제거
            int cur = q.poll();
            int max =  list.get(list.size()-1);

            if(cur==-1 && val==max){
                //뽑은 값이 최댓값인데 타겟이면 answer+1 끝내기.
                answer++;
                break;
            }
            else if(cur==max){
                //뽑은 값이 최댓값이면 , answer+1
                answer++;
                list.remove(list.size()-1);
            }
            else{
                //뽑은 값이 최댓값이 아니면 다시 넣기
                q.offer(cur);
            }
        }
        System.out.println(">>"+answer);

    }
}
