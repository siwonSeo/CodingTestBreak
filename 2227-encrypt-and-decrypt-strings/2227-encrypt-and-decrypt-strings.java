class Encrypter {
    Map<Character,String> encTable;
    Map<String,List<Character>> decTable;
    Map<String,Integer> dictionaryMap;
    int decRes;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        encTable = new HashMap<>();
        decTable = new HashMap<>();
        dictionaryMap = new HashMap<>();
        for(int i = 0; i < keys.length; i++){
            encTable.put(keys[i], values[i]);
            if(decTable.containsKey(values[i])){
                decTable.get(values[i]).add(keys[i]);
            }else{
                int k = i;
                decTable.put(values[i],new ArrayList<Character>(){{add(keys[k]);}});
            }
            
        }
        
        for(String s : dictionary){
            char[] cArr = s.toCharArray();
            //dictionarySet.add(s);
            StringBuilder sb = new StringBuilder();
            boolean appendYn = true;
            for(char c : cArr){
                if(!encTable.containsKey(c)){
                    appendYn = false;
                    break;                    
                }
                sb.append(encTable.get(c));
            }            
            
            if(!appendYn){
                continue;
            }
            
            String d = sb.toString();
            if(d.length() > 0){
                dictionaryMap.put(d,dictionaryMap.getOrDefault(d,0)+1);
            }
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = word1.toCharArray();
        for(char c : cArr){
            sb.append(encTable.get(c));
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        
        return dictionaryMap.getOrDefault(word2,0);
    }
    
    }

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */