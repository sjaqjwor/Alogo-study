package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj5502 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String s = sc.next();
		char ch[] = s.toCharArray();
		char reverse[] = new char[ch.length];
		int b=0;
		for(int a=ch.length-1;a>=0;a--) {
			reverse[b]=ch[a];
			b++;
		}
		System.out.println(Arrays.toString(reverse));
		System.out.println(Arrays.toString(ch));
		
		int dist[][]= new int[num+1][num+1];
		for(int a=1;a<=num;a++) {
			for(int c=1;c<=num;c++) {
				if(ch[a-1]==reverse[c-1]) {
					dist[a][c]=dist[a-1][c-1]+1;
				}else {
					dist[a][c]=Math.max(dist[a-1][c], dist[a][c-1]);
				}
			}
		}
		System.out.println(num-dist[num][num]);
	}
}
