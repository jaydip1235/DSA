// https://leetcode.com/problems/truncate-sentence/description/
#include<bits/stdc++.h>
class Solution {
public:
    string truncateSentence(string s, int k) {
        string ans="";
        int i=0;
        while(k>0 && i<s.size()){
            if(s[i]==' '){
                k--;
                if(k==0)break;
            }
            ans.push_back(s[i++]);

        }
        return ans;
    }
};