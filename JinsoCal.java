import java.util.*;

public class JinsoCal {

    public static void main(String[] args) {
      Set<Integer> set = new HashSet<>();


    }
    static boolean solution(int[] arr) {
        boolean answer = true;
        Set<Integer> set = new HashSet<>();
        int num  = arr.length;
        Arrays.sort(arr);
        for(int a=num-1;a>=0;a--){
            if(arr[a]!=num){
                answer=false;
                break;
            }
            num--;
        }
        return answer;
    }
}
