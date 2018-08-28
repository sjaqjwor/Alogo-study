package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int t[] = new int [N+1];
		int p[] = new int [N+1];
		
		int dp[] = new int[N+1];
		for(int a=1;a<=N;a++) {
			t[a]=sc.nextInt();
			p[a]=sc.nextInt();
			
			dp[a]=p[a];
		}
		
		for(int a=2;a<=N;a++) {
			for(int b=1;b<a;b++) {
				if(a-b>=t[b]) {
					dp[a]=Math.max(dp[a],dp[b]+p[a]);
				}
			}
		}
		int max=0;
		for(int a=1;a<=N;a++) {
			if(a+t[a]<=N+1 && max<dp[a]) {
				max=dp[a];
			}
		}
		System.out.println(max);
	}

}
