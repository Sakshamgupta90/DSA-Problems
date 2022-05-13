/* Method: Find each word's first matching letter on board and recursion to check for rest of the word. We will also keep in mind that we didnt consider the same index more than once so for this we will create visited array where we will mark the index where we are at, true so that we cant reach at that index again. if we didnt find the next word we also have to make sure that we mark the visited index false. */

//code:
 static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
    visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }

//Time complexity: O(N^2) where N=rows and col
//Space complexity: O(N^2)
