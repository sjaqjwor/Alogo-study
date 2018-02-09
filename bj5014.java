package baeckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj5014 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int F, G, S, U, D;
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		int num[] = new int[1000000+1];
		boolean check[] = new boolean[1000000+1];
	
		if (S == G) {
			System.out.println(0);
		} else {
			check[S]=true;
			while (!q.isEmpty()) {
				int a = q.poll();
				if (a + U <= F && !check[a + U]) {
					q.add(a + U);
					check[a + U] = true;
					num[a + U] = num[a] + 1;
				}
				if (a - D > 0 && !check[a - D]) {
					q.add(a - D);
					check[a - D] = true;
					num[a - D] = num[a] + 1;
				}
			}

			System.out.println(num[G] == 0 ? "use the stairs" : num[G]);
		}
	}

}
