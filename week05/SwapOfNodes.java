package week05;

import LinkedList.ListNode;

public class SwapOfNodes {
	
    	public ListNode swapPairs(ListNode head) {  // 1, 2, 3, 4 ����      

			if(head == null || head.next == null){
            return head;
        }
        
        ListNode ref = head; // 1,2,3,4
        ListNode refNext = head.next; // 2,3,4
        
        while(ref != null && ref.next != null){   
 
            ListNode dummyNode = ref; // 1,2,3,4
            ref = ref.next; // ref = 2,3,4

						// 2,3,4�� ref�� next(3,4)�� dummy�� next��..dummy = 1,3,4
            dummyNode.next = ref.next; 

					  ref.next = dummyNode;   //  ref = 2, 1, 3, 4

						// ���ؾȵǴºκ� ===> �̷��� �ϸ� �տ��� ������ ������ �ʱ�ȭ �ȵǳ�?
            ref = dummyNode.next;   //  ref �缼��
					  // 1,3,4�� next�̴� 3,4�� �尨
						
            if(ref != null && ref.next != null){
                 dummyNode.next = ref.next;
            }
          
        }          
        return refNext;
    }
}
