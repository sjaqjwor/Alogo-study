import java.util.LinkedList;
import java.util.Queue;

public class ZigZag {

    public static void main(String[] args) {
        String k = "ab2v9bc13j5jf455";
//        String k = "10";
        k=k.replaceAll("[^0-9]"," ");
        System.out.println(k);
        String str[] = k.split(" ");

        Queue<Double> q = new LinkedList<>();
        for(int a=0;a<str.length;a++){
            if(str[a].length()>0) {
                q.add(Double.parseDouble(str[a]));
            }
        }

        if(q.isEmpty() || q.size()==1){
            System.out.println(0);
        }else{
            double start = q.poll();
            double answer = 0;
            while(!q.isEmpty()){

                answer+=Math.pow(q.poll(),start);
            }
            System.out.println(answer);

        }
    }
}
