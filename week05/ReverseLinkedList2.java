package week05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import LinkedList.ListNode;

//Iterative
//recall




public class ReverseLinkedList2 {
	
	public class ListNode {
		
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }	
	
	
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        // '�߰��� List�� ������, List�� ���� ������ �����Ǿ�� �Ѵٴ� �� �������!'
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head; 
        
				// make a pointer pre as a marker for the node before reverse
        ListNode preNode = dummyNode;  // 0,1,2,3,4,5
        
         // start���� ���� (left 2, right 4)
        for(int i = 0; i<left-1; i++){
            preNode = preNode.next;
            System.out.println("preNode : " + preNode.val + ", preNodeNext : " + preNode.next.val);
        }  

				// �������, preNode ���õ� ���� (1,2,3,4,5)     
        // startNode : 2,3,4,5 &  nextNode = 3,4,5
        ListNode startNode = preNode.next;  // a pointer to the beginning of a sub-list that will be reversed
        ListNode nextNode = startNode.next; // a pointer to a node that will be reversed
        
        
        // 1 - 2 - 3 - 4 - 5 ;
        // left=2; right=4 ---> preNode = 1, startNode = 2, nextNode = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        // end�������� reverse ������
        for(int i=0; i<right-left; i++)
        {
            // 4,5�� startNode�� next(3~)�� �ھƹ�����
            startNode.next = nextNode.next;
            
            // 2,3,4,5�� nextNode�� next(4~)�� �ھƹ�����
            nextNode.next = preNode.next;
            
            // 3,2,3,4,5�� nextNode�� next(2~)�� �ھƹ�����
            preNode.next = nextNode;
            
            // 
            nextNode = startNode.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish) 
         
//      ListNode nowList = dummyNode; // 0,1,2,3,4,5
           
//      while (nowList != null) {
// 		    // nextNode
// 	        ListNode nextTemp = nowList.next;	
	        
// 	        nowList.next = pastList;
// 	        pastList = nowList;
// 	        nowList = nextTemp;
// 	    }
        
        return preNode;
        
    }
}
