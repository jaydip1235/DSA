// https://leetcode.com/problems/count-pairs-of-similar-strings/description/
#include<bits/stdc++.h>
class Solution
{
public:
    int similarPairs(vector<string> &words)
    {
        vector<string> v;
        int ans = 0;
        for (int i = 0; i < words.size(); i++)
        {
            string tmp = words[i];
            set<char> st;
            for (int j = 0; j < tmp.size(); j++)
            {
                st.insert(tmp[j]);
            }
            string rec;
            for (auto it = st.begin(); it != st.end(); it++)
            {
                rec.push_back(*it);
            }
            v.push_back(rec);
        }
        for (int i = 0; i < v.size() - 1; i++)
        {
            for (int j = i + 1; j < v.size(); j++)
            {
                if (v[i] == v[j])
                    ans++;
            }
        }
        return ans;
    }
};