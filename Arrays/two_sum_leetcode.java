// Approach 1 (BRUTE FORCE)

// method: we will use two for loops and when nums[i] + nums[j] == target sum then we return the index in array.

//code:
 public int[] twoSum(int[] nums, int target) {
       for(int i = 0; i < nums.length; i++){
           for(int j = i+1; j < nums.length; j++){
               if(nums[i] + nums[j] == target){
                   return new int[]{i,j};
               }
           }
       }
        
        return new int[0];
    }

//Time complexity: O(N^2)
// Space Complexity: O(1)


// Approach 2 (OPTIMAL)

//method: Using extra space by taking hashmap. we will linearly traverse in the array and if target-nums[i] is present then we return the index else add int the map.

//code:
 public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++){
              
               if(map.containsKey(target - nums[i])){
                   return new int[]{map.get(target - nums[i]),i};
               }else{
                   map.put(nums[i], i);
               }
           }
       
        
        return new int[0];
    }

//Time complexity: O(N)
//Space complexity: O(N)
