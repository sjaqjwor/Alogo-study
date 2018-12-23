import java.util.*;

public class rankGrade {
    public static void main(String[] args) {
//        int arr [] = new int[]{2,2,1};
        int arr [] = new int[]{3,2,1,2};

       int answer[] = new int[arr.length];
       Integer temp [] = new Integer[arr.length];
       for(int a=0;a<arr.length;a++){
           temp[a]=arr[a];
       }
       Arrays.sort(temp,Collections.reverseOrder());
       Map<Integer,Integer> map = new HashMap<>();
       map.put(temp[0],1);
       int r =2;

       for(int a=1;a<temp.length;a++){
           if(temp[a-1]==temp[a]){
               map.put(temp[a],map.get(temp[a-1]));
               r++;
           }else{
               map.put(temp[a],r);
               r++;
           }
       }

        for(int a=0;a<arr.length;a++){
            answer[a]=map.get(arr[a]);
        }
        for(int a=0;a<arr.length;a++){
            System.out.print(arr[a]+" ");
        }
        System.out.println();

        for(int a=0;a<arr.length;a++){
            System.out.print(answer[a]+" ");
        }


    }
}
