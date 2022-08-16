// https://leetcode.com/problems/keys-and-rooms/
#include<bits/stdc++.h>
class Solution
{
public:
    bool canVisitAllRooms(vector<vector<int>> &rooms)
    {

        queue<int> q;
        q.push(0);
        vector<bool> arr(rooms.size(), false);

        while (!q.empty())
        {
            int rem = q.front();
            q.pop();
            arr[rem] = true;
            for (auto it : rooms[rem])
            {
                if (arr[it] == false)
                {
                    q.push(it);
                }
            }
        }
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr[i] == false)
                return false;
        }
        return true;
    }
};