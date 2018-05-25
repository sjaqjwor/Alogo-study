package baeckjoon;

import java.util.Arrays;

public class bamin3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = new int[] {3,3,4,4};
		System.out.println(solution(3,3,4,4));
		System.out.println(Math.abs(arr[0]=arr[2]));
	}
	 static int solution(int A, int B, int C, int D) {
	        // write your code in Java SE 8
		 int arr[] = new int[] {A,B,C,D};
		 Arrays.sort(arr);
		 return Math.abs(arr[0]=arr[2])+Math.abs(arr[1]=arr[3]);
	    }
}
