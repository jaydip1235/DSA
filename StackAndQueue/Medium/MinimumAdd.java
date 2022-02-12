// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
import java.util.*;
public class MinimumAdd {
    public int minAddToMakeValid(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() > 0 && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }

        }
        return st.size();

    }
}
