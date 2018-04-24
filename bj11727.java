package baeckjoon;

import java.util.Scanner;

public class bj11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int dist[] = new int[num+1];
		dist[2]=3;
		dist[1]=1;
		for(int a=3;a<=num;a++) {
			dist[a]=(dist[a-1]+dist[a-2]*2)%10007;
		}
		System.out.println(dist[num]%10007);
	}

}
