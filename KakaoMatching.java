import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KakaoMatching {

    public static void main(String[] args) {


        solution("blind",new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"});
        solution("Muzi",new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"});
        solution("aba",new String[]{"<meta property=\"og:url\" content=\"https://a.com\"/>\n abaaaba aba"});
    }
    static int solution(String word, String[] pages) {
        word = word.toLowerCase();
        int arr[] = new int[pages.length];
        String url[] = new String[pages.length];
        Map<String,Double> Contentmap = new HashMap<>();
        Map<String,Double> Hrefmap = new HashMap<>();
        int start=0;
        for(String page : pages){
            double correct=0;
            String content=null;
            double href=0;
            String str[] = page.split("\n");

            for(int a=0;a<str.length;a++){
                int count=0;
                int index=0;
                String all = str[a].toLowerCase();
                int contentIndex=all.indexOf("<meta");

                if(contentIndex>-1){
                    contentIndex=all.indexOf("content");

                    content = all.substring(contentIndex+9,all.length()-3);


                }
                int hrefIndex=all.indexOf("href");
                if(hrefIndex>-1){
                    href++;
                }
                for(int b=0;b<all.length();){
                    if(word.charAt(index)== all.charAt(b)){
                        count=count+1;
                        index++;
                        b++;
                        if(count==word.length()){
                            correct++;
                            boolean check = true;
                            int countKo=0;

                            for(int c=b;c<all.length() && (all.charAt(c)>=97 && all.charAt(c)<=122) ;c++){
                                b=c;
                                check=false;
                            }
                            if(!check){
                                correct-=1;
                            }
                            index=0;
                            count=0;
                        }
                    }else{
                        b++;
                        count=0;
                        index=0;
                    }
                }
            }
            Contentmap.put(content,correct);
            Hrefmap.put(content,href);
            url[start]=content;
            start++;
        }
        start=0;
        Map<String,Double> an = new HashMap<>();
        for(String page : pages){
            String name = url[start];
            String str[] = page.split("\n");
            for(int a=0;a<str.length;a++){
                String all = str[a].toLowerCase();
                int hrefIndex=all.indexOf("href");
                if(hrefIndex>-1){
                    String href = all.substring(hrefIndex+6,all.indexOf(">")-1);
                    if(Contentmap.containsKey(href)){
                        double point =
                                (Contentmap.get(name)/
                                        Hrefmap.get(name));
                        if(an.containsKey(href)){
                            an.put(href,an.get(href)+point);
                        }else{
                            an.put(href,point);
                        }
                    }
                }
            }
            start++;
        }
        start=0;

        int answer = 0;
        double max = 0;
        for(int a=0;a<url.length;a++){
            double point = Optional.ofNullable(Contentmap.get(url[a])).orElse(0.0)+Optional.ofNullable(an.get(url[a])).orElse(0.0);
            if(max<point){
                max=point;
                answer=a;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
