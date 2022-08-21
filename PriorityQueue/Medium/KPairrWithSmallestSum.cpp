// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
#incude<bits/stdc++.h>
class Solution
{
public:
    struct Pair
    {

        int i;
        int j;
        int sum;
    };

    struct comp
    {

        bool operator()(const Pair &x, const Pair &y)
        {
            return x.sum > y.sum;
        }
    };

    vector<vector<int>> kSmallestPairs(vector<int> &nums1, vector<int> &nums2, int k)
    {

        int m = nums1.size();
        int n = nums2.size();

        vector<vector<int>> ans;

        priority_queue<Pair, vector<Pair>, comp> pq;

        pq.push({0, 0, nums1[0] + nums2[0]});

        set<pair<int, int>> visited;

        while (!pq.empty() && ans.size() < k)
        {

            auto curr = pq.top();
            pq.pop();

            int i = curr.i;
            int j = curr.j;
            int sum = curr.sum;

            if (visited.find({i, j}) != visited.end())
            {
                continue;
            }

            visited.insert({i, j});

            ans.push_back({nums1[i], nums2[j]});

            if (i + 1 < m && j < n)
            {

                pq.push({i + 1, j, nums1[i + 1] + nums2[j]});
            }

            if (i < m && j + 1 < n)
            {

                pq.push({i, j + 1, nums1[i] + nums2[j + 1]});
            }
        }

        return ans;
    }
};