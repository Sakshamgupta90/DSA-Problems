/* method: we will create a dummy listnode and we will linked it with the head. We will iterate through our list and if get the same value as that of val(given) then we will linked it will curr.next. */

//code:
 public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy , curr = head;
        prev.next = head;
        
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

//Time complexity: O(N)
//Space complexity: O(1)
