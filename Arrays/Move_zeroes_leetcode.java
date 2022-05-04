//Approach 1

//method: we will use two pointers i and j both at idx 0. we will iterate throug array and when element is not zero we swap the element with j and increase j by 1.

//code:
public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                j++;
            }
        }
        
    }

//Time complexity: O(N)
//Space complexity: O(1)

//Approach 2

// method: shifting all non zero elements to left and zero elements to the right

// code:
public void moveZeroes(int[] nums) {
        int ptr = 0;
        
        for(int i : nums){
            if(i != 0){
                nums[ptr++] = i;
            }
        }
        
        while(ptr < nums.length){
            nums[ptr++] = 0;
        }
    }

//Time complexity: O(N)
//Space complexity: O(1)
