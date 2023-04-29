package level_2;

import java.util.*;

public class 전화번호목록 {
    public static void main(String[] args) {

        String[] phone_book= {"119", "97674223", "1195524421"};
        boolean answer = true;

        //logic
        Map<String, String> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, "prefix");
        }

        for (String s : phone_book) {
            for(int i = 1; i < s.length(); i++) {
                if(map.containsKey(s.substring(0, i))) {
                    answer =  false;
                    break;
                }
            }
        }

        //output
        System.out.println(answer);
    }
}