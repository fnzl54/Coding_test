import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
      int i1Abs = Math.abs(i1);
      int i2Abs = Math.abs(i2);

      if (i1Abs == i2Abs) return i1 > i2 ? 1 : -1;
      return i1Abs - i2Abs;
    });

    for (int i = 0; i < N; i++ ) {
      int input = Integer.parseInt(br.readLine());

      if (input != 0) {
        pq.add(input);
      } else if (input == 0 && pq.isEmpty()) {
        sb.append("0").append("\n");
      } else {
        sb.append(pq.poll()).append("\n");
      }
    }



    System.out.println(sb);
  }
}