package baeckjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj11724 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int vertex = sc.nextInt();
		int line = sc.nextInt();

		List<Integer> list[] = new ArrayList[vertex + 1];

		for (int a = 0; a <= vertex; a++) {
			list[a] = new ArrayList<>();
		}
		boolean check[] = new boolean[vertex + 1];
		for (int a = 0; a < line; a++) {
			int v = sc.nextInt();
			int l = sc.nextInt();
			list[v].add(l);
			list[l].add(v);
		}
		Queue<Integer> q = new LinkedList<>();
		int count=0;
		for (int a = 1; a <= vertex; a++) {
			if (!check[a]) {
				count++;
				check[a]=true;
				q.add(a);
				while (!q.isEmpty()) {
					int p = q.poll();
					for (int b = 0; b < list[p].size(); b++) {
						if (!check[list[p].get(b)]) {
							check[list[p].get(b)] = true;
							q.add(list[p].get(b));
						}
					}
				}
			}
		}
		System.out.println(count);
	}

}
