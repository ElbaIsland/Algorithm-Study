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
        
        // true or false가 나올때까지 계속 반복....
				// 마지막 node에서 return! 이때의 node값은 맨 뒤
        boolean ans = check(node.next);
        System.out.println("재귀함수 out >> node : " + node.val);
        
        // 이렇게 하면 사실상 하나의 ListNode로 원래값과 reverse값을 비교 가능
        // (ref는 정상, node는 reverse값)
        boolean isEqual = (ref.val == node.val)? true : false; 
        
        ref = ref.next; // 1 => 2
        System.out.println("next ref : " + ref.val);
        
        // 여기서 boolean값 return을 받아 그 다음 check(node.next) 이후 로직 진행
        return ans && isEqual;
    }   
    
}
