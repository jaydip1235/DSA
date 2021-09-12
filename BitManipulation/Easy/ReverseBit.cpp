// https://leetcode.com/problems/reverse-bits/
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
       int res = 0;
       for(int i=0;i<32;i++){
           if(n&1==1){
               res+=1;
           }
           if(i==31)break;
           res=res<<1;
           n=n>>1;
       } 
        return res;
    }
};