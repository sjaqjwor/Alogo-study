import java.util.HashSet;
import java.util.Set;

public class SearchMa1 {
    public static void main(String[] args) {
        System.out.print(solution(new int[]{3,3,3,2,2,2}));
    }
   static  int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        int num = nums.length/2;

        for(int n : nums){
            set.add(n);
        }
        answer = set.size()>num ? num : set.size();
        return answer;
    }
}
