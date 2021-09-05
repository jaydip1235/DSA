// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
import java.util.*;
public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] all = sentence.split(" ");
        int i=0;
        int flag=1;
        for(String s : all){
            i++;
            System.out.println(s);
            if(s.startsWith(searchWord)){
                flag=0;
                break;
            }
        }
        return flag==1?-1:i;
    }
}
