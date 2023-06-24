package level_1;

import java.util.*;

public class 푸드파이트대회 {
    public static void main(String[] args) {

        int[] food = {1, 3, 4, 6};
        String answer = "";

        //logic
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int count_food = food[i] / 2;

            for (int c = 0; c < count_food; c++) {
                sb.append(i);
            }
        }

        answer = sb + "0";
        answer += sb.reverse();

        //output
        System.out.println(answer);
    }
}