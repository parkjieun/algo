package heap;

import java.util.Collections;
import java.util.PriorityQueue;

//우선순위 큐(Priority Queue)는 들어간 순서에 상관없이 "우선순위가 높은 데이터가 먼저 나오는 것" (최댓값,최솟값 구할 때)

//기본은 우선순위가 낮은 숫자가 부여!!!!!!!!!!!
//만약 높은 숫자가 우선순위가 되게 하고 싶다면 선언 시 Collections.reverseOrder() 메서드를 활용
public class priorityQueue {
    public static void main(String[] args) {
        //int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();

        //int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());

        //String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
        PriorityQueue<String> priorityQueue3 = new PriorityQueue<>();

        //String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
        PriorityQueue<String> priorityQueue4 = new PriorityQueue<>(Collections.reverseOrder());


        //Priority Queue 값 추가
        //add 메소드 : 삽입에 성공하면 true를 반환, 큐에 여유 공간이 없어 삽입에 실패하면 IllegalStateException을 발생
        //            우선순위 큐에 값을 추가한다면 즉시 정렬이 됩니다.
        //            값이 들어오면, 맨마지막에 넣고 부모와 비교하여 이동
        priorityQueue1.add(1);
        priorityQueue1.add(2);
        priorityQueue1.offer(3);


        //Priority Queue 값 삭제
        //값을 제거할 시 우선순위가 가장 높은 값이 제거됩니다.
        priorityQueue1.poll();       // priorityQueue에 첫번째 값을 반환하고 제거, 비어있다면 null
        priorityQueue1.remove();     // priorityQueue에 첫번째 값 제거
        priorityQueue1.clear();      // priorityQueue에 초기화


        //Priority Queue에서 우선순위가 가장 높은 값 출력
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();//int형 priorityQueue 선언
        priorityQueue.offer(2);     // priorityQueue에 값 2 추가
        priorityQueue.offer(1);     // priorityQueue에 값 1 추가
        priorityQueue.offer(3);     // priorityQueue에 값 3 추가
        priorityQueue.peek();          // priorityQueue에 첫번째 값 참조 = 1
    }
}
