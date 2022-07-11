// Method:
/* we simply perform add the all the root values function, where we simply add all the values just small thing we have to change is that since it is a 
binary search tree so if root value is greater than given high value then moving to right will be useless so we move to left, and if root value is less than
low so moving to left will have no use so in that case we move to right */

//code:
public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        
        if(root.val > high){
            return rangeSumBST(root.left, low, high);
        }
        if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

//Time complexity: O(N)
//space complexity: O(1)
