class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        setIp(s, new StringBuilder(),res, 0, 0);
        return res;
    }
    
    public void setIp(String s, StringBuilder resStr, List<String> list, int setCnt, int index){
        if(setCnt == 4){
            if(index == s.length()){
                list.add(resStr.toString());
            }
            return;
        }             
        
        for(int j = index; j<= Math.min(index+2,s.length()-1); j++){
            String subStr = s.substring(index,j+1);   
            if(j==index || 
              (s.charAt(index) != '0' && Integer.parseInt(subStr) <= 255)){
            StringBuilder sb = new StringBuilder(resStr);
            if(setCnt>0) sb.append(".");
            sb.append(subStr);
            setIp(s,sb,list,setCnt+1,j+1);
            }
        }
    }
    
}