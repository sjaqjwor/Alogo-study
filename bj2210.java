package baeckjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class bj2210 {

	static StringBuilder st = new StringBuilder();
	static Map<String, Integer> map = new HashMap<>();
	static int arr[][] = new int[7][7];
	static int check[] = new int [7];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			for(int a=1;a<=5;a++) {
				for(int a1=1;a1<=5;a1++) {
					 arr[a][a1]= sc.nextInt();
				}
			}
			for(int a=1;a<=5;a++) {
				for(int a1=1;a1<=5;a1++) {
					dfs(0,a,a1);
				}
			}
			System.out.println(map.size());
			
	}
	static void dfs(int count,int a,int b) {
		if(a<=0||b<=0||a>5||b>5) {
			return;
		}
		if(count==6) {
			map.merge(Arrays.toString(check),1 ,Integer::sum);
			return;
		}
		++count;
		check[count]=arr[a][b];
		dfs(count,a+1,b);
		dfs(count,a-1,b);
		dfs(count,a,b+1);
		dfs(count,a,b-1);
		
	}
}
