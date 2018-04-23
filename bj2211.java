package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj2211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num1 = sc.nextInt();

		int dist[] = new int[num + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		List<bj2211e>[] list = new ArrayList[num + 1];
		int root[] = new int[num+1];
		for (int a = 0; a <= num; a++) {
			list[a] = new ArrayList<>();
		}
		for (int a = 0; a <num1; a++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			list[b].add(new bj2211e(c, d));
			list[c].add(new bj2211e(b, d));
		}
		PriorityQueue<bj2211e> q = new PriorityQueue<>();

		dist[1] = 0;
		q.add(new bj2211e(1, dist[1]));
	;
		while (!q.isEmpty()) {
			bj2211e e = q.poll();
			for (int a = 0; a < list[e.x].size(); a++) {
				if (dist[list[e.x].get(a).x] > dist[e.x] + list[e.x].get(a).count) {
					root[list[e.x].get(a).x]=e.x;
					dist[list[e.x].get(a).x] = dist[e.x] + list[e.x].get(a).count;
					q.add(new bj2211e(list[e.x].get(a).x, dist[list[e.x].get(a).x]));
				}
			}
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(num-1);
		for(int a=2;a<=num;a++) {
			System.out.println(root[a]+" "+a);
		}

	}

}

class bj2211e implements Comparable<bj2211e> {
	int x;
	int count;

	bj2211e(int x, int count) {
		this.x = x;
		this.count = count;
	}

	@Override
	public int compareTo(bj2211e arg0) {
		// TODO Auto-generated method stub
		return this.count < arg0.count ? -1 : 1;
	}
}
