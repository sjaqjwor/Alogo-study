package baeckjoon;

import java.util.*;

public class bj1012 {

	static int count = 0;
	static int k=0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();

		for (int a = 1; a <= test; a++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int pointNumber = sc.nextInt();
			int arr[][] = new int[n + 2][m + 2];
			boolean check[][] = new boolean[n + 2][m + 2];

			for (int a1 = 1; a1 <= pointNumber; a1++) {
				int point = sc.nextInt();
				int point1 = sc.nextInt();
				arr[point1+1][point+1] = 1;
			}
			for (int a1 = 1; a1 <= n; a1++) {
				for (int a2 = 1; a2 <= m; a2++) {
					k=0;
					dfs(a1, a2, arr, check);
					if(k!=0) {
						count++;
					}
				}
				
			}
			System.out.println(count);
			count=0;
			k=0;
		}

	}

	static void dfs(int n, int m, int[][] arr, boolean check[][]) {
		if (arr[n][m] != 0 && check[n][m] != true) {
			check[n][m] = true;
			dfs(n - 1, m, arr, check);
			dfs(n + 1, m, arr, check);
			dfs(n, m - 1, arr, check);
			dfs(n, m + 1, arr, check);
			k=1;
		}
		

	}

}
