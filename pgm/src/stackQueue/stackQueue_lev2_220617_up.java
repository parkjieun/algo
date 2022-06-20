package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class stackQueue_lev2_220617_up {
    public static void main(String[] args) {
        int bridge_length=2, weight=10;
        int[] truck_weights = {7,4,5,6};
        
        Queue<Car> waitQ = new LinkedList<>();
        Queue<Car> bridgeQ = new LinkedList<>();

        for (int t : truck_weights) {
            waitQ.offer(new Car(t));
        }

        int time = 0;
        int bridgeW = 0;

        while (!waitQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;

            //초기세팅
            if (bridgeQ.isEmpty()) {
                Car t = waitQ.poll();
                bridgeW += t.weight;
                bridgeQ.offer(t);
                continue;
            }
            //다리위에 차 전체 거리 추가
            for (Car t : bridgeQ) {
                t.moving();
            }

            //맨앞차 거리 체크
            if (bridgeQ.peek().move > bridge_length) {
                bridgeW -= bridgeQ.poll().weight;
            }

            //대기중인차 있고 대기중인차+다리위차 무게 되면,다리위에 차 올리기
            if (!waitQ.isEmpty() && bridgeW + waitQ.peek().weight <= weight) {
                Car t = waitQ.poll();
                bridgeW += t.weight;
                bridgeQ.offer(t);
            }
        }

        System.out.println("time = " + time);

    }

    static class Car {
        int weight;
        int move;

        public Car(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }
}
