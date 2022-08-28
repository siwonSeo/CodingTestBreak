class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int yLength = mat.length;
        int xLength = mat[0].length;
        for(int i = 0; i < xLength+yLength; i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int start = Math.max(0,yLength - 1 - i);
            int to = Math.min(yLength, xLength+yLength - i - 1);            
            int xIndex = Math.max(0, i - yLength + 1);
            
            int tempCnt = 0;
            for(int j = start; j < to; j++){
                pq.add(mat[j][xIndex+tempCnt]);
                tempCnt++;
            }
            tempCnt = 0;
            for(int j = start; j < to; j++){
                mat[j][xIndex+tempCnt] = pq.poll();
                tempCnt++;
            }              
          
        }
        
        return mat;
    }
    

}