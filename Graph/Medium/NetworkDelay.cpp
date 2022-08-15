// https://leetcode.com/problems/network-delay-time/
#inlcude<bits/stdc++.h>
class Solution
{
public:
    int networkDelayTime(vector<vector<int>> &times, int n, int k)
    {

        vector<pair<int, int>> adj[n + 1];
        for (int i = 0; i < times.size(); i++)
        {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj[u].push_back({v, w});
        }

        vector<int> dist(n + 1, INT_MAX);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        dist[k] = 0;
        pq.push({0, k});

        while (!pq.empty())
        {
            int predist = pq.top().first;
            int prenode = pq.top().second;
            pq.pop();
            for (auto it : adj[prenode])
            {
                if (dist[it.first] > predist + it.second)
                {
                    dist[it.first] = predist + it.second;
                    pq.push({dist[it.first], it.first});
                }
            }
        }
        int ans = INT_MIN;
        for (int i = 1; i <= n; i++)
        {
            if (i != k && dist[i] == INT_MAX)
                return -1;
            if (dist[i] > ans)
            {
                ans = dist[i];
            }
        }
        return ans;
    }
};