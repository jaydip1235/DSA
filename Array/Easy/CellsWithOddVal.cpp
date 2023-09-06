// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/
#include<bits/stdc++.h>
class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        vector<int>r(m,0),c(n,0);
        for (int i = 0 ; i < indices.size(); i++) {
            r[indices[i][0]]++;
            c[indices[i][1]]++;
        }

        int oddRows = 0;
        for(int i =0; i < m; i++) {
            if(r[i]%2 == 1) {
                oddRows++;
            }            
        }
        

        int oddColumns = 0;
        for(int i =0; i < n; i++){ 
            if(c[i]%2 == 1) {
                oddColumns++;
            }
        }

        return oddRows * n + oddColumns * m - 2*oddRows*oddColumns;
    }
};