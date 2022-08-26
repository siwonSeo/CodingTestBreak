class Solution {
    public boolean reorderedPowerOf2(int n) {
        boolean res = false;
        Set<Integer> powSet = new HashSet<>();
        char[] cArr = String.valueOf(n).toCharArray();
        int cArrLength = cArr.length;         
        
        int pow = 1;
        int num = 1;
        
        for(int i = 0; i < cArrLength - 1; i++){
            pow *= 10;
        }
        
        while(num / pow < 10){
            if(num >= pow){
                powSet.add(num);
            }
            num *= 2;
        }
        
        for(int powNum : powSet){
            if(isPower(powNum,cArr)){
                return true;
            }
        }        
        
        return false;
    }
    
    public boolean isPower(int powNum, char[] cArr){
        char[] powcArr = String.valueOf(powNum).toCharArray();          

        int[] kArr = new int[10];
        for(int i = 0; i < powcArr.length; i++){
            kArr[powcArr[i] - '0']++;
            kArr[cArr[i] - '0']--;
        }
        for(int cnt : kArr){
            if(cnt != 0){
                return false;
            }
        }
        return true;
        
    }
}