// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
#include<bits/stdc++.h>
class Solution
{
public:
    //Function to find a continuous sub-array which adds up to a given number.
    vector<int> subarraySum(vector<int> arr, int n, long long s)
    {

        int i = 0, j = 0;
        if (s == 0)
            return {-1};
        long long sum = 0;
        while (i < n)
        {
            while (j < n && sum + arr[j] < s)
            {
                sum += arr[j];
                j++;
            }
            if (sum + arr[j] == s)
            {
                return {i + 1, j + 1};
            }
            sum -= arr[i];
            i++;
            if (sum == s)
            {
                return {i + 1, j + 1};
            }
        }
        return {-1};
    }
};