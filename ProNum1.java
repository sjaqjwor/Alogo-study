public class ProNum1 {

    static int ans;
    public static void main(String[] args) {
        solution(33);
    }
    static int solution(int n) {
        int answer = 0;
        for(int a=3;a<=n;a++){
            boolean check=false;
            for(int b=2;b<a;b++){
                if(a%b==0){
                    check=true;
                    break;
                }
            }
            if(!check){

                num(a,n,a,1);
            }
        }
        System.out.println(ans);
        return answer;
    }
    static void num(int a, int n,int sum,int count){
       if(count==3 && sum==n){

            ans++;
            return;
        }else if(sum>n || count>=3){
            return;
        }else{
            for(int b=a+1;b<n;b++){
                boolean check=false;
                for(int c=2;c<b;c++){
                    if(b%c==0){
                        check=true;
                        break;
                    }
                }
                if(!check){
                    num(b,n,sum+=b,count+1);
                    sum-=b;
                }

            }
        }

    }


}
