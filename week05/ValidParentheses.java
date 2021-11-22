package week05;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        
        // 각각의 괄호를 체크하기 위해 char[] 배열에 저장
        // s = "{[]}"
        char[] validChk = s.toCharArray();
        char stkVal;
        char queVal;
        
     // Stack stk = new Stack();
     // Stack에도 타입이 있다....이렇게 제네릭으로 타입지정을 안해주면 object로 인식, 오류발생한다.
        Stack<Character> stk = new Stack<Character>();
        
        boolean isValidChk = true;
        
        // 스택
        for(int i = 0; i < validChk.length; i++){
            
            char chr = validChk[i];
            System.out.println("char chr : " + chr);
            
            // 시작하는 괄호를 stack에 넣어준다
            if(chr == '(' || chr == '{' || chr == '[') {
                stk.push(chr);
            }
            else if (!stk.empty() && chr == ')' && stk.peek() == '(')
            {
                stk.pop();
            }
            else if (!stk.empty() && chr == '}' && stk.peek() == '{')
            {
                stk.pop();
            }            
            else if (!stk.empty() && chr == ']' && stk.peek() == '[')
            {
                stk.pop();
            } 
            else
            {
                isValidChk = false;
                return isValidChk;
            }
            
        }
        
        // 스택과 큐의 값들을 꺼내서 유효성 검사 ㄱㄱ
        
        isValidChk = stk.empty();
        
        return isValidChk;
        
    }
}
