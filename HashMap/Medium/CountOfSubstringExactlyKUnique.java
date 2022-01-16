// https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/1
import java.util.*;
public class CountOfSubstringExactlyKUnique {
    public static long atmostKDistinctChar(String str, int k) {  
        int arr[] = new int[26];
        for(int i:arr){
            arr[i]=0;
        }
        long cc=0;
        long count = 0;
        int i = -1;
        int j = -1;

        while (i < str.length() - 1) {

            //aquire
            while (i < str.length() - 1 && cc <= k) {
                i++;

                char ch = str.charAt(i);
             
                if(arr[ch-'a']==0){
                    cc++;
                    arr[ch-'a']=1;
                }
                else if(arr[ch-'a']>0){
                     arr[ch-'a']++;
                }

                if ( cc <= k) {
                    count += (i - j);
                }
            }

            //release
            while (j < i && cc == k + 1) {
                j++;

                char ch = str.charAt(j);
                if(arr[ch-'a']==1){
                    arr[ch-'a']=0;
                    cc--;
                    count += (i - j);
                    break;
                }

                else if(arr[ch-'a']>1){
                    arr[ch-'a']--;
                }
            }

        }

        return count;
    }
    long substrCount (String str, int k) {
        long count = atmostKDistinctChar(str, k) - atmostKDistinctChar(str, k - 1);
        return count;
    }
}
