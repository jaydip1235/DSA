// https://leetcode.com/problems/perfect-number/
import java.util.*;
public class PerfectNo {
    public boolean checkPerfectNumber(int n) {
        int sum = 0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                sum+=i;
                if(n/i!=i){
                    sum+=(n/i);
                }
            }
        }

        return sum==2*n;
    }
}
