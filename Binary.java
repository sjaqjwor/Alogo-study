public class Binary {

    public static void main(String[] args) {
        int k = 7;

        int num=0;
        while(true){
            if(k==0){
                break;
            }
            if(k%2==1){
                num++;
            }
            k=k/2;
        }
        System.out.print(num);
    }
}
