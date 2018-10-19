import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;


public class SummerCoding2018Budget {

    public static void main(String[] args) {
        solution(new int[]{2,2,3,3},10);
    }

    static int solution(int[] d, int budget) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int k : d){
            list.add(k);
        }
        Collections.sort(list);
        for(int k : list){
            if(budget-k>=0){
                budget-=k;
                answer++;
            }
        }
        System.out.print(answer);
        return answer;
    }
}
