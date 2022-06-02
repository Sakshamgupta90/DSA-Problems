//Appraoch

/* method: we will use two pointer for this approach. our first pointer si will be at 0th idx and second pointer will be at the last index of the string. we will iterate till si < ei. if the characters at both the idx si and ei are same then we will simply increase and decrease the ptr si and ei respectively. And if the character are not same then we will check whether the string is palindrome or not. we will check the string palindrome starting from idx si+1 till j or from idx si to ei - 1. And finally we will return our result.*/

//code:
public boolean validPalindrome(String s) {
        
        int si = 0; int ei = s.length() - 1;
        while(si < ei ){
            char ch1 = s.charAt(si);
            char ch2 = s.charAt(ei);
            
            if(ch1 != ch2){
               return isPalindrome(s , si+1, ei) || isPalindrome(s, si, ei-1);
                
            }
            si++;
            ei--;
        }
        return true;
    }
    
    public boolean isPalindrome(String s , int i , int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
            
        }
        return true;
    }
    
//Time complexity: O(N) 
//Space complexity: o(1)
