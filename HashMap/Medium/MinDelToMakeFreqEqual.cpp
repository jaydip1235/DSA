// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
#include<bits/stdc++.h>
class Solution {
public:
    int minDeletions(std::string s) {
        unordered_map<char, int> cnt;
        int deletions = 0;
        unordered_set<int> used_frequencies;
        
        for (char c : s) {
            cnt[c]++;
        }
        
        for (auto& kv : cnt) {
            int freq = kv.second;
            while (freq > 0 && used_frequencies.find(freq) != used_frequencies.end()) {
                freq--;
                deletions++;
            }
            used_frequencies.insert(freq);
        }
        
        return deletions;
    }
};