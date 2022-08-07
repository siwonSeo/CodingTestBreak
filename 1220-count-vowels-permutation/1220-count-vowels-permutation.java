class Solution {
    final int modulo = 1000000007;
    public int countVowelPermutation(int n) {
        Map<Character, Integer> sumMap = calcMap(1,n,new HashMap<Character, Integer>());
        long aCnt = sumMap.get('a');
        long eCnt = sumMap.get('e');
        long iCnt = sumMap.get('i');
        long oCnt = sumMap.get('o');
        long uCnt = sumMap.get('u');
        
        return (int)((aCnt+eCnt+iCnt+oCnt+uCnt) % modulo);
        
    }
    
    public Map<Character, Integer> calcMap(int calc, int n, Map<Character, Integer> sumMap){
        if(calc > n){
            return sumMap;
        }
        if(calc == 1){
            sumMap = new HashMap<Character, Integer>(){{
                put('a',1);
                put('e',1);
                put('i',1);
                put('o',1);
                put('u',1);
            }};
        }else{
            long aCnt = sumMap.get('a');
            long eCnt = sumMap.get('e');
            long iCnt = sumMap.get('i');
            long oCnt = sumMap.get('o');
            long uCnt = sumMap.get('u');

            int aToCnt = (int)((eCnt + uCnt + iCnt) % modulo);
            int eToCnt = (int)((aCnt + iCnt) % modulo);
            int iToCnt = (int)((eCnt + oCnt) % modulo);
            int oToCnt = sumMap.get('i');
            int uToCnt = (int)((iCnt + oCnt) % modulo);

            sumMap.put('a',aToCnt);         
            sumMap.put('e',eToCnt);
            sumMap.put('i',iToCnt);
            sumMap.put('o',oToCnt);
            sumMap.put('u',uToCnt);
        }       

        
        return calcMap(calc+1,n,sumMap);
    }
}