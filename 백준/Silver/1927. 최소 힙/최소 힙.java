import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int inputNum = Integer.parseInt(br.readLine());

      if (inputNum == 0) {
        if (pq.isEmpty()) {
          sb.append("0").append("\n");
        } else {
          sb.append(pq.poll()).append("\n");
        }
      } else {
        pq.add(inputNum);
      }
    }

    System.out.println(sb);
  }
}