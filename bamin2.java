package baeckjoon;

public class bamin2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("A586QK","AJ653K"));
	}
	static int solution(String A, String B) {
        // write your code in Java SE 8
		int a=0;
		int count=0;
		String b[] = B.split("");
		String ar[] = A.split("");
		for(String k: ar) {
			if(k.equals("A")) {
				count++;
			}else if(k.compareTo(b[a])>0) {
				count++;
			}
			a++;
		}
		return count;
    }
}
