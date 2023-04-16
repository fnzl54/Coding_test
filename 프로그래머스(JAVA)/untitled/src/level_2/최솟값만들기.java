package level_2;

import java.util.*;

public class 최솟값만들기 {
    public static void main(String[] args) {

        int []A = {1, 4, 2};
        int []B = {5, 4, 4};
        int answer = 0;

        //logic
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }


        //output
        System.out.println(answer);
    }
}