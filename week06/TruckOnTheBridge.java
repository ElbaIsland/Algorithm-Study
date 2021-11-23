package week06;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;

        int sumOfTruckWeight = 0;
        int time = 0;    
     
        Queue<Integer> queueBridge = new LinkedList<>();

        // Ʈ���� �̵��ϴµ� �ɸ��� �ð� : bridge_length
        // bridge_length : 2, weight : 10, truck_weights : [7,4,5,6]
        // ť�� �ٸ���� ��������..?        

        for(int i = 0; i < truck_weights.length; i++){

            int truck = truck_weights[i];

						// while(true) : Ư���� ���� ���� �� ����ؼ� �ݺ��� ����
            while(true){
                // 1) �ٸ��� ��������� Ʈ���� ���δ�
                if(queueBridge.isEmpty()){
                    queueBridge.add(truck);
                    sumOfTruckWeight += truck;
                    time++;
                    break;   //  ���� for������ pass
                }
                else if(queueBridge.size() == bridge_length){
                     //2) �ٸ����̸�ŭ ��á���� Ȯ��
                    //    �� á����� pass, ó�� ���� Ʈ���� queue���� ���ش�.
                      sumOfTruckWeight -= queueBridge.poll();
                }
                else{   // 3) �ٸ��� ������� ������ 2

                    // 4-1)���Ը� Ȯ���� �۾��Ѵ� => ����ٸ��� �ߵ����� ���� �����Ѱ��
                    if(sumOfTruckWeight + truck <= weight){
                        queueBridge.add(truck);
                        sumOfTruckWeight += truck;
                        time++;
                        break;   //  ���� for������ pass
                    }
                    else{   // 4-2) �׷��� ���Ұ��
                   //     sumOfTruckWeight -= queueBridge.poll();
                        queueBridge.add(0);
                        time++;
                    }                     

                } // else end            

            }// while end

        } // for�� end

    //  System.out.println("time : " + time);

        return bridge_length + time;
    }
	
}
