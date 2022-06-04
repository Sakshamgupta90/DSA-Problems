//Approach

// method: we will start from beginning. First we will check that in starting there should be no spaces. after resolving the starting spaces we will use two pinter i and j. i pointer will be at the first index of the char and j at the index where we get our next space. Then we will get our first word. and add it in our result.

//code:
public String reverseWords(String s) {
        String ans = "";
        int i = 0;
        int n = s.length();
        
        while(i < n){
            
            while(i < n && s.charAt(i) == ' ') // for resolving the spaces in the starting of the string
                i++;
            
            if(i >= n)
                break;
            
            int j = i+1;
            
            while(j < n && s.charAt(j) != ' ')//j will run till it reached to next space index. if it find space that means we found a word
                j++;
            
            String sub = s.substring(i , j); // we will get our word
            if(ans.length() == 0)//if our string is empty then we will simply add in our string
                ans = sub;
                
            else
                ans = sub + " " + ans;//if there already a word in our string then we will add a space and then add our word.
            
            i= j+1;
        }
        
        return ans;
    }

//Time complexity: O(N)
//Space complexity: O(N)
