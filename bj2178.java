package baeckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2178 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num1 = sc.nextInt();
		int arr[][] = new int[num][num1];
		int dx[] = new int[] {1,-1,0,0};
		int dy[] = new int[] {0,0,1,-1};
		boolean check[][] = new boolean[num][num1];
		for(int a=0;a<num;a++) {
			String s= sc.next();
			for(int a1=0;a1<num1;a1++) {
				arr[a][a1]=Integer.parseInt(s.substring(a1,a1+1));
			}	
		}
		
		Queue<bj2178e> q = new LinkedList<>();
		q.add(new bj2178e(0,0,1));
		check[0][0]=true;
		while(!q.isEmpty()) {
			bj2178e e = q.poll();
			if(e.y==num-1&& e.x==num1-1) {
				System.out.println(e.count);
				break;
			}
			for(int a=0;a<4;a++) {
				int tempx = e.x+dx[a];
				int tempy = e.y+dy[a];
				if(tempy<0 || tempx<0 || tempy>num-1 ||tempx>num1-1) continue;
				if(check[tempy][tempx]==false && arr[tempy][tempx]==1) {
					check[tempy][tempx]=true;
					q.add(new bj2178e(tempx,tempy,e.count+1));
				}
			}
		}
		
	}
}
class bj2178e{
	int x;
	int y;
	int count;
	public bj2178e(int x,int y,int count) {
		this.x=x;
		this.y=y;
		this.count=count;
	}
}
