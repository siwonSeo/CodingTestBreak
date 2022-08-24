class Solution {
    public boolean isPowerOfThree(int n) {

        do{
            if(n==0)return false;
            if(n==1)return true;
            if(n%3 == 0){
                n /= 3;
            }else{
                return false;
            }
        }while( n != 0);
        
        return false;
    }
}