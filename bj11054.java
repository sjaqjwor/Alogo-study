package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num+1];
		int dist[] = new int[num+1];
		int back[] = new int[num+1];
		for(int a=1;a<=num;a++) {
			arr[a]=sc.nextInt();
		}
		dist[1]=1;
		for(int a=1;a<=num;a++) {
			for(int b=1;b<a;b++) {
				if(arr[a]>arr[b]) {
					dist[a]=Math.max(dist[a],dist[b]+1);
				}
			}
		}
		back[num]=1;
		for(int a=num;a>=1;a--) {
			for(int b=num;b>=1;b--) {
				if(arr[a]>arr[b]) {
					back[a]=Math.max(back[a],back[b]+1);
				}
			}
		}
		int result =0;
		for(int a=1;a<=num;a++) {
			int max=dist[a]+back[a];
			if(result<max) {
				result=max;
			}
		}
		System.out.println(result-1);
	}

}
