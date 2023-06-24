package level_1;

import java.util.*;

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {

        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        //logic
        List<String> arr = new ArrayList<>();

        for (String s : strings) {
            arr.add(s.charAt(n) + s);
        }

        Collections.sort(arr);

        String[] answer = arr.stream().map( s -> s.substring(1, s.length())).toArray(String[]::new);

        System.out.println(Arrays.toString(answer));
        //output
        System.out.println(answer);
    }
}
