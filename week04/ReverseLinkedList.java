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
		
	    ListNode pastList = null; // ���� listnode
	    ListNode nowList = head;  // ���� listnode
			
			// ó�� 1�� ���� �� nextTemp = 2
			// nowList(1)�� next null ���� & 1�� past & 2�� now
			// ���� 2�� ���۽� nextTemp = 3
			// nowList(2)�� next 1 ���� & 2�� past & 3�� now  			
			// �̷������� �ϳ��� node�� �з��� �ۼ��ϸ� �ݺ�

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
