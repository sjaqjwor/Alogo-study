package baeckjoon;

import java.util.Scanner;

public class bj12865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		item [] ia = new item[n];
		int answer[][] = new int [n+1][k+1];
		
		for(int a=0;a<n;a++) {
			item i = new item(sc.nextInt(),sc.nextInt());
			ia[a]=i;
		}
		for(int a=1;a<=n;a++) {
			for(int b=1;b<=k;b++) {
				if(b-ia[a-1].w>=0) {
					answer[a][b]=Math.max(answer[a-1][b],answer[a-1][b-ia[a-1].w]+ia[a-1].g);
				}else {
					answer[a][b]=answer[a-1][b];
				}
			}
		}
			System.out.println(answer[n][k]);
	}
}
class item{
	int w;
	int g;
	
	public item(int w, int g) {
		this.w=w;
		this.g=g;
	}
}
