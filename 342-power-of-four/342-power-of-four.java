class Solution {
    public boolean isPowerOfFour(int n) {
        boolean res = true;
        
        do{
            if(n == 0) return false;
            if(n == 1) return true;
            if(n % 4 != 0) return false;
            n = n / 4;
        }while(n != 0);
        
        return res;
    }
}