// https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1
class Solution
{
public:
    // Function to reverse every sub-array group of size k.
    void reverseInGroups(vector<long long> &arr, int n, int k)
    {

        int s = 0;
        int e = k - 1;
        int i = 1;
        int full = n / k;
        int rem = n % k;

        while (i <= full)
        {
            while (s <= e)
            {
                swap(arr[s], arr[e]);
                s++;
                e--;
            }
            s = i * k;
            e = s + k - 1;
            i++;
        }
        e = n - 1;
        while (s <= e)
        {
            swap(arr[s], arr[e]);
            s++;
            e--;
        }
    }
};