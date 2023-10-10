import java.util.Arrays;

public class Candy  {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        if (n == 1) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Candy solution = new Candy();
        int[] ratings = {1, 0, 2};
        int result = solution.candy(ratings);
        System.out.println("Minimum number of candies: " + result);
    }

}
