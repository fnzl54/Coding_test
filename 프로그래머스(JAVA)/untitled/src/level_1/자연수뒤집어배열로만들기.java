package level_1;

import java.util.*;

public class 자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
        long n = 12345;

        List<Integer> list = new ArrayList<>();

        while(n != 0) {
            list.add((int)(n % 10));
            n /= 10;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        System.out.println(answer);
    }

}
