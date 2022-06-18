/* method: we will create a dummy list. and we will iterate through our list1 and list2 till any one ptr reaches null. while iterating through both lists
we will also check if ptr1.val <= ptr.val then in that case we will connect dummy ptr with ptr1 of list1 else I will connect the ptr2 of list2. when the 
base condition gets false then it simply means that either ptr1 value is null or ptr2 value is null. After exiting from the condition we will connect the
dummy ptr with the ptr whose value is not null. */

//code:
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode ptr1 = list1 , ptr2 = list2;
        
        while(ptr1 != null && ptr2 != null){
            if(ptr1.val <= ptr2.val){
                curr.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                curr.next = ptr2;
                ptr2 = ptr2.next;
            }
            
            curr = curr.next;
        }
        
        curr.next = ptr1 == null ? ptr2 : ptr1;
        
        return dummy.next;
        
    }

//Time complexity: O(N)
//Space complexity: O(1)
