import java.util.*;
public class SlidingPuzzle {
    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
      }
        public int slidingPuzzle(int[][] board) {
            
            int level=0;
            String tar = "123450";
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    sb.append(board[i][j]);
                }
            }
            String initial = sb.toString();
            int[][] sidx = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
            LinkedList<String> q = new LinkedList<>();
            HashSet<String> hs = new HashSet<>();
            hs.add(initial);
            q.addLast(initial);
            while(q.size()>0){
                int sz = q.size();
                while(sz-->0){
                    String rem = q.removeFirst();
                    if(rem.equals(tar))return level;
                    int idx=rem.indexOf('0');
                    int[] swap = sidx[idx];
                    for(int i=0;i<swap.length;i++){
                        String res = swap(rem,idx,swap[i]);
                        if(hs.contains(res))continue;
                        q.addLast(res);
                        hs.add(res);
                    }
                }
                level++;
            }
            return -1;
        } 
}
