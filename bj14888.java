package baeckjoon;

import java.util.Scanner;

public class bj14888 {

	static int max = -1000000000;
	static int min = 1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		int cal[] = new int[4];
		for (int a = 0; a < N; a++) {
			arr[a] = sc.nextInt();
		}
		for (int a = 0; a < 4; a++) {
			cal[a] = sc.nextInt();
		}
		action(cal[0],cal[1],cal[2],cal[3],N,0,arr[0],arr);
		System.out.println(max);
		System.out.println(min);
	}

	static void action(int plus, int minus, int mul, int nanu, int n, int index, int sum, int arr[]) {
		if (index == n - 1) {
			if (max < sum) {
				max = sum;
			}
			if (min > sum) {
				min = sum;
			}
		}
		if (plus > 0) {
			action(plus - 1, minus, mul, nanu, n, index + 1, sum + arr[index + 1], arr);
		}
		if (minus > 0) {
			action(plus, minus - 1, mul, nanu, n, index + 1, sum - arr[index + 1], arr);
		}
		if (mul > 0) {
			action(plus, minus, mul - 1, nanu, n, index + 1, sum * arr[index + 1], arr);
		}
		if (nanu > 0) {
			action(plus, minus, mul, nanu - 1, n, index + 1, sum / arr[index + 1], arr);
		}

	}
}
