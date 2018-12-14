import java.util.*;

public class TreasureMove {

    static int x=0;
    static int y=0;
    public static void main(String[] args) {
        HashMap<String,String> f = new HashMap<>();
        f.put("F","F");
        f.put("R","R");
        f.put("L","L");
        f.put("B","B");
        HashMap<String,String> b = new HashMap<>();
        b.put("F","B");
        b.put("R","L");
        b.put("L","R");
        b.put("B","F");
        HashMap<String,String> l = new HashMap<>();
        l.put("F","L");
        l.put("R","F");
        l.put("L","B");
        l.put("B","R");
        HashMap<String,String> r = new HashMap<>();
        r.put("F","R");
        r.put("R","B");
        r.put("L","F");
        r.put("B","L");


        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int arr[][] = new int[num+1][num+1];
        char move[][] = new char[num+1][num+1];
        boolean check[][] = new boolean[num+1][num+1];
        for(boolean ex[] : check){
            Arrays.fill(ex,false);
        }

        for(int a=1;a<=num;a++){
            for(int b1=1;b1<=num;b1++){
                String str = sc.next();
                move[a][b1]=str.charAt(0);
                arr[a][b1]=Integer.parseInt(str.substring(1,str.length()));
            }
        }
        Stack<Tmove> stack = new Stack<>();
        check[1][1]=true;
        stack.add(new Tmove(1,1,"B"));


        while(!stack.isEmpty()) {
            Tmove t = stack.pop();
            boolean k = true;
            if (t.before.equals("B")) {
                char ch = move[t.y][t.x];
               k = m(move,t,b,check,arr,stack,"B");
            }else if (t.before.equals("L")) {
                char ch = move[t.y][t.x];
                 k = m(move,t,l,check,arr,stack,"L");
            }else if (t.before.equals("R")) {
                char ch = move[t.y][t.x];
                k = m(move,t,r,check,arr,stack,"R");
            }else{
                char ch = move[t.y][t.x];
                 k = m(move,t,f,check,arr,stack,"F");
            }
            if(!k){
                System.out.println((x-1)+" "+(y-1));
                break;
            }

        }
    }
    static boolean m(char move[][], Tmove t, HashMap<String,String> b,boolean check[][],int arr[][],Stack<Tmove> stack,String str){
        char m = move[t.y][t.x];
        if(b.get(String.valueOf(m)).equals("L")){
            x= t.x-arr[t.y][t.x];
            y= t.y;
            if(check[y][x]==true){
                return false;
            }else{
                check[y][x]=true;
            }
            stack.add(new Tmove(x,y,b.get(String.valueOf(m))));
        }else if(b.get(String.valueOf(m)).equals("R")){
            x= t.x+arr[t.y][t.x];
            y= t.y;
            if(check[y][x]==true){
                return false;
            }else{
                check[y][x]=true;
            }
            stack.add(new Tmove(x,y,b.get(String.valueOf(m))));
        }else if(b.get(String.valueOf(m)).equals("F")){
            x= t.x;
            y= t.y-arr[t.y][t.x];
            if(check[y][x]==true){
                return false;
            }else{
                check[y][x]=true;
            }
            stack.add(new Tmove(x,y,b.get(String.valueOf(m))));
        }else{
            x= t.x;
            y= t.y+arr[t.y][t.x];
            if(check[y][x]==true){
                return false;
            }else{
                check[y][x]=true;
            }
            stack.add(new Tmove(x,y,b.get(String.valueOf(m))));
        }
        return true;
    }

}
class Tmove{
    int x;
    int y;
    String before;

    public Tmove(int x, int y, String before){
        this.x=x;
        this.y=y;
        this.before=before;
    }
}




