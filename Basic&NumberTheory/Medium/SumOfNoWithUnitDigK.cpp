// https://leetcode.com/problems/sum-of-numbers-with-units-digit-k/
#include<bits/stdc++.h>
class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if(num==0)return 0;
        if(k==0){
            if(num%10==0)return 1;
            return -1;
        }
        for(int i=1;i*k<=num && i<=10;i++){
            if((num-i*k)%10==0)return i;
        }
        return -1;
    }
};