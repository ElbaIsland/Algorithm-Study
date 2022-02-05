package week17;

public class TheMostBigWord {
    
    // * 문제 힌트 : k개의 수를 제거했을 때 가장 큰 수 + 각 자릿수는 그대로 고정
    //   => 최소한 number.length - k 값에 해당하는 각 자릿수는 남아있어야 한다.
    // ex) 4(1924) - 2 = 2, 따라서 2 中 1의자리인 4는 고정이며 나머지 1,9,2 中 최댓값 확인
    
    public String solution(String number, int k) {
        
        StringBuffer answer = new StringBuffer();
        int index = 0;
        
        // 1) k개의 수를 뺀 값(answer)의 범위만큼 반복
        // ex) 4177252841 & k : 4의 경우, 6번 반복
        for(int i = 0; i < number.length()-k; i++){
            
            int maxNum = 0;
            // 2) 각 자릿수와 maxNum 비교, 값 대체
            // 범위 시작 : 탐색해야하는 문자의 시작(index)
            // 범위 끝 : 정답의 index + k(만큼 뺀 남은 자릿수)
            // 그리고 index에는 가장 큰수 다음 index를 넣어준다.            
            for(int j = index; j <= (k+i); j++){
           //     System.out.println("체킹 자리수 : " + (k+i));
                char ch = number.charAt(j);
                int numIdx = ch - '0'; // 현재 index에 위치한 수를 int로 변환
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