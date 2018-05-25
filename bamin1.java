package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class bamin1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> st = new Stack();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		String arr[] = s.split(" ");
		int count = 0;
		for (String s1 : arr) {
			if (s1.equals("POP")) {
				if(st.empty()) {
					count=1;
					break;
				}
				st.pop();
			} else if (s1.equals("DUP")) {
				if(st.empty()) {
					count=1;
					break;
				}
				st.push(st.peek());
			} else if (s1.equals("+")) {
				if (!st.empty() && st.size() > 2) {
					st.push(String.valueOf((Integer.parseInt(st.pop()) + Integer.parseInt(st.pop()))));
				} else {
					count = 1;
					break;
				}
			} else if (s1.equals("-")) {
				if (!st.empty() && st.size() > 2) {
					st.push(String.valueOf((Integer.parseInt(st.pop()) - Integer.parseInt(st.pop()))));
				} else {
					count = 1;
					break;
				}
			}else {
				st.push(s1);
			}

		}
		System.out.println(count == 0 ? st.pop() : -1);
	}

}
