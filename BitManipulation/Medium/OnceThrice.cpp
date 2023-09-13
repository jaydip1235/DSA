// https://practice.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1

class Solution {
  public:
    int singleElement(int a[] ,int n) {
        int ans=0;
        for(int i=0;i<32;i++)
        {
            int bit=1<<i;
            int c=0;
            for(int j=0;j<n;j++)
            {
                if(a[j]&bit)
                c++;
            }
            if(c%3)
            ans|=bit;
        }
        return ans;
    }
};