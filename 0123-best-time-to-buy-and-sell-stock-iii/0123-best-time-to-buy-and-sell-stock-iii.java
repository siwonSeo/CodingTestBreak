class Solution {
    public int maxProfit(int[] prices) {
        /*
        int b1 = Integer.MIN_VALUE, s1 = 0;
        int b2 = Integer.MIN_VALUE, s2 = 0;
        
        for (int i = 0; i < prices.length; i++){
            int cur = prices[i];
            b1 = Math.max(b1, -cur);
            s1 = Math.max(s1, b1 + cur);
            b2 = Math.max(b2, s1 - cur);
            s2 = Math.max(s2, b2 + cur);
        }
        return s2;
        */
        
        int[] bArr = new int[2];
        int[] sArr = new int[2];
        
        Arrays.fill(bArr,Integer.MIN_VALUE);
        
        for(int price : prices){
            for(int i = 0; i < bArr.length; i++){
                bArr[i] = Math.max(bArr[i], (i>0 ? sArr[i-1]: 0)-price);
                sArr[i] = Math.max(sArr[i], bArr[i] + price);
            }
        }
        
        return sArr[sArr.length-1];
    }
}