package baeckjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj1261 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int numy=sc.nextInt();
		
		int dx[] = new int[] {1,-1,0,0};
		int dy[] = new int[] {0,0,1,-1};
		
		int arr[][]= new int[numy][num];
		int dist[][] = new int[numy][num];
		for(int a=0;a<numy;a++) {
			String s =sc.next();
			for(int a1=0;a1<num;a1++) {
				arr[a][a1]=Integer.parseInt(s.substring(a1, a1+1));
			}
		}
		
		PriorityQueue<bj1261e> p = new PriorityQueue<>();
		p.add(new bj1261e(0,0,0));
		for(int d[] : dist) {
			Arrays.fill(d,Integer.MAX_VALUE);
		}
		dist[0][0]=0;
		while(!p.isEmpty()) {
			bj1261e e = p.poll();
			if(e.x==num-1 && e.y==numy-1) {
				System.out.println(e.count);
				break;
			}
			for(int a=0;a<4;a++) {
				int tex = dx[a]+e.x;
				int tey = dy[a]+e.y;
				
				if(tex<0 || tey<0 || tex>num-1 || tey>numy-1) continue;
				if(dist[tey][tex]>dist[e.y][e.x]+e.count) {
					if(arr[tey][tex]==1) {
						dist[tey][tex]=dist[e.y][e.x]+1;
						p.add(new bj1261e(tex,tey,dist[tey][tex]));
					}else {
						dist[tey][tex]=e.count;
						p.add(new bj1261e(tex,tey,e.count));
					}
				}
			}
		}
	}
}
class bj1261e implements Comparable<bj1261e>{
	int x;
	int y;
	int count;
	public bj1261e(int x,int y,int count) {
		this.x=x;
		this.y=y;
		this.count=count;
	}
	@Override
	public int compareTo(bj1261e arg0) {
		// TODO Auto-generated method stub
		return this.count<arg0.count? -1:1;
	}
}
