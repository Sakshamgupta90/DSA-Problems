

//code:

public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
      
        while(left > 1){
            prev = curr; // prev ptr will be at the 1 index before the curr pointer
            curr = curr.next; // make our curr pointer to the value at left index
                left--;
            right--;
        }
        
        ListNode start = prev; // we will store our prev value in new listnode start which links the starting node with the reverse 
        ListNode tail = curr;// we will store the curr value which later gets reverse to the tail which links the last value of the linkedlist
        
        while( right > 0){ // reversing the linkedlist between the index left to right
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
           right--;
            
        }
        if(start != null){
            start.next = prev; // linking the starting node
        }else{
            head = prev;
        }
        
        tail.next = curr; // linking the last node
        return head; // returning the updated linkedlist
    }

//Time complexity: O(N)
//space complexity: O(1)
