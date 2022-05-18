//Approach 1:

//Method: we will start from the last index and if we are able to reach the 0th index of our array that means we are able to reach the first index of our array.

//code:
public boolean canJump(int[] nums) {
        int last = nums.length - 1; // last index/ position to reach 
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i+nums[i] >= last) { // check if i+nums[i] >= last means we can reach to that index 
			//with curr value and from current index and if yes then 
			//change last to current index
                last = i;
            }
        }
        return last <= 0; // if last <= 0  then that means we can reach to solution if we start from begining also return true else false
    }

//Time Complexity: O(N)
//Space complexity: O(1)

//Approach 2: Using DP

//code:
public boolean canJump(int[] nums) 
    {
        int n=nums.length;
       int[] dp=new int[n];
       dp[0]=nums[0];
        if(n==1) return true;
       for(int i=1;i<n-1;i++)
       {
            if(dp[i-1]<i) return false;
            
            dp[i]=Math.max(dp[i-1],nums[i]+i);
           
            if(dp[i]>=n-1) return true; 
       }
       return dp[n-2]>=n-1?true:false;
    }

//Time Complexity: O(N)
//Space complexity: O(N)
