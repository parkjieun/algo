package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

//"일차선 다리"  & 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며 == 다리 길이
//1초에 1칸씩 유추
public class pgm_stackQueue_lev2_220617_다리를지나는트럭 {
    public static void main(String[] args) {

        int bridge_length=2, weight=10;
        int[] truck_weights = {7,4,5,6};
        Queue<Integer> waitQ = new LinkedList<>();  //대기중인 차
        Queue<Car> bridgeQ = new LinkedList<>();    //다리위에 있는 차

        for (int num:truck_weights) {
            waitQ.offer(num);
        }

        //처음 세팅
        int time=0;
        int bridgeW = 0; //다리위에 차 무게

        while(true){
            time++; //시간

            //종료시점 (대기중인 차 없고 다리위에 차 없을 경우)
            if(waitQ.peek() == null && bridgeQ.peek() == null ) break;

            //대기중인 차 있을 경우
            if(!waitQ.isEmpty()){
                int w = waitQ.peek();

                if(bridgeW+w <= weight && bridgeQ.size()+1 <= bridge_length){
                    bridgeQ.offer(new Car(w,0)); //다리위에차 추가
                    bridgeW += w; //다리위에차 추가
                    waitQ.poll(); //대기중인차 제거
                }
            }

            //다리위에 차 전체 거리 추가
            for(int i=0; i<bridgeQ.size(); i++){
                Car c = bridgeQ.poll();
                bridgeQ.offer(new Car(c.weight,++c.distance));
            }

            //맨앞차 거리 체크
            if(bridgeQ.peek().distance == bridge_length){
                bridgeW -= bridgeQ.poll().weight;
            }
        }
        System.out.println("time = " + time);

    }

    public static class Car{
        int weight;
        int distance;

        Car(int weight, int distance){
            this.weight = weight;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "weight=" + weight +
                    ", distance=" + distance +
                    '}';
        }
    }
}

    /*



    트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
    모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
    다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
    단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

    예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
    무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

    경과 시간   다리를 지난 트럭   다리를 건너는 트럭      대기 트럭
    0	           []	            []	            [7,4,5,6]
    1~2	           []	            [7]	            [4,5,6]
    3	           [7]	            [4]	            [5,6]
    4	           [7]	            [4,5]	        [6]
    5	           [7,4]	        [5]	            [6]
    6~7	           [7,4,5]	        [6]	            []
    8	           [7,4,5,6]	    []	            []


    따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
    solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
    이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

    제한 조건
    bridge_length는 1 이상 10,000 이하입니다.
    weight는 1 이상 10,000 이하입니다.
    truck_weights의 길이는 1 이상 10,000 이하입니다.
    모든 트럭의 무게는 1 이상 weight 이하입니다.

    입출력 예
    bridge_length	weight	truck_weights	                    return
    2	            10	        [7,4,5,6]	                    8
    100	            100	        [10]	                        101
    100	            100	        [10,10,10,10,10,10,10,10,10,10]	110

    * */