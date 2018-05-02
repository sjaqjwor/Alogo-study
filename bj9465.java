package baeckjoon;

import java.util.Optional;
import java.util.Scanner;

public class bj9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional.ofNullable("aasd").ifPresent(s->{System.out.println(s+" "+"asdasd");});
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int c = 0; c < count; c++) {
			int num = sc.nextInt();
			int arr[][] = new int[2][num + 1];
			int dist[][] = new int[2][num + 1];
			int dx[] = new int[] { 1, -1, 0, 0 };
			int dy[] = new int[] { 0, 0, 1, -1 };

			for (int a = 0; a <= 1; a++) {
				for (int a1 = 1; a1 <= num; a1++) {
					arr[a][a1] = sc.nextInt();
				}
			}

			dist[0][0] = dist[1][0] = 0;
			dist[0][1] = arr[0][1];
			dist[1][1] = arr[1][1];

			for (int a = 2; a <= num; a++) {
				dist[0][a] = Math.max(dist[1][a - 1], dist[1][a - 2]) + arr[0][a];
				dist[1][a] = Math.max(dist[0][a - 1], dist[0][a - 2]) + arr[1][a];
			}
			System.out.println(dist[0][num] > dist[1][num] ? dist[0][num] : dist[1][num]);

		}
	}

}
