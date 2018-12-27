public class StringWatch {

    public static void main(String[] args) {
        String str[] = new String[]{"a","b","c","d","e","f","g"};
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int a=0;a<str.length;a++){
            sb.append("\"[arr").append(",").append(str[a]).append("]\"");
            if(a!=str.length-1){
                sb.append(",");
            }
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}
