class Solution {
    int res = 0;
    public int maxProfit(int k, int[] prices) {
    int[] maxProfit = new int[k+1];
    int[] lowPrice = new int[k+1];
    for(int i=0; i<lowPrice.length; i++) lowPrice[i]=Integer.MAX_VALUE;
    for(int p : prices){
            for(int i=1; i<=k; i++){
                maxProfit[i] = Math.max(maxProfit[i],p-lowPrice[i]);
                lowPrice[i] = Math.min(lowPrice[i],p-maxProfit[i-1]);
            }
    }
    return maxProfit[k];
    }
}