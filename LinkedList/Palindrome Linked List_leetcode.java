/* method: The intuition is super simple we will first find the middle node of the linkedlist. and then reverse that middle linkedlist. 
Now we will keep our curr pointer at head(given linkedlist) and second pointer mid at second linkedlist(reverse linkedlist). now we will iterate till
curr != null && mid != null and side by side we will check if at any point curr.val is not equal to mid.val that means the linkedlist is not palindrome and we will return false.
eg:
head = 1->2->3->3->2->1
mid = 3->2->1
after reversing mid linkedlist
mid = 1->2->3

now we will check every value of head and mid
*/

//Code:
public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        ListNode mid = midNode(head);
          mid = reverseNode(mid);
        
        while(mid != null && curr != null){
            if(curr.val != mid.val){
                return false;
            }
            
            curr = curr.next;
            mid = mid.next;
        }
        return true;
    }
    
    public ListNode midNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverseNode(ListNode head){
       ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }

//Time complexity: O(N)
//Space complexity: O(1)
