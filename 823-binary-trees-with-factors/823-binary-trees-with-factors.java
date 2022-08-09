class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        final int modulo = 1000000007;
        Arrays.sort(arr);
        long res = 1;
        Map<Integer,Long> numMap = new HashMap<>();
        numMap.put(arr[0],res);
        for(int i = 1; i < arr.length; i++){
            long sum = 1;
            int c = arr[i];
            for(int j = 0; j < i; j++){
                int to = arr[j];
                if(c%to==0 && numMap.containsKey(c/to)){
                    sum=sum+(numMap.get(to)*(numMap.get(c/to)));
                }
            }
            numMap.put(c,sum);
            res+=sum;
        }
        
        return (int)(res%modulo);
    }
}