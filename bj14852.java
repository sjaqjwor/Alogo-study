package baeckjoon;

import java.util.Scanner;

public class bj14852 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int dist[]= new int[1000000];
		dist[1]=2;
		dist[2]=7;
		for(int a=3;a<=num;a++) {
			dist[a]=(dist[a-2]*dist[a-1])%1000000007;
		}
		System.out.println(dist[num]);
	}

}
