import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class baminExam3 {

    public static void main(String[] args) {
        int a[] = new int[]{40,40,100,80,20};
        int b[] = new int[]{3,3,2,2,3};
        int m= 3;
        int x= 5;
        int y=200;
//        System.out.println(solution(m,x,y,a,b));
        a= new int[]{60,80,40};
        b=new int[]{2,3,5};
        m=5;
        x=2;
        y=200;
        System.out.println(solution(m,x,y,a,b));
    }
        static int solution(int m , int x, int y,int a[], int b[]){

            Queue<persopn> queue = new LinkedList<>();

            for(int k=0;k<a.length;k++){
                queue.add(new persopn(a[k],b[k]));
            }
            int stop=0;
            while (!queue.isEmpty()){
                int num = 0;
                int we = 0;
                Map<Integer,Integer> map = new HashMap<>();
                while(!queue.isEmpty()&& num+1<=x && we+queue.peek().w<=y){
                    num++;
                    we+=queue.peek().w;
                    map.merge(queue.peek().f,1,Integer::sum);
                    queue.poll();
                }
                stop+=map.entrySet().size();
                stop++;
            }
            return stop;
        }
    }

class persopn{
    int w;
    int f;


    public persopn(int w, int f){
        this.w=w;
        this.f=f;
    }
}
