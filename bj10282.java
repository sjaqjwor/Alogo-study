package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj10282 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int a = 0; a < num; a++) {
			int cn = sc.nextInt();
			int ln = sc.nextInt();
			int bi = sc.nextInt();

			List<bj10282e>[] list = new ArrayList[cn + 1];
			for (int b = 0; b <= cn; b++) {
				list[b] = new ArrayList<>();
			}
			int dist[] = new int[cn + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			for (int b = 0; b < ln; b++) {
				int lna = sc.nextInt();
				int lnb = sc.nextInt();
				int lnc = sc.nextInt();
				list[lnb].add(new bj10282e(lna, lnc, 0));
			}
			PriorityQueue<bj10282e> q = new PriorityQueue<>();
			dist[bi] = 0;
			q.add(new bj10282e(bi, dist[bi], 1));
			bj10282e last = new bj10282e(bi, 0, 1);

			while (!q.isEmpty()) {
				bj10282e e = q.poll();
				for (int c = 0; c < list[e.x].size(); c++) {
					if (dist[list[e.x].get(c).x] > e.count + list[e.x].get(c).count) {
						dist[list[e.x].get(c).x] = e.count + list[e.x].get(c).count;
						q.add(new bj10282e(list[e.x].get(c).x,dist[list[e.x].get(c).x], e.bcount + 1));
					}
				}
			}
			int count=0;
			int max=0;
			for(int d : dist) {
				if(d<Integer.MAX_VALUE) {
					count++;
					max=Math.max(max, d);
				}
			}
			System.out.println(count+ " "+max);
		}

	}

}

class bj10282e implements Comparable<bj10282e> {
	int x;
	int count;
	int bcount;

	public bj10282e(int x, int y, int bcount) {
		this.x = x;
		this.count = y;
		this.bcount = bcount;
	}

	@Override
	public int compareTo(bj10282e arg0) {
		// TODO Auto-generated method stub
		return this.x < arg0.x ? -1 : 1;
	}
}