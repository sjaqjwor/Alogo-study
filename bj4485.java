package baeckjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj4485 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 1;
		while (num != 0) {
			int dist[][] = new int[num][num];
			int arr[][] = new int[num][num];
			Queue<Poi> q = new LinkedList<>();
			int dx[] = new int[] { 1, -1, 0, 0 };
			int dy[] = new int[] { 0, 0, -1, 1 };
			for (int a = 0; a < num; a++) {
				for (int a1 = 0; a1 < num; a1++) {
					arr[a][a1] = sc.nextInt();
				}
			}
			for (int d[] : dist) {
				Arrays.fill(d, Integer.MAX_VALUE);
			}
			q.add(new Poi(0, 0));
			dist[0][0] = arr[0][0];
			while (!q.isEmpty()) {
				Poi p = q.poll();
			
				for (int a = 0; a < 4; a++) {
					int x1 = p.x + dx[a];
					int y1 = p.y + dy[a];

					if (x1 < 0 || y1 < 0 || x1 > num - 1 || y1 > num - 1)
						continue;
					if (dist[y1][x1] > dist[p.y][p.x] + arr[y1][x1]) {
						dist[y1][x1] = dist[p.y][p.x] + arr[y1][x1];
						q.add(new Poi(x1, y1));

					}
				}

			}
			System.out.println("Problem " + count + ": " + dist[num - 1][num - 1]);
			num=sc.nextInt();
		}
	}
}

class Poi /* implements Comparable<Poi> */ {

	int x, y;

	// int count;
	Poi(int x, int y/* int count */) {
		this.x = x;
		this.y = y;
		// this.count=count;
	}

	// @Override
	// public int compareTo(Poi o) {
	//
	// return this.count <= o.count ? -1 : 1;
	// }
}
