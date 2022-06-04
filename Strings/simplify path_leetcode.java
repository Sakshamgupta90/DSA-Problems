// Approach (USING STACK)

/* method:
It goes by first splitting the given string with "/" and storing the strings in an array.
Maintain a stack of strings to push and pop while iterating the array formed.
Now iterate the array
if string is ".." then pop the string from the top of your stack
if string is "." do nothing
else push the current string in the stack.
At last pop the strings from the stack and go on adding in front of your answer string.*/

//code:
public String simplifyPath(String path) {
        
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p =path.split("/");
        
        for(int i=0;i<p.length;i++){
            if(!s.isEmpty()  && p[i].equals("..")) s.pop();
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }
        
        
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            res.insert(0,s.pop()).insert(0,"/");
        }
        
        return res.toString();
        
    }

//Time complexity: O(N)
//Space complexity: O(N)
