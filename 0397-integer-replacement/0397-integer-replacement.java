class Solution {
    int res = Integer.MAX_VALUE;
    public int integerReplacement(int n) {
        setData(n,0);
        return res;
    }
    
    public void setData(int n, int cnt){
        if(n==1){
            res = Math.min(res,cnt);
            return;
        }
        
        if(n%2 == 0){
            setData(n/2,cnt+1);
        }else{
            setData(n-1,cnt+1);
            if(n==Integer.MAX_VALUE){
                setData(n/2+1,cnt+2);
            }else{
                setData(n+1,cnt+1);
            }
        }
    }
}