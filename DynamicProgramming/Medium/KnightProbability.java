public class KnightProbability{
     public double knightProbability(int n, int k, int r, int c) {
        double[][] dp1 = new double[n][n];
		double[][] dp2 = new double[n][n];
		int[][] moves = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { 1, -2 }, { -2, 1 }, { 2, -1 }, { -1, -2 }, { -2, -1 } };
		dp1[r][c] = 1;
		double factor = 8.0;
		for (int i = 0; i < k; i++) {
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (dp1[row][col] > 0.0) {
						for (int move = 0; move < moves.length; move++) {
							int nr = row + moves[move][0];
							int nc = col + moves[move][1];
							if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
								dp2[nr][nc] += dp1[row][col] / factor;
								;
							}
						}
					}
				}
			}
			dp1 = dp2;
			dp2 = new double[n][n];
		}

		double ans = 0.0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += dp1[i][j];
			}
        }
		return ans;
    }
}