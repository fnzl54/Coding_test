package level_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String answer = "";

        String[] input_list = s.split(" ");
        int[] input_list_int = new int[input_list.length];

        for (int i = 0; i < input_list.length; i++) {
            input_list_int[i] = Integer.parseInt(input_list[i]);
        }

        Arrays.sort(input_list_int);

        answer = input_list_int[0] + " " + input_list_int[input_list_int.length - 1];

        System.out.println(answer);
    }
}
