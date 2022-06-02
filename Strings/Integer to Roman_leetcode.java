//Appraoch 

//we will create array where we stored the values nd their corresponding values. We will iterate till our values array. where we will have a condition that whenever the num >= val[i] we will add that val[i] character in the string. num>=val[i] means that this is the correct character to be used. example : 58 and val[i] = 50 and its character is L. so 58 is greater than 50 so we will add L in string and reduce the number 58 by val[i] i.e 58 - 50 = 8. Now 8 > 5. 5 character is V in roman. so we will add it in string, i.e "LV". now num becomes 8-5 = 3. we will write 3 by III so we will add it in the string and our final answer will be LVIII.

//code:
final static int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    final static String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        String temp = "";
        
        for(int i = 0; num > 0; i++){
            while(num >= val[i]){
               String ch = rom[i];
                temp += ch;
                num -= val[i];
            }
        }
        return temp;
    }

//Time complexity: O(N)
//Space complexity: O(N)
