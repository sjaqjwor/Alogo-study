public class SummerCodingsosu {

    public static void main(String[] args) {
        solution(new int[]{1,2,3,4});
    }
    static int solution(int[] nums) {
        int answer = 0;

        for(int a=0;a<nums.length;a++){
            for(int b=a+1;b<nums.length;b++){
                for(int c=b+1;c<nums.length;c++){
                    if(check(nums[a]+nums[b]+nums[c])){
                        answer++;
                    }
                }
            }
        }
        System.out.print(answer);
        return answer;
    }
    static boolean check(int k){
        for(int a=k-1;a>=2;a--){
            if(k%a==0){
                return false;
            }
        }
        return true;
    }
}
