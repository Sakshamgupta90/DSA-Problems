//Approach 1(BRUTE FORCE)

/*method: We use two for loops. first loop will run rom i = 0 till length and second loop will run from j=i+1 till length of array. And whenever we find same element 
that means it is a duplicate array so we add it in our result. We also have to make sure that the duplicate array should be unique that means if that element is
present more times it should be stored only once in our result. */

//code:
 public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j])
                    result.add(nums[j]);
            }
        }
        
        return result;
        
    }

//Time complexity: O(N^2)
//Space complexity: O(1)

//Approach 2

/* method: sort the array. and iterate through the array once. and we will find the duplicate number.*/

//code:
public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])
                result.add(nums[i]);
            
        }
        return result;
        
    }

//Time complexity: O(NlogN)
//Space complexity: O(1)

//Approach 3 (OPTIMIZED)

/* method: The idea is to modify the array in-place as you walk through it, while also preserving the original array elements.

We know that all elements are positive initially. When we see k = | A[i] | for the first time, multiply A[k] by -1. The negative sign on index k indicates k has been seen once. As you progress through the array, you will find some j > i such that A[j] = k. Now when you look at A[k], it is already negative (seen once). Thus j is a duplicate.*/

//code:
 public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int val = Math.abs(nums[i]);
            
            if(nums[val-1] < 0)
                result.add(val);
            else
                nums[val - 1] = - nums[val - 1];
        }
        return result;
    }

//Time complexity: O(N)
//Space complexity: O(1)
