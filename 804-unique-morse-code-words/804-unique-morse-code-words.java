class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseArr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> resSet = new HashSet<>();
        for(String str : words){
            StringBuilder sb = new StringBuilder();
            char[] cArr = str.toCharArray();
            for(char c : cArr){
                sb.append(morseArr[c-'a']);
            }
            resSet.add(sb.toString());
        }
        
        return resSet.size();
    }
}