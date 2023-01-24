// https://leetcode.com/problems/decode-the-message/description/
#include<bits/stdc++.h>
class Solution
{
public:
    string decodeMessage(string key, string message)
    {
        map<char, char> mp;
        int p = 0;
        for (int i = 0; i < key.size(); i++)
        {
            if (key[i] != ' ')
            {
                if (mp.find(key[i]) == mp.end())
                {
                    mp[key[i]] = p + 'a';
                    p++;
                }
            }
        }
        string ans = "";
        for (int i = 0; i < message.size(); i++)
        {
            if (message[i] == ' ')
                ans += ' ';
            else
                ans += mp[message[i]];
        }
        return ans;
    }
};