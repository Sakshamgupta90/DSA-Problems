//Approach is similiar as in All Nodes Distance K in Binary Tree

//Code:
public static void rootToLeaf(Node root , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> path){
        if(root == null)
        return;
        
        if(root.left == null && root.right == null){
            ArrayList<Integer> base = new ArrayList<>(path);
            base.add(root.data);
            ans.add(base);
            return;
        }
        
        path.add(root.data);
        rootToLeaf(root.left , ans , path);
        rootToLeaf(root.right , ans , path);
        path.remove(path.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        rootToLeaf(root , ans , path);
        
        return ans;
        
    }

