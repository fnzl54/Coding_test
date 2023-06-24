package level_2;

import java.util.*;

public class 의상 {
    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 1;

        //logic
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String s : hash.keySet()) {
            answer *= (hash.get(s) + 1);
        }

        answer--;


        //output
        System.out.println(answer);
    }
}