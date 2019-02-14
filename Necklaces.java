import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Necklaces {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1,0}));
          System.out.println(solution(new int[]{0}));
        System.out.println(solution(new int[]{5,4,0,3,1,6,2}));
    }
    static int solution(int[] A) {
        if(A.length==0){
            return 0;
        }

        List<Integer> arr[] = new List[A.length];

        for(int a=0;a<arr.length;a++){
            arr[a]=new ArrayList<Integer>();
        }
        for(int a=0;a<A.length;a++){
            arr[a].add(A[a]);
        }
        boolean check[] = new boolean[A.length];
        Queue<Integer> queue = new LinkedList<>();
        int max =0;
        for(int a=0;a<A.length;a++) {
            if (!check[a]) {
                int num=0;
                queue.add(a);
                while (!queue.isEmpty()) {

                    int nextBead =  arr[queue.poll()].get(0);
                    if(!check[nextBead]){
                        queue.add(nextBead);
                        check[nextBead]=true;
                        num++;
                    }
                }
                if(max<num){
                    max=num;
                }
            }
        }
        return max;
    }
}
