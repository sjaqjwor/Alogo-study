package baeckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj14502 {
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int dist[][] = new int[y][x];
		for(int a=0;a<y;a++) {
			for(int b=0;b<x;b++) {
				int x1 = sc.nextInt();
				dist[a][b]=x1;
			}
		}
		for(int a=0;a<y;a++) {
			for(int b=0;b<x;b++) {
				if(dist[a][b]==0) {
//					int d[][] = new int[y][x];
//					for(int c=0;c<y;c++) {
//						for(int e=0;e<x;e++) {
//							d[c][e]=dist[c][e];
//						}
//					}
					change(y,x,dist,0);
				}
			}
		}
		System.out.println(max);
		
		
	}
	static void change(int y,int x,int arr[][], int count) {
		if(count==3) {
			birus(y,x,arr);
			return;
		}
		for(int a=0;a<y;a++) {
			for(int b=0;b<x;b++) {
				if(arr[a][b]==0) {
					arr[a][b]=1;
					change(y,x,arr,count+1);
					arr[a][b]=0;
				}
			}
		}
	}
	static void birus(int y,int x,int arr[][]) {
		int d[][] = new int[y][x];
		Queue<bj14502e> q = new LinkedList<>();
		for(int a=0;a<y;a++) {
			for(int b=0;b<x;b++) {
				d[a][b]=arr[a][b];
				if(d[a][b]==2) {
						q.add(new bj14502e(b,a));
				}
			}
		}
		int dx[] = new int[] {1,-1,0,0};
		int dy[] = new int[] {0,0,1,-1};
		while(!q.isEmpty()) {
			bj14502e e = q.poll();
			for(int a=0;a<4;a++) {
				int tx = e.x+dx[a];
				int ty = e.y+dy[a];
				if(tx<0 || tx>x-1 || ty<0 || ty>y-1) continue;
				if( d[ty][tx]==0) {
					d[ty][tx]=2;
					q.add(new bj14502e(tx,ty));
				}
			}
		}
		int count=0;
		for(int a=0;a<y;a++) {
			for(int b=0;b<x;b++) {
				if(d[a][b]==0) {
					count++;
				}
			}
		}
		max=Math.max(max,count);
		
	}

}
class bj14502e{
	int x;
	int y;
	public bj14502e(int x, int y){
		this.x=x;
		this.y=y;
	}
}
