// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
#include<bits/stdc++.h>
class Solution
{
public:
    vector<int> numSmallerByFrequency(vector<string> &queries, vector<string> &words)
    {
        vector<int> v(words.size());
        vector<int> ans(queries.size());
        for (int i = 0; i < words.size(); i++)
        {
            vector<int> count(26, 0);
            for (int j = 0; j < words[i].size(); j++)
            {
                count[words[i][j] - 'a']++;
            }
            for (int j = 0; j < 26; j++)
            {
                if (count[j] > 0)
                {

                    v[i] = (count[j]);
                    break;
                }
            }
        }
        sort(v.begin(), v.end());

        for (int i = 0; i < queries.size(); i++)
        {
            vector<int> count(26, 0);
            for (int j = 0; j < queries[i].size(); j++)
            {
                count[queries[i][j] - 'a']++;
            }
            int temp = 0;
            for (int j = 0; j < 26; j++)
            {
                if (count[j] > 0)
                {
                    temp = count[j];
                    break;
                }
            }
            ans[i] = words.size() - (upper_bound(v.begin(), v.end(), temp) - v.begin());
        }
        return ans;
    }
};