//Approach 1(BRUTE FORCE)

/* method: We have to calculate the maximum area between two heights of the container. So the first apporach that comes is we fixed one pointer i and second pointer to
j=i+1 and we will iterate through our array by increasing j and side by side we calculate the area between these two. and when our area is greater than the previous area
we update our result.*/

//code:
public int maxArea(int[] height) {
        int max = 0; // maximum amount of water
        
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){ 
                int min = Math.min(height[i] , height[j]); // calculate the minimum height, so that the water will fill till the minimum height unless it will overflow
                int dis = j - i; // this will calculate the distance between two heights i.e. base
                
                int area = min * dis; // area is height * base
                
                max = Math.max(max,area); // when area is greater than max we will update it
            }
        }
        return max;
        
    }

//Time complexity: O(N^2)
//Space complexity: O(1)

//Approach 2 (OPTIMAL)

/* method: we will use two pointer approach. our first pointer left will be at 0index and right pointer will be at the last index of array and will iterate once in array.
Then the similar step we will calculate the minimum heigth and distance between them and calculate the area. But now this time after calculating the area, if the height
of right pointer is less than left then we will decrease the right pointer by one. else increase the left by one. 
Example, left ptr height = 8  index = 0, right ptr height = 5 index = 6;
area will be = 5*(6-0) = 30. now we will decrease right ptr. The intuition behind it is that, is we suppose dont decrease right ptr and instead increase left ptr then
left ptr will at idx 1 and height suppose 10. The area would remain same because the water will be filled till the minimum height only and we didnt get our maximum area

Now if we decrease the right ptr then it will be at idx = 5 and suppose the height is 7. The area will be 7 * (5-0) = 35. maximum area then the previous one.
So this is why the ptr having minimum height will be decrease or increase.
If we have smaller height on left or right we don't care about it. We always want a higher height line on our left & right.
*/

//code:
public int maxArea(int[] height) {
        int max = 0;
        int left = 0 , right = height.length-1;
        
        while(left < right){
            int min = Math.min(height[left] , height[right]);
            
            int distance = (right - left);
            int area = min * distance;
            
            max = Math.max(max,area);
            
            if(height[left] > height[right])
                right--;
            else
                left++;
            
        }
        return max;
        
    }

//Time complexity: O(N)
//Space complexity: O(1)
