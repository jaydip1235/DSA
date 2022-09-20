// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/ sililar to
// https://leetcode.com/problems/video-stitching/
#include<bits/stdc++.h>
class Solution
{
public:
    int minTaps(int T, vector<int> &clips)
    {
        int mini = 0, maxi = 0, total = 0;
        while (maxi < T)
        {
            for (int i = 0; i < clips.size(); i++)
            {
                int l = i - clips[i];
                int r = i + clips[i];
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