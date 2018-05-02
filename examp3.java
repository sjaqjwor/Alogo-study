package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class examp3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	            final int T = Integer.parseInt(br.readLine().trim());

	            for (int i = 0; i < T; i ++) {
	                final StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
	                int N = Integer.parseInt(tokenizer.nextToken());
	                int K = Integer.parseInt(tokenizer.nextToken());
	                int M = Integer.parseInt(tokenizer.nextToken());
	                int count = co(N , M);
	                int count1 = co(N , K-M);
	                System.out.println(count*count1);
	            }
	        }

	}
	static int co(int n, int k) {
		if (k == n || k==0) return 1;
	    else if (k == 1) return n;
	    else return co(n - 1, k - 1) + co(n - 1, k);
	}

}
