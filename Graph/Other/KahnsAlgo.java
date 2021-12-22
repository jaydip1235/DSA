import java.io.*;
import java.util.*;

public class KahnsAlgo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] prerequisites = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			prerequisites[i][0] = Integer.parseInt(st[0]);
			prerequisites[i][1] = Integer.parseInt(st[1]);
		}
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int u = prerequisites[i][0];
			int v = prerequisites[i][1];

			graph.get(v).add(u);
		}

		int[] ans = findOrder(n, graph);

		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

	public static int[] findOrder(int numCourses, ArrayList<ArrayList<Integer>> graph) {

		int[] ans = new int[numCourses];
		int[] indegree = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			for (int nbrs : graph.get(i)) {
				indegree[nbrs]++;
			}
		}

		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.addLast(i);
			}
		}

		int idx = 0;
		while (queue.size() > 0) {
			int rem = queue.removeFirst();
			ans[idx] = rem;
			idx++;

			for (int nbrs : graph.get(rem)) {
				indegree[nbrs]--;
				if (indegree[nbrs] == 0) {
					queue.addLast(nbrs);
				}
			}
		}

		if (idx == numCourses) {
			return ans;
		} else {
			return new int[] { -1 };
		}
	}
}

         