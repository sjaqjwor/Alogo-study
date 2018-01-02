package baeckjoon;

import java.util.*;

public class bj2206 {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int arr[][] = new int[1001][1001];
		boolean check[][][] = new boolean[1001][1001][2];
		Queue<Crash> queue = new LinkedList<>();
		int x[] = {0,-1,0,1};
		int y[] = { -1,0,1,0 };
		for(int i=0;i<=m;i++){
            String str = sc.next();
            System.out.println(str);
            char ch[]=str.toCharArray();
            for(int j=0;j<ch.length;j++){
                arr[i][j+1]=ch[j]-'0';
            }
		}
		
	
		int count = 0;
		queue.add(new Crash(0, 0, false));
		check[0][0][1] = true;
		check[0][0][0] = true;
		boolean success = false;
		while (!queue.isEmpty() && !success) {
			count++;
			for (int i = 0; i < queue.size(); i++) {
				Crash c = queue.poll();

				if (c.x == n-1 && c.y == m-1) {
					success = true;
					break;
				}
				for (int a = 0; a < 4; a++) {
					int x1 = c.x + x[a];
					int y1 = c.y + y[a];

					if (x1 >= n || y1 >= m || x1 < 0 || y1 < 0)
						continue;
					if (arr[x1][y1] == 1) {
						if (!check[x1][y1][1] && !c.check) {
							check[x1][y1][1] = true;
							queue.add(new Crash(x1, y1, true));
						}
					} else {
						if (!check[x1][y1][0]) {
							check[x1][y1][0] = true;
							queue.add(new Crash(x1, y1, c.check));
						}
					}
				}
			}
		}
		System.out.println(success ? count : -1);
	}
}

class Crash {
	int x;
	int y;
	boolean check;

	public Crash(int x, int y, boolean check) {
		this.x = x;
		this.y = y;
		this.check = check;
	}
}
