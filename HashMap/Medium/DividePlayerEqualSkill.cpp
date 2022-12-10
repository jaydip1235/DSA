// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/
#include<bits/stdc++.h>
class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        long long ans=0,sum=0;
        int n=skill.size();
        for(int i=0;i<n;i++)sum+=skill[i];
        int each=n/2;
        if(sum%each != 0)return -1;
        int k=sum/each;
        map<int,int>mp;
        for(int i=0;i<n;i++){
            if(mp.find(k-skill[i])!=mp.end()){
                ans+=(long long)skill[i]*(long long)(k-skill[i]);
                mp[k-skill[i]]--;
                if(mp[k-skill[i]]==0){
                    mp.erase(k-skill[i]);
                }
            }
            else{
                mp[skill[i]]++;
            }
        }
        if(mp.size()==0)return ans;
        return -1;

    }
};