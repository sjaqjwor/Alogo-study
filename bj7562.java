package baeckjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7562 {
	static int co = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int dx[] = new int[] { 2, -2, 2, -2, -1, -1, 1, 1 };
		int dy[] = new int[] { 1, 1, -1, -1, 2, -2, 2, -2 };
		for (int a = 0; a < num; a++) {
			int l = sc.nextInt();
			boolean check[][] = new boolean[l][l];
			Queue<chess> q = new LinkedList<>();
			int x = sc.nextInt();
			int y = sc.nextInt();
			chess st = new chess(x, y, 0);
			x = sc.nextInt();
			y = sc.nextInt();
			chess end = new chess(x, y, 0);
			q.add(st);
			check[st.y][st.x] = true;
			while (!q.isEmpty()) {
				chess c = q.poll();
				if (c.x == end.x && c.y == end.y) {
					co = c.count;
					break;
				}
				for (int a1 = 0; a1 < 8; a1++) {
					int m = c.x + dx[a1];
					int n = c.y + dy[a1];
					if (m >= 0 && m <= l - 1 && n >= 0 && n <= l - 1 && !check[n][m]) {
						q.add(new chess(m, n, c.count + 1));
						check[n][m] = true;
					}
				}
			}
			System.out.println(co);
		}
	}
}

class chess {
	int x;
	int y;
	int count;

	public chess(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
