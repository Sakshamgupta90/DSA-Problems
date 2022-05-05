//Approach

//method: we will linearly iterate through our array. and when the prices are low we will buy the stock and when the prices are high we sell the stock. 
// we simply do if arr[i] > arr[i-1] that means the prices are high and at this point we have to sell the stock and we calculate the profit.

//code:
public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]) // that means its time to sell the stock
                profit += (prices[i] - prices[i-1]); //calculate the profit after selling the stocks
        }
        return profit;
    }

//Time complexity: O(N)
//space complexity: O(1)
