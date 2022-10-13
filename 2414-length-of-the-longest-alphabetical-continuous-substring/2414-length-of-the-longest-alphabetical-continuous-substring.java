class Solution {
    public int longestContinuousSubstring(String s) {
        int res = 1;
        int continueCnt = 1;
        char temp = s.charAt(0);
        for(int i = 1; i < s.length();i++){
            char c = s.charAt(i);
            if(c-temp == 1){
                ++continueCnt;
            }else{
                continueCnt = 1;
            }
            temp = c;
            res = Math.max(res,continueCnt);
        }
        
        return res;
    }
}