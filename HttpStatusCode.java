import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpStatusCode {


    public static void main(String[] args) {
        String arr [] = new String[]{"POST /users/CONY", "POST /users/BROWN", "POST /users/CONY/data value=WHERE IS SALLY"
        ,"GET /users/CONY/DATA","GET /users/BROWN/data","GET /users/EDWARD/data","GET /abc","GET /users/CONY"};

        String postRegex = "POST /users/([\\D]*)|POST /users/([\\D]*)/data value=([\\D]*)";
        Pattern post = Pattern.compile(postRegex);
        Pattern get = Pattern.compile("GET /users/([\\D]*)/data");
        Set<String> user = new HashSet<>();
        Map<String,String> data = new HashMap<>();

        for(String str : arr){
            Matcher p = post.matcher(str);
            Matcher g = get.matcher(str);

            if(!p.matches() && !g.matches()){
                System.out.println("404 Not Found");
            }
            if(p.matches()){
                String code[] = p.group(1).split("/");
                if(code.length==1){
                    if(user.contains(code[0])){
                        System.out.println("403 FORBIDDEN");
                    }else{
                        user.add(code[0]);
                        System.out.println("201 Created");
                    }
                }else{
                    if(!user.contains(code[0])){
                        System.out.println("403 FORBIDDEN");
                    }else {
                        data.put(code[0], code[1].substring(11, code[1].length()));
                        System.out.println("200 OK");
                    }
                }
            }else if(g.matches()){
                String code = g.group(1);
                if(!user.contains(code)){
                    System.out.println("403 FORBIDDEN");
                }else if(!Optional.ofNullable(data.get(code)).isPresent()){
                    System.out.println("404 NOT FOUND");
                }else{
                    System.out.println("200 OK "+data.get(code));
                }
            }
        }

        System.out.println();
         user = new HashSet<>();
         data = new HashMap<>();

        for(String status : arr){
            if(status.contains("/users/")){
                String info[] = status.split("/");
                if(info[0].trim().equals("GET")){
                    if(info.length==3){
                        System.out.println("405 Method_Not_Allow");
                    }
                    else if(!user.contains(info[2])){
                        System.out.println("403 FORBIDDEN");
                    }else if(!Optional.ofNullable(data.get(info[2])).isPresent()){
                        System.out.println("404 NOT FOUND");
                    }else{
                        System.out.println("200 OK "+data.get(info[2]));
                    }
                }else{
                    if(info.length==4){
                        if(!status.contains("data value=")) {
                            System.out.println("405 Method_Not_Allow");
                        }
                        else if(!user.contains(info[2])){
                            System.out.println("403 FORBIDDEN");
                        }else {
                                data.put(info[2], info[3].substring(11, info[3].length()));
                                System.out.println("200 OK");
                            }
                    }else{
                        if(user.contains(info[2])){
                            System.out.println("403 FORBIDDEN");
                        }else{
                            user.add(info[2]);
                            System.out.println("201 Created");
                        }
                    }
                }
            }else{
                System.out.println("404 Not Found");
            }
        }

    }

}
