import java.util.LinkedList;
import java.util.Queue;

public class KakaoTest4 {

    public static void main(String[] args) {
        System.out.print(solution1(new int[]{1,1,1},3));
    }
    static int solution(int[] food_times, long k) {

        int length = food_times.length;
        if(food_times.length > k){
            return (int)k;
        }

        for(int a=0;a<length;a++){
            food_times[a]=food_times[a]-1;
        }
        k=k-food_times.length;
        int stage=0;
        for(int a=0;a<=k;a++){
            if(stage==length){
                stage=0;
            }
            if(food_times[stage]-1<0){
                stage = stage+1;
               while(true){
                   if(stage==length){
                       stage=0;
                   }
                   if(food_times[stage]-1>=0){
                       food_times[stage]=food_times[stage]-1;

                       stage++;
                       break;
                   }
                   stage++;
               }
            }else{
                food_times[stage]=food_times[stage]-1;
                stage++;
            }
        }

        return stage;
    }
    static int solution1(int[] food_times, long k) {
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int a=1;a<=food_times.length;a++){
            queue.add(a);
        }
        int num=0;
        long count=0;
        while (count<k){
            num = queue.poll();
            if(food_times[num-1]-1>0){
                queue.add(num);
                food_times[num-1]=food_times[num-1]-1;
                count++;
            }else if(food_times[num-1]-1==0){
                count ++;
            }

        }
        if(queue.isEmpty()){
            return -1;
        }
        num=queue.poll();
        return num;
    }
}
