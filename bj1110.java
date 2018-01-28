package baeckjoon;

import java.util.Scanner;

public class bj1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count=0;
		int a1=a;
		while(a1!=a || count==0) {
			int k = a1/10;
			int k1 = a1%10;
			a1=(k1*10)+((k+k1)%10);
			count++;
		}
		System.out.println(count);
	}
	

}
