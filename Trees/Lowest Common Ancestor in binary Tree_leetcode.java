// method1: BRUTE FORCE
/* we will first find the all the node to root path of p and q in arrayList. and we will keep two pointers in the end of both the arraylist list1 and list2
we will keep a Node null which will return the answer. while iterating when the node of both list1 and list2 are same we will decrease the two pinters 
i and j by 1 and also update the answer. When the nodes are not equal that means the node before them is the answer. */

//code:
 public boolean nodeToRootPath(TreeNode root , int target, ArrayList<TreeNode> arr){
        
        if(root == null)
            return false;
        
        if(root.val == target){
           arr.add(root);
            return true;
        }
        boolean res = nodeToRootPath(root.left , target , arr) || nodeToRootPath(root.right, target , arr);
        
        if(res)
            arr.add(root);
        
        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        nodeToRootPath(root, p.val, list1);
        nodeToRootPath(root, q.val, list2);
        
        int i = list1.size() - 1 , j = list2.size() - 1;
        TreeNode LCA = null;
        while(i >= 0 && j >= 0){
           if(list1.get(i) != list2.get(j))
               break;
            
            LCA = list1.get(i);
            i--;
            j--;
        }
        
        return LCA;
    }
//Time complexity: O(N)
//Space Complexity: O(N)


// method2: OPTIMIZE
/* We will traverse through our tree and we will check that from that root if from left we get true and from right we also get true then we will can say
that the present root is the LCA. If suppose the p is present root and q is root from left from p root then we still have LCA that will be p so we have to
handle that case also.
*/
//code:
 static TreeNode LCA = null;
    public boolean LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        
        boolean selfptr = (root == p || root == q); // if its true that means selfptr is one of the node
        
        boolean leftptr = LCA(root.left, p , q); //traverse in left

        
        boolean rightptr = LCA(root.right, p , q); // traverse in right

        
        if((leftptr && rightptr) || (leftptr && selfptr) || (rightptr && selfptr)) /*left and right is true that means that node is LCA, if left or self
                                                                                      is true that means that self is LCA similarly for right and self */
            LCA = root;
        
        
        return selfptr || leftptr || rightptr;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA(root, p, q);
        return LCA;
    }

//Time Complexity: O(N)
//Space Complexity: O(1)
