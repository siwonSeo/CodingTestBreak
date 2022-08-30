class Solution {
    public void rotate(int[][] matrix) {
        int matSize = matrix.length-1;
        for(int i = 0; i < matSize/2+1; i++){
            int matSizeTo = matSize-i;
            for(int j = i; j < matSizeTo; j++){
                swap(matrix
                     ,i,j
                     ,j,matSizeTo
                     ,matSizeTo,matSize-j
                     ,matSize-j,i)
                    ;
            }
        }
    }
    
    public void swap(int[][] matrix, int y1, int x1, int y2, int x2, int y3, int x3, int y4, int x4){
        int temp = matrix[y1][x1];
        matrix[y1][x1] = matrix[y4][x4];
        matrix[y4][x4] = matrix[y3][x3];
        matrix[y3][x3] = matrix[y2][x2];
        matrix[y2][x2] = temp;
    }
}