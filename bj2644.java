package baeckjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj2644 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int count = sc.nextInt();
		int dist[] = new int[n + 1];
		List<Integer>[] list = new ArrayList[n + 1];
		boolean[] ch = new boolean[n + 1];
		for (int a = 1; a <= n; a++) {
			list[a] = new ArrayList<>();
		}
		for (int a = 0; a < count; a++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			list[x1].add(y1);
			list[y1].add(x1);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		while (!queue.isEmpty()) {
			int q = queue.poll();
			for (int a = 0; a < list[q].size(); a++) {
				if (dist[list[q].get(a)] != 0)
					continue;
				dist[list[q].get(a)] = dist[q] + 1;
				queue.add((int) list[q].get(a));
			}
		}
		System.out.println(dist[y]==0 ? -1 : dist[y]);

	}

}
