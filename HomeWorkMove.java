import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HomeWorkMove{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int a=1;a<=num;a++){
            int size = Integer.parseInt(br.readLine());

            int arr[][] = new int [size][size];
            int d[][] = new int[size][size];

            for(int t[] : d){
                Arrays.fill(t,Integer.MAX_VALUE);
            }

            for(int b=0;b<size;b++){
               String temp[] = br.readLine().split("");
               int index=0;
               for(String te : temp){
                   arr[b][index]=Integer.parseInt(te);
                   index++;
               }
            }

            int dx[]= new int[]{1,-1,0,0};
            int dy[]= new int[]{0,0,1,-1};

            Queue<MoveP> queue = new LinkedList<>();
            queue.add(new MoveP(0,0,0));
            d[0][0]=0;
            while(!queue.isEmpty()){
                int tx = queue.peek().x;
                int ty = queue.peek().y;
                int n = queue.poll().num;
                for(int c=0;c<4;c++) {
                    int tex = tx+dx[c];
                    int tey = ty+dy[c];
                    if (tex >= 0 && tey >= 0 && tex <= size - 1 && tey <= size - 1) {
                        int mn = n+arr[tey][tex];
                        if(mn<d[tey][tex]){
                            d[tey][tex]=mn;
                            queue.add(new MoveP(tex,tey,mn));
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(a).append(" ").append(d[size-1][size-1]);
            System.out.println(sb.toString());
        }
    }
}
class MoveP{
    int x;
    int y;
    int num;

    public MoveP(int x,int y,int num){
        this.x=x;
        this.num=num;
        this.y=y;
    }
}