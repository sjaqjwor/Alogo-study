import java.util.*;

public class Sw_6730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int a=0;a<num;a++){
            StringBuilder sb = new StringBuilder();
            int size = sc.nextInt();

            int arr[] = new int[size];

            for(int b=0;b<size;b++){
                arr[b]=sc.nextInt();
            }
            List<Integer> list = new ArrayList<>();
            List<Integer> minlist = new ArrayList<>();
            for(int b=0;b<size-1;b++){
                if(arr[b]-arr[b+1]>=0){
                    minlist.add(arr[b]-arr[b+1]);
                }else{
                    list.add(arr[b+1]-arr[b]);
                }
            }

            Collections.sort(list);
            Collections.sort(minlist);
            int max = list.size() ==0 ? 0 : list.get(list.size()-1);
            int min = minlist.size() ==0 ? 0 : minlist.get(minlist.size()-1);
            sb.append("#").append(a+1).append(" ")
                    .append(max).append(" ")
                    .append(min);
            System.out.println(sb.toString());


        }
    }
}
