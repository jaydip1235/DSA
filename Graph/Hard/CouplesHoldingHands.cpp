// https://leetcode.com/problems/couples-holding-hands/
#incldue<bits/stdc++.h>
class Solution
{
public:
    void swapfunc(vector<int> &row, int i, int j)
    {
        swap(row[i], row[j]);
        mp[row[i]] = i;
        mp[row[j]] = j;
    }
    map<int, int> mp;
    int minSwapsCouples(vector<int> &row)
    {
        mp.clear();
        for (int i = 0; i < row.size(); i++)
        {
            mp[row[i]] = i;
        }
        int swaps = 0;
        for (int i = 0; i < row.size(); i += 2)
        {
            int first = row[i];
            int second = first ^ 1;
            if (second != row[i + 1])
            {
                swaps++;
                swapfunc(row, i + 1, mp[second]);
            }
        }
        return swaps;
    }
};