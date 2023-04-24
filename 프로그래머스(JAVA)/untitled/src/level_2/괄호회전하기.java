package level_2;

import java.util.*;

public class 괄호회전하기 {
    public static void main(String[] args) {

        String s = "(";
        int answer = 0;

        //logic
        for (int i = 0 ; i < s.length(); i++) {

            char[] input_list = new char[s.length()];
            int list_num = s.length() - i;

            for (char c : s.toCharArray()) {

                if ( list_num >= s.length() ) {
                    list_num = 0;
                }

                input_list[list_num] = c;
                list_num++;

            }

            if ( is_true(input_list) ) {
                answer++;
            }
        }

        //output
        System.out.println(answer);
    }

    public static boolean is_true (char[] s)  {

        Stack<Character> stack = new Stack<>();

        if ( s.length % 2 != 0 ) return false;

        for ( char c : s ) {
            switch (c) {
                case '{': case '[': case '(':
                    stack.push(c);
                    break;
                case '}':
                    if ( stack.isEmpty() ) {
                        return false;
                    } else if ( stack.pop() == '{' )
                        break;
                    else
                        return false;
                case ')':
                    if ( stack.isEmpty() ) {
                        return false;
                    } else if ( stack.pop() == '(' )
                        break;
                    else
                        return false;
                case ']':
                    if ( stack.isEmpty() ) {
                        return false;
                    } else if ( stack.pop() == '[' )
                        break;
                    else
                        return false;
            }
        }

        return true;
    }
}