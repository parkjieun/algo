package stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class stackQueue_lev2_210712_up {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        Queue<Integer> workTimeQueue = new LinkedList<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();

        for (int i=0; i<progresses.length; i++){
            double remain = 100-progresses[i]/(double)speeds[i]; 
            int date = (int) Math.ceil(remain);

            //q에 사람넣고s size체크
            if(!workTimeQueue.isEmpty() && workTimeQueue.peek() < date){
                resultList.add(workTimeQueue.size());
                workTimeQueue.clear();
            }
            
            workTimeQueue.offer(date);
        }

        resultList.add(workTimeQueue.size());//마지막

        int[] answer = new int[resultList.size()];

        for (int i=0 ; i <resultList.size(); i ++){
           answer[i] = resultList.get(i);
           System.out.println(answer[i]);
        }
    }
}
