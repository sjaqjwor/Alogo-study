import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NhnPretest2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int arr[][]= new int[length][length];
        boolean check[][]= new boolean[length][length];
        int dx[] = new int[]{1,-1,0,0};
        int dy[] = new int[]{0,0,1,-1};
        int count=0;
        List<Integer> list = new ArrayList<>();

        for (int a = 0; a < length; a++) {
            String[] str = br.readLine().split(" ");
            for (int b = 0; b < length; b++) {
                arr[a][b] = Integer.parseInt(str[b]);
            }
        }
        Queue<Point> q = new LinkedList<>();
        for (int a = 0; a < length; a++) {
            for (int b = 0; b < length; b++) {
                if(arr[a][b]==1 && !check[a][b]) {
                    count++;
                    q.add(new Point(b,a));
                    check[a][b]=true;
                    while(!q.isEmpty()){
                        int x = q.peek().x;
                        int y = q.peek().y;
                        q.poll();
                        for(int c=0;c<4;c++){
                            int tempx = x+dx[c];
                            int tempy = y+dy[c];
                            if(tempx>=0 && tempy>=0 && tempx<length && tempy<length && arr[tempy][tempx]==1 && !check[tempy][tempx]){
                                count++;
                                q.add(new Point(tempx,tempy));
                                check[tempy][tempx]=true;
                            }
                        }
                    }
                    list.add(count);
                    count=0;
                }
            }
        }
        if(list.size()==0){
            System.out.println(0);
        }else{
            System.out.println(list.size());
            Collections.sort(list);
            list.forEach(s-> System.out.print(s+" "));
        }


    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
