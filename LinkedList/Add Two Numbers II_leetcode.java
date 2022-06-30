/*method: To add the linkedlist we have to first reverse the linkedlist because the length of the two linkedlist might be different and reversing them will
help us while adding the values from the last. After reversing we simply add the two variables with the approach that we followed on add two numbers questions. After adding all the values of both the linkedlist, we get our result in reverse so we also have to reverse our new result linkedlist. */

//code:
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        l1= reverse(l1); l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = l1, c2 = l2;
        int carry = 0;
        while(c1 != null || c2 != null || carry != 0){
            int sum = carry + (c1 == null ? 0 : c1.val) + (c2 == null ? 0 : c2.val);
            
            carry = sum/10;
            
            prev.next = new ListNode(sum%10);
            
            prev = prev.next;
            
            if(c1 != null)
                c1 = c1.next;
            
            if(c2 != null)
                c2 = c2.next;
        }
        
       
         return reverse(dummy.next);
       
        
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null ){
            ListNode forw = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = forw;
            
            
        }
        
        return prev;
    }

//Time complexity: O(N)
//Space complexity: O(1)
