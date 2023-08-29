// https://leetcode.com/problems/length-of-last-word/description/
#include<bits/stdc++.h>
class Solution {
public:
    int lengthOfLastWord(string s) {
        int ans=0;
        int i=s.size()-1;
        while(s[i]==' ')i--;
        for(;i>=0;i--){
            if(s[i]==' ')break;
            else ans++;
        }
        return ans;
    }
};