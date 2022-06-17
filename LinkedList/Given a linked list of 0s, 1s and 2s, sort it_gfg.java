/* method: we will create three dummy nodes 0,1 and 2. and we will iterate through our given list. and whenever we get any 0, 1 and 2 then we will linked them with their respective dummy nodes respectively and in last we will linked the dummy nodes together to get the sorted list.*/

//code:
static Node segregate(Node head)
    {
        // add your code here
        
        if(head == null || head.next == null)
        return head;
        
        Node zero = new Node(-1) , one = new Node(-1) , two = new Node(-1);
        Node curr = head;
        Node op = one , tp = two , zp = zero;
        
        while(curr != null){
            if(curr.data == 1){
                op.next = curr;
                op = op.next;
            }else if(curr.data == 0){
                zp.next = curr;
                zp = zp.next;
            }else{
                tp.next = curr;
                tp = tp.next;
            }
            
            curr = curr.next;
            
        }
        
        tp.next = null;
        op.next = two.next;
        zp.next = one.next;
        return zero.next;
    }

//Time complexity: O(N)
//Space complexity: O(1)
