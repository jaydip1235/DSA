// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
#include<bits/stdc++.h>
class Solution {
public:
    string smallestSubsequence(string s) {
        stack<char>st;
        vector<int>count(26,0);
        vector<bool>exist(26,false);
        for(char c:s){
            count[c-'a']++;
        }
        for(char c:s){
            count[c-'a']--;
            if(exist[c-'a']){
                continue;
            }
            while(st.size()>0 && st.top()>c && count[st.top()-'a']>0){
                exist[st.top()-'a']=false;
                st.pop();
            }
            st.push(c);
            exist[c-'a']=true;
        }
        string ans="";
        while(st.size()>0){
            ans+=st.top();
            st.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};