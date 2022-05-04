// Approach 1 (BRUTE FORCE)

/*method: we will create a dummy row and dummy col. We will traverse thorugh our matrix and whenever we find zero then we update our dummy row and dummy col by
putting zero at that index. In the first traversal wherever we get zero in the matrix we keep updating our dummy row and col. In the second traversal, whenever 
in dummy row or col, wherever zero is present we change that row and col of the matrix by updating the element to zero.*/

//code:

public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        Arrays.fill(row , -1);
        Arrays.fill(col , -1);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
               if(row[i] == 0 || col[j] == 0)
                   matrix[i][j] = 0;
            }
        }
        
    }

//Time complexity: O(N*M + N*M) // N = number of rows and M = number of col of the matrix
//Space complexity: O(N)

// Approach 2 (OPTIMAL)

/* method: Instead of taking two separate dummy array,take first row and column of the matrix as the array for checking whether the particular column or 
row has the value 0 or not.Since matrix[0][0] are overlapping.Therefore take separate variable col0(say) to check if the 0th column has 0 or not and use 
matrix[0][0] to check if the 0th row has 0 or not.Now traverse from last element to the first element and check if matrix[i][0]==0 || matrix[0][j]==0 and
if true set matrix[i][j]=0,else continue. */

//code:
public void setZeroes(int[][] matrix) {
        int col = 1; //no 0 element is present in 0th row
        int m = matrix.length , n = matrix[0].length;
        
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){ // checking if 0th element in the row or not
                col = 0;
            }
            for(int j =1; j < n; j++){ // iterating from 1st column
               
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0; 
                }
                
            }
        }
        
         for(int i = m-1; i >= 0; i--){ //iterating from back and when our dummy row or col is 0 we update our matrix
            for(int j = n - 1; j >= 1; j--){
                
                if(matrix[i][0] == 0 || matrix[0][j] == 0 ){
                    matrix[i][j] = 0;
                }
                
            }
             if(col == 0){ // that means there is 0 present in the row so we also update our row by making all elements 0 
                    matrix[i][0] = 0;
                   
                }
        }
        
    }

//Time complexity: O(N*M + N*M) =~ O(2*N*M)
// Space complexity: O(1)
