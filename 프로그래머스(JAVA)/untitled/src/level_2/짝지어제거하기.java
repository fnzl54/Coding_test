package level_2;

import java.util.*;

public class 짝지어제거하기 {
    public static void main(String[] args) {

        String s = "abbbabbb";
        int answer = -1;

        //logic

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);

        answer = stack.isEmpty() ? 1 : 0;


        //output
        System.out.println(answer);
    }
}
