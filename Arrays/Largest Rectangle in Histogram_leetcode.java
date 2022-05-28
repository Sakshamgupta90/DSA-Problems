//Approach 1(BRUTE FORCE)

/* method: Since we have to calculate the maximum area hold by a rectangle for this what we will do that we will iterate through our loop and then checked the left and right elements of every element. This is done because if there is greater than or equal element present in the left or right side of every element then we will coinsidered them as well. After checking the left and right side elemetns range we will calculate the area. And compare the max area and return it.*/

//Code:
public int largestRectangleArea(int[] heights) {
        int maxArea = -(int)1e9;
        for(int i = 0; i < heights.length; i++){
            int left = i;
            int right = i;
            
            while(left >= 0 && heights[left] >= heights[i] )
                left--;
            
            while(right < heights.length && heights[right] >= heights[i])
                right++;
            
            int height = heights[i];
            
            int width = right - left - 1;
            
            int area = height * width;
            
            maxArea = Math.max(maxArea , area);


        }
        
        return maxArea;
    }

//Time complexity: O(N^2)
//Space complexity: O(1)

//Approach 2 (OPTIMISED) : USING STACK

/* method: First we will create two array name next_smaller and previos_smaller. Next_smaller will contain the index of elements that are smaller than the current element. Previous_smaller will contain the left side of index of elements having value smaller than the current element. After filling the array we will iterate through our array and calculate the area by (next_smaller[i] - previous_smaller[i] - 1) * arr[i]. Then we will return the max Area.*/

//code:
public static int[] next_smaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = 0; i < n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }
    public static int[] prev_smaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = -(int)1e9;
        int n = heights.length;
        int[] prev_smaller = prev_smaller(heights);
        
        int[] next_smaller = next_smaller(heights);
        
        for(int i = 0; i < n; i++){
            int height = heights[i];
            int width = next_smaller[i] - prev_smaller[i] - 1;
            
            maxArea = Math.max(maxArea , height * width);
        }
        
        return maxArea;
    }


//Time complexity: O(N) + O(N) + O(N) == 3O(N) ~= O(N)
//Space complexity: O(N)
