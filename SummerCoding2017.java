import java.util.*;

public class SummerCoding2017 {

    public static void main(String[] args) {
        solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3);
    }
    static int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<point>[] list= new ArrayList[N+1];
        Set<Integer> set = new HashSet<>();
        boolean check[] = new boolean[N+1];

        for(int a=0;a<=N;a++){
            list[a]=new ArrayList<>();
        }

        Queue<point> queue = new LinkedList<>();

        for(int a=0;a<road.length;a++){
                    list[road[a][0]].add(new point(road[a][1],road[a][2]));
                    list[road[a][1]].add(new point(road[a][0],road[a][2]));
        }

        for(int a=0;a<list[1].size();a++){
            queue.add(list[1].get(a));
        }



        if(!queue.isEmpty()){
            set.add(1);
        }

        while (!queue.isEmpty()){
            int temp = queue.peek().count;
            int index = queue.peek().x;
            queue.poll();
            if(temp<=K ){
              set.add(index);
            }
            for(int a=0;a<list[index].size();a++){
                if(temp+list[index].get(a).count<=K){
                    list[index].get(a).count+=temp;
                    queue.add(list[index].get(a));
                }
            }

        }
        return set.size();
    }
}
class point{
    int x;
    int count;
    public point(int x,int count){
        this.x=x;
        this.count=count;
    }
}
