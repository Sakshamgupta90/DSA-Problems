// Method1: 
/* We will use either morris inorder traversal for this. Since morris inorder traversal gives the tree in sorted order so while writing the code wherever
we have to add the values instead of that we have to check that previous element is less than the curr or not. If not that means it is not a binary search
tree and we will return false. */

//Code:
 public TreeNode rightMostNode(TreeNode root, TreeNode curr){
        while(root.right != null && root.right != curr)
            root = root.right;
        return root;
    }
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long prev = -(long)1e13;
        
        while(curr != null){
            TreeNode leftNode = curr.left;
            if(leftNode == null){
                if(prev >= curr.val)
                    return false;
                
                prev = curr.val;
                curr = curr.right;
                
            }else{
                TreeNode rightNode = rightMostNode(leftNode, curr);
                if(rightNode.right == null){
                    rightNode.right = curr;
                    curr = curr.left;
                    
                }else{
                    rightNode.right = null;
                    if(prev >= curr.val)
                    return false;
                
                prev = curr.val;
                    
                    curr = curr.right;
                }
            }
        }
        
        return true;
    }

//Time Complexity: O(N)
//Space Complexity: O(1)

//Method2: USING SPACE
/* we will find all the left element of the root and stored it in the stack, and while removing if the value is greate than last element of stack then it
is not a BST */

//Code:
 public void insertAllLeft(TreeNode root, LinkedList<TreeNode> stack){
        while(root != null){
            stack.addFirst(root);
            root = root.left;
        }
            
    }
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = -(long)1e13;
       
         insertAllLeft(root, stack);
            
            while(stack.size() != 0){
                TreeNode removeRoot = stack.removeFirst();
                if(prev >= removeRoot.val)
                    return false;
                
                prev = removeRoot.val;
                
                insertAllLeft(removeRoot.right, stack);
            }
            
            
        return true;
    }



//Time complexity: O(N)
//Space Complexity:O(N)
