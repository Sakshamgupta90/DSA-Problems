/* Approach: We will use two pointers fast and slow. We will keep increasing slow pointer by 1 and fast pointer by two steps untill our fast pointer
is not equalls to null and fast.next not equals to null. When this condition gets failed then our prev pointer will be at the value which is the middle of 
the linkedlist.*/

//code:
public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
        
    }

//Time complexity: O(N)
//Space complexity: O(1)
