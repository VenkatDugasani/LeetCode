class Solution {
    private void dfs(int[][] grid, int sr, int sc , int color, int curr)
    {
        if(sr < 0 || sr >= grid.length|| sc < 0 || sc >= grid[0].length)
        return;
        if(grid[sr][sc] != curr) return;
        grid[sr][sc] = color;
        dfs(grid, sr+1, sc, color,curr);
        dfs(grid, sr-1, sc, color,curr);
        dfs(grid, sr, sc +1, color,curr);
        dfs(grid, sr, sc-1, color,curr);


    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
        return image;
        int n = image.length;
        int m = image[0].length;
    //    int[][] res = new int[n][m];

       dfs(image, sr, sc, color, image[sr][sc]);

       return image;
        
    }
}