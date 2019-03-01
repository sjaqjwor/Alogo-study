import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Sw_4408 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int a=1;a<=test;a++){
            int num = Integer.parseInt(br.readLine());
            List<Room> list = new ArrayList<>();
            for(int b=1;b<=num;b++){
                String temp[] = br.readLine().split(" ");
                list.add(new Room(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])));
            }
            int an []= new int[401];

            for(int b=0;b<list.size();b++){
                int max = Math.max(list.get(b).s,list.get(b).st);
                int min = Math.min(list.get(b).s,list.get(b).st);
                for(int c=min;c<=max;c++){
                    an[c]++;
                }
            }

            int result=0;
            for(int b=0;b<an.length;b++){
                if(an[b]!=0 && an[b]>result){
                    result=an[b];
                }
            }
            System.out.println("#"+a+" "+result);
        }

    }
}
class Room {
    int s;
    int st;
    public Room(int s,int st){
        this.s=s;
        this.st=st;
    }

}
