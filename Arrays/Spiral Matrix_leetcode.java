//Approach

/* method: to solve this question there is not such brute force and then optimal solution. We will simply use 4 pointers to solve this problem. We will take four pointer top = 0 , down = last row , left = 0 , right  = last column. First we have to print the first row, so we will fixed the top and iterate from left to right. and after it ends we will increase our top pointer. Then we have to print the last column so we will fixed our right pointer and iterate from top to down. after that decrease the right pointer. Then we have to print last row so we will fixed down ptr and iterate from right to left and decrease the down. and last we have to print the first column so fixing the left ptr and iterate from down to top and increase left ptr. This way it works and we will continusouly do this till top <= bottom and left <= right.*/

//code:
public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int top = 0 , down = matrix.length - 1,left = 0 , right = matrix[0].length-1;
        
        while(top <= down && left <= right){
            
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            
            for(int i = top; i <= down; i++){
                result.add(matrix[i][right]);
            }
            right--;
            
            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
        
    }

//Time complexity: O(M*N) M = row and N = col
//Space complexity: O(1)
