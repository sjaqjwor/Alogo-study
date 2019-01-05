public class Exam01 {

    public static void main(String[] args) {
        System.out.print(solution(10000000,9,13000000));
    }
    static int solution(int p, int m, int d) {


        double x=1.0;
        double k = x/100;
        int money=(int)(p*Math.pow(1+(x/100),m));
        while(money<=d){
            money=(int)(p*Math.pow(1+(x/100),m));
            x++;
        }
        return (int)x-1;
    }
}
