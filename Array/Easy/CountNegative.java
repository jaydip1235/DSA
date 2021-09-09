// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
import java.util.*;
public class CountNegative{
    public int countNegatives(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int i=0;
        int j= c-1;
        int ans = 0;
        while(i<r && j>=0){
            if(grid[i][j]<0){
                ans+=r-i;
                j--;
            }
            else{
                i++;
            } 
        }
            return ans;
            
        }
}