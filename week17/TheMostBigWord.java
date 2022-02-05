package week17;

public class TheMostBigWord {
    
    // * ���� ��Ʈ : k���� ���� �������� �� ���� ū �� + �� �ڸ����� �״�� ����
    //   => �ּ��� number.length - k ���� �ش��ϴ� �� �ڸ����� �����־�� �Ѵ�.
    // ex) 4(1924) - 2 = 2, ���� 2 �� 1���ڸ��� 4�� �����̸� ������ 1,9,2 �� �ִ� Ȯ��
    
    public String solution(String number, int k) {
        
        StringBuffer answer = new StringBuffer();
        int index = 0;
        
        // 1) k���� ���� �� ��(answer)�� ������ŭ �ݺ�
        // ex) 4177252841 & k : 4�� ���, 6�� �ݺ�
        for(int i = 0; i < number.length()-k; i++){
            
            int maxNum = 0;
            // 2) �� �ڸ����� maxNum ��, �� ��ü
            // ���� ���� : Ž���ؾ��ϴ� ������ ����(index)
            // ���� �� : ������ index + k(��ŭ �� ���� �ڸ���)
            // �׸��� index���� ���� ū�� ���� index�� �־��ش�.            
            for(int j = index; j <= (k+i); j++){
           //     System.out.println("üŷ �ڸ��� : " + (k+i));
                char ch = number.charAt(j);
                int numIdx = ch - '0'; // ���� index�� ��ġ�� ���� int�� ��ȯ
           //     System.out.println("maxNum chk > maxNum : " + maxNum + ", numIdx : " + numIdx);
                if(maxNum < numIdx){
                    maxNum = numIdx;
                    index = j+1; // ??
                }
            }
            answer.append(maxNum);
        }
        
        return answer.toString();
    }
    
}