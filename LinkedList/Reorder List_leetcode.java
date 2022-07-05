/* Approach: The intuition is that we will first find the middle of the linkedlist and after finding the middle of the linkedlist we will reverse that
middle linkedlist. Now we will keep two pointers i.e. c1 at head and c2 at mid. now we will iterate till c2 != null. and we will start connecting c1.next
with c2 and c2 with c1.next and increase the pointers. */

//Code:

public ListNode middleList(ListNode head){
        ListNode slow = head , fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr=forw;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        
        ListNode mid = middleList(head);
        ListNode newMid = mid.next;
        mid.next = null;
        
         newMid = reverse(newMid);
        
       
        ListNode c1 = head , c2 = newMid;
        
        while( c2 != null){
             ListNode fastc1 = c1.next;
             ListNode fastc2 = c2.next;
            
            c1.next = c2;
            c2.next = fastc1;
               
            c1 = fastc1;
            c2 = fastc2;
           
        }
        
        
    }

//Time complexity: O(N)
//Space complexity: O(1)
