// https://leetcode.com/problems/sort-colors/
#include<bits/stdc++.h>
class Solution {
public:
    void sortColors(vector<int>& arr) {
        int i=0,j=0,k=arr.size()-1;
        while(i<=k){
            if(arr[i]==0){
                swap(arr[i],arr[j]);
                i++;
                j++;
            }
            else if(arr[i]==1)i++;
            else{
                swap(arr[i],arr[k]);
                k--;
            }
        }
    }
};