//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
import java.util.*;
public class BSStock {
    public int maxProfit(int[] arr) {
        int bbd = arr[0];
        int maxprofit = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<bbd){
                bbd = arr[i];
            }
            else if(arr[i]-bbd>maxprofit)
                maxprofit = arr[i]-bbd;
        }
        return maxprofit;
    }
}
