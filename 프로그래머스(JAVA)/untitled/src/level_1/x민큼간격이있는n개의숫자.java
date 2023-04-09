package level_1;

import java.util.*;

public class x민큼간격이있는n개의숫자 {
    public static void main(String[] args) {
        int x = -4;
        int n = 2;

        ArrayList<Long> answer = new ArrayList<>();

        long num = x;

        for(int i = 0; i < n; i++){
            answer.add(num);
            num += x;
        }

        System.out.println(answer);

    }
}
