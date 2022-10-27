class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        for(int i = 1 - img1.length; i < img1.length; i++){
            for(int j = 1 - img1[0].length; j < img1[0].length; j++){
                res = Math.max(res, overlapCount(img1,img2,i,j));
            }
        }
        return res;
    }
    
    public int overlapCount(int[][] img1, int[][] img2, int y, int x){
        int count = 0;
        for(int i = 0; i < img1.length; i++){
            for(int j = 0; j < img1[0].length; j++){
                if(i-y >= 0 && i-y < img1.length && j-x >= 0 && j-x < img1[0].length 
                      && img1[i][j] == img2[i-y][j-x] && img1[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}