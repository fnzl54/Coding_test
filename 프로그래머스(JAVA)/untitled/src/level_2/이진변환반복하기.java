package level_2;

import java.util.*;

public class 이진변환반복하기 {
    public static void main(String[] args) {

        String s = "110010101001";

        //logic
        int count_num = 0;
        int total_num = 0;

        while (s.length() != 1) {

            StringBuilder sb = new StringBuilder();
            total_num++;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sb.append("1");
                } else {
                    count_num++;
                }
            }

            s = Integer.toBinaryString(sb.length());

        }

        int[] answer = {total_num, count_num};

        //output
        System.out.println(answer.toString());
    }
}
