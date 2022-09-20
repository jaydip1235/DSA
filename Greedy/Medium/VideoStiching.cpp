// https://leetcode.com/problems/video-stitching/
#include<bits/stdc++.h>
class Solution
{
public:
    int videoStitching(vector<vector<int>> &clips, int T)
    {
        int mini = 0, maxi = 0, total = 0;
        while (maxi < T)
        {
            for (int i = 0; i < clips.size(); i++)
            {
                int l = clips[i][0];
                int r = clips[i][1];
                if (l <= mini && r > maxi)
                {
                    maxi = r;
                }
            }
            if (mini == maxi)
                return -1;
            mini = maxi;
            total++;
        }
        return total;
    }
};