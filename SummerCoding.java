import java.util.ArrayDeque;
import java.util.Deque;

public class SummerCoding {

    public static void main(String[] args) {
            solution(11,new int[]{4,11},1);
    }

    static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int arr[] = new int[n+1];

        Deque<Integer> deque = new ArrayDeque<>();

        for(int k : stations){
            for(int a=k-w;a<=k+w;a++){
                if(a<0 || a>arr.length-1){
                    continue;
                }else{
                    arr[a]=1;
                }
            }
        }

        for(int a : arr){
            System.out.print(a+" ");
        }

        for(int a=1;a<=n;a++){
            if(arr[a]==0){
                deque.add(a);
            }
            if(a==n || arr[a]!=0){
                if(!deque.isEmpty()) {
                    int k = (deque.peekFirst() + deque.peekLast()) / 2;
                    for (int c = k - w; c <= k + w; c++) {
                        if (c < 0 || c > arr.length - 1) {
                            continue;
                        } else {
                            arr[c] = 1;
                        }
                    }
                    deque.clear();
                    a = k + w;
                    answer++;
                }
            }
        }
        System.out.println();
        for(int a : arr){
            System.out.print(a+" ");
        }

        System.out.println();
        System.out.print(answer);
        return answer;
    }
}
