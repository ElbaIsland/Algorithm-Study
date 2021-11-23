package week06;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;

        int sumOfTruckWeight = 0;
        int time = 0;    
     
        Queue<Integer> queueBridge = new LinkedList<>();

        // 트럭이 이동하는데 걸리는 시간 : bridge_length
        // bridge_length : 2, weight : 10, truck_weights : [7,4,5,6]
        // 큐를 다리라고 생각하자..?        

        for(int i = 0; i < truck_weights.length; i++){

            int truck = truck_weights[i];

						// while(true) : 특별한 일이 없는 한 계속해서 반복문 진행
            while(true){
                // 1) 다리가 비어있으면 트럭을 들인다
                if(queueBridge.isEmpty()){
                    queueBridge.add(truck);
                    sumOfTruckWeight += truck;
                    time++;
                    break;   //  다음 for문으로 pass
                }
                else if(queueBridge.size() == bridge_length){
                     //2) 다리길이만큼 꽉찼는지 확인
                    //    꽉 찼을경우 pass, 처음 들어갔던 트럭을 queue에서 빼준다.
                      sumOfTruckWeight -= queueBridge.poll();
                }
                else{   // 3) 다리가 비어있지 않으면 2

                    // 4-1)무게를 확인해 작업한다 => 현재다리가 견딜만한 무게 보유한경우
                    if(sumOfTruckWeight + truck <= weight){
                        queueBridge.add(truck);
                        sumOfTruckWeight += truck;
                        time++;
                        break;   //  다음 for문으로 pass
                    }
                    else{   // 4-2) 그러지 못할경우
                   //     sumOfTruckWeight -= queueBridge.poll();
                        queueBridge.add(0);
                        time++;
                    }                     

                } // else end            

            }// while end

        } // for문 end

    //  System.out.println("time : " + time);

        return bridge_length + time;
    }
	
}
