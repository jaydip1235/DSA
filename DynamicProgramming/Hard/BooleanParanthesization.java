// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/boolean-parenthesization-official/ojquestion
public class BooleanParanthesization {
    public static int solution(String str1, String str2) {
        int n = str1.length();
        int dpt[][] = new int[n][n];
        int dpf[][] = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {

                if (g == 0) {
                    char ch = str1.charAt(i);
                    if (ch == 'T') {
                        dpt[i][j] = 1;
                        dpf[i][j] = 0;
                    } else {
                        dpt[i][j] = 0;
                        dpf[i][j] = 1;
                    }
                } else {
                    for (int k = i; k < j; k++) {
                        int ltc = dpt[i][k];
                        int rtc = dpt[k + 1][j];
                        int lfc = dpf[i][k];
                        int rfc = dpf[k + 1][j];

                        char ch = str2.charAt(k);
                        if (ch == '|') {
                            dpt[i][j] += ltc * rtc + ltc * rfc + lfc * rtc;
                            dpf[i][j] += lfc * rfc;
                        } else if (ch == '&') {
                            dpt[i][j] += ltc * rtc;
                            dpf[i][j] += lfc * rfc + ltc * rfc + lfc * rtc;
                        } else {
                            dpt[i][j] += ltc * rfc + lfc * rtc;
                            dpf[i][j] += ltc * rtc + lfc * rfc;
                        }
                    }
                }

            }
        }
        return dpt[0][n - 1];
    }
}
