//Approach 1 (BRUTE FORCE)

/* method: The intuition is super simple. We basically have to count number of pairs such that nums[i] > 2* nums[j], so we will iterate through our array twice. in first loop, 'i' will start from 0 till array end and in second loop j will start from i+1. we basically have to compare specific element with all the elements that are present in the array. */

//Code:
public int reversePairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if((long)nums[i] >(long) 2*nums[j])
                    count++;
            }
        }
        return count;
        
    }

//Time complexity: O(N^2)
//Space complexity: O(1)

//Approach 2 (OPTIMAL)

/* method: USING MERGE SORT ALGORITHM. In each round, we divide our array into two parts and sort them. So after "int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); ", the left part and the right part are sorted and now our only job is to count how many pairs of number (leftPart[i], rightPart[j]) satisfies leftPart[i] <= 2*rightPart[j].
For example,
left: 4 6 8 right: 1 2 3
so we use two pointers to travel left and right parts. For each leftPart[i], if j<=e && nums[i]/2.0 > nums[j], we just continue to move j to the end, to increase rightPart[j], until it is valid. Like in our example, left's 4 can match 1 and 2; left's 6 can match 1, 2, 3, and left's 8 can match 1, 2, 3. So in this particular round, there are 8 pairs found, so we increases our total by 8. */

//code:
public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }

////Time complexity: O(NlogN) + O(N) + O(N)
//Space complexity: O(1)
