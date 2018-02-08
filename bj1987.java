package baeckjoon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class bj1987 {
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int y = sc.nextInt();
			int x = sc.nextInt();
			
			char arr[][] = new char[y][x];
			Set<String> set = new HashSet<>();
			
			for(int a=0;a<y;a++) {
				String s = sc.next();
				for(int b=0;b<x;b++) {
					arr[a][b]=s.charAt(b);
				}
			}
			dfs(x,y,0,0,0,arr,set);
			
			System.out.println(max);
	}
	static void dfs(int x , int y,int a, int b , int count, char arr[][] , Set<String> set) {
		if(x==a || y==b ||a <0 || b<0 ) {
			return;
		}
		if(!set.contains(String.valueOf(arr[b][a]))) {
			set.add(String.valueOf(arr[b][a]));
			count++;
		}else {
			return;
		}
		if(max<count) max=count;
		dfs(x,y,a+1,b,count,arr,set);
		dfs(x,y,a-1,b,count,arr,set);
		dfs(x,y,a,b+1,count,arr,set);
		dfs(x,y,a,b-1,count,arr,set);
		count--;
		set.remove(String.valueOf(arr[b][a]));
	}
}
