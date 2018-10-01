import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersColoringBook {

    public static void main(String[] args) {
        int an[] =solution(6,4,new int[][]{{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}});
        System.out.println(an[0]);
        System.out.println(an[1]);
    }
    static int[] solution(int m, int n, int[][] picture){
        boolean check[][] = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int answer[] = new int[2];
        answer[0]=numberOfArea;
        answer[1]=maxSizeOfOneArea;

        for(int a=0;a<m;a++){
            for(int b=0;b<n;b++){
                if(picture[a][b]!=0 && !check[a][b]){
                    answer[0]+=1;
                    int count = bfs(picture,b,a,check,m,n);
                    if(answer[1]<count){
                        answer[1]=count;
                    }
                }
            }
        }
        return answer;
    }
    static int bfs(int [][]picture , int x,int y , boolean check[][],int m, int n){
        int dx[] = new int[]{1,-1,0,0};
        int dy[] = new int[]{0,0,1,-1};

        Queue<ColorPoint> queue = new LinkedList<>();
        queue.add(new ColorPoint(x,y,picture[y][x]));
        check[y][x]=true;
        int count =1;

        while(!queue.isEmpty()){
            int x1 = queue.peek().x;
            int y1 = queue.peek().y;
            int num = queue.peek().num;
            queue.poll();

            for(int a=0;a<4;a++){
                int tempx = x1+dx[a];
                int tempy = y1+dy[a];
                if(tempx>=0 && tempx<n
                        && tempy>=0
                        && tempy<m
                        && picture[tempy][tempx]==num
                        && !check[tempy][tempx]){
                    check[tempy][tempx]=true;
                    queue.add(new ColorPoint(tempx,tempy,num));
                    count++;
                }
            }
        }

        return count;
    }
}
class ColorPoint{
    int x;
    int y;
    int num;

    public ColorPoint(int x,int y,int num){
        this.x=x;
        this.y=y;
        this.num=num;
    }
}
