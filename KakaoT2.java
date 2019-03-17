import java.util.*;

public class KakaoT2 {

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"}));
    }

    static int solution(String[] moves){
        List<String> list = new ArrayList<>();

        int x=0;
        int y=0;
        for(int a=0;a<moves.length;a++){
            if(moves[a].equals("U")){
                y+=1;
            }else if(moves[a].equals("R")){
                x+=1;
            }else if(moves[a].equals("D")){
                y-=1;
            }else{
                x-=1;
            }

                list.add(x+" "+y);

        }
        list.add(x+" "+y);
        int answer=0;
        for(int a=0;a<list.size();){
            String str = list.remove(a);
            if(list.contains(str)){
                a++;
                answer++;
            }
        }
        if(answer%2==1){
            return answer;
        }
        return answer%2-1;



    }


}
class P{
    int x;
    int y;
    int num;
    public P(int x,int y,int num){
        this.x=x;
        this.y=y;
        this.num=num;
    }
}
