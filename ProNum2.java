import java.util.Arrays;

public class ProNum2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3},new int[]{1,1}));
    }
    static int solution(int[] people, int[] tshirts) {
        Arrays.sort(people);
        Arrays.sort(tshirts);

        boolean check[] = new boolean[tshirts.length];
        int result=0;
        for(int a=0;a<people.length;a++){
            for(int b=0;b<tshirts.length;b++){
                if(people[a]<=tshirts[b] && !check[b]){
                    result++;
                    check[b]=true;
                    break;
                }
            }
        }
        return result;
    }
}
