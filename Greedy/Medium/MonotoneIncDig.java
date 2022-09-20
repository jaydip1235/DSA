// https://leetcode.com/problems/monotone-increasing-digits/
import java.util.*;
public class MonotoneIncDig{
class Solution
{
public
    int monotoneIncreasingDigits(int N)
    {
        // 1. Convert the given integer to character array
        char[] ch = String.valueOf(N).toCharArray();

        // 2. Create a integer mark variable and initialize it to the length of the character array
        int mark = ch.length;

        // 3. Iterate from the end of the array to the beginning of the array.
        // Everytime you find current digit less then previous digit, reduce the previous digit by 1 and set that digit as the mark
        for (int i = ch.length - 1; i > 0; i--)
        {
            if (ch[i] < ch[i - 1])
            {
                mark = i - 1;
                ch[i - 1]--;
            }
        }

        // 4. Set all digits after mark to 9 as we want the highest number.
        // In step 3 we made sure that all digits before mark are in increasing order
        for (int i = mark + 1; i < ch.length; i++)
        {
            ch[i] = '9';
        }
        return Integer.parseInt(new String(ch));
    }
}
}