class Solution {
    int res = 0;
    public int uniquePaths(int m, int n) {  
        int[][] resArr = new int[m][n];
        int[] arr = resArr[0];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        
        for(int[] a : resArr){
            a[0] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                resArr[i][j] = resArr[i-1][j] + resArr[i][j-1];
            }
        }
        return resArr[m-1][n-1];
    }
    
  
}
