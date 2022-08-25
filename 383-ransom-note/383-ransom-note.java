class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] a = ransomNote.toCharArray();
        char[] b = magazine.toCharArray();
        
        
        int[] alpha = new int['z'-'a'+1];
        for(char cha : b){
            alpha[cha-'a']++;
        }
        
        for(char cha : a){
            if(alpha[cha-'a']-- == 0){
                return false;
            }
        }
        return true;
        
        
    }
}