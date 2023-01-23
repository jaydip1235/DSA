// https://practice.geeksforgeeks.org/problems/minimum-indexed-character-1587115620/1
class Solution
{
public:
    int minIndexChar(string str, string patt)
    {
        map<char, int> mp;
        for (int i = 0; i < patt.size(); i++)
        {
            if (mp.find(patt[i]) == mp.end())
                mp[patt[i]]++;
        }
        for (int i = 0; i < str.size(); i++)
        {
            if (mp.find(str[i]) != mp.end())
                return i;
        }
        return -1;
    }
};