// Approach 1

// method: sort the array to get the required answer
***//DONT Tell this approach , you can just say that we an use inbuilt sort function but we will not use it here. 
  //we can do it by taking 3 pointers and then explain approach 2

//code:
public void sortColors(int[] nums) {
        Arrays.sort(nums); 
    }

//Time complexity: O(NlogN)
//Space omplexity: O(1)


// Approach 2 (OPTIMIZED)

//method: We will use 2 pointers. si indicates the place where we kept 0 and ei indicates the place where we place 2. The primary goal here is to move 0s to the left and 2s to the right of the array and at the same time all the 1s shall be in the middle region of the array and hence the array will be sorted.  

//code:
public void sortColors(int[] nums) {
        int si = 0, ei=nums.length-1,mid=0;
        while(mid <= ei){
            if(nums[mid] == 0){
                swap(nums,si,mid);
                si++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,ei);
                ei--;
            }
        }
    }
    
    public void swap(int[] arr, int si, int ei){
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

//Time complexity: O(N)
//Space Complexity: O(1)
