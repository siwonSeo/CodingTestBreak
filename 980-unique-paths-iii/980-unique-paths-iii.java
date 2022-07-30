class Solution {
    int res = 0;
    public int uniquePathsIII(int[][] grid) {
        int gridLength = grid.length;
        int nLength = grid[0].length;
        boolean[][] visited = new boolean[gridLength][nLength];
        int startX = 0;
        int startY = 0;
        int goalX = 0;
        int goalY = 0;
        
        for(int i = 0; i < gridLength; i++){
            for(int j = 0; j < nLength; j++){
                int loc =  grid[i][j];
                if(loc == 2){
                    goalX = j;
                    goalY = i;
                }
                if(loc == 1){
                    startX = j;
                    startY = i;
                }                
                if(loc == -1){
                    visited[i][j] = true;
                }
            }
        }
        
        search(grid,visited,goalY,goalX,startY,startX);            
        return res;
    }
    
    public void search(int[][] grid, boolean[][] visited,int goalY,int goalX,int startY,int startX){
        if(goalY == startY && goalX == startX){
        	visited[goalY][goalX] = true;
            setValidPath(visited);
            return;
        }
        
        if(goalY < 0 || goalY >= grid.length || goalX < 0 || goalX >= grid[0].length) {
        	return;
        }
        
        if(grid[goalY][goalX] == -1){
            return;
        }
        
        if(visited[goalY][goalX]){
            return;
        }
        
        visited[goalY][goalX] = true;
        search(grid,visited,goalY+1,goalX,startY,startX);
        search(grid,visited,goalY-1,goalX,startY,startX);
        search(grid,visited,goalY,goalX+1,startY,startX);
        search(grid,visited,goalY,goalX-1,startY,startX);
        visited[goalY][goalX] = false;
        /*
        search(grid,visited.clone(),goalY+1,goalX,startY,startX);
        search(grid,visited.clone(),goalY-1,goalX,startY,startX);
        search(grid,visited.clone(),goalY,goalX+1,startY,startX);
        search(grid,visited.clone(),goalY,goalX-1,startY,startX);
        */
    }
    
    public void setValidPath(boolean[][] visited){
        int gridLength = visited.length;
        int nLength = visited[0].length;
        for(int i = 0; i < gridLength; i++){
            for(int j = 0; j < nLength; j++){
                if(!visited[i][j]){
                    return;
                }
            }
        }
        res++;
    }
}