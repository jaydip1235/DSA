// https://leetcode.com/problems/sort-the-people/description/
class Solution
{
public:
    vector<string> sortPeople(vector<string> &names, vector<int> &heights)
    {
        map<int, string> mp;
        for (int i = 0; i < names.size(); i++)
        {
            mp[heights[i]] = names[i];
        }
        vector<string> ans;
        for (auto it = mp.rbegin(); it != mp.rend(); it++)
        {
            ans.push_back(it->second);
        }
        return ans;
    }
};