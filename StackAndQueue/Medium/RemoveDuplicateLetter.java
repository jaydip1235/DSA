// https://leetcode.com/problems/remove-duplicate-letters/
import java.util.*;

public class RemoveDuplicateLetter {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int count[] = new int[26];
        boolean visited[] = new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            count[ch-'a']++;
        }
        
         for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            count[ch-'a']--;
            if(visited[ch-'a']==false){
                while(st.size()>0 && st.peek()>ch && count[st.peek()-'a']>0){
                    char rem = st.pop();
                    visited[rem-'a']=false;
                }
                st.push(ch);
                visited[ch-'a']=true;
            } 
        }
        
        char ans[] = new char[st.size()];
        int i = ans.length-1;
        while(i>=0)ans[i--]=st.pop();
        return new String(ans); 
    }
}
