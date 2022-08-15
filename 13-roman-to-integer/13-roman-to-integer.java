class Solution {
    public int romanToInt(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('V','I');
        map.put('X','I');
        map.put('L','X');
        map.put('C','X');
        map.put('D','C');
        map.put('M','C');
        
        Map<Character,Integer> valueMap = new HashMap<>();
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);        
        valueMap.put('M',1000);        
        char[] cArr = s.toCharArray();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(i+1<s.length() && cArr[i]==map.getOrDefault(cArr[i+1],' ')){
                res -= valueMap.get(cArr[i]);
            }else{
                res += valueMap.get(cArr[i]);
            }
        }
        return res;
    }
}