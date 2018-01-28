package baeckjoon;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class bj1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		PriorityQueue<Meeting> q = new PriorityQueue<>();
		Stack<Meeting> s = new Stack<Meeting>();
		for (int a = 0; a < num; a++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			q.offer(new Meeting(b, c));
		}
		int max = 1;
		Meeting m = q.poll();
		while(!q.isEmpty()) {
			Meeting m1 = q.poll();
			if(m.last<=m1.start) {
				m=m1;
				max++;
			}
		}
		System.out.println(max);

	}

}

class Meeting implements Comparable<Meeting> {

	int start;
	int last;

	public Meeting(int start, int last) {
		this.start = start;
		this.last = last;
	}

	@Override
	public int compareTo(Meeting m) {
		// TODO Auto-generated method stub
		if (this.last != m.last)
	         return this.last > m.last ? 1 : -1;
	      else {
	         return this.start > m.start ? 1 : -1;
	      }
	}

	public String toString() {
		return String.format("%d %d", start, last);
	}

}