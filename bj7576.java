package baeckjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj7576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int count = 0;
		int arr[][] = new int[y + 2][x + 2];
		boolean check[][] = new boolean[y + 2][x + 2];

		Stack<tomato> st = new Stack<>();
		Stack<tomato> st1 = new Stack<>();
		for (int a = 1; a <= y; a++) {
			for (int b = 1; b <= x; b++) {
				int number = sc.nextInt();
				arr[a][b] = number;
				if (number == 1) {
					st.push(new tomato(a, b));
					count++;
				}

			}
		}
		// for (int a = 1; a <= y; a++) {
		// for (int b = 1; b <= x; b++) {
		// System.out.print(arr[a][b]+" ");
		//
		// }
		// System.out.println();
		// }

		if (st.isEmpty() && arr[1][1] == 0) {
			System.out.println(-1);
		} else if (st.isEmpty() && arr[1][1] == -1) {
			System.out.println(0);
		} else if (count == x * y) {
			System.out.println(0);
		} else {
			count = 0;
			while (!st.empty()) {
				tomato t = st.pop();
				check[t.y][t.x] = true;

				if (t.x > 0 && t.y > 0 && t.x <= x && t.y <= y) {
					if ((arr[t.y][t.x + 1] != -1) && !check[t.y][t.x + 1]) {
						arr[t.y][t.x + 1] = 1;
						check[t.y][t.x + 1] = true;
						if (t.x + 1 <= x) {
							st1.push(new tomato(t.y, t.x + 1));
						}
					}
					if ((arr[t.y][t.x - 1] != -1) && !check[t.y][t.x - 1]) {
						arr[t.y][t.x - 1] = 1;
						check[t.y][t.x - 1] = true;
						if (t.x - 1 > 0) {
							st1.push(new tomato(t.y, t.x - 1));
						}
					}
					if ((arr[t.y + 1][t.x] != -1) && !check[t.y + 1][t.x]) {
						arr[t.y + 1][t.x] = 1;
						check[t.y + 1][t.x] = true;
						if (t.y + 1 <= y) {
							st1.push(new tomato(t.y + 1, t.x));
						}
					}
					if ((arr[t.y - 1][t.x] != -1) && !check[t.y - 1][t.x]) {
						arr[t.y - 1][t.x] = 1;
						check[t.y - 1][t.x] = true;
						if (t.y - 1 > 0) {
							st1.push(new tomato(t.y - 1, t.x));
						}
					}
				}
				if (st.empty() && !st1.isEmpty()) {
					while (!st1.isEmpty()) {
						st.push(st1.pop());
					}
					count++;
				}
			}
			int ch = 0;
			for (int a = 1; a <= y; a++) {
				for (int b = 1; b <= x; b++) {
					if (check[a][b] == false && arr[a][b] != -1) {
						ch = 1;
						break;
					}
				}
			}
			System.out.println(ch == 1 ? -1 : count);
		}
	}
}

class tomato {
	int x;
	int y;

	public tomato(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
