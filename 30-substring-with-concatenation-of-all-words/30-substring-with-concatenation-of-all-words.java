class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String,Integer> wordMap = getWordsMap(words);
        int wordsLength = words.length;
        int wordLength = words[0].length();
        int subStrLength = wordsLength * wordLength;
        for(int i = 0; i <= s.length()-subStrLength;i++){
            String subStr = s.substring(i,i+subStrLength);
            if(getMached(subStr,wordMap,wordLength)){
                res.add(i);

            }
        }
               
        return res;
        
        
    }
    
    public Map<String,Integer> getWordsMap(String[] words){
        Map<String,Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        return map;
    }
    
    public boolean getMached(String s, Map<String,Integer> orgMap,int wordLength){
        boolean res = true;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i+=wordLength){            
            String str = s.substring(i,i+wordLength);
            if(!orgMap.containsKey(str)){
                return false;
            }
            map.put(str, map.getOrDefault(str,0)+1);
        }
        System.out.println(map);
        return orgMap.equals(map);
    }
}