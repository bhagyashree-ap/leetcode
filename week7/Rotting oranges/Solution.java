class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 2);
                }
            }
        }

        int max = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1; // fresh left
                max = Math.max(max, grid[i][j]);
            }
        }

        return max - 2;
    }

    private void dfs(int[][] g, int x, int y, int time) {
        int m = g.length, n = g[0].length;

        if (x < 0 || y < 0 || x >= m || y >= n || 
            (g[x][y] != 1 && g[x][y] < time)) {
            return;
        }

        g[x][y] = time;

        dfs(g, x + 1, y, time + 1);
        dfs(g, x - 1, y, time + 1);
        dfs(g, x, y + 1, time + 1);
        dfs(g, x, y - 1, time + 1);
    }
}
