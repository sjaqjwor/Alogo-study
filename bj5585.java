package baeckjoon;

import java.util.Scanner;

public class bj5585 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[6];
		arr[0] = 500;
		arr[1] = 100;
		arr[2] = 50;
		arr[3] = 10;
		arr[4] = 5;
		arr[5] = 1;

		int sum = 0;
		n = 1000 - n;
		for (int a = 0; a < 6; a++) {
			sum += n / arr[a];
			n = n % arr[a];
			if (n == 0) {
				break;
			}
		}
		System.out.println(sum);
	}

}
