package level_1;

import java.util.*;

public class 가장가까운같은글자 {
    public static void main(String[] args) {

        String s = "foobar";
        int[] answer = new int[s.length()];

        //logic
        answer[0] = -1;
        char[] str_char = s.toCharArray();

        for (int i = 1; i <s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (str_char[i] == str_char[j]) {
                    answer[i] = i - j;
                    break;
                }
                answer[i] = -1;
            }
        }


        //output
        System.out.println(Arrays.toString(answer));
    }
}