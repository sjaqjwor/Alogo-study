package baeckjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj6593 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int floor = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		while (floor != 0) {
			char arr[][][] = new char[floor][y][x];
			int dist[][][] = new int[floor][y][x];
			int dx[] = new int[] { 1, -1, 0, 0 };
			int dy[] = new int[] { 0, 0, 1, -1 };
			int f[] = new int[] { 1, -1 };
			for (int a = 0; a < floor; a++) {
				for (int d[] : dist[a]) {
					Arrays.fill(d, Integer.MAX_VALUE);
				}
			}
			Queue<bj6593e> q = new LinkedList<>();
			bj6593e start = null;
			bj6593e last = null;
			for (int a = 0; a < floor; a++) {
				for (int a1 = 0; a1 < y; a1++) {
					String s = sc.next();
					for (int a2 = 0; a2 < x; a2++) {
						if (s.charAt(a2) == 'S') {
							start = new bj6593e(a, a2, a1, 1);
						}
						if (s.charAt(a2) == 'E') {
							last = new bj6593e(a, a2, a1, 1);
						}
						arr[a][a1][a2] = s.charAt(a2);
					}
				}
			}
			q.add(start);
			dist[start.floor][start.y][start.x] = 0;
			while (!q.isEmpty()) {
				bj6593e t = q.poll();

				for (int b = 0; b < 2; b++) {
					int tf = t.floor + f[b];
					if (tf < 0 || tf > floor - 1)
						continue;
					if (arr[tf][t.y][t.x] != '#' && dist[tf][t.y][t.x] > dist[t.floor][t.y][t.x] + t.count) {
						dist[tf][t.y][t.x] = dist[t.floor][t.y][t.x] + 1;
						q.add(new bj6593e(tf, t.x, t.y, dist[tf][t.y][t.x]));
					}

				}
				for (int a = 0; a < 4; a++) {
					int tempx = t.x + dx[a];
					int tempy = t.y + dy[a];
					if (tempx < 0 || tempx > x - 1 || tempy < 0 || tempy > y - 1) {
						continue;
					}
					if (arr[t.floor][tempy][tempx] != '#'
							&& dist[t.floor][tempy][tempx] > dist[t.floor][t.y][t.x] + t.count) {
						dist[t.floor][tempy][tempx] = dist[t.floor][t.y][t.x] + 1;
						q.add(new bj6593e(t.floor, tempx, tempy, dist[t.floor][tempy][tempx]));
					}
				}
			}
			System.out.println(dist[last.floor][last.y][last.x] == Integer.MAX_VALUE ? "Trapped!"
					: "Escaped in " + dist[last.floor][last.y][last.x] + " minute(s).");
			floor=sc.nextInt();
			y=sc.nextInt();
			x=sc.nextInt();
		}
	}
}

class bj6593e {
	int floor;
	int x;
	int y;
	int count;

	public bj6593e(int floor, int x, int y, int count) {
		this.floor = floor;
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
