//Approach 1 (BRUTE FORCE)

/* method: The first approach that comes in the mind is iterating through the array three times. and we will calculate the sum of a[i] + a[j] + a[k], if
the sum is 0 then we will add it in our arraylist.*/

//code:

public List<List<Integer>> threeSum(int[] nums) {
      List < List < Integer >> ans = new ArrayList < > ();

        int i, j, k;
        for (i = 0; i < nums.length - 2; i++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    List < Integer > temp = new ArrayList < > ();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if (temp.size() != 0)
                        ans.add(temp);
                }
            }
        }

        return ans;
    }

//Time Complexity: O(N^3)
//Space complexity: O(3*K) where k is the no. of triplets

//Approach 2: (OPTIMAL)

/*method: We could make use of the fact that we just need to return the triplets and thus could possibly sort the array. This would help us use a 
modified two-pointer approach to this problem.

Eg) Input :  [-1,0,1,2,-1,-4]

After sorting, our array is : [-4,-1,-1,0,1,2]

Notice, we are fixing the i pointer and then applying the traditional 2 pointer approach to check whether the sum of three numbers equals zero. If the sum 
is less than zero, it indicates our sum is probably too less and we need to increment our j pointer to get a larger sum. On the other hand, if our sum is 
more than zero, it indicates our sum is probably too large and we need to decrement the k pointer to reduce the sum and bring it closer to zero.*/

//code:
public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);

        List < List < Integer >> res = new ArrayList < > ();

        for (int i = 0; i < num.length - 2; i++) {

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) { // the second or condition is to avoid duplicates like in exam.1 
                                                              //-1 and -1 are duplicates and their sum will be same
                                                              
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];

                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i] , num[lo] , num[hi]));

                        while (lo < hi && num[lo] == num[lo + 1]) lo++; // similar lo elements are ignored i.e avoid duplicates
                        while (lo < hi && num[hi] == num[hi - 1]) hi--; //Similarly for all hi elements

                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;

                    else hi--;
                }
            }
        }
        return res;
    }
    
//Time Complexity: O(N^2)
//Space complexity: O(N)
