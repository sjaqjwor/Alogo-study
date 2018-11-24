import java.util.Scanner;

public class DivdeNum {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);


        int arr[] = new int [1];

        for(int a=0;a<arr.length;a++){
            arr[a]=sc.nextInt();
        }

        for(int k :arr) {
            if (k % 2 == 0) {
                System.out.print(k >> 1);
            } else {
                System.out.print(k - 1);
            }
            System.out.println();
        }


    }

}
