package baeckjoon;

import java.util.Scanner;

public class bj1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num <= 99) {
			System.out.println(num);
		} else {
			int count = 99;
			for (int a = 100; a <= num; a++) {
				int b = a / 100; // 백의자리
				int c = a%10;//일의자리
				int d = (a-(b*100)-c)/10;
				
				if ((d - b) == (c - d)) {
					count++;
				}
			}
			System.out.println(count);
		}

	}

}
