// https://leetcode.com/problems/multiply-strings/
import java.util.*;
public class MultiplyStrings{
 public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int res[] = new int[l1+l2];
        int i=l2-1;
        int pf=0;
        while(i>=0){
            int val1 = num2.charAt(i)-'0';
            i--;
            int carry=0;
            int j=num1.length()-1;
            int k=res.length-1-pf;
            while(j>=0 || carry!=0){
                int val2 = j>=0 ? num1.charAt(j)-'0':0;
                int pro = (val1*val2)+carry+res[k];
                j--;
                res[k--]=pro%10;
                carry=pro/10;    
            }
            pf++;
        }
        int flag=0,p=0;
        String ans="";
        while(p<res.length){
            if(res[p]==0 && flag==0){p++;continue;}
                flag=1;
                ans+=Integer.toString(res[p]); 
            p++;
            
        }
        return ans==""?"0":ans;
    }
}