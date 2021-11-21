package week04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import LinkedList.ListNode;

//Iterative
//recall

public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
		
			// 1,2,3,4,5, (null)
		
	    ListNode pastList = null; // 더미 listnode
	    ListNode nowList = head;  // 들어온 listnode
			
			// 처음 1로 시작 시 nextTemp = 2
			// nowList(1)의 next null 세팅 & 1이 past & 2가 now
			// 다음 2로 시작시 nextTemp = 3
			// nowList(2)의 next 1 세팅 & 2가 past & 3이 now  			
			// 이런식으로 하나씩 node를 밀려서 작성하며 반복

	    while (nowList != null) {
		    	// nextNode
	        ListNode nextTemp = nowList.next;	
	        
	        nowList.next = pastList;
	        pastList = nowList;
	        nowList = nextTemp;
	    }
	    return pastList;
	}
	
}
