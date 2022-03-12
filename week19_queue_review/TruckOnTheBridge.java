package week19_queue_review;
import java.util.*;

public class TruckOnTheBridge{
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int sumOfTruckWeight = 0; // ����ٸ�����
        int time = 0; // �ɸ� �ð�
        Queue<Integer> queueBridge = new LinkedList<>();
        
        // Ʈ���� �̵��ϴµ� �ٸ�����(�ð�) : bridge_length
        // �ٸ� �ִ����� : weight
        // �� Ʈ���� ���Ը� ��Ƴ��� �迭 : truck_weights
        // bridge_length : 2, weight : 10, truck_weights : [7,4,5,6]
        // ť�� �ٸ���� �����ϰ�, ����� ������ ���� �۾� ����
        // (3/10 �߰�)
        /*
            1. �ٸ��� ����ִ� => Ʈ�� ����
            2. �ٸ��� ������� �ʴ�. => ���� �ڸ��� �ִ��� Ȯ��
             2-1 ) ���� �ڸ��� �ִ� : ���� Ȯ�� �� ����
             2-2 ) ���� �ڸ��� ���� : ���� for������ pass, Ʈ�����ð� Ȯ���� ť���� ����.
        */
        
        for(int i = 0; i < truck_weights.length; i++){
            
            int truck = truck_weights[i];   //  ���� Ʈ��
            
						//  ���� Ʈ���� ���� ó��(�ٸ� ����) �Ϸ�������� �ݺ�
            while(true){    
                // 1) �ٸ��� ������� ��� ���� Ʈ���� bridge ť�� �߰�
                if(queueBridge.isEmpty())
                {
                    queueBridge.add(truck);
                    sumOfTruckWeight += truck;
                    time++;  // Ʈ���� �ٸ��� �ö󰡴°͵� 1�� +�� ģ��..
                    break;   //  ���� for������ pass
                } 
                else if(queueBridge.size() == bridge_length) // �ٸ��� ������� ���� ���
                {
                    // 2) �ٸ����̸�ŭ ��á���� Ȯ��
                    // �� á�����, ó�� ���� Ʈ���� queue���� ���ش�.
					// �̷��Ը� �ϰ� �ѱ�� ���� => Ʈ���� �������� �ð��� ���� �߰��� �ʿ䰡 ����?
                    sumOfTruckWeight -= queueBridge.poll();                   
                }
                else{

                    // �ٸ��� ���� �ڸ��� �ִ��� �Ǻ�
                    // int spareWeight = weight - queueBridge.peek();
                    // System.out.println("spareWeight : " + spareWeight);
                    if(sumOfTruckWeight + truck > weight) // �����ڸ� ����
                    {
                        queueBridge.add(0); // ���� �־��ش�. �̷��� queue�� ���� �ٸ���Ȳó�� �����δ�.
                        time++; //  1�� ��ٸ���ŭ �ð� +
                    }
                    else 
                    {
                        queueBridge.add(truck);
                    //  System.out.println("truck in bridge");
                        sumOfTruckWeight += truck;
                        time++;  // Ʈ���� �ٸ��� �ö󰡴°͵� 1�� +�� ģ��..
                        break;   //  ���� for������ pass
                    }

                 }
            } // while end
 
        } // for�� end
        
        return bridge_length + time;
    }
}