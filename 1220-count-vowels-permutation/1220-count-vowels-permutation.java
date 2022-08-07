class Solution {
    final int modulo = 1000000007;
    public int countVowelPermutation(int n) {
        int[] sumArr = calcMap(1,n,new int[5]);
        long aCnt = sumArr[0];
        long eCnt = sumArr[1];
        long iCnt = sumArr[2];
        long oCnt = sumArr[3];
        long uCnt = sumArr[4];
        
        return (int)((aCnt+eCnt+iCnt+oCnt+uCnt) % modulo);
        
    }
    
    public int[] calcMap(int calc, int n, int[] sumArr){
        if(calc > n){
            return sumArr;
        }
        if(calc == 1){
            sumArr[0] = 1;
            sumArr[1] = 1;
            sumArr[2] = 1;
            sumArr[3] = 1;
            sumArr[4] = 1;
        }else{
            long aCnt = sumArr[0];
            long eCnt = sumArr[1];
            long iCnt = sumArr[2];
            long oCnt = sumArr[3];
            long uCnt = sumArr[4];

            int aToCnt = (int)((eCnt + uCnt + iCnt) % modulo);
            int eToCnt = (int)((aCnt + iCnt) % modulo);
            int iToCnt = (int)((eCnt + oCnt) % modulo);
            int oToCnt = sumArr[2];
            int uToCnt = (int)((iCnt + oCnt) % modulo);
          
            sumArr[0] = aToCnt;
            sumArr[1] = eToCnt;
            sumArr[2] = iToCnt;
            sumArr[3] = oToCnt;
            sumArr[4] = uToCnt;
        }       
        
        return calcMap(calc+1,n,sumArr);
    }    
}