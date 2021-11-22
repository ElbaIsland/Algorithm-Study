package week05;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        
        // ������ ��ȣ�� üũ�ϱ� ���� char[] �迭�� ����
        // s = "{[]}"
        char[] validChk = s.toCharArray();
        char stkVal;
        char queVal;
        
     // Stack stk = new Stack();
     // Stack���� Ÿ���� �ִ�....�̷��� ���׸����� Ÿ�������� �����ָ� object�� �ν�, �����߻��Ѵ�.
        Stack<Character> stk = new Stack<Character>();
        
        boolean isValidChk = true;
        
        // ����
        for(int i = 0; i < validChk.length; i++){
            
            char chr = validChk[i];
            System.out.println("char chr : " + chr);
            
            // �����ϴ� ��ȣ�� stack�� �־��ش�
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
        
        // ���ð� ť�� ������ ������ ��ȿ�� �˻� ����
        
        isValidChk = stk.empty();
        
        return isValidChk;
        
    }
}
