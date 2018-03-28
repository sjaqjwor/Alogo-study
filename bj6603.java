package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj6603 {
	static int num = 0;
	static StringBuilder st = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		num=1;
		while (num!=0) {
			num=sc.nextInt();
			int arr[] = new int[num];
			int back[] = new int[num];
			for (int a = 0; a < num; a++) {
				arr[a] = sc.nextInt();
			}
			make(0, arr, back, 0);
			st.append("\n");
			System.out.println(st.toString());
			st=new StringBuilder();
			
		}

	}

	static void make(int a, int arr[], int back[], int count) {
		if (count == 6) {
			for(int b=0;b<6;b++) {
				st.append(back[b]+" ");
			}
			return;
		} else {
			for (int b = a; b < num; b++) {
				back[count] = arr[b];
				make(b + 1, arr, back, count + 1);
			}
		}
	}

}
