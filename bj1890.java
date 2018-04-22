package baeckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1890 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[][] = new int[num][num];
		long dist[][] = new long[num][num];

		for (int a = 0; a < num; a++) {
			for (int a1 = 0; a1 < num; a1++) {
				arr[a][a1] = sc.nextInt();
			}
		}
		dist[0][0]=1;
		for (int a = 0; a < num; a++) {
			for (int a1 = 0; a1 < num; a1++) {
				if(dist[a][a1]==0 || (a==num-1 && a1==num-1))continue;
				
				int d = arr[a][a1];
				int tempy = d+a;
				int tempx = d+a1;
				
				if(tempy<num) {
					dist[tempy][a1]+=dist[a][a1];
				}
				if(tempx<num) {
					dist[a][tempx]+=dist[a][a1];
				}
			}
		}
		System.out.println(dist[num-1][num-1]);
	}
}

class bj1890e {
	int x;
	int y;

	public bj1890e(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
