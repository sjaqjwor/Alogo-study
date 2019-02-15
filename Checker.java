import java.util.LinkedList;
import java.util.Queue;

public class Checker {


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"..X...","......","....X.",".X....","..X.X.","...O.."}));
        System.out.println(solution(new String[]{"X....",".X...","..O..","...X.","....."}));
        System.out.println(solution(new String[]{"..X",".X.","O.."}));
        System.out.println(solution(new String[]{"...","..X",".O."}));
        System.out.println(solution(new String[]{"...",".X.",".O."}));
        System.out.println(solution(new String[]{"O..",".X.","..."}));
    }

    static int solution(String[] B) {
        // write your code in Java SE 8

        int size = B.length;

        String arr[][] = new String [size][size];
        Queue<CheckerPoint> queue = new LinkedList<>();
        for(int a=0;a<size;a++){
            String temp[] = B[a].split("");
            arr[a]=temp;
            for(int b=0;b<temp.length;b++){
                if(temp[b].equals("O")){
                    queue.add(new CheckerPoint(b,a,0));
                    break;
                }
            }
        }


        int max=0;
        while (!queue.isEmpty()){
            CheckerPoint c = queue.poll();
            int leftx = c.x-1;
            int lefty = c.y-1;
            int rightx = c.x+1;
            int righty = c.y-1;
            int turn = c.turn;
            if(max<turn){
                max=turn;
            }
            if((leftx>=0 && leftx<size && lefty >=0) && arr[lefty][leftx].equals("X")){
                leftx=leftx-1;
                lefty=lefty-1;
                if((leftx>=0 && leftx<size && lefty >=0)&& !arr[lefty][leftx].equals("X")){
                    queue.add(new CheckerPoint(leftx,lefty,turn+1));
                }
            }
            if((rightx>=0 && rightx<size && righty >=0) && arr[righty][rightx].equals("X")){
                rightx+=1;
                righty-=1;
                if((rightx>=0 && rightx<size && righty >=0) && !arr[righty][rightx].equals("X")){
                    queue.add(new CheckerPoint(rightx,righty,turn+1));
                }
            }
        }
        return max;
    }
}
class CheckerPoint{
    int x;
    int y;
    int turn;

    public CheckerPoint(int x, int y,int turn){
        this.x=x;
        this.y=y;
        this.turn=turn;
    }
}
