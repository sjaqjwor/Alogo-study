package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj10971 {

	static boolean check[];
	static int arr[][];
	static int min = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		arr = new int[n + 1][n + 1];
		check = new boolean[n + 1];

		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				arr[a][b] = sc.nextInt();
			}
		}

		for (int a = 1; a <= n; a++) {
			dfs(a, a, 1, 0);
		}

		System.out.println(min);

	}

	static void dfs(int start, int current, int deep, int sum) {
		if (deep == n) {
			if (arr[current][start] == 0) {
				return;
			}
			sum += arr[current][start];

			if (sum < min) {
				min = sum;
			}
			return;
		}

		check[current] = true;
		
		for (int a = 1; a <= n; a++) {
			if (arr[current][a] != 0 && check[a] != true) {
				dfs(start, a, deep + 1, sum + arr[current][a]);
			}
		}
		
		check[current] = false;
	}
}
