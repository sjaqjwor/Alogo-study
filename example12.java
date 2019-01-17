public class example12 {

    public static void main(String[] args) {
        System.out.print(re(10));
    }

    static int re(int n){
        if(n==1){
            return n;
        }
        return re(n-1)+n;
    }
}
