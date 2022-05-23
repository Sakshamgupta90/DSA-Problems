// Approach

/* method: To solve it in place, we use 2 bits to store 2 states: [2nd bit, 1st bit] = [next state, current state]
 
  For each cell, check the current state of 8 neighbors, and set the cell's 2nd bit. Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
  Transition 00 -> 10: when board == 0 and lives == 3.
 
  To get the current state, simply do board[i][j] & 1
  To get the next state, simply do board[i][j] >>> 1 */

//code:
private static final int[][] DIRS = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveCount = 0;
                for (int[] d : DIRS) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        liveCount += board[x][y] & 1;
                    }
                }
                if (liveCount == 3 || (board[i][j] == 1 && liveCount == 2)) {
                    board[i][j] |= 2; // 1 << 1
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>>= 1;
            }
        }
    }

//Time complexity: O(M*N) where M = number of rows, and N is number of cols
//Space complexity: O(1)
