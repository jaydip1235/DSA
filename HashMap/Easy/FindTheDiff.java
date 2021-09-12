// https://leetcode.com/problems/find-the-difference/
import java.util.*;
public class FindTheDiff {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!hm.containsKey(t.charAt(i))){
                hm.put(t.charAt(i),1);
            }
            else{
                 hm.put(t.charAt(i),hm.get(t.charAt(i))+1);
            }
        }
        
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i))>1){
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
            }
            else if(hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i))==1){
                hm.remove(s.charAt(i));
            }
        }
        for(char c : hm.keySet()){
            return c;
        }
        return '0';
    }
}
