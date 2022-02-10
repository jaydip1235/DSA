// https://leetcode.com/problems/backspace-string-compare/

import java.util.*;
public class BackSpace {
    public boolean backspaceCompare(String s, String t) {
        String ff="";
        String ss="";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
             if(ch=='#' && st.size()>0)st.pop();
             if(ch=='#')continue;
            else st.push(ch);
        }

        while(st.size()>0){
            ff+=st.pop();
        }
       
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch=='#' && st.size()>0)st.pop();
             if(ch=='#')continue;
            else st.push(ch);
        }
         while(st.size()>0){
            ss+=st.pop();
        }
        
        if(ff.equals(ss))return true;
        return false;
    }
}
