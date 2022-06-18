/* method: we will first calculate the length of the two linkedlist and keep two pointers at each linked list. After finding the length of the linked lists we will check if length of linkedlist a is greater than b then we will keep the ptr2 of list b at (lenA - lenB) or vice versa. In other words we will keep the ptr of both the lists at the same index. Then we will keep increasing both ptr til ptr1 != ptr2.And then we will return any of the ptr as they will be at the point where the linkedlist interact. */

//code:
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        ListNode ptr1 = headA , ptr2 = headB;
        int lenA = length(headA) , lenB = length(headB);
        
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++)
                ptr1 = ptr1.next;
        }else{
            for(int i = 0; i < lenB - lenA; i++)
                ptr2 = ptr2.next;
        }
        
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return ptr1;
        
    }
    
    public int length(ListNode head){
        int len = 0; 
        while(head != null){
            len++;
            head = head.next;
        }
        
        return len;
    }

//Time complexity: O(n + m) ==== n = list A || m = list B
//Space complexity: O(1)
