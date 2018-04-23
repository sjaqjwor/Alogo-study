package baeckjoon;

import java.util.Scanner;

public class bj2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		int dist[] = new int[31];
		dist[0]=1;
		dist[2]=3;
		for(int a=4;a<=num;a++) {
			dist[a]=3*dist[a-2];
			for(int b=4;b<=a;b=b+2) {
				dist[a]+=2*dist[a-b];
			}
		}
		System.out.println(dist[num]);
	}

}
