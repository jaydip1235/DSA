// https://leetcode.com/problems/minimum-number-of-people-to-teach/
#include<bits/stdc++.h>
class Solution {
public:
    int minimumTeachings(int n, vector<vector<int>>& lang, vector<vector<int>>& fr) {
        int m=lang.size(),ans=m;
        map<int,unordered_set<int>> mp;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<lang[i].size();j++){
                mp[lang[i][j]].insert(i+1);
            }
        }
        
        unordered_set<int>s;
        for(int i=0;i<fr.size();i++){
            int user1=fr[i][0];
            int user2=fr[i][1];
            int f=0;
            for(int j=0;j<lang[user1-1].size();j++){
                int l=lang[user1-1][j];
                if(mp[l].find(user2)!=mp[l].end()){
                    f=1;
                    break;
                }
            }
            if(!f){
                s.insert(user1);
                s.insert(user2);
            }
        }
        for(int i=1;i<=n;i++){
            int c=0;
            for(auto u:s){
                if(mp[i].find(u)==mp[i].end())c++;
            }
            ans=min(ans,c);
        }
        return ans;
        
    }
};