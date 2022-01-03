package week14;

import java.util.*;

public class Immigration {
	
    
    // �̺�Ž�� �⺻ �Լ�
    public int BinarySearch(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }	
	
//	���α׷��ӽ� �̺�Ž�� : �Ա��ɻ�
//	n : �ɻ縦 ������ �� ��� ��, time[] : ���� �ɻ��(�ɻ翡 �ɸ��� �ð�)
//	��� n�� ���� ������ �ɻ縦 �޴� �ּҽð��� ���Ͻÿ�	

    public long solution(int n, int[] times) {
        // n : �ɻ���� ��� ��, times[] : �ɻ�뺰 �ɸ��� �ð�
        
        // 1) �ִ�ð� ���� ������ ������
        Arrays.sort(times); // �ɻ�뺰 �ɸ��� �ð������� ����
        long start = 0;
        long answer = 0; 
        long end = (long) n * times[times.length - 1]; // �ִ� ����� ��(���� �����ɸ��� �ɻ�뿡 ���� ����)
        
        // 2) �̺�Ž�� ����
        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            System.out.println("start : " + start + ", end : " + end + ", mid : " + mid);
            
            // �־��� �ð����� ��� �˻� �� �� �ִ��� ������
            for(int i=0; i<times.length; i++){
                sum += mid / times[i]; // ������ �ɰ� mid�� �ɻ�ð����� ������? 
                System.out.println("for in, sum : " + sum);
                if(sum >= n)
                   break;
            }
            
            // mid(�־��� �ð�)�� ���� �ɻ��� ���
            if (sum < n) { // �ؾ��� �ο����� �ɻ�ó�� ���� -> �ð� �� �ʿ�
                start = mid + 1;
            } else { // �ؾ��� �ο����� �ɻ�ó�� ������ -> �ð��� �ٿ��� �� �ְ� ����� �ð��� �����.
                end = mid - 1;
                answer = mid;
            }                 
        }        
        
        return answer;
    }  
   
}