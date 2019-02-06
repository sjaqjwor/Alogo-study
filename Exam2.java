public class Exam2 {

    public static void main(String[] args) {
        solution(5000);
    }
    static  String solution(int num) {
        String number[] = new String[]{"","일","이","삼","사","오","육","칠","팔","구"};
        String dan[] = new String[]{"","십","백","천","만"};

        int size = String.valueOf(num).length();
        String n =String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for(int a=size-1;a>=0;a--){
            if(a!=0 && Integer.parseInt(n.substring(size-a-1, size-a))>1) {
                sb.append(number[Integer.parseInt(n.substring(size - a - 1, size - a))]);
            }
            if(a==0 && Integer.parseInt(n.substring(size-a-1, size-a))>=1){
                sb.append(number[Integer.parseInt(n.substring(size - a - 1, size - a))]);
            }
            if(Integer.parseInt(n.substring(size-a-1, size-a))>0){
                sb.append(dan[a%5]);
            }

        }
        System.out.print(sb.toString());
        return sb.toString();
    }
}
