import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solider {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0}));
        System.out.println(solution(new int[]{4,2,0}));
        System.out.println(solution(new int[]{1000000000,1}));
    }
    static int solution(int[] ranks) {
        Set<Integer> set = new HashSet<>();

        for(int num : ranks){
            set.add(num);
        }

        int result =0;
        for(int num: ranks){
            if(set.contains(num+1)){
                result++;
            }
        }
        return result;
    }
}
