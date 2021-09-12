// https://leetcode.com/problems/count-primes/
import java.util.*;
public class CountPrime {
    public int countPrimes(int n) {
        
        int sieve[] = new int[n+1];
        for(int i=2;i*i<=n;i++){
            if(sieve[i]==0){
                for(int j=i*i;j<=n;j+=i){
                    sieve[j]=1;
                }
            }
        }
        
        int count = 0;
        for(int i=2;i<n;i++){
            if(sieve[i]==0)count++;
        }
        return count;
        
    } 
}
