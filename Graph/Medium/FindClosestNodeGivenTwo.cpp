// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
#include<bits/stdc++.h>
class Solution
{
public:
    int closestMeetingNode(vector<int> &edges, int node1, int node2)
    {

        vector<int> dist_node1(edges.size(), -1);
        vector<int> dist_node2(edges.size(), -1);

        vector<bool> visited(edges.size(), false);
        dfs(node1, dist_node1, visited, edges, 0);
        visited.assign(edges.size(), false);
        dfs(node2, dist_node2, visited, edges, 0);

        int ans = edges.size();
        int result = -1;
        for (int i = 0; i < edges.size(); i++)
        {
            if (dist_node1[i] != -1 && dist_node2[i] != -1)
            {
                if (max(dist_node1[i], dist_node2[i]) < ans)
                {
                    ans = max(dist_node1[i], dist_node2[i]);
                    result = i;
                }
            }
        }
        return result;
    }

    void dfs(int node, vector<int> &dist_node1, vector<bool> &visited,
             vector<int> &edges, int distance)
    {
        if (node != -1 && !visited[node])
        {
            visited[node] = true;
            dist_node1[node] = distance;
            dfs(edges[node], dist_node1, visited, edges, distance + 1);
        }
    }
};