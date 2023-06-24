package level_2;

import java.util.*;

public class 뉴스클러스터링 {
    public static void main(String[] args) {

        String str1 = "FRANCE", str2 = "french";
        int answer = 0;

        //logic
        List<String> str1_list = new ArrayList<>();
        List<String> str2_list = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0 ; i < str1.length() - 1 ; ++i) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if (first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z') {
                str1_list.add(first + "" + second);
            }
        }

        for (int i = 0 ; i < str2.length() - 1 ; ++i) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if (first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z') {
                str2_list.add(first + "" + second);
            }
        }

        Collections.sort(str1_list);
        Collections.sort(str2_list);

        for(String s : str1_list){
            if(str2_list.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : str2_list){
            union.add(s);
        }

        if(union.size() == 0) {
            answer = 1;
        } else {
            answer = (int) (((double)intersection.size() / (double)union.size()) * 65536);
        }

        //output
        System.out.println(answer);
    }
}