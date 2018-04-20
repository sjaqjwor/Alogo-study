package baeckjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj2606 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		
		List<Integer>[] list = new ArrayList[num+1];
		int line = sc.nextInt();
		boolean check[] = new boolean[num+1];
		for(int a=1;a<=num;a++) {
			list[a]=new ArrayList<Integer>();
		}
		for(int a=0;a<line;a++) {
			int v = sc.nextInt();
			int n =sc.nextInt();
			list[v].add(n);
			list[n].add(v);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int count=0;
		check[1]=true;
		while(!q.isEmpty()) {
			Integer p = q.poll();
			for(int a=0;a<list[p].size();a++) {
				if(!check[list[p].get(a)]) {
					check[list[p].get(a)]=true;
					q.add(list[p].get(a));
					count++;
				}
			}
		}
		System.out.println(count);	

	}

}
