package week05;

import LinkedList.ListNode;

public class SwapOfNodes {
	
    	public ListNode swapPairs(ListNode head) {  // 1, 2, 3, 4 예시      

			if(head == null || head.next == null){
            return head;
        }
        
        ListNode ref = head; // 1,2,3,4
        ListNode refNext = head.next; // 2,3,4
        
        while(ref != null && ref.next != null){   
 
            ListNode dummyNode = ref; // 1,2,3,4
            ref = ref.next; // ref = 2,3,4

						// 2,3,4인 ref의 next(3,4)가 dummy의 next로..dummy = 1,3,4
            dummyNode.next = ref.next; 

					  ref.next = dummyNode;   //  ref = 2, 1, 3, 4

						// 이해안되는부분 ===> 이렇게 하면 앞에서 세팅한 영역들 초기화 안되나?
            ref = dummyNode.next;   //  ref 재세팅
					  // 1,3,4의 next이니 3,4가 드감
						
            if(ref != null && ref.next != null){
                 dummyNode.next = ref.next;
            }
          
        }          
        return refNext;
    }
}
