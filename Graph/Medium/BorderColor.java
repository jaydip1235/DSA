public class BorderColor {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid,row,col,grid[row][col]);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0)grid[i][j]=color;
            }
        }
        return grid;
    }
    static int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int[][] grid, int row, int col, int clr){
        grid[row][col]=-clr;
        int count=0;
        for(int i=0;i<4;i++){
            int nr = row+dir[i][0];
            int nc = col+dir[i][1];
            if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length || Math.abs(grid[nr][nc])!=clr)
                continue;
            count++;
            if(grid[nr][nc]==clr){
                dfs(grid,nr,nc,clr);
            }
        }
        if(count==4){
            grid[row][col]=clr;
        }
        
        
    }
}
