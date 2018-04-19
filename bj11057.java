package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		int dist[][] = new int[num+1][10];
		if(num==1) {
			System.out.println(10);
		}else {
			Arrays.fill(dist[1], 1);
			for(int a=2;a<=num;a++) {
				int max=0;
				for(int a3=0;a3<=9;a3++) {
					max+=dist[a-1][a3];
				}
				dist[a][0]=max;
				for(int a1=1;a1<=9;a1++) {
					max-=dist[a-1][a1-1];
					dist[a][a1]=max%10007;
				}
			}
			int max=0;
			for(int a=0;a<=9;a++) {
				max+=dist[num][a];
			}
			System.out.println(max%10007);
		}
		
	}

}
