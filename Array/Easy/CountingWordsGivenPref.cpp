// https://leetcode.com/problems/counting-words-with-a-given-prefix/description/
#include<bits/stdc++.h>
class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int ans=0;
        for(int i=0;i<words.size();i++){
            string s=words[i];
            int fl=0;
            
            if(s.size() < pref.size()) { 
                continue;
            }

            for(int j=0;j<pref.size();j++){  
                if(s[j]!=pref[j]){
                    fl=1;
                    break;
                }
            }
            
            if(fl==0)ans++;
        }
        return ans;
    }
};
