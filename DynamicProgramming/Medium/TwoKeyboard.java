// https://leetcode.com/problems/2-keys-keyboard/
import java.util.*;
public class TwoKeyboard{
        public int minSteps(int n) {
        int ans=0;
        for(int i=2;i*i<=n;){
            if(n%i==0){
                ans+=i;
                n/=i;
            }
            else i++;
        }
        if(n!=1)ans+=n;
        return ans;
    }
}