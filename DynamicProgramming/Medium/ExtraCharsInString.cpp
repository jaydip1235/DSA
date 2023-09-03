class Solution {
public:
    int f(int index, string& s, unordered_map<string, bool>& mp, vector<int>& dp) {
        // base condition
        if (index >= s.size()) return 0;

        // already computed
        if (dp[index] != -1) return dp[index]; 
        
        // Try all cuts
        string curr = "";
        int res = s.size();
        for (int i = index; i < s.size(); i++) {
            curr.push_back(s[i]);
            int extraCount = curr.size();
            // if curr string present in dictionary
            if(mp[curr])
                extraCount = 0;
            // recursive call for remaining string
            extraCount += f(i+1, s, mp, dp);
            res = min(res, extraCount);
        }
        return dp[index] = res;
    }

    int minExtraChar(string s, vector<string>& dictionary) {
        // store dictionary words in map
        unordered_map<string, bool> mp;
        for (auto& word : dictionary) 
            mp[word] = true;

        vector<int> dp(s.size(),-1);    // memo
        // Write recursion function to check all cuts
        // index, string, map , dp
        return f(0, s, mp, dp);
    }
};