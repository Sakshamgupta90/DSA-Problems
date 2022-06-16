// method: we will use two pointers slow and fast. we will increase two pointer by 1 and fast ptr by 2 and when slow and fast ptr are equal then we can say that there is a cycle present in the given linked list.

//code:
public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slow = head , fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        
        
        return false;
    }

//Time complexity: O(N)
//space complexity: O(1)
