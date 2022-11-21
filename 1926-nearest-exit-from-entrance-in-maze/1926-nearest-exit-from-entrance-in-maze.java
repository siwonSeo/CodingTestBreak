class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        var q = new ArrayDeque<>(List.of(entrance));
        maze[entrance[0]][entrance[1]] = '+';

        for (int m = maze.length, n = maze[0].length, steps = 1; !q.isEmpty(); steps++)
            for (var i = q.size(); i > 0; i--) {
                var cell = q.poll();

                for (var dir : DIRS) {
                    var r = cell[0] + dir[0];
                    var c = cell[1] + dir[1];

                    if (r == -1 || r == m || c == -1 || c == n || maze[r][c] == '+') // reached out of bounds or a wall
                        continue;
                    if (r == 0 || r == m - 1 || c == 0 || c == n - 1) // reached a border
                        return steps;

                    maze[r][c] = '+'; // mark visited
                    q.add(new int[]{r, c});
                }
            }
        return -1;
    }    
}