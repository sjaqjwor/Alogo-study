package baeckjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj2583 {
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int n = sc.nextInt();
		boolean arr[][] = new boolean[y][x];
		Queue<Range> q = new LinkedList<>();
		for(int a=0;a<n;a++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int b=y1;b<y2;b++) {
				for(int c=x1;c<x2;c++) {
					arr[b][c]=true;
				}
			}
		}
	
		for(int a=0;a<y;a++) {
			for(int b=0;b<x;b++) {
				if(!arr[a][b]) {
					q.add(new Range(a,b));
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		int count=0;
		while(!q.isEmpty()) {
			Range r= q.poll();
			if(!arr[r.y][r.x]) {
				count++;
				max++;
			}else {
				continue;
			}
			dfs(arr,r.x,r.y,x,y);
			list.add(max);
			max=0;
		}
		System.out.println(count);
		Collections.sort(list);
		list.forEach(s->System.out.print(s-1+" "));
	}
	static void dfs(boolean arr[][],int rx, int ry,int x, int y) {
		if(rx<0 || rx >x-1 ||ry<0 || ry >y-1){
			return;
		}
		if(!arr[ry][rx]) {
			arr[ry][rx]=true;
			max++;
		}else {
			return;
		}
		dfs(arr,rx+1,ry,x,y);
		dfs(arr,rx-1,ry,x,y);
		dfs(arr,rx,ry+1,x,y);
		dfs(arr,rx,ry-1,x,y);
	
	}
}
class Range{
	int x;
	int y;
	public Range(int y, int x) {
		this.y=y;
		this.x=x;
	}
}
