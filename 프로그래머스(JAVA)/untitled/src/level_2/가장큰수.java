package level_2;

import java.util.*;

public class 가장큰수 {
    public static void main(String[] args) {

        int[] numbers = {6, 10, 2};
        //String answer = "";
        StringBuilder answer = new StringBuilder();
        //logic

        ArrayList<String> str_num = new ArrayList<>();

        for (int n : numbers) {
            str_num.add(String.valueOf(n));
        }

        str_num.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for (String s : str_num) {
            answer.append(s);
        }

        if (str_num.get(0).equals("0")) {
            answer.delete(0, answer.length());
            answer.append("0");
        }

        //output
        System.out.println(answer);
    }
}