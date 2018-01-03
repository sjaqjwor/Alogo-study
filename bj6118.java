package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj6118 {

	
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int dist[] = new int [N+1];
		List<Integer>[] list = new ArrayList[N+1];
		PriorityQueue<Dis> q = new PriorityQueue<>();
		for(int a=0;a<list.length;a++) {
			list[a] = new ArrayList<>();
			dist[a]=Integer.MAX_VALUE;
		}
		
		for(int a=0;a<M;a++) {
			int b=sc.nextInt();
			int c = sc.nextInt();
			list[b].add(c);
			list[c].add(b);
		}
		
		dist[1]=0;
		q.offer(new Dis(1));
		
		while(!q.isEmpty()) {
			Dis d = q.poll();
			for(int a=0;a<list[d.number].size();a++) {
				if(dist[list[d.number].get(a)]>dist[d.number]+1) {
					dist[list[d.number].get(a)]=dist[d.number]+1;
					q.offer(new Dis(list[d.number].get(a)));
				}
			}
		}
		Map<String,Integer> map = new HashMap<>();
		int min=0;
		int minNumber=0;
		for(int a=1;a<dist.length;a++) {
			
			map.merge(String.valueOf(dist[a]),1, Integer::sum);
			if(dist[a]>min) {
				min=dist[a];
				minNumber=a;
			}
		}
		System.out.println(minNumber);
		System.out.println(min);
		System.out.println(map.get(String.valueOf(min)));
		
		
		
		
		
	}
}
class Dis implements Comparable<Dis>{
	int number;
	int distance;
	
	public Dis(int a) {
		this.number=a;
		this.distance=1;
	}

	@Override
	public int compareTo(Dis arg0) {
		// TODO Auto-generated method stub
		return this.distance <= arg0.distance ?-1: 1;
	}
}