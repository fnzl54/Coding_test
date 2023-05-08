package level_1;

import java.util.*;

public class 하샤드수 {
    public static void main(String[] args) {

        int x = 10;
        boolean answer = true;

        //logic
        int sum = 0;
        int temp = x;

        while (temp >= 1) {
            sum += temp % 10;
            temp /= 10;
        }

        if (x % sum != 0) answer = false;


        //output
        System.out.println(answer);
    }
}