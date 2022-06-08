//Approach

/*Method: In this question we will use hashmap containing another hashmap of character and integer{for frequency} and arraylist. Basically we will count the characater of each string present in our array. the string having same character values, we will add that string in our arrayList and then in the last we will create list of list and using values() function we will get the values present in the hashmap and then add in our final result and return it.
we will create two hashmap. 
First hashmap called bmap HashMap<HashMap<Character, Integer> , ArrayList<String>>.
this contains an hashmap called freq map that contains the character of each string along with their character count. */

//Code:
public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character , Integer> , ArrayList<String>> bmap = new HashMap<>();//hashmap that contains the all the string having same characters
        
        for(String str : strs){
            HashMap<Character,Integer> fmap=new HashMap<>();// contains the count of every character of strings
            
            for(int i = 0; i < str.length(); i++){ // traverse through every character of the string
                char ch = str.charAt(i); 
                
                fmap.put(ch , fmap.getOrDefault(ch , 0) + 1);// putting the characters count in frequency map
            }
            
            if(!bmap.containsKey(fmap)){ // if our main hashmap doesnt contain the hashmap having same no. of character ie if the character counts are not equal then we will create another arraylist and add it in our hashmap
                ArrayList<String> list = new ArrayList<>(); //created new list
                list.add(str);// add that string in newly arraylist
                bmap.put(fmap,list); // adding the new frequency hashmap and new arraylist in the map
            }else{ // if the map contains the same no. of characters count freq hashmap then we just have to add another string in that present list only
                ArrayList<String> list = bmap.get(fmap); // get the arraylist having same no. of characters freq map in the main hashmap
                list.add(str);// add the new string in arraylist
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> val : bmap.values()){ //get all the values means all the arraylist present in the main hashmap bmap.
            result.add(val);//add it another list
        }
        return result; //finally returning our result
    }

//time complexity: O(NM) //n = string in array , m = length of string
//space complexity: O(N)
