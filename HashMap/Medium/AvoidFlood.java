// https://leetcode.com/problems/avoid-flood-in-the-city/
import java.util.*;
public class AvoidFlood{
     public int[] avoidFlood(int[] rains) {
        
        int n=rains.length;
        int ans[] = new int[n];
        HashMap<Integer,Integer> last = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>();
        for(int i=0;i<rains.length;i++){
            int x = rains[i];
            if(x==0){
                dry.add(i);
                ans[i]=1;
            }
            else{
               Integer id = last.get(x);
                if(id==null){
                    last.put(x,i);
                }else{
                    Integer dryDay = dry.higher(id);
                    if(dryDay==null){
                        return new int[0];
                    }else{
                        ans[dryDay]=x;
                        dry.remove(dryDay);
                        last.put(x,i);
                    }
                }
                ans[i]=-1;
            }
        }
        return ans;
        
    }
}