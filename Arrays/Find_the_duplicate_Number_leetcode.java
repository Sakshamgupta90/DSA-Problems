// O(N^2) can be a brute force as well. In which we will use two for loops i = 0 and j=i+1. and when i == j we get our repeated number.
// Aproach 1 (BRUTE FORCE)

// method: sort the array, and when i==i+1 then we get our result.
//code: 
public int findDuplicate(int[] nums) {
       Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i < nums.length-1; i++){
            if(nums[i+1]==nums[i]){
                ans = nums[i];
                break;
            }
            
        }
        
        return ans;
    }

// Time Complexity: O(NlogN)
// Space Complexity: O(1)

// Approach 2

/*method: Using extra space. Either we take array or can use hashset. We will traverse through our array and side by side we will check that whether that element
          is already present or not in the hashset. if it is present that means the number is repeated and we get our required result.
*/

//code:
  public int findDuplicate(int[] nums) {
        
    HashSet<Integer> stack = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(stack.contains(nums[i])){
                ans = nums[i];
                break;
            }else{
                stack.add(nums[i]);
            }
        }
        return ans;
    }

// Time Complexity: O(N)
// Space Complexity: O(N)

// Aprroach 3 (OPTIMIZED)

/* method: we will think the array just like a linkedlist. And if there is a duplicate number present in the linkedlist that means it creates cycle. Then we apply that
           algo to find the dupicate number in a cyclic linkedlist using fast and slow pointer.
           In first, slow and fast pointer will be at nums[0]. Then we increase slow pointer by 1 i.e, slow=nums[slow] and fast pointer by 2 i.e, fast=nums[nums[fast]]
           this iteration will take place till slow!=fast. after they are at same position we will place our fast pointer to nums[0] and iterate again but this time
           we will increase slow and fast pointer by 1. and whenever our slow == fast then we get our repeated number. */

//code:
public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow !=fast);
        
        fast = nums[0];
        while(slow !=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }

// Time Complexity: O(N)
// Space Complexity: O(1)

