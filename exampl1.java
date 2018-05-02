package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class exampl1 {
	static int count = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int sum=1;
		int result=0;
		int num=1;
		while(true) {
			if(sum==11) {
				break;
			}
			if(num %2==0 || num%3==0 || num%5==0) {
				sum=sum+1;
				result=num;
			}
			num++;
			
		}
		System.out.print(result);
				
	}
}

class Friend implements Comparable<Friend> {
	int x;
	int y;

	public Friend(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Friend f) {

		if (this.y < f.y) {

			return -1;

		} else if (this.y == f.y) {

			return 0;

		} else {

			return 1;

		}

	}

}
