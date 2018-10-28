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

        HashSet<String> set = new HashSet<>();
        int x=0;
        int y=0;

        StringBuilder st = new StringBuilder();
        int count=0;
        st.append(0).append(0).append(" ");
        for(int a=0;a<dirs.length();a++){
            char move = dirs.charAt(a);

                if (move == 'U' && y < 5) {
                    y += 1;
                    st.append(x).append(y).append(" ");
                } else if (move == 'D' && y > -5) {
                    y -= 1;
                    st.append(x).append(y).append(" ");
                } else if (move == 'R' && x < 5) {
                    x += 1;
                    st.append(x).append(y).append(" ");
                } else if (move == 'L' && x > -5) {
                    x -= 1;
                    st.append(x).append(y).append(" ");
                }

        }
        String str[] = st.toString().split(" ");

        for(int a=0;a<str.length-1;a++){
            if(!set.contains(str[a]) || !set.contains(str[a+1])){
                count++;
                set.add(str[a]);
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
