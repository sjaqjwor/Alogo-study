package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj3640 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v= sc.nextInt();
		int e= sc.nextInt();
		
		List<bj3640e>list[] = new ArrayList[v+1];
		boolean check[] = new boolean[v+1];
		int root[] = new int[v+1];
		int dist[] = new int[v+1];
		for(int a=0;a<=v;a++) {
			list[a]=new ArrayList<>();
		}
		for(int a=0;a<e;a++) {
			int a1=sc.nextInt();
			int b1=sc.nextInt();
			int c1 = sc.nextInt();
			list[a1].add(new bj3640e(b1,c1));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<bj3640e> q = new LinkedList<>();
		dist[1]=0;
		q.add(new bj3640e(1,0));
		while(!q.isEmpty()) {
			bj3640e b = q.poll();
			for(int a=0;a<list[b.x].size();a++) {
				if(dist[list[b.x].get(a).x] > dist[b.x]+list[b.x].get(a).count) {
					dist[list[b.x].get(a).x] = dist[b.x]+list[b.x].get(a).count;
					q.add(new bj3640e(list[b.x].get(a).x,dist[list[b.x].get(a).x]));
				}
			}
		}
		System.out.println(Arrays.toString(dist));
		
		
		
		
		
	}

}
class bj3640e{
	int x;
	int count;
	public bj3640e(int x,int y) {
		this.x=x;
		this.count=y;
	}
}
