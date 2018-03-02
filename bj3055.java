package baeckjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj3055 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		Queue<Kosm> kq = new LinkedList<>();
		Queue<Water> wq = new LinkedList<>();
		int dx[] = new int[] { 1, -1, 0, 0 };
		int dy[] = new int[] { 0, 0, 1, -1 };
		char[][] arr = new char[y][x];
		boolean ch = false;
		boolean [][]check = new boolean[y][x];
		int lastx = 0;
		int lasty = 0;
		int result = Integer.MAX_VALUE;
		for (int a = 0; a < y; a++) {
			String s = sc.next();
			for (int a1 = 0; a1 < x; a1++) {
				if (s.charAt(a1) == 'S') {
					arr[a][a1] = s.charAt(a1);
					kq.add(new Kosm(a1, a, 0));
				}
				if (s.charAt(a1) == '*') {
					arr[a][a1] = s.charAt(a1);
					wq.add(new Water(a1, a));
				}
				if (s.charAt(a1) == 'D') {
					arr[a][a1] = s.charAt(a1);
					lastx = a1;
					lasty = a;
				} else {
					arr[a][a1] = s.charAt(a1);
				}
			}
		}
		while (!kq.isEmpty()&& !ch) {
			int wqsize = wq.size();
			for (int a1 = 0; a1 < wqsize; a1++) {
				Water w = wq.poll();
				for (int a = 0; a < 4; a++) {
					int wx = w.x + dx[a];
					int wy = w.y + dy[a];
					if (wx >= 0 && wy >= 0 && wx <= x - 1 && wy <= y - 1 && arr[wy][wx] == '.' ) {
						arr[wy][wx] = '*';
						wq.add(new Water(wx, wy));
					}
				}
			}
			int kqsize = kq.size();
			for (int a = 0; a < kqsize && !ch; a++) {
				Kosm k = kq.poll();
				for (int a1 = 0; a1 < 4; a1++) {
					int kx = k.x + dx[a1];
					int ky = k.y + dy[a1];
					if (kx >= 0 && ky >= 0 && kx <= x - 1 && ky <= y - 1 && (arr[ky][kx] == '.' ||arr[ky][kx]=='D')&& !check[ky][kx]) {
						if(ky==lasty && kx==lastx) {
							result=k.count+1;
							ch=true;
							break;
						}
						check[ky][kx]=true;
						kq.add(new Kosm(kx, ky, k.count + 1));
					}
				}
			}
		}
		System.out.println(result==Integer.MAX_VALUE ? "KAKTUS" : result);
	}
}

class Kosm {
	int x;
	int y;
	int count;

	public Kosm(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

class Water {
	int x;
	int y;

	public Water(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
