import java.util.Arrays;

public class Cookie {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{1,2,4,5}));
    }

    static int solution(int[] cookie) {
        Arrays.sort(cookie);
        int max=0;
        int min =0;
        boolean ch = true;
        for(int a=cookie.length-1;a>=0;a--){
            max+=cookie[a];
            for(int b=a-1;b>=0;b--){
                min+=cookie[b];
                if(max==min){
                    ch=false;
                    break;
                }
            }
            min=0;
            if(!ch){
                break;
            }
        }

        return !ch ? max : 0;
    }
}
