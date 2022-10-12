class Solution {
    public String decodeString(String s) {
        String res = "";
        while(s.contains("]")){
            s = newString(s);
        }
        return s;
    }
    
    public String newString(String s){
        int rIndex = 0;
        int lIndex = 0;
        int numIndex = 0;
        StringBuilder sb = new StringBuilder();
        while(rIndex<s.length()){
            if(s.charAt(rIndex) == ']'){
                break;
            }
            rIndex++;
        }
        
        lIndex = rIndex-1;        
        
        
        while(lIndex>=0){
            if(s.charAt(lIndex) == '['){
                break;
            }
            lIndex--;
        }        
        
        numIndex = lIndex - 1;
        while(numIndex >= 0){
            int num = s.charAt(numIndex) - '0';
            if(num >= 0 && num<= 9){
                numIndex--;
            }else{
                numIndex++;
                break;    
            }
        }
        if(numIndex < 0) numIndex = 0;
        String lStr = s.substring(0,numIndex);
        String rStr = s.substring(rIndex+1);
        int cnt = Integer.parseInt(s.substring(numIndex,lIndex));
        String str = s.substring(lIndex+1,rIndex);
        
        sb.append(lStr);
        while(cnt-->0){
            sb.append(str);
        }
        sb.append(rStr);
        //System.out.println(sb);
        return sb.toString();        
    }
}