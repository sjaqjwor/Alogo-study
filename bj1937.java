package baeckjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class bj1937 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[][] = new int[num][num];
		int dx[] = new int[] {1,-1,0,0};
		int dy[] = new int[] {0,0,1,-1};
		
		for(int a=0;a<num;a++) {
			for(int b=0;b<num;b++) {
				arr[a][b]=sc.nextInt();
			}
		}
		PriorityQueue<bj1937e> q = new PriorityQueue<>();
		int max=0;
		for(int a=0;a<num;a++) {
			for(int b=0;b<num;b++) {
				q.add(new bj1937e(b,a,1));
				while(!q.isEmpty()) {
					bj1937e e = q.poll();
					if(e.count>max) {
						max=e.count;
					}
					for(int c=0;c<4;c++) {
						int tx = e.x+dx[c];
						int ty = e.y+dy[c];
						if(tx <0 || ty<0 || tx>num-1 || ty>num-1) continue;
						if(arr[e.y][e.x]>arr[ty][tx]) {
							q.add(new bj1937e(tx,ty,e.count+1));
						}
					}
				}
			}
		}
		System.out.println(max);
	}

}
class bj1937e implements Comparable<bj1937e>{
	int x;
	int y;
	int count;
	public bj1937e(int x, int y,int count) {
		this.x=x;
		this.y=y;
		this.count=count;
	}
	@Override
	public int compareTo(bj1937e o) {
		// TODO Auto-generated method stub
		return this.count> o.count ? -1 : 1;
	}
}