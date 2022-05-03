/* Method: Here we will traverse through the whole given array, but simultaneously keep the pointer of the previous index which is stored.
As we traverse through the arrray, whenever we came across a new integer will compare it with the previous one if both of them are different then will store the new integer in new place and update the pointer. Once the the traversal is complete will have all the unique integer at left side and thats what we want.
*/

//code:
 public int removeDuplicates(int[] nums) {
        int i = 0; 
        for(int n : nums){
            if(i == 0 || n > nums[i-1])
                nums[i++] = n;
        }
        return i;
    }

//Time complexity: O(N)
//Space Complexity: O(1)

//****This is the only solution for this question, it is the brute force and optimized apporach as well :)****
