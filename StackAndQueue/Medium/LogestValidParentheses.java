import java.io.*; 
import java.util.*;

class LogestValidParentheses{
    public static void main(String args[]){
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
      int t = Integer.parseInt(in.readLine()); 

      while(t-- > 0){
        String S = in.readLine();
        Solution ob = new Solution(); 
        System.out.println(ob.maxlength(5));
       }
    }
}

class Solution{
    static int maxLength(String S){
         Stack<Integer> stack=new Stack<Integer>();
       stack.push(-1);
       int ans=0;
       for(int i=0;i<S.length();i++){
           char x=S.charAt(i);
           if(x=='('){
               stack.push(i);
           }
           else {
               stack.pop();
               if(!stack.isEmpty()){
                   ans=Math.max(ans,i-stack.peek());
               }
               else{
                   stack.push(i);
               }
           }
       }
       return ans;
    }
}
