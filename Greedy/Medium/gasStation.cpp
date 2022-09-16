// https://leetcode.com/problems/gas-station/
#include<bits/stdc++.h>
class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        if(accumulate(gas.begin(),gas.end(),0)<accumulate(cost.begin(),cost.end(),0))return -1;
        int ans=0;
        int rem=0;
        for(int i=0;i<gas.size();i++){
            rem+=gas[i]-cost[i];
            if(rem<0){
                rem=0;
                ans=i+1;
            }
        }
        return ans;
    }
};