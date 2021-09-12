// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
import java.util.*;
public class KidWithGreatestNoOfCandies {
    public List<Boolean> kidsWithCandies(int[] arr, int ex) {
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxi) maxi=arr[i];
            arr[i]+=ex;
        }
        List<Boolean> res = new ArrayList<>(arr.length);
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=maxi)res.add(true);
            else res.add(false);
        }
        return res;
    }
}
