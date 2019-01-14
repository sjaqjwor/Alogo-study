public class StudyCoin {

    public static void main(String[] args) {
        System.out.print(coin(new int[]{1,5,10},100));
    }
    static int coin(int coins[] , int money){
        int d[] = new int[money+1];
        d[0]=1;
        for (int a = 0; a <coins.length; a++) {
            for (int b = 1; b <= money; b++) {
                if (b >= coins[a]) {
                    d[b] += d[b-coins[a]];
                }
            }
        }
        return d[money];
    }
}
