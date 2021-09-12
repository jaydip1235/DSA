// https://leetcode.com/problems/ransom-note/
import java.util.*;
public class RansomeNote {
    public boolean canConstruct(String r, String m) {
        HashMap<Character,Integer>hm= new HashMap<>();
        for(int i=0;i<r.length();i++){
            if(!hm.containsKey(r.charAt(i))){
                hm.put(r.charAt(i),1);
            }
            else{
                  hm.put(r.charAt(i),hm.get(r.charAt(i))+1);
            }
        }
        
        for(int i=0;i<m.length();i++){
            if(hm.containsKey(m.charAt(i)) && hm.get(m.charAt(i))>1){
                hm.put(m.charAt(i),hm.get(m.charAt(i))-1);
            }
            else if(hm.containsKey(m.charAt(i)) && hm.get(m.charAt(i))==1){
                hm.remove(m.charAt(i));
            }
             if(hm.size()==0)return true;
        }
        return false;           
    }
}
