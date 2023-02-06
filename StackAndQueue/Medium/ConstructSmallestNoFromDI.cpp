// https://leetcode.com/problems/construct-smallest-number-from-di-string/
#include<bits/stdc++.h>
class Solution {
public:
    string smallestNumber(string pattern) {
        stack<int>st;
        string ans="";
        int num=1;
        for(int i=0;i<pattern.size();i++){
            if(pattern[i]=='D'){
                st.push(num++);
            }
            else{
                st.push(num++);
                while(st.size()>0){
                    ans+=to_string(st.top());
                    st.pop();
                }
            }
        }
        st.push(num);
        while(st.size()>0){
                    ans+=to_string(st.top());
                    st.pop();
                }
        return ans;
    }
};