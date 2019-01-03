public class MoneyCoin {
    static int countK=0;
    public static void main(String[] args) {
        int [] cointType = new int[]{1,2};

        System.out.println(count(cointType,1000));
    }
    static int count(int []coint , int money){
        int arr[] = new int[money+1];
        arr[0]=1;
        for(int i = 0; i < coint.length; i++)
        {
            for(int j = 1; j <= money; j++)
            {
                if(j - coint[i] >= 0){
                    arr[j] += arr[j - coint[i]];
                }
            }
        }
        return arr[money];
    }
}
