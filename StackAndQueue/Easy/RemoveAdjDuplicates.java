// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
import java.util.*;
public class RemoveAdjDuplicates{
    public String removeDuplicates(String s) {
        
        Stack<Character>st = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(st.size()>0 && st.peek()==s.charAt(i)){
                st.pop();
            }
        else
           st.push(s.charAt(i));
        }
        System.out.println(st.size());
        if(st.size()==0)return "";
        String ans = "";
        while(st.size()>0){
            ans = st.pop()+ans;
        }
        return ans;
    }
}