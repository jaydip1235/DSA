// https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
#include<bits/stdc++.h>
class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        map<char,int>mp;
        for(int i=0;i<allowed.size();i++){
            mp[allowed[i]]++;
        }
        int ans=0;
        for(int i=0;i<words.size();i++){
            string s=words[i];
            int fl=0;
            for(int i=0;i<s.size();i++){
                if(mp.find(s[i])==mp.end()){
                    fl=1;
                    break;
                }
            }
            if(fl==0)ans++;
        }
        return ans;
    }
};