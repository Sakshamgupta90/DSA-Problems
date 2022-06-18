/* Method: we will iterate through our linkedlist and side by side converting the number into binary number by multiplying the value into 2 and suming 
them up.*/

//code:
public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int sum = 0;
        while(curr != null){
            sum = (2*sum) + curr.val;
            curr = curr.next;
        }
        return sum;
    }

//Time complexity: O(N)
//Space complexity : O(1)
