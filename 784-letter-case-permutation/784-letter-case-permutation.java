class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){   
            char c = s.charAt(i);
            if(!(c >= '0' && c <= '9')) {
                list.add(i);
            }
        }
        
        setPermutation(s,list,res,0);        
        return res;
    }
    
    public void setPermutation(String s,List<Integer> list,List<String> res,int index){
        
        if(index == list.size()){
            res.add(s);
            return;
        }
        char[] cArr = s.toCharArray();
        
        int idx = list.get(index);
        char c = s.charAt(idx);
        cArr[idx] = Character.toLowerCase(c);
        setPermutation(new String(cArr), list, res,index+1);
        cArr[idx] = Character.toUpperCase(c);
        setPermutation(new String(cArr), list, res,index+1);     
        
    }
}