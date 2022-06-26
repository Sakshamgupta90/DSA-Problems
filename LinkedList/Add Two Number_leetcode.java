/* Method: we will create a dummy node, and iterate through both our listnode. while iterating at every value we will add carry and will take a variable sum that contains the overall sum of all the values. then will update our carry by doing sum / 10. we will link our dummy node with sum % 10. */

//code:
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null?l2:l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1 , c2 = l2 , prev = dummy;
        int carry = 0;
        while(c1 != null || c2 != null || carry != 0){
            
            int sum = carry + (c1 == null ? 0 : c1.val) + (c2 == null ? 0 : c2.val);
            
            carry = sum / 10;
            
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            
            if(c1 != null)
                c1 = c1.next;
            if(c2 != null)
                c2 = c2.next;
        }
        return dummy.next;
    }

//Time complexity: O(n)
//Space complexity: O(1)
