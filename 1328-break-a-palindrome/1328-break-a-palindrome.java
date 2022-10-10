class Solution {
    public String breakPalindrome(String palindrome) {
        String res = "";
        char[] cArr = palindrome.toCharArray();
        final int a = 'a';
        int sLength = palindrome.length();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : cArr){
            map.merge(c, 1, (k, v) -> map.get(c) + 1);
        }
        
        if(palindrome.length() <= 1) return res;
        
        if(map.size() == 1){            
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                char c = entry.getKey();
                if(entry.getValue() == 1){
                    return res;
                }else{
                    if(c == 'a'){
                        cArr[sLength - 1] = 'b';
                    }else{
                        cArr[0] = 'a';
                    }
                    return new String(cArr);
                }
                
            }
            
        }
        
        
        for(int i = 0; i < (sLength+1)/2; i++){
            char c = cArr[i];          
            
            
            if((sLength+1) / 2 == i+1){
                if(sLength % 2 == 0){
                    cArr[i] = 'a';                    
                }else{
                    cArr[sLength-1] = 'b';
                }
                return new String(cArr);
            }       

            
            if(c != 'a'){           
                cArr[i] = 'a';
                break;                
            }

        }
        
        return new String(cArr);
    }
}