//Appraoch 1 (USING RECURSION)

/*method: we will iterate through our haystack string and if we get the same character as that of needle.charAt(0) then we will check that whether the rest elements in the haystack elements contains the same substring as that of needle. if it exists then we will return the starting index of substring. */

//code:
public int strStr(String haystack, String needle) {
        
      int n = haystack.length(),m=needle.length();
       
        
		for(int i=0;i<n-m+1;i++){
			if(haystack.charAt(i)==needle.charAt(0)){
				if(isSame(haystack,needle,i,0)) return i;
			}
		}
		return -1;
	}

	boolean isSame(String a,String b,int i,int j){
		if(j>=b.length()) return true;
		if(a.charAt(i)!=b.charAt(j)) return false;
		return isSame(a,b,i+1,j+1);
	}

//Time complexity: O(N)
//Space complexity: O(1)



//Approach 2(USING SUBSTRING)

//method: remains same;

//code:
public int strStr(String haystack, String needle) {
        
      int n = haystack.length(),m=needle.length();
       
        
		for(int i=0;i<n-m+1;i++){
			if(haystack.charAt(i)==needle.charAt(0)){
				if(isSame(haystack,needle,i,0)) return i;
			}
		}
		return -1;
	}

	boolean isSame(String a,String b,int i,int j){
		if(j>=b.length()) return true;
		if(a.charAt(i)!=b.charAt(j)) return false;
		return isSame(a,b,i+1,j+1);
	}

//Time complexity: O(N)
//Space complexity: O(1)
