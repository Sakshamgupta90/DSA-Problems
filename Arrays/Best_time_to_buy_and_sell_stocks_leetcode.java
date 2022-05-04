// Approach 1 (BRUTE FORCE)

// method: We can simply use 2 loops and track every transaction and maintain a variable maxPro to contain the max value among all transactions.

//code:
 public int maxProfit(int[] arr) {
        int maxPro = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    maxPro = Math.max(arr[j] - arr[i], maxPro);
                }
            }
        }
        return maxPro;
    }

//Time Complexity: O(N^2)
//Space complexity: O(1)

//Approach 2 (OPTIMAL)

/*method: We will linearly travel the array. We can maintain a minimum from the starting of the array and compare it with every element of the array, if it 
     is greater than the minimum then take the difference and maintain it in max, otherwise update the minimum. */

 public int maxProfit(int[] prices) {
        int min = (int)1e9;
        int profit = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            else if(prices[i] - min > profit)
                profit = prices[i] - min;
           
            
        }
        
        return profit;
    }

//Time Complexity: O(N)
//Space complexity: O(1)
