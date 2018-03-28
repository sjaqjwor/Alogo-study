package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2631 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num];
		int dist[] = new int[num];
		for(int a=0;a<num;a++) {
			arr[a]=sc.nextInt();
		}
		for(int a=0;a<num;a++) {
			dist[a]=1;
			for(int b=a-1;b>=0;b--) {
				if(arr[a]>arr[b]) {
					dist[a]=Math.max(dist[a], dist[b]+1);
				}
			}
		}

		int max=0;
		for(int a=0;a<num;a++) {
			if(max<dist[a]) {
				max=dist[a];
			}
		}
		System.out.println(num-max);
	}
}
