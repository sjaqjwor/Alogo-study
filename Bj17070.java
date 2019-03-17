import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj17070 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String arr[][] = new String[num][num];

        for(int a=0;a<num;a++){
            arr[a]=br.readLine().split(" ");
        }
        Queue<Pipe> queue = new LinkedList<>();
        queue.add(new Pipe(1,0,"가로"));
        int an=0;

        while(!queue.isEmpty()){
            Pipe pipe = queue.poll();
            if(pipe.x==num-1 && pipe.y==num-1){
                an++;

                continue;
            }
            check(arr,pipe,queue,num);
        }
        System.out.println(an);

    }
    static void check(String arr[][],Pipe pipe,Queue<Pipe> queue,int size){
        if(pipe.move.equals("가로")) {
            if( pipe.x+1<size&&(arr[pipe.y][pipe.x+1].equals("0"))) {

                    queue.add(new Pipe(pipe.x + 1, pipe.y, "가로"));
            }
            if(pipe.y+1<size && pipe.x+1<size && arr[pipe.y+1][pipe.x+1].equals("0")) {
                if(arr[pipe.y+1][pipe.x].equals("0") && arr[pipe.y][pipe.x+1].equals("0")  ){

                        queue.add(new Pipe(pipe.x + 1, pipe.y + 1, "대각선"));

                }

            }
        }else if(pipe.move.equals("세로")){
            if(pipe.y+1<size && arr[pipe.y+1][pipe.x].equals("0")){

                    queue.add(new Pipe(pipe.x, pipe.y + 1, "세로"));

            }
            if(pipe.y+1<size&& pipe.x+1<size&& arr[pipe.y+1][pipe.x+1].equals("0")) {
                if(arr[pipe.y+1][pipe.x].equals("0") && arr[pipe.y][pipe.x+1].equals("0")  ){

                        queue.add(new Pipe(pipe.x + 1, pipe.y + 1, "대각선"));

                }

            }
        }else{
            if(pipe.x+1<size&& arr[pipe.y][pipe.x+1].equals("0"))  {

                    queue.add(new Pipe(pipe.x + 1, pipe.y, "가로"));

            }
            if(pipe.y+1<size &&  arr[pipe.y+1][pipe.x].equals("0")) {

                    queue.add(new Pipe(pipe.x, pipe.y + 1, "세로"));

            }
            if(pipe.y+1<size&& pipe.x+1<size && arr[pipe.y+1][pipe.x+1].equals("0")){
                if(arr[pipe.y+1][pipe.x].equals("0") && arr[pipe.y][pipe.x+1].equals("0")  ){

                        queue.add(new Pipe(pipe.x + 1, pipe.y + 1, "대각선"));

                }
            }
        }
    }
}
class Pipe{
    int x;
    int y;
    String move;

    public Pipe(int x, int y,String move){
        this.x=x;
        this.y=y;
        this.move=move;
    }
}
