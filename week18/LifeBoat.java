package week18;

import java.util.*;

public class LifeBoat {
    
    // people : ������� ������ �迭
    // limit : ����Ʈ�� ���� ����
    // ��� ����� ���ϱ� ���� �ּ��� ����Ʈ ��(����Ʈ�� 2�ν�, 1�ε� �¿� �� �ִ�!) 
    
    public int solution(int[] people, int limit) {
        
        // 1) ���Լ����� ����
        Arrays.sort(people);
        int answer = 0;
        int index = 0;
        
        // 2) �� ������ Ǯ��! ���� ���� �� ���� = ���������� ���, �� ������ = ������ū ���
        // ���� ū �����Ժ��� �ϳ��� ���Ͽ� for���� ������ �ȴ�.
        for(int i = people.length-1; i >= index; i--){
            
            int maxWeightPerson = people[i];
            int minWeightPerson = people[index];
            System.out.println("maxWeight : " + maxWeightPerson
                               + ", minWeight : " + minWeightPerson);
            // ���� �׶� + ���� �θ��� ���� �¿� �� �ִ��� �Ǻ�
            // �Ұ����� �� 1�� �¿��.
            if(maxWeightPerson + minWeightPerson > limit){
                answer++;
            }
            else{
                index++;
                answer++;
            }
            System.out.println("for end, answer : " + answer + ", index : " + index);
        }
        
        
        return answer;
    }
}