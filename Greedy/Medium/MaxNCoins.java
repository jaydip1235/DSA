// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
import java.util.* ;
public class MaxNCoins{

     public int maxCoins(int[] piles) {
        
        Arrays.sort(piles);
        int p=piles.length-2;
        int i=0,sum=0;
        while(i++<(piles.length/3)){
            sum+=piles[p];
            p-=2;
        }
        return sum;
    }


}