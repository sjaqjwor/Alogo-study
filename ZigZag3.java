public class ZigZag3 {

    public static void main(String[] args) {
        String k="PM 01:00:00";
        solution(10,k);

        String k1="PM 11:59:59";
        solution(600,k1);

        String  k2="AM 12:10:00";

    }
    static String solution(int n , String k){

        String date = k.substring(3,k.length());

        String t = date.replaceAll(":","");
        int time = Integer.parseInt(t)+120000;
        t = String.valueOf(time);

        int second = Integer.parseInt(t.substring(4,t.length()));
        int m = Integer.parseInt(t.substring(2,t.length()-2));
        int h = Integer.parseInt(t.substring(0,t.length()-4));

        int count=0;
        for(int a=0;a<n;a++){
            second=second+1;
            if((second%60)==0){
                second=0;
                count++;
            }
        }

        String sec ="";

        if(second==0){
            sec="00";
        }else{
            String te = String.valueOf(second);
            if(te.length()<2){
                sec="0"+te;
            }else {
                sec=te;
            }
        }

        int ho=0;
        for(int a=1;a<=count;a++){
            m=m+1;
            if((m%60)==0){
                m=0;
                ho++;
            }
        }


        String mi = "";
        if(m==0){
            mi="00";
        }else{
            String te = String.valueOf(m);
            if(te.length()<2){
                mi="0"+te;
            }else {
                mi=te;
            }
        };

        for(int a=1;a<=ho;a++){
            h=h+1;
            if((h%24)==0){
                h=0;
            }
        }
        h=h%24;


        String h1 = "";
        if(h==0){
            h1="00";
        }else{
            h1=String.valueOf(h);
        }

        StringBuilder st = new StringBuilder();
        st.append(h1+":").append(mi+":").append(sec);
        System.out.println(st.toString());

        return null;
    }
}
