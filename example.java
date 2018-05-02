package baeckjoon;

import java.util.Scanner;
import java.util.regex.Pattern;

public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean check =true;
		for(int a=0;a<num;a++) {
			String regex = sc.next();
			String str = sc.next();
			for(int b=0;b<regex.length();b++) {
				
				
			}
			System.out.println(check==false ? "X" : "O");
		
		}
	}
}
