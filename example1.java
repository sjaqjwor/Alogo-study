package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.List;

public class example1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine().trim());

			for (int i = 0; i < T; ++i) {
				String word = br.readLine().trim();
				List<String> list = new ArrayList<>();
				List<Integer> list1 = new ArrayList<>();
				char temp = word.charAt(0);
				int count = 1;
				for (int a = 1; a <word.length(); a++) {
					if (temp == word.charAt(a)) {
						count++;
					} else {
						list.add(String.valueOf(temp));
						list1.add(count);
						count = 1;
						temp = word.charAt(a);
					}
				}
				list.add(String.valueOf(temp));
				list1.add(count);
				for(int a=0;a<list.size();a++) {
					System.out.print(list1.get(a)+list.get(a));
				}
				System.out.println();
				list=new ArrayList<>();
				list1=new ArrayList<>();
				
				

			}

		}
	}
}

class choo {
	int size;
	int count;

	public choo(int size, int count) {
		this.size = size;
		this.count = count;
	}
}
