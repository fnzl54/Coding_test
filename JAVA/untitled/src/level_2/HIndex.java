package level_2;

import java.util.*;

public class HIndex {
    public static void main(String[] args) {

        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;

        //logic
        long count = 0;

        for (int i = citations.length; i > 0; i--) {
            int temp_num = i;

            count = Arrays.stream(citations).filter( n -> n >= temp_num).count();

            if (i <= count) {
                answer = i;
                break;
            }
        }


        //output
        System.out.println(answer);
    }
}