package baeckjoon;

public class bamin5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {6,1,4,6,3,2,7,4},6,1));
	}

	static int solution(int[] A, int K, int L) {
		// write your code in Java SE 8
		int acount = 0;
		int bcount = 0;
		int bebcount = 0;
		int max = 0;
		if (K + L > A.length) {
			return -1;
		} else {
			for (int a = 0; a <= A.length-K; a++) {
				for (int a1 = a; a1 <= a + (K - 1); a1++) {
					acount += A[a1];
				}
				for (int b = a + K; b <= A.length-L; b++) {
					for (int b1 = b; b1 <= b + (L - 1); b1++) {
						bcount += A[b1];
					}
					if (max < acount + bcount) {
						max = acount + bcount;
					}
					bcount=0;
				}
				for(int b2=0;b2<a && b2+(L-1)<a ;b2++) {
					for (int b3 = b2; b3 <= b2+ (L - 1); b3++) {
						bebcount += A[b3];
					}
					if(max<acount+bebcount) {
						max=acount+bebcount;
					}
					bebcount=0;
				}
				acount=0;
			}
		}
		return max;
	}
}
