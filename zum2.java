import java.util.*;

public class zum2 {
    public static void main(String[] args) {
        StringBuilder st = new StringBuilder();

        System.out.print(solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11"));
    }
    static String solution(String s){
        String potoArray [] = s.split("\n");

        List<Potos> list = new ArrayList<>();
        List<Potos> originList = new ArrayList<>();

        for(String poto : potoArray){
            String info[] = poto.split(",");
            list.add(new Potos(info[0],info[1],info[2]));
            originList.add(new Potos(info[0],info[1],info[2]));
        }

        Collections.sort(list);
        Map<String,List<String>> groupList = new HashMap<>();
        for(Potos p : list){
            if(!groupList.containsKey(p.city)){
                List<String> temp = new ArrayList<>();
                temp.add(p.date);
                groupList.put(p.city,temp);
            }else{
                List<String> temp = groupList.get(p.city);
                temp.add(p.date);
                groupList.put(p.city,temp);
            }
        }



        Map<String,Integer> map = new HashMap<>();

        for(Potos p : list){
            map.merge(p.city,1,Integer::sum);
        }


       String st="";
        for(Potos p : originList){
            String num = String.valueOf(groupList.get(p.city).indexOf(p.date)+1);
            String extention = p.name.substring(p.name.lastIndexOf("."),p.name.length());
            if(map.get(p.city)>=10){

                if(num.length()<2){
                    st+=p.city+"0"+num+extention+"\n";
                }else{
                    st+=p.city+num+extention+"\n";
                }
            }else{
                st+=p.city+num+extention+"\n";
            }
        }

        String answer = st.toString().substring(0,st.length()-1).replaceAll(" ","");
        return answer;
    }
}
class Potos implements Comparable<Potos>{
    String name;
    String city;
    String date;

    public Potos(String name,String city,String date){
        this.city=city;
        this.name=name;
        this.date=date;
    }

    @Override
    public int compareTo(Potos o) {
        if(this.date.compareTo(o.date)>0){
            return 1;
        }else if(this.date.compareTo(o.date)<0){
            return -1;
        }else{
            return 0;
        }
    }
}
