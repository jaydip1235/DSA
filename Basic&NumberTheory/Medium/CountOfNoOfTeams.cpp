// https://leetcode.com/problems/count-number-of-teams
#include<bits/stdc++.h>
class Solution
{
public:
    int numTeams(vector<int> &rating)
    {
        int ans = 0;
        for (int i = 1; i < rating.size() - 1; i++)
        {
            int in1 = 0, in2 = 0, de1 = 0, de2 = 0;
            for (int j = 0; j < i; j++)
            {
                if (rating[j] < rating[i])
                    in1++;
                if (rating[j] > rating[i])
                    de1++;
            }
            for (int j = i + 1; j < rating.size(); j++)
            {
                if (rating[j] < rating[i])
                    de2++;
                if (rating[j] > rating[i])
                    in2++;
            }
            ans += (in1 * in2) + (de1 * de2);
        }
        return ans;
    }
};