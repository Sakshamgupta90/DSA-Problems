//Approach 1:

/* method: we will start filling the largest element at the last.This is because both the given arrays are sorted. So our first pointer will be at the last index of nums1 and second pointer will be at the last pointer of nums2. and our third pointer will be at the last index of (nums1 + nums2 - 1). then we will iterate in both the array together and compare the largest element on that index of both the array and placed it on the third pointer index. This way our loop iterate till i>=0 and j>=0. if anyone of the condition gets false that means we have iterate through all the index of one of the array. */

//code:
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1 , j = n - 1 , result = m + n - 1;
        while(i >= 0 && j >= 0){
            nums1[result--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        
        while(j >= 0){
            nums1[result--] = nums2[j--];
        }
        
    }
//Time complexity:  O(M+N)
//Space Complexity: O(1)

