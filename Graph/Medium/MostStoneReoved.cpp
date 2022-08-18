// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
#include<bits/stdc++.h>
class Solution
{

    int findPar(int u, vector<int> &parent)
    {
        if (u == parent[u])
            return u;
        return parent[u] = findPar(parent[u], parent);
    }

    void unionn(int u, int v, vector<int> &parent, vector<int> &rank)
    {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if (rank[u] < rank[v])
        {
            parent[u] = v;
        }
        else if (rank[v] < rank[u])
        {
            parent[v] = u;
        }
        else
        {
            parent[v] = u;
            rank[u]++;
        }
    }

public:
    int removeStones(vector<vector<int>> &stones)
    {
        vector<int> parent(20005);
        vector<int> rank(20005, 0);
        for (int i = 0; i < rank.size(); i++)
        {
            parent[i] = i;
        }
        for (int i = 0; i < stones.size(); i++)
        {
            unionn(stones[i][0], stones[i][1] + 10001, parent, rank);
        }
        set<int> s;
        for (vector<int> stone : stones)
        {
            s.insert(findPar(stone[0], parent));
        }
        return stones.size() - s.size();
    }
};