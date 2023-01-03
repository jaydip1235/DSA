// https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1
class Solution
{
public:
    // Function to check if the
    // Pythagorean triplet exists or not
    bool checkTriplet(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];
        sort(arr, arr + n);
        for (int i = n - 2; i >= 2; i--)
        {
            int l = 0, r = i - 1;
            while (l < r)
            {
                if (arr[i] == arr[l] + arr[r])
                    return true;
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }
        return false;
    }
};