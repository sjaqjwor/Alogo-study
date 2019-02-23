import java.util.*;

public class ProNum3 {

    public static void main(String[] args) {
        solution(new int[]{1,1,1},new int[][]{{100, 3000}, {150, 70}, {160, 80}});
    }
    static  int[] solution(int[] healths, int[][] items) {
        Arrays.sort(healths);
        List<Ite> list = new ArrayList<>();
        for(int a=0;a<items.length;a++) {
            list.add(new Ite(items[a][1],items[a][0],a+1));
        }

        Collections.sort(list);

        for(Ite ite : list){
            System.out.println(ite.health+" "+ite.attack);
        }
        StringBuilder sb = new StringBuilder();
        for(int a=healths.length-1;a>=0;a--){
            for(int b=list.size()-1;b>=0;b--){
                if(healths[a]-list.get(b).health>=100 ){
                    sb.append(list.get(b).num).append(" ");
                    list.remove(b);
                    break;
                }
            }
        }

        if(sb.toString().length()==0){
            int answer[]=new int[0];
            return answer;
        }else{
        String temp [] = sb.toString().split(" ");
        int answer[] = new int[temp.length];

        for(int b=0;b<temp.length;b++){
            answer[b]=Integer.parseInt(temp[b]);
            System.out.println(answer[b]);

        }
        Arrays.sort(answer);

        return answer;
        }
    }
}
class Ite implements Comparable<Ite> {
    int health;
    int attack;
    int num;

    public Ite(int health,int attack,int num){
        this.health=health;
        this.attack=attack;
        this.num=num;
    }


    @Override
    public int compareTo(Ite o) {
        if(this.health>o.health){
            return 1;
        }else if(this.health<o.health){
            return -1;
        }else if(this.health==o.health){
            if(this.attack>o.attack){
                return 1;
            }else if(this.attack<o.attack){
                return -1;
            }else {
                return 0;
            }
        }else{
            return 0;
        }
    }
}

