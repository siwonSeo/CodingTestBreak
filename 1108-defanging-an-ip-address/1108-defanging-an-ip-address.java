class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        String[] ipList = address.split("[.]");
        for(int i = 0; i < ipList.length; i++){
            if(i>0){
                sb.append("[.]");
            }
            sb.append(ipList[i]);
        }
        
        return sb.toString();
    }
}