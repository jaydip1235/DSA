import java.util.*;
public class AsFarFromLand {
    static int dir[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public static class Pair {
    int x;
    int y;

    Pair(int row, int col) {
      this.x = row;
      this.y = col;
    }

  }
    public int maxDistance(int[][] arr) {
        LinkedList<Pair> q = new LinkedList<>();
        int level = -1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1)q.addLast(new Pair(i,j));
            }
        }
        
        while(q.size()>0){
            int sz = q.size();
            level++;
            while(sz-->0){
                Pair rm = q.removeFirst();
                for(int i=0;i<4;i++){
                    int nr = rm.x + dir[i][0];
                    int nc = rm.y + dir[i][1];
                    if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && arr[nr][nc]==0){
                        q.addLast(new Pair(nr,nc));
                        arr[nr][nc]=1;
                    }
                }
            }
        }
        return level==0?-1:level;
    } 
}
