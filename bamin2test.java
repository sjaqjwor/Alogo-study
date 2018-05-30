package baeckjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bamin2test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			int d = s.nextInt();
			int k = s.nextInt();
			int j = s.nextInt();

			int arr[] = new int[n + 1];
			boolean check[] = new boolean[n + 1];
			if (d == 1) {
				int b = 1;
				int count = 0;
				while (count != (n - 1)) {
					int c = (b + k) % n;
					if (c == 0) {
						c++;
					}
					if (check[c] != true) {
						check[c] = true;
						count++;
						b = c;
					}
					k += j;
				}
				for (int a = 1; a <= n; a++) {
					if (check[a] == false) {
						System.out.println(a);
					}
				}

			} else {
				int b = n;
				int count = 0;
				while (count != (n - 1)) {
					int c = ((b + k) % n);
					if(c==0) {
						c=c+2;
					}else {
						c+=1;
					}
					if (check[c] != true) {
						check[c] = true;
						count++;
						b = c;
					}
				
					k += j;
				}
				for (int a = 1; a <= n; a++) {
					if (check[a] == false) {
						System.out.println(a);
					}
				}
			}
		}
	}
}
