package level_1;

import java.util.*;

public class 나누어떨러지는숫자배열 {
    public static void main(String[] args) {

        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        ArrayList<Integer> answer = new ArrayList<>();

        //logic
        for ( int n : arr ) {
            if (n % divisor == 0) answer.add(n);
        }

        if (answer.size() == 0) {
            answer.add(-1);
        }

        Collections.sort(answer);

        //output
        System.out.println(answer);
    }
}