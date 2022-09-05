// https://leetcode.com/problems/k-closest-points-to-origin/
import java.util.*;
class Solution
{
public:
    class ComparisonClass
    {
    public:
        bool operator()(vector<int> &v1, vector<int> &v2)
        {
            int x1 = v1[0];
            int y1 = v1[1];
            int x2 = v2[0];
            int y2 = v2[1];
            return (((x1 * x1) + (y1 * y1)) < ((x2 * x2) + (y2 * y2)));
        }
    };

    vector<vector<int>> kClosest(vector<vector<int>> &points, int k)
    {
        vector<vector<int>> ans;
        priority_queue<vector<int>, vector<vector<int>>, ComparisonClass> pq;
        for (int i = 0; i < points.size(); i++)
        {
            vector<int> point = points[i];
            int x = point[0];
            int y = point[1];
            int dist = (x * x) + (y * y);
            if (pq.size() < k)
            {
                vector<int> temp;
                temp.push_back(x);
                temp.push_back(y);
                pq.push(temp);
            }
            else
            {
                vector<int> topdist = pq.top();
                if (((topdist[0] * topdist[0]) + (topdist[1] * topdist[1])) > dist)
                {
                    pq.pop();
                    vector<int> temp;
                    temp.push_back(x);
                    temp.push_back(y);
                    pq.push(temp);
                }
            }
        }
        while (!pq.empty())
        {
            ans.push_back(pq.top());
            pq.pop();
        }
        return ans;
    }
};