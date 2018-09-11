package baeckjoon;

import java.util.ArrayList;
import java.util.List;
public class kakaoNewsCluster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(solution("ab","bc"));
			System.out.println(getJarkad("ab","bc"));

	}
	 public static int solution(String str1, String str2) {
		 List<String> halist = new ArrayList<>();
	    List<String> list = new ArrayList<>();
	    List<String> kolist = new ArrayList<>();
	    str1 = str1.toUpperCase();
	    str2 = str2.toUpperCase();
	    for(int a=0;a<str1.length()-1;a++){
	        String k = str1.substring(a,a+2);
	        if(k.charAt(0)>='A' && k.charAt(0)<='Z'&&k.charAt(1)>='A' && k.charAt(1)<='Z'){
	            list.add(k);
	            halist.add(k);
	        }
	    }
	     for(int a=0;a<str2.length()-1;a++){
	        String k = str2.substring(a,a+2);
	        if(k.charAt(0)>='A' && k.charAt(0)<='Z'&&k.charAt(1)>='A' && k.charAt(1)<='Z'){
	            if(list.contains(k)){
	                list.remove(k);
	                kolist.add(k);
	            }else{
	                 halist.add(k);
	            }
	        }
	    }
	     double hap = halist.size();
	     double ko = kolist.size();
	     int answer=(int)((ko/hap)*(double)65536);
//	    System.out.println(hap);
//	    System.out.println(ko);
	     if(ko==0 || hap==0) {
	    	 return 65536;
	     }
	    return answer;
	  }
	 public static int getJarkad(String str1, String str2) {
	        ArrayList<String> list1 = new ArrayList<String>();
	        ArrayList<String> list2 = new ArrayList<String>();
	        
	        String tempStr = "";
	        // 문자열을 잘라서 다중 집합 만들기 str1=>arr1
	        for(int i = 0 ; i < str1.length()-1; i++) {
	            tempStr = str1.substring(i, i+2).toUpperCase();
	            if(tempStr.matches("^[A-Z]+$")) {
	                list1.add(tempStr);
	            }
	        }
	        
	        // 문자열을 잘라서 다중 집합 만들기 str1=>arr1
	        for(int i = 0 ; i < str2.length()-1; i++) {
	            tempStr = str2.substring(i, i+2).toUpperCase();
	            if(tempStr.matches("^[A-Z]+$")) {
	                list2.add(tempStr);
	            }
	        }
	        
	        ArrayList<String> unionList = getUnionList(list1, list2); // 합집합 만들기
	        ArrayList<String> intersectionList = getIntersectionList(list1, list2); // 교집합 만들기
	        
	        // return 교집합원소수/합집합원소수 * 65536
	        if(intersectionList.size()==0) return 65536;
	        else return (int) ((double) intersectionList.size() / (double) unionList.size() * (double) 65536);
	    }
	    
	    /**
	     * 중복허용 다중집합의 합집합 구하기
	     * @param list1
	     * @param list2
	     * @return
	     */
	    private static ArrayList<String> getUnionList(ArrayList<String> list1, ArrayList<String> list2) {
	        list1 = (ArrayList<String>) list1.clone();
	        list2 = (ArrayList<String>) list2.clone();
	        
	        ArrayList<String> unionList = new ArrayList<String>();
	        for(String str : list1) {
	            if(list2.contains(str)) {
	                list2.remove(str);
	            }
	            unionList.add(str);
	        }
	        unionList.addAll(list2);
	        return unionList;
	    }
	    
	    /**
	     * 중복허용 다중집합의 교집합 구하기
	     * @param list1
	     * @param list2
	     * @return
	     */
	    private static ArrayList<String> getIntersectionList(ArrayList<String> list1, ArrayList<String> list2) {
	        list1 = (ArrayList<String>) list1.clone();
	        list2 = (ArrayList<String>) list2.clone();
	        ArrayList<String> interList = new ArrayList<String>();
	        for(String str : list1) {
	            if(list2.contains(str)) {
	                interList.add(str);
	                list2.remove(str);
	            }
	        }
	        return interList;
	    }
}
