class Solution {
    class Location{
        char c;
        int location;
        int count;
        
        Location(char c,int location, int count){
            this.c =c;
            this.location = location;
            this.count = count;
        }
        
    }
    public int firstUniqChar(String s) {
        int res = -1;
        int resComp = -1;
        Map<Character,Location> map = new LinkedHashMap<>();
        char[] cArr = s.toCharArray();
        for(int i = 0; i < cArr.length;  i++){                       
            char c = cArr[i];
            if(map.containsKey(c)){
                map.get(c).count++;
            }else{
                map.put(c,new Location(c,i,1));
            }
        }

        
        for(Map.Entry<Character,Location> entry : map.entrySet()){
            int index = entry.getKey();
            Location value = entry.getValue();
         
            if(value.count == 1){
                return value.location;
            }
        }
        
        return res;
    }
}