package level_1;

import java.util.*;

public class 이상한문자만들기 {
    public static void main(String[] args) {

        String s = "try hello world";
        String answer = "";

        //logic
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += ' ';
                num = 0;
            } else {
                if (num % 2 == 0) {
                    answer += String.valueOf(s.charAt(i)).toUpperCase();
                    num++;
                } else {
                    answer += String.valueOf(s.charAt(i)).toLowerCase();
                    num++;
                }
            }
        }


        //output
        System.out.println(answer);
    }
}
