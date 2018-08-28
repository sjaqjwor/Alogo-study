package baeckjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class bj1026 {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int A[]  = new int[N];
		Integer B[]  = new Integer[N];
		for(int b=0;b<N;b++) {
			A[b]=sc.nextInt();
		}
		for(int b=0;b<N;b++) {
			B[b]=sc.nextInt();
		}
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		};
		Arrays.sort(A);
		Arrays.sort(B, c);;
		int sum = 0;
		for(int b=0;b<N;b++) {
			sum+=A[b]*B[b];
		}
		System.out.println(sum);
		
		
	}

}
