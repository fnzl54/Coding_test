package level_2;

public class JadenCase문자열만들기 {
    public static void main(String[] args) {
        
        String answer = "";
        String s = "3people unFollowed me";

        //logic
        s = s.toLowerCase();
        String[] input_list = s.split(" ");

        for (int i = 0; i < input_list.length; i++) {
            if(input_list[i].length() == 0) {
                answer += "";
            } else {
                answer += input_list[i].substring(0,1).toUpperCase() + input_list[i].substring(1, input_list[i].length()) + " ";
            }
        }

        //output
        if(s.substring(s.length() -1, s.length()).equals(" ")) System.out.println(answer);
        System.out.println(answer.substring(0, answer.length() - 1));

    }
}