// https:// leetcode.com/problems/cheapest-flights-within-k-stops/
#inlcude<bits/stdc++.h>
# define MAX 1e9
        class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<int> cost(n,MAX);
        vector<int> pre_cost;
        cost[src]=0;
        k++;
        while(k--){
            pre_cost.assign(cost.begin(),cost.end());
            for(auto i:flights){
                int a=i[0];
                int b=i[1];
                int w=i[2];
                cost[b]=min(cost[b],pre_cost[a]+w);
            }
        }
        if(cost[dst]==MAX) return -1;
        return cost[dst];
    }
};