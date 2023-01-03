// https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1
class Solution
{
public:
    // Program for zig-zag conversion of array
    void zigZag(int arr[], int n)
    {

        int f = 1;
        int i = 0, j = 1;
        while (j < n)
        {
            if (f == 1)
            {
                if (arr[i] > arr[j])
                    swap(arr[i], arr[j]);
            }
            else if (f == 0)
            {
                if (arr[i] < arr[j])
                    swap(arr[i], arr[j]);
            }
            f = 1 - f;
            i++;
            j++;
        }
    }
};