public class Oncoder1 {
    public static void main(String[] args) {
    System.out.println(solution(new String[]{"a","b","c","d","e","f","g","h"}));
        System.out.println(solution(new String[]{"0","1","2","3","4","5","6","7"}));
        System.out.println(solution(new String[]{"r","d","a","9","c","t","q","q"}));
    }
    static String solution(String inputs[]){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String str[] = new String[]{"arr1","arr2","arr3"};
        for(int a=0;a<inputs.length;a++){
            if(a!=inputs.length-1) {
                sb.append("\"[").append(str[a % 3]).append(",").append(inputs[a]).append("]\"").append(",");
            }else{
                sb.append("\"[").append(str[a % 3]).append(",").append(inputs[a]).append("]\"");
            }
        }
        sb.append("}");

        return sb.toString();
    }
}
