class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        String res = "";
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c == ' '){
                if(!sb.isEmpty()) list.add(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(c);    
            }            
        }
        
        if(!sb.isEmpty()){
            list.add(sb.toString());
            sb = new StringBuilder();    
        }
        
        
        for(int i = list.size() -1; i >= 0; i--){
            if(i < list.size() -1){
                sb.append(" ");    
            }
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}