// https://leetcode.com/problems/maximal-network-rank/
#include<stdc++.h>
class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
       vector<int>count(n);
       vector<vector<int>> direct(n,vector<int>(n,0));
            for (vector<int> road : roads) {
                count[road[0]]++;
                count[road[1]]++;
                direct[road[0]][road[1]] = 1;
                direct[road[1]][road[0]] = 1;
            }

            int rank = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    rank = max(rank, count[i] + count[j] - direct[i][j]);
                }
            }

            return rank;
    }
};