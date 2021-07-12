package stackQueue;

import java.util.LinkedList;
import java.util.Queue;


public class stackQueue_lev2_210712 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        Queue<Integer> workTimeQueue = new LinkedList<Integer>();
        LinkedList<Integer> remainPgsList = new LinkedList<>();
        int mNum = progresses.length;
        LinkedList<Integer> resultList = new LinkedList<>();

        //1. 남은 진도

        for(int i : progresses){
            remainPgsList.add(100-i);
        }

        //2. 남은 진도/스피드 = 작업일
        for (int i=0; i<mNum; i++){
            workTimeQueue.offer(remainPgsList.get(i)%speeds[i] >0 ? remainPgsList.get(i)/speeds[i] +1 : remainPgsList.get(i)/speeds[i]);
        }

        //3. 작업일 계산(뒤에 있는 작업일이 크면 pass, 작으면 +1)
        int cur = workTimeQueue.poll(); //현재
        int cnt = 1;

        while (!workTimeQueue.isEmpty()){
            int next = workTimeQueue.peek(); //다음
            if(cur >= next){
                cnt+=1;
                workTimeQueue.poll(); //다음 지우기
            }else{
                resultList.add(cnt);
                cur = workTimeQueue.poll(); //다음을 현재로
                cnt = 1;
            }
        }


        resultList.add(cnt);//마지막막


        int[] answer = new int[resultList.size()];

        for (int i=0 ; i <resultList.size(); i ++){
           answer[i] = resultList.get(i);
            System.out.println(answer[i]);
        }


    }
}
