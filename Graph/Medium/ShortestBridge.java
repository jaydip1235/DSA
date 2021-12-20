import java.util.*;
public class ShortestBridge {
    static int dir[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public static class Pair {
    int x;
    int y;

    Pair(int row, int col) {
      this.x = row;
      this.y = col;
    }

  }
    public int shortestBridge(int[][] arr) {
        int dist = 0;
        LinkedList<Pair> q = new LinkedList();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        boolean flag=false;
        
        for(int i=0;i<arr.length && !flag ;i++){
            for(int j=0;j<arr[0].length && !flag;j++){
                if(arr[i][j]==1){
                    dfs(i,j,arr,q,visited);
                    flag=true;
                }
            }
        }
        while(q.size()>0){
            int sz = q.size();
            while(sz-->0){
                Pair rem = q.removeFirst();
                for(int p=0;p<4;p++){
                    int nr = rem.x + dir[p][0];
                    int nc = rem.y + dir[p][1];
                    if(nr<0 || nc<0 || nr>=arr.length || nc>=arr[0].length || visited[nr][nc]==true)continue;
                    if(arr[nr][nc]==1)return dist;
                    q.addLast(new Pair(nr,nc));
                    visited[nr][nc]=true;
                }
                
            }
            dist++;

        }
        return -1;
        
    }
    private void dfs(int r, int c,int[][] arr, LinkedList<Pair>q, boolean [][]vis){
        vis[r][c]=true;
        q.addLast(new Pair(r,c));
        for(int i=0;i<4;i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr<0 || nc<0 || nr>=arr.length || nc>=arr[0].length || vis[nr][nc]==true || arr[nr][nc]==0)
                continue;
            dfs(nr,nc,arr,q,vis);
        }
    }
}
