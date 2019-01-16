import java.util.Scanner;

public class SecretCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num  = sc.next();

        int dp[] = new int[num.length()+1];
        dp[0]=dp[1]=1;
        for(int a=2;a<=num.length();a++){
            if(num.charAt(a-1)>'0'){
                dp[a]=dp[a-1];
            }
            int n = (num.charAt(a-2) - '0') * 10 + (num.charAt(a-1) - '0');
             if (n >= 10 && n <= 26)
                dp[a] = (dp[a] + dp[a - 2]) % 1000000;
          }
          System.out.print(dp[num.length()] ==0 ? 0 :dp[num.length()]);
        }
    }

