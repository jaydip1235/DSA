import java.util.*;
public class RottenOranges {
    static int dir[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public static class Pair {
    int x;
    int y;

    Pair(int row, int col) {
      this.x = row;
      this.y = col;
    }

  }
    public int orangesRotting(int[][] arr) {
      LinkedList<Pair>q = new LinkedList<>();
        int fresh=0;
        int level=-1;
      for(int i=0;i<arr.length;i++){
          for(int j=0;j<arr[0].length;j++){
              if(arr[i][j]==2)q.addLast(new Pair(i,j));
              else if(arr[i][j]==1)fresh++;
          }
      }
    if(fresh==0)return 0;
        while(q.size()>0){
            level++;
            int sz = q.size();
            while(sz-->0){
                Pair rm = q.removeFirst();
                for(int i=0;i<4;i++){
                    int nr = rm.x + dir[i][0];
                    int nc = rm.y + dir[i][1];
                    if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && arr[nr][nc]==1){
                        q.addLast(new Pair(nr,nc));
                        arr[nr][nc]=0;
                        fresh--;
                    }
                }
            }
            
        }
        if(fresh==0)return level;
        return -1;
        
    }
}
