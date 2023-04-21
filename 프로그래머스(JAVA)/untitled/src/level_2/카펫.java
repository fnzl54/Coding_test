package level_2;

import java.util.*;

public class 카펫 {
    public static void main(String[] args) {

        int brown = 24, yellow = 24;
        int[] answer = new int[2];

        //logic
        int temp_brown = (brown - 4) / 2;

        for (int i = temp_brown; i > 0; i--) {
            if (yellow % i == 0 && i + (yellow / i) == temp_brown) {
                answer[0] = i + 2;
                answer[1] = temp_brown - i + 2;
                break;
            }
        }

        //output
        System.out.println(Arrays.toString(answer));
    }
}