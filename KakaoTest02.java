import java.util.*;

public class KakaoTest02 {

    public static void main(String[] args) {
        solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
    static int[] solution(int N , int stages[]){
        Map<Integer , Integer> map = new HashMap<>();
        for(int stage : stages){
            if(map.containsKey(stage)){
                map.put(stage,map.get(stage)+1);
            }else{
                map.put(stage,1);
            }
        }
        int person = stages.length;

        List<Fail> list = new ArrayList<>();

        for(int a=1 ;a<=N;a++){
            if(map.containsKey(a)) {
                Fail f = new Fail(a, (double) map.get(a) / (double) person);
                list.add(f);
                person = person - map.get(a);
            }else{
                Fail f = new Fail(a, 0);
                list.add(f);
            }

        }
        list.forEach(s -> System.out.println(s.stage+" "+s.point));
        Collections.sort(list);
        System.out.println();
        list.forEach(s -> System.out.println(s.stage+" "+s.point));
        return null;
    }
}
class Fail implements Comparable<Fail>{
    int stage;
    double point;
    Fail(int stage, double point){
        this.stage=stage;
        this.point=point;
    }

    @Override
    public int compareTo(Fail o) {
        if(this.point>o.point){
            return -1;
        }else{
            return 1;
        }
    }
}
