// https://leetcode.com/problems/maximum-value-after-insertion/
#include<bits/stdc++.h>
class Solution
{
public:
    string maxValue(string n, int x)
    {
        if (n[0] == '-')
        {
            int pos = n.size();
            for (int i = 1; i < n.size(); i++)
            {
                if ((n[i] - '0') > x)
                {
                    pos = i;
                    break;
                }
            }
            if (pos == n.size())
                return n + to_string(x);
            else
                return n.substr(0, pos) + to_string(x) + n.substr(pos);
        }
        else
        {
            int pos = n.size();
            for (int i = 0; i < n.size(); i++)
            {
                if ((n[i] - '0') < x)
                {
                    pos = i;
                    break;
                }
            }
            if (pos == n.size())
                return n + to_string(x);
            else
                return n.substr(0, pos) + to_string(x) + n.substr(pos);
        }
    }
};