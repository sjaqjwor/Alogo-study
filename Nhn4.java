import java.util.*;

public class Nhn4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        String arr[][] = new String[n][n];
        boolean check[][] = new boolean[n][n];
        int dx[] = new int[]{1,-1,0,0};
        int dy[] = new int[]{0,0,1,-1};
        Queue<Country> queue = new LinkedList<>();
        Queue<Country> temp = new LinkedList<>();



        for(int a=0;a<n;a++){
            for(int b=0;b<n;b++){
                String str = sc.next();
                if(str.matches("[A-Za-z]")){
                    queue.add(new Country(b,a,str));
                    check[a][b]=true;
                }
                arr[a][b]=str;
            }
        }
        int count=0;
        while (!queue.isEmpty()){
            Country country = queue.poll();
            for(int a=0;a<4;a++){
                int tempx = country.x+dx[a];
                int tempy = country.y+dy[a];
                if( tempx >=0 && tempx<n && tempy >=0 && tempy<n &&
                        arr[tempy][tempx].matches("[^a-zA-Z]{1,2}")
                       ){
                            if(checkWall(tempx,tempy,arr,country.x,country.y)) {
                                String k = check(arr, tempx, tempy);
                                arr[tempy][tempx] = k;

                                if (!k.equals("0")) {
                                    temp.add(new Country(tempx, tempy, k));
                                }
                            }
                }
            }
            if(queue.isEmpty()){
                for(int a=0;a<n;a++){
                    for(int b=0;b<n;b++){
                        System.out.print(arr[a][b]+" ");
                    }
                    System.out.println();
                }
                System.out.println();
                count++;
                queue.addAll(temp);
                temp.clear();
            }
        }

        System.out.print(count-1);
        System.out.println();
        for(int a=0;a<n;a++){
            for(int b=0;b<n;b++){
                System.out.print(arr[a][b]+" ");
            }
            System.out.println();
        }


    }
    static String check(String [][] str,int x, int y){
        Map<String , Integer> map = new HashMap<>();

        int dx[] = new int[]{0,0,-1,1};
        int dy[] = new int[]{1,-1,0,0};

        for(int a=0;a<4;a++){
            int tempx = dx[a]+x;
            int tempy = dy[a]+y;

            if(tempx>=0 && tempx < str.length && tempy>=0 && tempy < str.length && str[tempy][tempx].matches("[a-zA-z]{1,2}")){
                if(checkWall(x,y,str,tempx,tempy)){
                    map.merge(str[tempy][tempx],1,Integer::sum);
                }

            }
        }
        int max=0;
        String an = null;
        for(Map.Entry<String,Integer> e : map.entrySet()){
            if(e.getValue()>max){
                max=e.getValue();
                an=e.getKey();
            }
        };
        int count = 0 ;
        for(Map.Entry<String,Integer> e : map.entrySet()){
            if(e.getValue()==max){
                count++;
            }
        };
        if(count>1){
            return str[y][x];
        }else{
            return an;
        }

    }
    static boolean checkWall(int x, int y, String str[][],int tempx,int tempy){
        if(str[y][x].equals("0")){
            return true;
        }
        else if(str[y][x].equals("1")){
            if(y-1==tempy){
                return false;
            }else {
                return true;
            }
        }else if(str[y][x].equals("2")){
            if(y+1==tempy){
                return false;
            }else {
                return true;
            }
        }else if(str[y][x].equals("3")){
            if((y-1==tempy)||(y+1==tempy)){
                return false;
            }else {
                return true;
            }
        }else if(str[y][x].equals("4")){
                if(x-1==tempx){
                    return false;
                }else{
                    return true;
                }
        }else if(str[y][x].equals("5")){
            if(x-1==tempx || y-1==tempy){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("6")){
            if(x-1==tempx || y+1==tempy){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("7")){
            if(x-1==tempx || y-1==tempy|| y+1==tempy){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("8")){
            if(x+1==tempx){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("9")){
            if(x+1==tempx || y-1==tempy){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("10")){
            if(x+1==tempx || y+1==tempy){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("11")){
            if(x+1==tempx || y+1==tempy|| y-1==tempy){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("12")){
            if(x-1==tempx || x+1==tempy){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("13")){

            if(x+1==tempx || y-1==tempy|| x-1==tempy){
                return false;
            }else{
                return true;
            }
        }else if(str[y][x].equals("14")){

            if(x+1==tempx || y+1==tempy|| x-1==tempy){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}


class Country{
    int x;
    int y;
    String name;

    public Country(int x, int y, String name){
        this.x=x;
        this.y=y;
        this.name=name;
    }
}
