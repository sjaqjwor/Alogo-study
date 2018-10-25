import java.util.LinkedList;
import java.util.Queue;

public class ProgramingMaster {

    public static void main(String[] args) {
            solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}});
    }

    static int solution(int[][] maps) {
        Queue<PointNum> queue = new LinkedList<>();

        queue.add(new PointNum(0, 0, 1));
        boolean check[][] = new boolean[maps.length][maps.length];

        int dx[] = new int[]{1, -1, 0, 0};
        int dy[] = new int[]{0, 0, 1, -1};

        int an = -1;
        while (!queue.isEmpty()) {
            PointNum p  = queue.poll();
            if(p.x==maps.length-1 && p.y==maps.length-1){
                an= p.count;
                break;
            }
            for (int a = 0; a < 4; a++) {
                int tempx = p.x+dx[a];
                int tempy = p.y+dy[a];
                int count =p.count;

                if(tempx>=0 && tempx<maps.length && tempy>=0 && tempy<maps.length && maps[tempy][tempx]==1 && !check[tempy][tempx]){
                    queue.add(new PointNum(tempx,tempy,count+1));
                    check[tempy][tempx]=true;

                }


            }
        }
        System.out.print(an);
        return an;
    }
}
class PointNum{

    int x;
    int y;
    int count;

    public PointNum(int x, int y,int count){
        this.x=x;
        this.y=y;
        this.count=count;
    }
}
