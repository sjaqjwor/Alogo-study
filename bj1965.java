package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj1965 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num];
		int dist[] = new int[num];
		for(int a=0;a<num;a++) {
			arr[a]=sc.nextInt();
		}
		Arrays.fill(dist, 1);
		for(int a=1;a<num;a++) {
			for(int b=0;b<a;b++) {
				if(arr[a]>arr[b]) {
					dist[a]=Math.max(dist[a], dist[b]+1);
				}
			}
		}
		int max=0;
		for(int k  : dist) {
			if(k>max) {
				max=k;
			}
		}
		System.out.println(max);
	}

}
