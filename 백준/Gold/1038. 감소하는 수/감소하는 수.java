import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static int N;
  static List<Long> answer = new ArrayList<>();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    if (N <= 10) {
      System.out.println(N);
      return;
    } else {
      for (long i = 0; i < 10; i++) {
        dfs(1, i);
      }
    }

    if (N >= answer.size()) {
      System.out.println("-1");
    } else {
      Collections.sort(answer);
      System.out.println(answer.get(N));
    }

  }


  static void dfs(int depth, long currentNumber) {
    if (depth > 10) {
      return;
    }

    answer.add(currentNumber);

    for (int i = 0; i < currentNumber % 10; i++) {
      dfs(depth + 1, currentNumber * 10 + i);
    }

  }

}