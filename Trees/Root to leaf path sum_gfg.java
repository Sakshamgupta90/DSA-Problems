
/* Method: we will keep a variable sum which add the root value while traversing left or right in the tree. and if we reached to the leaf root we will make
sure that the sum should be equal to the given sum that will be handled in the base case. */

//Code:

boolean f(Node root,int c,int s){
       if(root.left==null&&root.right==null){
           if(c+root.data==s)return true; 
           return false;
       }
       boolean l=false,r=false;
       if(root.left!=null)
           l=f(root.left,c+root.data,s);
       if(root.right!=null)
           r=f(root.right,c+root.data,s);
       return l||r;    
   }
   boolean hasPathSum(Node root, int s) {
       // Your code here
       if(root==null)return false;
       return f(root,0,s);
   }
