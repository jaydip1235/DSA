// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
#include<bits/stdc++.h>
class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        vector<int>arr;
        for(int i=0;i<bank.size();i++){
            int count=0;
            for(int j=0;j<bank[i].size();j++){
                if(bank[i][j]=='1')count++;
            }
            arr.push_back(count);
        }
    map<int,int>mp;
    int nvi=-1;
    for(int i=arr.size()-1;i>=0;i--){
        if(arr[i]!=0){
            mp[i]=nvi;
            nvi=i;
        }
    }
    int ans=0;
    for(int i=0;i<arr.size()-1;i++){
        if(arr[i]!=0 && mp[i]!=-1){
            ans+=arr[i]*arr[mp[i]];
        }
    }
    return ans;
    }
};