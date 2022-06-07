//https://leetcode.com/problems/word-break-ii/
import java.util.*;
public class WordBreakTwo {
  HashMap<String,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s))return map.get(s);
        List<String>res = new ArrayList<>();
        for(String w:wordDict){
            if(s.length()>=w.length() && s.substring(0,w.length()).equals(w)){
                if(w.length()==s.length()){
                    res.add(s);
                }else{
                    List<String> temp = wordBreak(s.substring(w.length()),wordDict);
                    for(String t:temp){
                        res.add(w+" "+t);
                    }
                }
            }
        }
        map.put(s,res);
        return res;
    }
}
