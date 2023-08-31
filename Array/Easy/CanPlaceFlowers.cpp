// https://leetcode.com/problems/can-place-flowers/description/
#include<bits/stdc++.h>
class Solution {
public:
    bool canPlaceFlowers(std::vector<int>& flowerbed, int n) {
        int size = flowerbed.size();
        for(int i = 0; i < size && n > 0; ++i) {
            if(flowerbed[i] == 0) {
                bool prevEmpty = (i == 0 || flowerbed[i - 1] == 0);
                bool nextEmpty = (i == size - 1 || flowerbed[i + 1] == 0);
                
                if(prevEmpty && nextEmpty) {
                    flowerbed[i] = 1;
                    --n;
                }
            }
        }
        return n <= 0;
    }
};
