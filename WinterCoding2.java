import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WinterCoding2 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
    static int solution(String dirs) {
        String temp[] = dirs.split("");
        int x=0;
        int y=0;
        Set<winter> set = new HashSet<>();
        for (String str : temp){
            if(str.equals("L")){
                x-=1;
                if(x<-5){
                    x+=1;
                }
            }else if(str.equals("R")){
                x+=1;
                if(x>5){
                    x-=1;
                }
            }else if(str.equals("U")){
                y+=1;
                if(y>5){
                    y-=1;
                }
            }else{
                y-=1;
                if(y<-5){
                    y+=1;
                }
            }
            set.add(new winter(x,y));
        }
        return set.size();
    }

}
class winter{
    int x;
    int y;

    public winter(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public boolean equals(Object object){
        winter w = (winter)object;

       if(this.x==w.x && this.y==w.y){
           return true;
       }
       return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
