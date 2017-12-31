package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj2667 {
	
	static int count = 0;
	static int k=0;
	static int k1=0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

			int m = sc.nextInt();
	
			int arr[][] = new int[m + 2][m + 2];
			
			boolean check[][] = new boolean[m + 2][m + 2];
			ArrayList<Integer> list = new ArrayList<>();
			

			for(int i=1;i<=m;i++){
	            String str = sc.next();
	            char ch[]=str.toCharArray();
	            for(int j=0;j<ch.length;j++){
	                arr[i][j+1]=ch[j]-'0';
	            }
			}
			
			for (int a1 = 1; a1 <= m; a1++) {
				for (int a2 = 1; a2 <= m; a2++) {
					k=0;
					dfs(a1, a2, arr, check);
					if(k!=0) {
						count++;
					}
					if(k1!=0) {
						list.add(k1);
						k1=0;
					}
				}
				
			}
			Collections.sort(list);
			System.out.println(count);
			list.forEach(s->System.out.println(s));
			
	}

	

	static void dfs(int n, int m, int[][] arr, boolean check[][]) {
		if (arr[n][m] != 0 && check[n][m] != true) {
			check[n][m] = true;
			dfs(n - 1, m, arr, check);
			dfs(n + 1, m, arr, check);
			dfs(n, m - 1, arr, check);
			dfs(n, m + 1, arr, check);
			k=1;
			k1++;
		}
		

	}

}
