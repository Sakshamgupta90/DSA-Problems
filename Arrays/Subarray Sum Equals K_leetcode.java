//Approach 1(BRUTE FORCE)

/* method: The first approach that comes in mind is to find all the subarray sum and if it is equal to k then we increase the count variable. For this we iterate through
the array twice. first i will start from 0 till length and then we consider the individual elements of i as a sum as well becuase individual elements are consider to be
subarray as well. In second loop our j will start from i+1. and we add nums[j] in sum and if sum == k we increase our count and finally return our answer.*/

//code:
public int subarraySum(int[] arr, int k) {
    int ans = 0; // ans variable to store our count
        
        for(int i = 0; i < arr.length; i++) // traverse from the array
        {
            int sum = arr[i]; // provide sum with arr[i]
            
            if(sum == k) // if element itself equal to k, then also increment count
                ans++;
            
            for(int j = i + 1; j < arr.length; j++) // now moving forward,
            {
                sum += arr[j]; // add elements with sum
                
                if(sum == k) // if at any point they become equal to k
                    ans++; // increment answer
            }
            
        }
        
        return ans; // and at last, return answer
    }

//Time complexity: O(N^2)
//Space complexity: O(1)

//Approach 2 (OPTIMAL)

//code: We can use hashmap also. we iterate thorugh our array and take the sum of element and put it in the hashmap. and if sum - k is present then we increase the count.
public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
      
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

//Time complexity: O(N)
//Space complexity: O(N)
