package baeckjoon;

import java.util.*;

public class bj1260 {

	static StringBuilder st = new StringBuilder();
	static int v;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();
		int line = sc.nextInt();
		int start = sc.nextInt();
		int arr[][] = new int[2000][2000];
		boolean check[] = new boolean[2000];

		for (int a = 1; a <= line; a++) {
			int b = sc.nextInt();
			int c = sc.nextInt();

			arr[b][c] = arr[c][b]=1;

		}

		check[start] = true;
		st.append(start).append(" ");
		bfs(arr, check, start);
		System.out.println(st);

		Arrays.fill(check, false);
		st = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		check[start] = true;
		q.add(start);
		dfs(arr, check, q);
		System.out.println(st);

	}

	static void bfs(int arr[][], boolean check[], int start) {
		for (int a = 1; a <= v; a++) {
			if (arr[start][a] != 0 && check[a] != true) {
				st.append(a).append(" ");
				check[a] = true;
				bfs(arr, check, a);
			}
		}
	}

	static void dfs(int arr[][], boolean[] check, Queue<Integer> q) {
		while (!q.isEmpty()) {
			int start = q.poll();
			st.append(start + " ");
			for (int a = 1; a <=v; a++) {
				if (arr[start][a] != 0 && check[a] != true) {
					check[a] = true;
					q.add(a);
				}
			}
		}
	}

}
