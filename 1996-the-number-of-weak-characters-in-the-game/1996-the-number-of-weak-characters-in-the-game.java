class Solution {
    public int numberOfWeakCharacters(int[][] properties) {        
        Comparator<int[]> comp = (a,b)->{return (b[0]+b[1])- (a[0]+a[1]);};       
        
        Arrays.sort(properties,comp);
        int res = 0;
        
        for(int[] prop : properties){
            for(int[] prop2 : properties){
                int sum1 = prop[0] + prop[1];
                int sum2 = prop2[0] + prop2[1];
                if(sum1 > sum2 - 2){
                    break;
                }
                
                if(prop[0] < prop2[0] && prop[1] < prop2[1]){
                    res++;
                    break;
                }
            }
        }        

        return res;
        
    }
}