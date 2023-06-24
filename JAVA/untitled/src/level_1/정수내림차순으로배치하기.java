import java.util.*;

public class 정수내림차순으로배치하기 {
    public static void main(String[] args) {

        long n = 118372;
        long answer = 0;

        //logic
        String[] str = Long.toString(n).split("");
        Arrays.sort(str, Comparator.reverseOrder());

        String str_ans = "";

        for (String s : str) str_ans += s;

        answer = Long.parseLong(str_ans);

        //output
        System.out.println(answer);
    }
}