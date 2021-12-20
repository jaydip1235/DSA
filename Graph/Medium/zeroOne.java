import java.util.*;
public class zeroOne {
    private static class Pair {
        int x;
        int y;
    
        Pair(int x, int y) {
          this.x = x;
          this.y = y;
        }
      }
        static int dir[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        public int[][] updateMatrix(int[][] mat) {
            LinkedList<Pair> q = new LinkedList<>();
            for(int i=0;i<mat.length;i++)
            {
                for(int j=0;j<mat[0].length;j++){
                    if(mat[i][j]==0)q.addLast(new Pair(i,j));
                    else mat[i][j]=-1;
                }
            }    
                
            while(q.size()>0){
                Pair rem = q.removeFirst();
                for(int i=0;i<4;i++){
                    int nr =  rem.x + dir[i][0];
                    int nc = rem.y + dir[i][1];
                    
                    if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && mat[nr][nc]==-1){
                        q.addLast(new Pair(nr,nc));
                        mat[nr][nc] = mat[rem.x][rem.y]+1;
                    }
                }
                
            }
            return mat;    
                
        }
}
