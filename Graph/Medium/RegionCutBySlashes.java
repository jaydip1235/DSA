// https://leetcode.com/problems/regions-cut-by-slashes/
import java.util.*;
public class RegionCutBySlashes {
    public static int regionsBySlashes(String[] grid)
    {
      int n = grid.length;
      int dots = n + 1;
  
      par = new int[dots * dots];
      rank = new int[dots * dots];
      count = 1;
  
      for (int i = 0; i < par.length; i++)
      {
        par[i] = i;
        rank[i] = 1;
      }
  
      for (int i = 0; i < dots; i++)
      {
        for (int j = 0; j < dots; j++)
        {
          if (i == 0 || j == 0 || i == dots - 1 || j == dots - 1)
          {
            int cellno = i * dots + j;
  
            if (cellno != 0)
              union(0, cellno);
          }
        }
      }
  
      for (int i = 0; i < grid.length; i++)
      {
        char[] ch = grid[i].toCharArray();
        for (int j = 0; j < ch.length; j++)
        {
          if (ch[j] == '/')
          {
            int cellno1 = i * dots + j + 1;
            int cellno2 = (i + 1) * dots + j;
            union(cellno1, cellno2);
          }
          else if (ch[j] == '\\')
          {
            int cellno1 = i * dots + j;
            int cellno2 = (i + 1) * dots + (j + 1);
            union(cellno1, cellno2);
          }
        }
      }
      return count;
    }
  
    static int[] par;
    static int[] rank;
    static int count;
  
    public static int find(int x) {
      if (par[x] == x)
      {
        return x;
      }
      int temp = find(par[x]);
      par[x] = temp;
      return temp;
    }
  
    public static void union(int x, int y)
    {
      int lx = find(x);
      int ly = find(y);
  
      if (lx != ly)
      {
        if (rank[lx] > rank[ly])
        {
          par[ly] = lx;
        }
        else if (rank[lx] < rank[ly])
        {
          par[lx] = ly;
        }
        else {
          par[lx] = ly;
          rank[ly]++;
        }
      }
      else
      {
        count++;
      }
    }
}
