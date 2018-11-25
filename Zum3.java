import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Zum3 {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{2,5},new int[]{4,8}));
    }
    static  int solution(int[] A, int[] B) {
        List<Pin> list = new ArrayList<>();
       for(int a=0;a<A.length;a++){
           list.add(new Pin(A[a],B[a]));
       }
       Collections.sort(list);
       int count=0;

       for(int a=0;a<list.size();){
           int temp=0;
           for(int b=a+1;b<list.size();b++){
               if(list.get(a).y>=list.get(b).x){
                   temp=b;
               }
           }
           if(temp==0){
               a=a+1;
           }else{

               a=temp+1;
           }
           count++;
       }
       return count;
    }
}
class Pin implements Comparable<Pin>{
    int x;
    int y;

    public Pin(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Pin o) {
        if(this.x>o.x){
            return 1;
        }else if(this.x<o.x){
            return -1;
        }else{
            return 0;
        }
    }


}
