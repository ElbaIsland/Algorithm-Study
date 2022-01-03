package week14;

import java.util.*;

public class Immigration {
	
    
    // 이분탐색 기본 함수
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
	
//	프로그래머스 이분탐색 : 입국심사
//	n : 심사를 받으러 온 사람 수, time[] : 각각 심사대(심사에 걸리는 시간)
//	모든 n이 가장 빠르게 심사를 받는 최소시간을 구하시오	

    public long solution(int n, int[] times) {
        // n : 심사받을 사람 수, times[] : 심사대별 걸리는 시간
        
        // 1) 최대시간 정해 반으로 나누기
        Arrays.sort(times); // 심사대별 걸리는 시간순으로 정리
        long start = 0;
        long answer = 0; 
        long end = (long) n * times[times.length - 1]; // 최대 경우의 수(가장 오래걸리는 심사대에 전부 몰림)
        
        // 2) 이분탐색 시작
        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            System.out.println("start : " + start + ", end : " + end + ", mid : " + mid);
            
            // 주어진 시간동안 몇명 검사 할 수 있는지 누적합
            for(int i=0; i<times.length; i++){
                sum += mid / times[i]; // 반으로 쪼갠 mid를 심사시간으로 나누면? 
                System.out.println("for in, sum : " + sum);
                if(sum >= n)
                   break;
            }
            
            // mid(주어진 시간)을 각각 심사한 결과
            if (sum < n) { // 해야할 인원보다 심사처리 못함 -> 시간 더 필요
                start = mid + 1;
            } else { // 해야할 인원보다 심사처리 많이함 -> 시간을 줄여서 더 최고 경우의 시간을 만든다.
                end = mid - 1;
                answer = mid;
            }                 
        }        
        
        return answer;
    }  
   
}