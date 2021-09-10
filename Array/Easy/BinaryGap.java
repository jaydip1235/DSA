// https://leetcode.com/problems/binary-gap/
import java.util.*;
public class BinaryGap {
    ArrayList<Integer> al = new ArrayList<>();
    public int binaryGap(int n) {
        if((n & (n-1))==0)return 0;
        getBin(n);
        Collections.reverse(al);
        
        int p =0, c=1;
        int dist = 0;
        for(int i=1;i<al.size();i++){
            if(al.get(i)==0)c++;
            else{
                dist = Math.max(dist,(c-p));
                p=c;  
                c++;
            }
        }
        return dist;
    }
    public void getBin(int n){
        while(n!=0){
            int rem = n%2;
            al.add(rem);
            n/=2;
        }
    }
}
