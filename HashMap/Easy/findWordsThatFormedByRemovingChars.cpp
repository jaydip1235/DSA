// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
#include<bits/stdc++.h>
class Solution
{
public:
    int countCharacters(vector<string> &words, string chars)
    {
        vector<int> count(26, 0);
        for (int i = 0; i < chars.size(); i++)
        {
            count[chars[i] - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < words.size(); i++)
        {
            vector<int> arr(26, 0);
            for (int j = 0; j < words[i].size(); j++)
            {
                arr[words[i][j] - 'a']++;
            }
            int flag = 1;
            for (int i = 0; i < 26; i++)
            {
                if (arr[i] > count[i])
                {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                ans += words[i].size();
        }
        return ans;
    }
};