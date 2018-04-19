package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj1162 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K =sc.nextInt();
		List<bj1162e>[] list = new ArrayList[N+1];
		for(int a=1;a<=N;a++) {
			list[a]=new ArrayList<>();
		}
		for(int a=0;a<M;a++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			int k=sc.nextInt();
			list[n].add(new bj1162e(m,k,0));
			list[m].add(new bj1162e(n,k,0));
		}
		PriorityQueue<bj1162e> q = new PriorityQueue<>();
	
		int dist[][] = new int[N+1][K+1];
		for(int d[] : dist) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		dist[1][0]=0;
		q.add(new bj1162e(1,dist[1][0],0));
		while(!q.isEmpty()) {
			bj1162e e = q.poll();
			for(int a=0;a<list[e.y].size();a++) {
				if(e.step+1<=K&& dist[list[e.y].get(a).y][e.step+1]>dist[e.y][e.step]) {
					dist[list[e.y].get(a).y][e.step+1]=dist[e.y][e.step];
					q.add(new bj1162e(list[e.y].get(a).y,dist[list[e.y].get(a).y][e.step+1],e.step+1));
				}
				if(dist[list[e.y].get(a).y][e.step]>dist[e.y][e.step]+list[e.y].get(a).count) {
					dist[list[e.y].get(a).y][e.step]=dist[e.y][e.step]+list[e.y].get(a).count;
					q.add(new bj1162e(list[e.y].get(a).y,dist[list[e.y].get(a).y][e.step],e.step));
				}
			
			}
		}
		int min=Integer.MAX_VALUE;
		for(int a=0;a<=K;a++) {
			if(min>dist[N][a]) {
				min=dist[N][a];
			}
		}
		System.out.println(min);
		
	}
}
class bj1162e implements Comparable<bj1162e>{
	int y;
	int count;
	int step;
	public bj1162e(int y,int count,int step) {
		this.y=y;
		this.count=count;
		this.step=step;
	}
	@Override
	public int compareTo(bj1162e arg0) {
		// TODO Auto-generated method stub
		return this.count<arg0.count ? -1 : 1;
	}
}
