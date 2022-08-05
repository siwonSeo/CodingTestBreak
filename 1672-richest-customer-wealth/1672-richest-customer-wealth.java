class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for(int i = 0; i < accounts.length; i++){
            int[] b = accounts[i];
            int sum = 0;
            for(int j = 0; j < b.length; j++){
                sum += b[j];
            }
            res = Math.max(res,sum);
        }
        
        return res;
    }
}