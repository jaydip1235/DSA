// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
import java.util.*;
public class ProSumDiff {
    public int subtractProductAndSum(int n) {
        int pro=1,sum=0;
        while(n!=0){
            int rem = n%10;
            sum+=rem;
            pro*=rem;
            n/=10;
        }
        return pro-sum;
    } 
}
