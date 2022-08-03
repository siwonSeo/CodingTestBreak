class Solution {
    /*
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays,sort(arr1);
        Arrays,sort(arr2);
    } 
    */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for(int i = 0; i < arr1.length; i++){
            int arr1Num = arr1[i];
            boolean notDist = false;
            for(int j = 0; j < arr2.length; j++){
                if(Math.abs(arr1Num - arr2[j]) <= d){
                    notDist = true;
                    break;
                }
            }
            if(!notDist){
                res++;
            }
        }
        return res;
    }
}