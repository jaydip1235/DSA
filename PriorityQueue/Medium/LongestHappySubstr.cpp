// https://leetcode.com/problems/longest-happy-string/
#include<bits/stdc++.h>
class Solution
{
public:
    string longestDiverseString(int a, int b, int c)
    {
        string ans = "";
        priority_queue<pair<int, char>> pq;
        if (c > 0)
            pq.push({c, 'c'});
        if (b > 0)
            pq.push({b, 'b'});
        if (a > 0)
            pq.push({a, 'a'});
        int i = 0;
        while (!pq.empty())
        {
            char t = pq.top().second;
            if (ans.size() >= 2 && ans[i - 1] == t && ans[i - 2] == t)
            {
                pair<int, char> tp1 = pq.top();
                pq.pop();
                if (pq.size() == 0)
                    break;
                pair<int, char> tp2 = pq.top();
                pq.pop();
                ans += (char)tp2.second;
                pq.push(tp1);
                if (tp2.first - 1 != 0)
                    pq.push({tp2.first - 1, tp2.second});
            }
            else
            {
                pair<int, char> tp1 = pq.top();
                ans += (char)tp1.second;
                pq.pop();
                if (tp1.first - 1 != 0)
                    pq.push({tp1.first - 1, tp1.second});
            }
            i++;
        }
        return ans;
    }
};