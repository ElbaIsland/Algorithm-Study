package week05;

import LinkedList.ListNode;

public class OddEvenLinkedList {
	
    public ListNode oddEvenList(ListNode head) {
        
				if(head == null || head.next == null){
	            return head;
	        }
				// 1,2,3,4,5,6
        ListNode hole = head; 
        ListNode chack= head.next;
        ListNode chackHeadWhy = chack; // �� �̷��� �����ؾ� �ϴ°���???
				
        while(hole != null && chack != null && chack.next != null){    
            hole.next = hole.next.next; // hole = 1,3,4,5,6
            chack.next = chack.next.next; // chack = 2,4,5,6

            hole = hole.next;   // 3,4,5,6
            chack = chack.next; // 4,5,6
       //   System.out.println("hole : " + hole.val + ", chack : " + chack.val);
        } 

        System.out.println("head : " + head.val + ", headnext : " + head.next.val); 
				hole.next = chackHeadWhy; // �̶��� hole�� 5�� ����ִ� ����
        System.out.println("re > head : " + head.val + ", headnext : " + head.next.val);
        
        return head;  
    }          

}
