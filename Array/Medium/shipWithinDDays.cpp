// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
#include<bits/stdc++.h>
class Solution
{
public:
    bool isPossible(vector<int> &arr, int days, int boundary)
    {
        int n = arr.size();
        int required = 1;
        int curr_sum = 0;

        for (int i = 0; i < n; i++)
        {

            if (arr[i] > boundary)
                return false;

            if (curr_sum + arr[i] > boundary)
            {

                required++;

                curr_sum = arr[i];

                if (required > days)
                    return false;
            }

            else
                curr_sum += arr[i];
        }
        return true;
    }

    int shipWithinDays(vector<int> &weights, int days)
    {
        int sum = 0;
        int n = weights.size();
        if (n < days)
            return -1;

        for (int i = 0; i < n; i++)
            sum += weights[i];

        int start = 0, end = sum;
        int result = INT_MAX;

        while (start <= end)
        {

            int mid = (start + end) / 2;
            if (isPossible(weights, days, mid))
            {
                result = min(result, mid);
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        return result;
    }
};