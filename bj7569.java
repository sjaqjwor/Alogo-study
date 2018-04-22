package baeckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M =sc.nextInt();
		int N =sc.nextInt();
		int H =sc.nextInt();
		int dist[][][] = new int[H][N][M];
		int floor[] = new int[] {1,-1};
		int dx[] = new int[] {1,-1,0,0};
		int dy[] = new int[] {0,0,1,-1};
		Queue<bj7569e> q = new LinkedList<>();
		boolean[][][] check = new boolean[H][N][M];
		for(int b=0;b<H;b++) {
		for(int a=0 ; a<N;a++) {
			for(int a1=0 ; a1<M ;a1++) {
				dist[b][a][a1]=sc.nextInt();
				if(dist[b][a][a1]==1) {
					q.add(new bj7569e(b,a1,a));
					check[b][a][a1]=true;
				}
			}
		}
		}
		int count=0;
		boolean checkcount= false;
		while(!q.isEmpty()) {
			int size= q.size();
			for(int a=0;a<size;a++) {
				bj7569e j = q.poll();
				for(int b1=0;b1<2;b1++) {
					int tf = j.floor+floor[b1];
					if(tf<0 || tf>H-1)continue;
					if(dist[tf][j.y][j.x] !=-1 && !check[tf][j.y][j.x]) {
						checkcount=true;
						check[tf][j.y][j.x]=true;
						q.add(new bj7569e(tf,j.x,j.y));
					}
				}
				for(int b=0;b<4;b++) {
					int tempx = j.x+dx[b];
					int tempy = j.y+dy[b];
					if(tempx<0 || tempx>M-1 || tempy<0 || tempy>N-1)continue;
					if(dist[j.floor][tempy][tempx] != -1 && !check[j.floor][tempy][tempx]) {
						checkcount=true;
						check[j.floor][tempy][tempx]=true;
						q.add(new bj7569e(j.floor,tempx,tempy));
					}
				}
			}
			if(checkcount) {
				count++;
				checkcount=false;
			}
		}
		for(int a=0;a<H;a++) {
			for(int a1=0;a1<N;a1++) {
				for(int a2=0;a2<M;a2++) {
					if(dist[a][a1][a2]==0 && !check[a][a1][a2]) {
						if(count>0) {
							System.out.println(-1);
							return;
						}
						if(count==0) {
							System.out.println(0);
							return;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}

class bj7569e {
	int floor;
	int x;
	int y;

	public bj7569e(int floor, int x, int y) {
		this.floor = floor;
		this.x = x;
		this.y = y;
	}
}
