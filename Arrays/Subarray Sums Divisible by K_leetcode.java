// Approach

/*method: we will use hashmap. We will iterate through our array and calculate the sum and in hashmap we will add rem = sum % k and its occurence(or count), if
remainder(rem) is already present in the hashmap that means we get our subarray divisible by k. and update our answer by the count of the remainder.*/

//code:
 public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); // contains rem and count
        int ans = 0;
        map.put(0,1); 
        int sum = 0;
        int rem = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            rem = sum % k;
            
            if(rem < 0)
                rem += k;
            
            if(map.containsKey(rem)){ // if rem is present that means we get our subarray
                ans += map.get(rem); //increase the ans by 1
                map.put(rem , map.get(rem)+1); // increase the count of that rem by 1
            }else{
                map.put(rem , 1); // if doesnot present rem we add it in the map
            }
            
        }
        
        return ans;
    }

//Time Complexity: O(N)
//Space complexity: O(N)


