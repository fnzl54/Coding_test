package level_2;

import java.util.*;

public class 타켓넘버 {
    static int answer = 0;
    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        //logic
        dfs(numbers, target, 0, 0);

        //output
        System.out.println(answer);
    }

    static void dfs(int[] numbers, int target, int index, int sum) {

      if (index == numbers.length) {
        if (sum == target) answer++;
        return;
      }

      dfs(numbers, target, index + 1, sum + numbers[index]);
      dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}


