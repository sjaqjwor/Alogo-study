import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MoveLength {
    public static void main(String[] args) {
        System.out.print(solution("LLRR"));
        System.out.println();
        System.out.print(solution("LULLLLLLU"));
    }

   static int solution(String dirs) {

        Map<MovePoint,Integer> setx = new HashMap<>();
        int x=0;
        int y=0;
        setx.put(new MovePoint(x,y),1);
        int count=0;
        for(int a=0;a<dirs.length();a++){
            char move = dirs.charAt(a);

                if (move == 'U' && y < 5) {
                    y += 1;
                    if(!setx.containsKey(new MovePoint(x,y))){
                        count++;
                    }
                    setx.put(new MovePoint(x,y),1);
                } else if (move == 'D' && y > -5) {
                    y -= 1;

                    if(!setx.containsKey(new MovePoint(x,y))){
                        count++;
                    }
                    setx.put(new MovePoint(x,y),1);
                } else if (move == 'R' && x < 5) {
                    x += 1;
                    if(!setx.containsKey(new MovePoint(x,y))){
                        count++;
                    }
                    setx.put(new MovePoint(x,y),1);
                } else if (move == 'L' && x > -5) {
                    x -= 1;
                    if(!setx.containsKey(new MovePoint(x,y))){
                        count++;
                    }
                    setx.put(new MovePoint(x,y),1);
                }



        }

        return count;
    }
}
class MovePoint{

    int tempx;
    int tempy;
    int x;
    int y;
    MovePoint(int x,int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public int hashCode() {
        return Integer.toString(x).hashCode()+Integer.toString(y).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o==null)
            return false;
        MovePoint temp=(MovePoint) o;
        if(temp.x==this.x && temp.y==this.y)
            return true;
        else
            return false;
    }
}
