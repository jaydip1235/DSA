// https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/
#include<bits/stdc++.h>
class Solution {
public:
  int maxDistance(vector<int>& A) {
        int n = A.size(), i = 0, j = n - 1;
        while (A[0] == A[j]) j--;
        while (A[n - 1] == A[i]) i++;
        return max(n - 1 - i, j);
    }
};