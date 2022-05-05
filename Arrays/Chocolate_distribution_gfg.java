// Method: we will first sort the array, and traverse the array such that if i = 0 then j will be at i + m - 1. and we calculate the minimum no. of chocolates given.

//code:
public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        Collections.sort(a);
        int i = 0;
        long ans = (long)1e9;
        
        while(i <= n - m){
            
            int j =(int)(i + m - 1);
            
            ans = Math.min(ans , a.get(j) - a.get(i));
            i++;
        }
        
        return ans;
    }

// Time complexity: O(NLogN)
//space complexity: O(1)
