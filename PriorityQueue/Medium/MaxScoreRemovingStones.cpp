// https://leetcode.com/problems/maximum-score-from-removing-stones/
#include<bits/stdc++.h>
class Solution {
public:
    int maximumScore(int a, int b, int c) {
        int count=0;
        priority_queue<int> pq;
        pq.push(a);
        pq.push(b);
        pq.push(c);
        while(1){
            int x = pq.top();
            pq.pop();
            int y = pq.top();
            pq.pop();
            if(x==0 || y==0)break;
            x--;
            y--;
            count++;
            pq.push(x);
            pq.push(y);
            
        }
        return count;
    }
};