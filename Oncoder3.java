public class Oncoder3 {
    public static void main(String[] args) {
        System.out.println(solution("ab"));
    }
    static int solution(String str){
        String reverse = new StringBuilder(str).reverse().toString();
        int max = Integer.MAX_VALUE;
        int count=0;
        if(str.length()==1){
            return 1;
        }
        for(int a=0;a<reverse.length();){
            for(int b=0;b<reverse.length()&&a<reverse.length();b++){
                if(str.charAt(a)==reverse.charAt(b)){
                    a++;
                    ++count;
                }else{
                    if(count==0){
                        a++;
                    }
                    count=0;
                    break;
                }
                if(a==reverse.length()&& max>reverse.length()-count){
                    max=reverse.length()-count;
                }


            }
        }
        return reverse.length()+max;
    }
}
