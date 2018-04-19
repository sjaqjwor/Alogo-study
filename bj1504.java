package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj1504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		List<N1>[] adj = new ArrayList[M + 1];
		int dist[] = new int[M + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean check[] = new boolean[M + 1];

		for (int a = 1; a <= M; a++) {
			adj[a] = new ArrayList<N1>();
		}
		
		for(int a= 0;a<N;a++) {
			int b= sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			adj[b].add(new N1(c,d));
			adj[c].add(new N1(b,d));
		}
		
		int p1=sc.nextInt();
		int p2 = sc.nextInt();
		int sum[] = new int[3];
		int max[] = new int[3];
		sum[0]=di(dist,1,p1,adj);
		Arrays.fill(dist,Integer.MAX_VALUE);
		sum[1]=di(dist,p1,p2,adj);
		Arrays.fill(dist,Integer.MAX_VALUE);
		sum[2]=di(dist,p2,M,adj);
		Arrays.fill(dist,Integer.MAX_VALUE);
		max[0]=di(dist,1,p2,adj);
		Arrays.fill(dist,Integer.MAX_VALUE);
		max[1]=di(dist,p2,p1,adj);
		Arrays.fill(dist,Integer.MAX_VALUE);
		max[2]=di(dist,p1,M,adj);
		
		long result=0;
		long result1=0;
		for(int a=0;a<3;a++) {
			if(sum[a]<0 || sum[a]==Integer.MAX_VALUE ||max[a]<0 || max[a]==Integer.MAX_VALUE) {
				System.out.println(-1);
				return;
			}
			result+=sum[a];
			result1+=max[a];
		}
		System.out.println(result>result1 ? result1 : result);

	}
	
	static int di(int arr[],int start , int last, List<N1>[] list) {
		PriorityQueue<N1> p  = new PriorityQueue<>();
		arr[start]= 0;
		p.offer(new N1(start,arr[start]));
		while(!p.isEmpty()) {
			N1 n = p.poll();
			for(int a=0;a<list[n.vertex].size();a++) {
				if(arr[list[n.vertex].get(a).vertex]>arr[n.vertex]+list[n.vertex].get(a).weight) {
					arr[list[n.vertex].get(a).vertex]=arr[n.vertex]+list[n.vertex].get(a).weight;
					p.offer(new N1(list[n.vertex].get(a).vertex,arr[list[n.vertex].get(a).vertex]));
				}
			}
		}
		return arr[last];
	}

}

class N1 implements Comparable<N1>{
	int vertex;
	int weight;
	
	public N1(int vertex,int weight) {
		this.vertex=vertex;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(N1 arg0) {
		// TODO Auto-generated method stub
		return this.weight <= arg0.weight ?-1: 1;
	}
	
}
