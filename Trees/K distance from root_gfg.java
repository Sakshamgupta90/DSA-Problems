/* Method: we will traverse through our tree and while traversing we will keep decrementing the kth value and when k value is equal to 0 we will store 
that node where k = 0 in our result arrayList. */

//Code:
public static void Kpathdown(Node root , int k, ArrayList<Integer> ans){
         if(root == null || k < 0)
          return;
          
         if(k == 0){
              ans.add(root.data);
              return;
         }
         
         Kpathdown(root.left , k - 1, ans);
         Kpathdown(root.right , k - 1 , ans);
     }
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          // Your code here
          ArrayList<Integer> ans = new ArrayList<>();
         
            
          Kpathdown(root , k , ans);
          return ans;
     }
