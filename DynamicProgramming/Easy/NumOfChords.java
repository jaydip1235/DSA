
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/circle-and-chords-official/ojquestion
import java.io.*;
import java.util.*;

public class NumOfChords {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        long dp[] = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(dp[n]);

    }

}