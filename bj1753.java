package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj1753 {

	static List<Node>[] adj;
	static int[] dist;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int v = sc.nextInt();
		int start = sc.nextInt();
		
		adj=new ArrayList[m+1];
		dist=new int[m+1];
		
		for(int i=1;i<=m;i++){
			adj[i]=new ArrayList<Node>();
			dist[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<v;i++){ 
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			adj[a].add(new Node(b,c));
		}
		dist[start] =0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start,dist[start]));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int a=0;a<adj[n.point].size();a++) {
				if(dist[adj[n.point].get(a).point]>dist[n.point]+adj[n.point].get(a).number) {
					dist[adj[n.point].get(a).point]=dist[n.point]+adj[n.point].get(a).number;
					q.offer(new Node(adj[n.point].get(a).point,dist[adj[n.point].get(a).point]));
				}
			}
		}
		for(int a=1;a<=m;a++) {
			System.out.println(dist[a]==Integer.MAX_VALUE ? "INF"  : dist[a]);
		}
		
		
	}
}
class Node implements Comparable<Node>{
	int point;
	int number;
	
	public Node(int point, int number) {
		this.point = point;
		this.number=number;
	}

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return this.number <= arg0.number?-1: 1;
	}
	
	
}
