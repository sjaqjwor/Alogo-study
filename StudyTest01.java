import java.util.Arrays;

public class StudyTest01 {

    public static void main(String[] args) {

        System.out.print(solution("qyyigoptvfb","abcdefghijk",3));
    }
    static String solution(String encr , String plain , int rotation){
        StringBuilder sb = new StringBuilder();
        boolean left = false;
        if(rotation<0){
            left=true;
            rotation=rotation*-1;
        }
        rotation=rotation%encr.length();

        String arr[] = new String[encr.length()];
        for(int a=0;a<encr.length();a++){
            int index=a;
            if(left){
                index=(a+rotation)%encr.length();
            }else{
                index=(encr.length()+(a-rotation))%encr.length();
            }
            int num = plain.charAt(index)-96;
            if(encr.charAt(a)-num<97){
                num=123-(97-(encr.charAt(a)-num));
            }else{
                num=encr.charAt(a)-num;
            }
            arr[index]=String.valueOf((char)num);
        }
        for(String str : arr){
            sb.append(str);
        }
        return sb.toString();
    }
}
