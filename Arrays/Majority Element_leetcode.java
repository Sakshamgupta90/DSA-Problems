//Approach 1:

/* method: we will count all the repeated elements of a number and return the number which is more than n/2 time.*/

//code:
public int majorityElement(int[] nums) {
        
        
        
        int n = nums.length;
      //  int ans = 0;
        
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int count = 0;
            for(int j = 0; j < n; j++){
                
                if(nums[j] == num)
                    count++;
                
               
            }
            
             if(count > n/2)
                    return num;
            
        }
        
        return -1;
        
    }
//Time complexity: O(N^2)
//space complexity: O(1)

//Approach 2:

// method: using sorting. we will sort the array and then return the element of index num.length/2

//code:
public int majorityElement(int[] nums) {
         Arrays.sort(nums);
    return nums[nums.length/2];
    }
//Time complexity: O(N logN)
//space complexity: O(1)

//Approach 3: Using hashmap

/* method: we will iterate through our array and create a hashmap that contains the element along with its count. while iterating if the element doesnt exists in the hashmap then we add it in the hashmap along with its count 1. if the element is already present then we simply increase its count. and in last return the element having count more than n/2 */

//code:
public int majorityElement(int[] nums) {
          Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
    //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
    int ret=0;
    for (int num: nums) {
        if (!myMap.containsKey(num))
            myMap.put(num, 1);
        else
            myMap.put(num, myMap.get(num)+1);
        if (myMap.get(num)>nums.length/2) {
            ret = num;
            break;
        }
    }
    return ret;
    }

//Time complexity: O(N)
//space complexity: O(N)

//Approach 4: Moore's Voting Algorithm. 
/*method: So, Moore's Voting algorithm is based on the fact that the majority element is present more than n/2 number of times, so if we iterate in the array and increase the count if element is same as the choosen element and decrement the count otherwise, then also we will be left with the majority element because it is present more than n/2 number of times and rest of the elements cannot cancel it's presence*/

//code:
public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            if(count == 0)
                ele = nums[i];
            
            if(ele ==nums[i])
                count++;
            else
                count--;
            
        }
        
        return ele;
        
    }
    
//Time complexity: O(N)
//space complexity: O(1)
