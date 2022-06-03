//Approach

//method: we will use recursion. we will first add open brac till open brac is less than num and after that we will call function for adding close brac. And the base condition will be when our string length is equal to num*2.


//code:
public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recusrion(res , n , 0 , 0 , "");
        return res;
        
    }
    
    public void recusrion(List<String> res , int max , int openBrac , int closeBrac , String temp){
        if(temp.length() == max*2){
            res.add(temp);
            return ;
        }
        
        if(openBrac < max)
            recusrion(res,max,openBrac + 1, closeBrac,temp + "(");
            
        if(closeBrac < openBrac)
            recusrion(res , max, openBrac , closeBrac+1 , temp + ")");
        
    }

//Time Complexity: O(N)
//Space Complexity: O(1)
