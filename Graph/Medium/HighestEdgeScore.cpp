// https://leetcode.com/problems/node-with-highest-edge-score/
#include<bits/stdc++.h>
class Solution
{
public:
    int edgeScore(vector<int> &edges)
    {
        vector<long long> arr(edges.size(), 0);

        for (int i = 0; i < edges.size(); i++)
        {
            arr[edges[i]] += i;
        }
        int node = -1;
        long long count = INT_MIN;
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr[i] > count)
            {
                count = arr[i];
                node = i;
            }
        }
        return node;
    }
};