// https://leetcode.com/problems/distribute-candies-to-people/
import java.util.*;
public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int count=0;
        while(candies>0){
            if(candies<=count){
                arr[count%num_people]+=candies;
                break;
            }
            arr[count%num_people] += ++count;
            candies -=count; 
        }
        return arr;
        
    }
}
