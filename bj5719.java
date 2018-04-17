package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj5719 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num1 = sc.nextInt();
		while (num != 0 && num1 != 0) {
			int dist[] = new int[num];
			boolean check[][] = new boolean[num][num];
			Arrays.fill(dist, Integer.MAX_VALUE);
			ArrayList<ArrayList<poi>> map = new ArrayList<>();
			ArrayList<ArrayList<poi>> reverseMap = new ArrayList<>();

			for (int i = 0; i < num; i++) {
				map.add(new ArrayList<>());
				reverseMap.add(new ArrayList<>());
			}
			int start = sc.nextInt();
			int last = sc.nextInt();
			for (int a = 0; a < num1; a++) {
				int co = sc.nextInt();
				int c = sc.nextInt();
				int cou = sc.nextInt();
				map.get(co).add(new poi(c, cou));
				reverseMap.get(c).add(new poi(co, cou));
			}

			Arrays.fill(dist, Integer.MAX_VALUE);
			PriorityQueue<poi> q = new PriorityQueue<>();
			dist[start] = 0;
			q.add(new poi(start, dist[start]));
			while (!q.isEmpty()) {
				poi p = q.poll();
				if (dist[p.y] >= p.cost) {
					for (poi k : map.get(p.y)) {
						int d = k.y;
						int co = k.cost;
						if (dist[d] > dist[p.y] + co && !check[p.y][d]) {
							dist[d] = dist[p.y] + co;
							q.add(new poi(d, dist[d]));
						}
					}
				}
			}
			dfs(check, dist, reverseMap, start, last);
			Arrays.fill(dist, Integer.MAX_VALUE);
			q = new PriorityQueue<>();
			dist[start] = 0;
			q.add(new poi(start, dist[start]));
			while (!q.isEmpty()) {
				poi p = q.poll();
				if (dist[p.y] >= p.cost) {
					for (poi k : map.get(p.y)) {
						int d = k.y;
						int co = k.cost;
						if (dist[d] > dist[p.y] + co && !check[p.y][d]) {
							dist[d] = dist[p.y] + co;
							q.add(new poi(d, dist[d]));
						}
					}
				}
			}
			System.out.println(dist[last]>=Integer.MAX_VALUE ? -1 : dist[last]);
			num = sc.nextInt();
			num1 = sc.nextInt();
		}

	}

	static void dfs(boolean check[][], int dist[], ArrayList<ArrayList<poi>> reverseMap, int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(end);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now != start) {
				for (poi p : reverseMap.get(now)) {
					if (dist[now] == dist[p.y] + p.cost) {
						check[p.y][now] = true;
						q.add(p.y);
					}
				}
			}
		}

	}

}

class poi implements Comparable<poi> {
	int y;
	int cost;

	poi(int x, int cost) {
		this.y = x;
		this.cost = cost;
	}

	@Override
	public int compareTo(poi o) {
		return this.cost >= o.cost ? 1 : -1;
	}

}
