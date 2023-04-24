package level_1;

import java.util.*;

public class 서울에서김서방찾기 {
    public static void main(String[] args) {

        String[] seoul = {"Jane", "Kim"};
        String answer = "";

        //logic
        int res = 0;

        for (int i = 0; i < seoul.length; i++) {

            if (seoul[i].length() == 3 && seoul[i].equals("Kim")) {
                res = i;
                break;
            }

        }

        answer = "김서방은 " + res + "에 있다";
        //output
        System.out.println(answer);
    }
}