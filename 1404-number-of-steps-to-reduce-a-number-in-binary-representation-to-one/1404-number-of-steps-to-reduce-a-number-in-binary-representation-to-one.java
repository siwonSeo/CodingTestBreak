class Solution {
    public int numSteps(String s) {
        int res = 0;
        int index = s.length() - 1;
        while(!"1".equals(s)){
            char c = s.charAt(index);
            if(c-'0' == 0){
                s = s.substring(0,index);
                index--;
            }else{
                int orgLength = s.length();
                s = getPlusStr(s);
                if(s.length() > orgLength){
                    index++;
                }
            }
            res++;
        }
        return res;
    }
    
    public String getPlusStr(String s){
        boolean carry = false;
        char[] cArr = s.toCharArray();
        for(int i = cArr.length-1; i >= 0; i--){
            if(i==cArr.length-1){
                carry = true;
                cArr[cArr.length-1] = '0';
                continue;
            }
            
            if(carry){
                if(cArr[i] == '0'){
                    cArr[i] = '1';
                    carry = false;
                }else{
                    cArr[i] = '0';
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(carry) sb.append("1");
        sb.append(new String(cArr));
        return sb.toString();
    }
}