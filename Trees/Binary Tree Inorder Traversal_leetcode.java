//Method: OPTIMAL
/* we are doing morris inorder traversal. We simply do that, we first find the rightmost node of the curr.left and we linked a thread with the curr node
when rightmost.right == null. this is done because while traversing the binary tree we can only move to left and right of the parent node but cannot 
backtrack. so in inorder we have to first print Left->Parent->right node. since we cannot backtrack so we have to create something so that we can also 
backtrack to our parent node so this is how morris inorder traversal works.
we will create the thread of the rightmost node of every curr.left value that will be linked to the parent node. One thing we have to keep in mind that
the after making changes in the tree we have to make it as it was before, since the same tree can be used for some other query so we cannot change the tree
 TO UNDERSTAND IN MORE WATCH TREE CLASS 3 LECTURE*/

//code:
 public static TreeNode rightMostNode(TreeNode root, TreeNode curr){
        while(root.right != null && root.right != curr)
            root = root.right;
        
        return root;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        
        while(curr != null){
            TreeNode leftNode = curr.left;
            
            if(leftNode == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode rightNode = rightMostNode(leftNode, curr);
                
                if(rightNode.right == null){ // Creating thread
                    rightNode.right = curr; // linked it with the parent node
                    curr=curr.left;
                }else{
                    rightNode.right = null; // breaking thread
                    ans.add(curr.val); 
                    curr = curr.right;
                }
                
                
                
            }
        }
        
        return ans;
        
    }

//Time complexity: O(N)
//Space complexity: O(1)

//method 2: BRUTE FORCE
/* we can also perform simple recursion, i.e move to left then print the value and then move to right;
func(root.left)
print/add(root.val)
func(root.right)

But the time complexity will be O(H) where H is the height of the binary tree */

//code:
 public static void inorderTraversal(TreeNode root, List<Integer> ans){
        if(root == null)
            return;
        
        inorderTraversal(root.left, ans);
        ans.add(root.val);
        inorderTraversal(root.right, ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
        
    }
