package week16;

import java.util.*;

public class ArcheryCompetition {
	
    int[] lionShotsEachScore = new int[11]; // 0~10�� �� 11�� ����
    int[] answer = {-1}; // 3) (������ ���ų� ���� ���)�� [-1]�� return 
    int max = Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {
        
        // n : ��� ȭ���� ����
        // info : ����ġ�� ������ ���� ȭ���� ����(0~10 �� 11 index)
        // ���̾��� �� ������ ���� ������ ���߰ų� �ȸ��߰ų� ���߿� �ϳ��� �ϴ� �������� ������ Ǯ�����
        // ���̾��� ����ġ�� �� ������ +1 ��ŭ �� ���߰ų� �ȸ��߰ų� �ؾ��Ѵ�.
        // �̶�, ���̾��� ���� ū ���� ���̷� ����ϱ� ���� n���� ȭ���� � ���� ������ ������ �ϴ�����            10������ 0������ ������� ���� �迭�� ��� return        
        
        // dfs(�� ȭ��߻� ����, ���̾� ȭ�� �߻�, info �迭);
        dfs(n, 1, info);
        
        // if(answer[0] == undefiend){
        //     answer[0] = -1;
        // }
        
        return answer;
    }

    public void dfs(int n, int ShotCount, int[] info){
        
        // ���� dfs���� ���̾��� �� ȭ���� ������ ȭ���̶��
        // dfs�� �����ϰ� ������ �����Ѵ�.
        if(ShotCount > n){
            int apeachScore = 0;
            int lionScore = 0;
            
            for(int i = 0; i < 11; i++) // �������� �� 11��
            {
                // 1) �� �� if�� �� ������ 10-i ���ı�
                // �� �� �Ѹ��̶� ������ ���ƴٸ�
                if(info[i] != 0 || lionShotsEachScore[i] != 0) { 
                    if(info[i] < lionShotsEachScore[i]) // ���̾��� 2��
                        lionScore += (10 - i);
                    else // ����ġ�� 2��
                        apeachScore += (10 - i);
                }
            }
            
            // ���̾��� �̰�ٸ�
            if(lionScore > apeachScore) {
                if(lionScore - apeachScore >= max)
                {
                	System.out.println("���̾� ���� in >> score :" + (lionScore - apeachScore));
                    answer = lionShotsEachScore.clone();  // 2) Ŭ�� ��ɾ��°� �ֳ�..
                    max = lionScore - apeachScore; // �γ��� �������� max�� �ֱ�
                    
                }
            }
            
            return;            
            
        }
        
        // 3) dfs ���� ���
        // 11�� ������ + �ش� ���� lion �� ���ᰳ���� info(����ġ)���� ���������� �ݺ�??
        for(int j = 0; j < 11 && lionShotsEachScore[j] <= info[j]; j++) {
        	lionShotsEachScore[j]++;
       //   System.out.println(10-j + "�� ���̾� ���ᰳ�� up >> ���ᰳ�� :" + lionShotsEachScore[j]);
            dfs(n, ShotCount + 1, info);
            lionShotsEachScore[j]--;
        }
        
    }	
    
    public static void main(String[] args) {
		
    	ArcheryCompetition ar = new ArcheryCompetition();
    	int[] inputPeach = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};	//	5
    	int[] inputPeach2 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	//	9
    	int[] inputPeach3 = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};	//	10
    	ar.solution(5, inputPeach);
    	
	}
   
}