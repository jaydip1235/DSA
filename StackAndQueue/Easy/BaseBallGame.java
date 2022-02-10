// https://leetcode.com/problems/baseball-game/
import java.util.*;
public class BaseBallGame {
    public int calPoints(String[] arr) {
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        st.push(Integer.parseInt(arr[0]));
        for(int i=1;i<arr.length;i++){
            if(arr[i].equals("C")){
                st.pop();
            }
            else if(arr[i].equals("D")){
                st.push(st.peek()*2);
            }
            else if(arr[i].equals("+")){
                int f = st.pop();
                int s = st.peek();
                int t = f+s;
                st.push(f);
                st.push(t);
            }
            else{
                st.push(Integer.parseInt(arr[i]));
            }
        }
        
        while(st.size()>0){
            sum+=st.pop();
        }
        return sum;
    }
}
