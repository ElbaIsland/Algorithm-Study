package week04;

import LinkedList.ListNode;

public class PalindromeLinkedList {
    
    ListNode ref;
    
    public boolean isPalindrome(ListNode head) {
        ref = head;        
        return check(head);
    }
    
    public boolean check(ListNode node){
        
			// 1, 2, 3, 2, 1
        if(node == null){
            System.out.println("in > " + node);
            return true;  
        }
        else System.out.println("in > " + node.val);
        
        // true or false�� ���ö����� ��� �ݺ�....
				// ������ node���� return! �̶��� node���� �� ��
        boolean ans = check(node.next);
        System.out.println("����Լ� out >> node : " + node.val);
        
        // �̷��� �ϸ� ��ǻ� �ϳ��� ListNode�� �������� reverse���� �� ����
        // (ref�� ����, node�� reverse��)
        boolean isEqual = (ref.val == node.val)? true : false; 
        
        ref = ref.next; // 1 => 2
        System.out.println("next ref : " + ref.val);
        
        // ���⼭ boolean�� return�� �޾� �� ���� check(node.next) ���� ���� ����
        return ans && isEqual;
    }   
    
}
