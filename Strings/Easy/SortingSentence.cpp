// https://leetcode.com/problems/sorting-the-sentence/description/
#include<bits/stdc++.h>
class Solution
{
public:
    string sortSentence(string s)
    {
        vector<string> v(10);
        string temp;

        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] >= 48 && s[i] <= 57)
            {
                v[s[i] - 48] = temp + " ";
                temp = "";
                i++;
            }
            else
            {
                temp += s[i];
            }
        }
        string ans = "";
        for (string s : v)
        {
            ans += s;
        }
        ans.pop_back();
        return ans;
    }
};