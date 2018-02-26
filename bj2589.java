package baeckjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2589 {
	static int max = 0;
	static int result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();

		int dist[][] = new int[y][x];

		char rout[][] = new char[y][x];
		Queue<point> q = new LinkedList<>();
		Queue<point> q1 = new LinkedList<>();
		for (int a = 0; a < y; a++) {
			String s = sc.next();
			for (int b = 0; b < x; b++) {
				if (s.charAt(b) == 'L') {
					rout[a][b] = 'L';
					q.add(new point(b, a));
				} else {
					rout[a][b] = 'W';
				}
			}
		}
		for (int c[] : dist) {
			Arrays.fill(c, Integer.MAX_VALUE);
		}
		while (!q.isEmpty()) {
			q1.add(q.poll());
			dist[q1.peek().y][q1.peek().x] = 1;
			while (!q1.isEmpty()) {
				int x1 = q1.peek().x;
				int y1 = q1.poll().y;

				if (x1 + 1 < x && x1 < x && y1 < y && y1 >= 0 && rout[y1][x1 + 1] == 'L') {
					if (dist[y1][x1 + 1] > dist[y1][x1] + 1) {
						dist[y1][x1 + 1] = dist[y1][x1] + 1;
						max = dist[y1][x1 + 1];
						q1.add(new point(x1 + 1, y1));
					}
				}
				if (x1 - 1 >= 0 && x1 < x && y1 < y && y1 >= 0 && rout[y1][x1 - 1] == 'L') {
					if (dist[y1][x1 - 1] > dist[y1][x1] + 1) {
						dist[y1][x1 - 1] = dist[y1][x1] + 1;
						max = dist[y1][x1 - 1];
						q1.add(new point(x1 - 1, y1));
					}
				}
				if (y1 + 1 < y && y1 < y && x1 < x && x1 >= 0 && rout[y1 + 1][x1] == 'L') {
					if (dist[y1 + 1][x1] > dist[y1][x1] + 1) {
						dist[y1 + 1][x1] = dist[y1][x1] + 1;
						max = dist[y1 + 1][x1];
						q1.add(new point(x1, y1 + 1));
					}
				}
				if (y1 - 1 >= 0 && y1 < y && x1 < x && x1 >= 0 && rout[y1 - 1][x1] == 'L') {
					if (dist[y1 - 1][x1] > dist[y1][x1] + 1) {
						dist[y1 - 1][x1] = dist[y1][x1] + 1;
						max = dist[y1 - 1][x1];
						q1.add(new point(x1, y1 - 1));
					}
				}
				if (max > result) {
					result = max;
				}
			}
			for (int c[] : dist) {
				Arrays.fill(c, Integer.MAX_VALUE);
			}

		}
		System.out.println(result - 1);
	}

}

class point {
	int x;
	int y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
