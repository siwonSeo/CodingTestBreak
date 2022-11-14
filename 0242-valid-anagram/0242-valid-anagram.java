class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sArr = new char[26];
        char[] tArr = new char[26];
        
        for(int i = 0; i < s.length(); i++){
            sArr[s.charAt(i)-'a']++;
            tArr[t.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < sArr.length; i++){
            if(sArr[i] != tArr[i]){
                return false;
            }
        }
        
        return true;
        
    } 
}