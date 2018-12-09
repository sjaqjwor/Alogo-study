public class TrafficMoney {

    public static void main(String[] args) {
        int arr[] = new int[]{11,128,15,111,59,31,70,102,50,172,88,56,40,41,40};

        int a=0;
        int money = 0;
        while(a<=arr.length-1 && arr[a]>=4 && arr[a]<=178 ){
            if(arr[a]<=40){
                money+=720;
            }else{
                int sum = arr[a]-40;
                money+=720;
                if(sum%8==0){
                    money+=(sum/8)*80;
                }else{
                    money+=((sum/8)+1)*80;
                }
            }
            a++;
        }
        System.out.println(20000-money);

    }
}
