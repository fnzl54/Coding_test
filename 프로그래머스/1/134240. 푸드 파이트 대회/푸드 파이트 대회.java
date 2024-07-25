import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int count_food = food[i] / 2;

            for (int c = 0; c < count_food; c++) {
                sb.append(i);
            }
        }

        answer = sb + "0";
        answer += sb.reverse();
        
        return answer;
    }
}