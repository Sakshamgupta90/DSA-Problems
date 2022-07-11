//Method: 
/* we will find the sum of root.left and root.right and compare it with the node and if sum of children is equals to parent node then we will return true,
else we will return false. */

//code:
public int sumOfTree(TreeNode root){
        return root == null ? 0 : root.val + sumOfTree(root.left) + sumOfTree(root.right); 
    }
    
    public boolean checkTree(TreeNode root) {
        
        int sum = sumOfTree(root); // This function will give us the sum of all the nodes.
        return root.val == (sum - root.val); /*since the sum function will return the sum of all the nodes including parent root so we have to subtract the 
                                                parent root from the sum*/
       
    }

//Time complexity: O(N)
//Space complexity: O(1)
