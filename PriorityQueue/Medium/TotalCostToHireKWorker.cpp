// https://leetcode.com/problems/total-cost-to-hire-k-workers/
#include<bits/stdc++.h>
class Solution
{
public:
    long long totalCost(vector<int> &costs, int k, int candidates)
    {
        int n = costs.size();

        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;

        int s=0,e=n-1;
        for(int i=0;i<candidates;i++)
        {
            if(s<=e){
                pq.push({costs[i],i});
                s=i+1;
            }
        }
        for(int i=n-1;i>=n-candidates;i--)
        {
            if(s<=e){
                pq.push({costs[i],i});
                e=i-1;
            }
        }

        long long ans=0;
        for(int i=0;i<k;i++){
            auto temp1=pq.top();
            ans+=temp1.first;
            pq.pop();
            if(temp1.second<s && s<=e){
                pq.push({costs[s],s});
                s++;
            }
            else if(temp1.second>e && s<=e){
                pq.push({costs[e],e});
                e--;
            }
        }
        return ans;
    }
};