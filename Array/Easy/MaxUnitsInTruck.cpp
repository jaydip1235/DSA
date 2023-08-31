// https://leetcode.com/problems/maximum-units-on-a-truck/description/
#include<bits/stdc++.h>
class Solution {
public:
   static bool customComparator(const vector<int>& a, const vector<int>& b) {
    if(a[1] == b[1]) {
        return a[0] > b[0];
    }
    return a[1] > b[1];
}

int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
   
    sort(boxTypes.begin(), boxTypes.end(), customComparator);
    
    int units = 0;
    for (auto& box : boxTypes) {
        if (truckSize >= box[0]) {
            units += box[0] * box[1];
            truckSize -= box[0];
        } else {
            units += truckSize * box[1];
            break; 
        }
    }
    return units;
}
};