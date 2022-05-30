//Approach

/*method: we will consider the first string of the array as a prefix (let name it result) and then iterate through our string array from index 1. We will check that the string has prefix in result. if it is present then it will return 0 else -1; if it gives -1 that means it doesnot contain prefix so we will reduce the string result by deleting the last character of the result. This will happen until it will show the prefix in result.
example:
arr = {"flower" , "flow" , "flight"}

result = flower

idx = 1 => flow, flower doesnt contain flow so we will delete the last charac from result. now result = 'flowe'. Now, flow doesnt exists in flowe so we will reduce the length of result. now result = 'flow'. Now the flow is prefix of the result flow. so we will move to idx 2;

idx =2 => flight; flow prefix doesnt exists in flight so we will again reduce the length now result = 'flo'. Now again we will reduce = 'fl'.
Now fl exists in flight so its the final result. */

//code:
 public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(res) != 0){
                res = res.substring(0 , res.length() - 1);
            }
        }
        return res;
    }

//time complexity: O(N)
//space complexity: O(1)
