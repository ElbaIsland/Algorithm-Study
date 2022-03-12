package week19_queue_review;
import java.util.*;

public class TruckOnTheBridge{
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int sumOfTruckWeight = 0; // 현재다리하중
        int time = 0; // 걸린 시간
        Queue<Integer> queueBridge = new LinkedList<>();
        
        // 트럭이 이동하는데 다리길이(시간) : bridge_length
        // 다리 최대하중 : weight
        // 각 트럭별 무게를 모아놓은 배열 : truck_weights
        // bridge_length : 2, weight : 10, truck_weights : [7,4,5,6]
        // 큐를 다리라고 생각하고, 경우의 순서에 따라 작업 진행
        // (3/10 추가)
        /*
            1. 다리가 비어있다 => 트럭 진입
            2. 다리가 비어있지 않다. => 여유 자리가 있는지 확인
             2-1 ) 여유 자리가 있다 : 무게 확인 후 진입
             2-2 ) 여유 자리가 없다 : 다음 for문으로 pass, 트럭대기시간 확인후 큐에서 뺀다.
        */
        
        for(int i = 0; i < truck_weights.length; i++){
            
            int truck = truck_weights[i];   //  현재 트럭
            
						//  현재 트럭에 대한 처리(다리 안착) 완료시점까지 반복
            while(true){    
                // 1) 다리가 비어있을 경우 현재 트럭을 bridge 큐에 추가
                if(queueBridge.isEmpty())
                {
                    queueBridge.add(truck);
                    sumOfTruckWeight += truck;
                    time++;  // 트럭이 다리에 올라가는것도 1초 +로 친다..
                    break;   //  다음 for문으로 pass
                } 
                else if(queueBridge.size() == bridge_length) // 다리가 비어있지 않을 경우
                {
                    // 2) 다리길이만큼 꽉찼는지 확인
                    // 꽉 찼을경우, 처음 들어갔던 트럭을 queue에서 빼준다.
					// 이렇게만 하고 넘기는 이유 => 트럭이 내려가는 시간은 굳이 추가할 필요가 없다?
                    sumOfTruckWeight -= queueBridge.poll();                   
                }
                else{

                    // 다리에 여유 자리가 있는지 판별
                    // int spareWeight = weight - queueBridge.peek();
                    // System.out.println("spareWeight : " + spareWeight);
                    if(sumOfTruckWeight + truck > weight) // 여유자리 읍다
                    {
                        queueBridge.add(0); // 빈값을 넣어준다. 이래야 queue가 실제 다리상황처럼 움직인다.
                        time++; //  1초 기다린만큼 시간 +
                    }
                    else 
                    {
                        queueBridge.add(truck);
                    //  System.out.println("truck in bridge");
                        sumOfTruckWeight += truck;
                        time++;  // 트럭이 다리에 올라가는것도 1초 +로 친다..
                        break;   //  다음 for문으로 pass
                    }

                 }
            } // while end
 
        } // for문 end
        
        return bridge_length + time;
    }
}