class Solution {
    int sum = 0;
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] sArr = new int[s.length()];
        for(int i = 0; i < sArr.length; i++){
            getCnt(n,startPos[1],startPos[0],i,s);
            sArr[i] = sum;
            sum = 0;
        }
        return sArr;
    }
    
    public void getCnt(int n, int x, int y,int index, String s){
        if(index == s.length()){
            return;
        }
        
        char c = s.charAt(index);
        
        if(c =='R') x++;
        if(c =='L') x--;
        if(c =='U') y--;
        if(c =='D') y++;
        
        if(x<0 || x >= n || y<0 || y >= n){
            return;
        }        
        sum++;
        getCnt(n,x,y,index+1,s);
    }
}