/*You are given 2 integers N and M , N is the number of vertices, M is the number of edges. 
You'll also be given ai and bi where ai and bi represents an edge from a vertex ai to a vertex bi.

You have to find the minimum number of edges you have to reverse in order to have atleast one path from
vertex 1 to N, where the vertices are numbered from 1 to N.*/

import java.io.*;
import java.util.*;

public class ZeroOneBFS {

    static class Pair{
        int vtx;
        int wt;
        Pair(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(new Pair(v, 0));
			graph.get(v).add(new Pair(u, 1));
		}

		LinkedList<Pair> queue = new LinkedList<>();
		boolean[] vis = new boolean[n];
		queue.addLast(new Pair(0, 0));

		while (queue.size() > 0) {
			Pair rem = queue.removeFirst();

			if (rem.vtx == n - 1) {
				System.out.println(rem.wt);
				return;
			}

			vis[rem.vtx] = true;

			for (Pair nbrs : graph.get(rem.vtx)) {
				if (vis[nbrs.vtx] == true) {
					continue;
				}

				if (nbrs.wt == 0) {
					queue.addFirst(new Pair(nbrs.vtx, rem.wt));
				} else {
					queue.addLast(new Pair(nbrs.vtx, rem.wt + 1));
				}
			}
		}
		System.out.println(-1);
	}
}

