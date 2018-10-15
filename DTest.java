import java.lang.reflect.Array;
import java.util.*;

public class DTest {

    public static void main(String[] args) {
        int point[] = new int[]{2,2,1};
        List<s> list = new ArrayList<>();
        for(int a=0;a<point.length;a++){
          list.add(new s(a,point[a]));
        }
        Collections.sort(list);
        Queue<s> q = new LinkedList<>(list);

        int count =1;
        int an[] = new int[point.length];
        an[q.peek().num]=1;
        int po = q.peek().point;
        q.poll();
        int temp=1;

        while(!q.isEmpty()){
            int n = q.peek().num;
            int p = q.peek().point;
            q.poll();
            if(p==po){
                an[n]=count;
                temp++;
            }else{
                an[n]=count+temp;
                count=count+temp;
                po=p;
                temp=1;
            }
        }

        for(int k : an){
            System.out.print(k+" ");
        }


    }
}
class s  implements Comparable<s>{
    int num;
    int point;
    public s(int num,int x){
        this.num=num;
        this.point=x;
    }

    @Override
    public int compareTo(s o) {
        if (this.point > o.point) {
            return -1;
        } else if (this.point < o.point) {
            return 1;
        } else {
            return 0;
        }
    }
}
