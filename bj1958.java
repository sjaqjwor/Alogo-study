package baeckjoon;

import java.util.Scanner;

public class bj1958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str1 = sc.next();
		String str2 = sc.next();
		int dist[][][] = new int[101][101][101];
		for(int a=1;a<=str.length();a++) {
			for(int b=1;b<=str1.length();b++) {
				for(int c=1;c<=str2.length();c++) {
					if((str.charAt(a-1)==str1.charAt(b-1))&&(str1.charAt(b-1)==str2.charAt(c-1))&&(str.charAt(a-1)==str2.charAt(c-1))){
						dist[a][b][c]=dist[a-1][b-1][c-1]+1;
					}else {
						dist[a][b][c]=Math.max(dist[a][b][c-1],Math.max(dist[a][b-1][c],dist[a-1][b][c]));
					}
				}
			}
		}
		System.out.println(dist[str.length()][str1.length()][str2.length()]);
		
		
	}

}
