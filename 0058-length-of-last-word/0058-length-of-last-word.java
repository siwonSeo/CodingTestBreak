class Solution {
    public int lengthOfLastWord(String s) {
        final char blank = ' ';
        int res = 0;
        for(int i = s.length()-1; i >=0; i--){
            char c = s.charAt(i);
            if(c == blank){
                if(res == 0){
                  continue;  
                }else{
                    break;
                }
            }
            res++;
        }
        return res;
    }
}