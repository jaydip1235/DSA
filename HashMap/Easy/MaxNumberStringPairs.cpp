// https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/

#include <vector>
#include <map>
#include <string>

class Solution {
public:
    int maximumNumberOfStringPairs(std::vector<std::string>& words) {
        std::map<std::string, int> mp;
        int ans = 0;
        
        for(int i = 0; i < words.size(); i++) {
            std::string f(1, words[i][0]); 
            std::string s(1, words[i][1]); 
            std::string target_s = s + f;
            
            if (mp.find(target_s) != mp.end()) {
                ans += mp[target_s];
            }
            
            mp[words[i]]++;
        }
        
        return ans;
    }
};
