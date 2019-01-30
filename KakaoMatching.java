import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KakaoMatching {

    public static void main(String[] args) {

        Solution s = new Solution();

        s.solution("blind",new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"});
//        solution1("Muzi",new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"});
//        solution1("aba",new String[]{"<meta property=\"og:url\" content=\"https://aba.com\"/>\n abaaaba aba"});

    }
    static int solution(String word, String[] pages) {
        word = word.toLowerCase();
//        int arr[] = new int[pages.length];
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

    static int solution1(String word, String[] pages){

        Pattern url = Pattern.compile("<meta property=\\\"og:url\\\" content=\\\"https://(.+?)\\\"/>");
        Pattern ahre = Pattern.compile("<a href=[\"']?([^>\"']+)[\"']?[^>]*>");

        int arr[] = new int[pages.length];
        String urlName[] = new String[pages.length];
        Map<String,Double> Contentmap = new HashMap<>();
        Map<String,Double> Hrefmap = new HashMap<>();
        int start=0;

        word=word.toLowerCase();
        for(String str : pages){
            double correct=0;
            int count=0;
            int index=0;
            String name = null;
            str=str.toLowerCase();
            Matcher urlm = url.matcher(str);

            while(urlm.find()) {
                name = urlm.group(1);
            }

            Matcher ahrefm = ahre.matcher(str);
            double href=0;
            while(ahrefm.find()) {
                href++;
            }
            for(int b=0;b<str.length();){
                    if(word.charAt(index)== str.charAt(b)){
                        count=count+1;
                        index++;
                        b++;
                        if(count==word.length()){
                            correct++;
                            boolean check = true;

                            for(int c=b;c<str.length() && (str.charAt(c)>=97 && str.charAt(c)<=122) ;c++){
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
                        if(index==0){
                            b++;
                        }else{
                            b=+index;
                        }

                        count=0;
                        index=0;
                    }
                }

            Contentmap.put(name,correct);
            Hrefmap.put(name,href);
            urlName[start]=name;
            start++;
        }
        start=0;
        Map<String,Double> an = new HashMap<>();
        for(String page : pages){
            String name = urlName[start];

                String all = page.toLowerCase();
                Matcher ahrefm = ahre.matcher(all);
                while(ahrefm.find()) {
                    String href= ahrefm.group(1);

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
            start++;
        }
        for(Map.Entry k : Contentmap.entrySet()){
            System.out.println(k.getKey()+ " "+k.getValue());
        }

        int answer = 0;
        double max = 0;
        for(int a=0;a<urlName.length;a++){
            double point = Optional.ofNullable(Contentmap.get(urlName[a])).orElse(0.0)+Optional.ofNullable(an.get(urlName[a])).orElse(0.0);
            if(max<point){
                max=point;
                answer=a;
            }
        }
        System.out.println(answer);

        return 0;
    }
}

class Solution {
    private static final Pattern URL_PATTERN = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
    private static final Pattern EXTERNAL_LINKS_PATTERN = Pattern.compile("<a href=\"https://(.+?)\">");

    private HashMap<String, Page> pageMap = new HashMap<>();

    private class Page {
        private HashSet<String> hadExternalLinks = new HashSet<>();
        private HashSet<String> externalLinks = new HashSet<>();
        private String html;
        private String word;
        private String url;
        private int defaultScore = 0;

        public int id;


        public Page(String word, String html, int id) {
            this.html = html;
            this.word = word;
            this.id = id;

            initUrl();
            initDefaultScore();
        }

        private void initUrl() {
            Matcher matcher = URL_PATTERN.matcher(html);

            while(matcher.find()) {
                url = matcher.group(1);
            }
        }

        private void initDefaultScore() {
            int find = html.indexOf(word);

            while(find != -1) {
                Character[] wordBorder = {
                        html.charAt(find - 1),
                        html.charAt(find + word.length())
                };

                if(Arrays.stream(wordBorder).anyMatch(ch -> ch.charValue() >= 'a' && ch.charValue() <= 'z') == false) {
                    defaultScore++;
                }

                find = html.indexOf(word, find + 1);
            }
        }

        public double getTotalScore() {
            double total = defaultScore;

            for (String link : externalLinks) {

                if(pageMap.containsKey(link)) {
                    Page externalPage = pageMap.get(link);

                    if(externalPage.hadExternalLinks.size() > 0) {
                        total += (double) externalPage.defaultScore / externalPage.hadExternalLinks.size();
                    }
                }
            }

            return total;
        }

        public void initExternalLinks() {
            Matcher matcher = EXTERNAL_LINKS_PATTERN.matcher(html);

            while(matcher.find()) {
                String link = matcher.group(1);

                if(hadExternalLinks.contains(link) == false) {
                    hadExternalLinks.add(link);
                }

                if(pageMap.containsKey(link)) {
                    pageMap.get(link).externalLinks.add(url);
                }
            }
        }

    }

    public int solution(String word, String[] pages) {
        int id = 0;

        for (String html : pages) {
            Page page = new Page(word.toLowerCase(), html.toLowerCase(), id);

            pageMap.put(page.url, page);
            id++;
        }

        for (Page page : pageMap.values()) {
            page.initExternalLinks();
        }

        return pageMap.values().stream().max((a, b) -> Double.compare(a.getTotalScore(), b.getTotalScore())).get().id;
    }

}

