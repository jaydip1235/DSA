https : //leetcode.com/contest/biweekly-contest-34/problems/matrix-diagonal-sum///
class Solution
{
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int sum=0;
        int n=mat.size();
        for(int i=0;i<n;i++)sum+=mat[i][i];
        for(int i=0;i<n;i++)sum+=mat[i][n-i-1];
        if(n%2)sum-=mat[(n/2)][(n/2)];
        return sum;
    }
};