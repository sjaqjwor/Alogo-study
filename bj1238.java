package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj1238 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		int dist [] = new int[N+1];
		int distreverse[]  = new int[N+1];
		List<NodeExam>[] list  = new ArrayList[N+1];
		PriorityQueue<NodeExam> q = new PriorityQueue<>();
		for(int a=1;a<=N;a++) {
			list[a] = new ArrayList<>();
			dist[a] = Integer.MAX_VALUE;
			distreverse[a]=Integer.MAX_VALUE;
		}
		for(int a=1;a<=M;a++) {
			int b = sc.nextInt();
			int c= sc.nextInt();
			int line = sc.nextInt();
			
			list[b].add(new NodeExam(c,line));
		}
		distreverse[X]=0;
		q.offer(new NodeExam(X,dist[X]));
		while(!q.isEmpty()) {
			NodeExam n = q.poll();
			for(int b=0;b<list[n.point].size();b++) {
				if(distreverse[list[n.point].get(b).point]>distreverse[n.point]+list[n.point].get(b).number) {
					distreverse[list[n.point].get(b).point]=distreverse[n.point]+list[n.point].get(b).number;
					q.offer(new NodeExam(list[n.point].get(b).point,distreverse[list[n.point].get(b).point]));
				}
			}
		}
		
		int max = 0;
		for(int a=1;a<=N;a++) {
			dist[a]=0;
			q.offer(new NodeExam(a,dist[a]));
			while(!q.isEmpty()) {		
				NodeExam n = q.poll();
				for(int b=0;b<list[n.point].size();b++) {
					if(dist[list[n.point].get(b).point]>dist[n.point]+list[n.point].get(b).number) {
						dist[list[n.point].get(b).point]=dist[n.point]+list[n.point].get(b).number;
						q.offer(new NodeExam(list[n.point].get(b).point,dist[list[n.point].get(b).point]));
					}
				}
			}
		
			if(max<dist[X]+distreverse[a]) {
				max=dist[X]+distreverse[a];
			}
			Arrays.fill(dist, Integer.MAX_VALUE);
		}
		
		System.out.println(max);
	}

}
class NodeExam implements Comparable<NodeExam>{
	int point;
	int number;
	
	public NodeExam(int point , int number) {
		this.point= point;
		this.number = number;
	}

	@Override
	public int compareTo(NodeExam o) {
		// TODO Auto-generated method stub
		return this.number <= o.number?-1: 1;
	}
}
