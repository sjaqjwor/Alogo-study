package baeckjoon;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1202 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long j[][] = new long[n][2];
		long b[] = new long[m];

		for (int a = 0; a < n; a++) {
			
			long w = sc.nextInt();
			long c = sc.nextInt();
			j[a][0] = w;
			j[a][1] = c;
		}
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}

		Comparator<long[]> comp = new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return (int) (o1[0] - o2[0]);
			}
		};
		Arrays.sort(j, comp);
		Arrays.sort(b);
		PriorityQueue<Long> q = new PriorityQueue<>(1, Collections.reverseOrder());

		int start = 0;
		long min = 0;

		for (int a = 0; a < m; a++) {
			while (start < n && b[a] >= j[start][0]) {
				q.offer(j[start][1]);
				start++;
			}

			if (!q.isEmpty()) {
				min += q.poll();
			}
		}

		System.out.println(min);

	}

}
