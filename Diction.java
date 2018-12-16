public class Diction {

    public static void main(String[] args) {
//        String str = "zabccbadd";
        String str = "zabcccbbbbaaaddd";


        int d[] = new int[str.length()];

        for(int a=0;a<str.length();a++){
            if(d[a]==0) d[a]=1;
            for(int b=0;b<a;b++){
                if(str.charAt(a)>=str.charAt(b)){
                    d[a]=Math.max(d[a],d[b]+1);
                }
            }
        }



        int max=0;
        for(int a=0;a<d.length;a++){
           if(max<d[a]){
               max=d[a];

           }
        }
        System.out.println(str.length()-max);
    }
}
