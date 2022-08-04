class Solution {
    public String defangIPaddr(String address) {
        char[] cArr = new char[address.length()+6];
        char[] addressArr = address.toCharArray();
        int setIndex = 0;
        for(int i = 0; i < addressArr.length; i++){
            char c = addressArr[i];
            if(c == '.'){
                cArr[setIndex++] = '[';
                cArr[setIndex++] = '.';
                cArr[setIndex++] = ']';
            }else{
                cArr[setIndex++] = c;    
            }
            
        }
        
        return new String(cArr);
        
    }

}