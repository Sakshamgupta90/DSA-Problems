/* **method**: we will first call the function node to root path which stores all the nodes from the target node to the root node in arrayList. Doing this
will able to get all the nodes that are above the target nodes. after getting the all the paths we will iterate in that path arrayList because these are 
the nodes only which we have to consider. we will also maintain a node block which make sure that we havent reached the node more than once.
While iterating we call a function Kpathdown which return the list containing all the nodes that are kth distance, and while iterating second times we will make that first node in path as block so that it can never be considered in next iteration.
and in last we will return our result. */
 
//Code:

public void kdown(TreeNode root, int k, TreeNode block, List<Integer> ans) {
        if (root == null || k < 0 || root == block)
            return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        kdown(root.left, k - 1, block, ans);
        kdown(root.right, k - 1, block, ans);
    }
     boolean nodeToRootPath_(TreeNode root, int data, ArrayList<TreeNode> ans) {

        if (root == null)
            return false;

        if (root.val == data) {
            ans.add(root);
            return true;
        }

       

        boolean res = nodeToRootPath_(root.left, data, ans) || nodeToRootPath_(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }

   public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath_(root, target.val, path);

        List<Integer> ans = new ArrayList<>();
        TreeNode block = null;
        for (int i = 0; i < path.size(); i++) {
            kdown(path.get(i), k - i, block, ans);
            block = path.get(i);
        }
        return ans;
    }

//Time complexity: O(N)
