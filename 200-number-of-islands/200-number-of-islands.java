class Solution {
    int res = 0;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int lengthY = grid.length;
        int lengthX = grid[0].length;        
        visited = new boolean[lengthY][lengthX];
        for(int i = 0; i < lengthY; i++){
            for(int j = 0; j < lengthX; j++){
                if(visited[i][j] || grid[i][j] == '0'){
                    continue;
                }
                res++;
                setLand(grid,i,j);
            }
        }
        
        return res;
    }
    
    public void setLand(char[][] grid, int y, int x){
        int lengthY = grid.length;
        int lengthX = grid[0].length;
        if(y < 0 || y >= lengthY 
           || x < 0 || x >= lengthX){
            return;
        }
        
        if(visited[y][x]){
            return;
        }
        
        visited[y][x] = true;
        
        if(grid[y][x] == '0'){
            return;
        }              
        
        setLand(grid,y+1,x);
        setLand(grid,y-1,x);
        setLand(grid,y,x+1);
        setLand(grid,y,x-1);         
    }
   
}