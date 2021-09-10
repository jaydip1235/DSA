// https://leetcode.com/problems/most-common-word/
import java.util.*;
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        HashSet<String> set = new HashSet<>();
        
        for(String s : banned){
            set.add(s);
        }
        
        HashMap<String,Integer> hm = new HashMap<>();
        String[] words = paragraph.toLowerCase().split("\\W+");
        
        for(String ss : words){
            if(!set.contains(ss)){
                hm.put(ss,hm.getOrDefault(ss,0)+1);
            }
        }
        String res = "";
        int max =0;
        for(String word : hm.keySet()){
            if(hm.get(word)>max){
                max = hm.get(word);
                res = word;
            }
        }
        System.out.println(max);
        return res;
    }
}
