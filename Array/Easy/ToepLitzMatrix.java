// https://leetcode.com/problems/toeplitz-matrix/
import java.util.*;
public class ToepLitzMatrix {
    public boolean isToeplitzMatrix(int[][] arr) {
        int val = arr[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==0 ||  j==0)continue;
                if(arr[i][j]!=arr[i-1][j-1])return false;
            }
        }
        return true;
    }
}
