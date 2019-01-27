import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WinterCoding2 {
    public static void main(String[] args) {
        System.out.println(solution("UD"));
    }
    static int solution(String dirs) {
        String temp[] = dirs.split("");
        int x=0;
        int y=0;

        Set<winter> set = new HashSet<>();
        for (String str : temp){
            winter w = new winter(0,0,x,y);
            if(str.equals("L")){
                x-=1;

            }else if(str.equals("R")){
                x+=1;

            }else if(str.equals("U")){
                y+=1;

            }else{
                y-=1;

            }

            if(x<-5){
                x+=1;
            }
            else if(y<-5){
                y+=1;
            }
            else if(x>5){
                x-=1;
            }else if(y>5){
                y-=1;
            }else{
                w.x=x;
                w.y=y;
                set.add(w);
            }


        }
        return set.size();
    }

}
class winter{
    int x;
    int y;
    int bx;
    int by;

    public winter(int x, int y,int bx,int by){
        this.x=x;
        this.y=y;
        this.bx=bx;
        this.by=by;
    }
    @Override
    public boolean equals(Object object){
        winter w = (winter)object;

       if(this.x==w.x && this.y==w.y){
           return true;
       }
       if(this.bx==w.x && this.by==w.y){
           return true;
       }
       if(this.bx==w.bx && this.by==w.by){
           return true;
       }
        if(this.bx==w.bx && this.by==w.by){
            return true;
        }

       return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y)+ Objects.hash(bx,by);
    }
}
