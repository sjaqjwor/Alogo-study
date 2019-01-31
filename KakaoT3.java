import java.util.LinkedList;
import java.util.Queue;

public class KakaoT3 {

    public static void main(String[] args) {
        solution(3,new int[]{4,2,2,5,3});
    }
    static int[] solution(int N , int[] coffee_times){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        q.add(0);
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            if(q.size()<N ){
                for(int a=0;a<coffee_times.length && q.size()<N;a++){
                    if(!q.contains(a) && coffee_times[a]>0){
                        q.add(a);
                    }
                }
            }
            if(q.size()<=N){
                while(!q.isEmpty()){
                    if(coffee_times[q.peek()]-N <=0 ){
                        coffee_times[q.peek()]-=N;
                        sb.append(q.poll()+1).append(" ");
                    }else{
                        coffee_times[q.peek()]-=N;
                        q1.add(q.poll());
                    }
                }
                q.addAll(q1);
                q1.clear();
            }
        }
        String temp[] = sb.toString().split(" ");
        int answer[]= new int[temp.length];
        int a=0;
        for(String str: temp){
            answer[a]=Integer.parseInt(str);
            a++;
        }
        for(int k : answer){
            System.out.println(k);
        }

        return answer;
    }
}
