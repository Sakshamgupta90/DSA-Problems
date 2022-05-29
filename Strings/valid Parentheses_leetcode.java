//Approach

/*method: we will create a stack and iterate through our string. if we find any open brackets we will simply add them in the stack. And if we get any closed bracket then we will check several condition that stack top element is the same open bracket or not if not then we will return false and if there doesnt exists any open bracket i.e. if stack is empty then in that case also we will return false. And if there exists the same open bracket then we will remove the that element from the stack. and in last we will check whether the stack is empty or not. if it is empty then it means string contains equal number of open and close parentheses and if stack is not empty that means string doesnot contain equal number of parentheses. */

//code:
public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[')
                stack.addFirst(ch);
            else{
                if(stack.size() == 0)
                    return false;
                else if(ch == ')' && stack.getFirst() != '(')
                   return false;
                 else if(ch == ']' && stack.getFirst() != '[')
                    return false;
                 else if(ch == '}' && stack.getFirst() != '{')
                    return false;
                else
                    stack.removeFirst();
                
            }
        }
        
        return stack.size()==0;
    }

//Time complexity: O(N)
//space complexity: O(N)
