// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
#include<bits/stdc++.h>
class Solution {
public:
    int kthLargestValue(vector<vector<int>>& arr, int k) {
        int maxi = INT_MIN;
        int n = arr.size();
        int m = arr[0].size();
        priority_queue<int,vector<int>,greater<int>>pq;
        int dp[n][m];
        memset(dp,0,sizeof dp);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=arr[i][j];
                }else if(i==0){
                    dp[i][j]=dp[i][j-1]^arr[i][j];
                }else if(j==0){
                    dp[i][j] = dp[i-1][j]^arr[i][j];
                }else{
                    dp[i][j] = dp[i-1][j]^dp[i-1][j-1]^dp[i][j-1]^arr[i][j];
                }
                if(pq.size()<k){
                    pq.push(dp[i][j]);
                }else if(dp[i][j]>pq.top()){
                    pq.pop();
                    pq.push(dp[i][j]);
                }
            }
        }
        return pq.top();
    }
};