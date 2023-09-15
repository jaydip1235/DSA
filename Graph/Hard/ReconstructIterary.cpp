// https://leetcode.com/problems/reconstruct-itinerary
#include<bits/stdc++.h>
class Solution {
public:
    unordered_map<string, priority_queue<string, vector<string>, greater<string>>> graph;
    vector<string> ans;

    void dfs(string src){
        while(!graph[src].empty()){
            string nbr = graph[src].top();
            graph[src].pop();
            dfs(nbr);
        }
        ans.insert(ans.begin(), src);
    }

    vector<string> findItinerary(vector<vector<string>>& tickets) {
        for (const auto& ticket : tickets) {
            graph[ticket[0]].push(ticket[1]);
        }
        dfs("JFK");
        return ans;        
    }
};
