package level_1;

import java.util.*;

public class 크기가작은부분문자열 {
    public static void main(String[] args) {

        String t = "10203";
        String p = "15";
        int answer = 0;

        //logic
        for (int i = 0; i <= t.length() - p.length(); i++) {
          if ( Long.parseLong(t.substring(i, i+p.length())) <= Long.parseLong(p)) answer++;
        }


        //output
        System.out.println(answer);
    }
}