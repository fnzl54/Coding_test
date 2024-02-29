import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

// 해설 - https://gh402.tistory.com/32
public class Main {

  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder answer  = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> maxFirstQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minFirstQueue = new PriorityQueue<>();

    for (int n = 0; n < N; n++) {
      int input = Integer.parseInt(br.readLine());

      if (maxFirstQueue.size() == minFirstQueue.size()) {
        maxFirstQueue.add(input);

        while (!minFirstQueue.isEmpty() && maxFirstQueue.peek() > minFirstQueue.peek()) {
          maxFirstQueue.add(minFirstQueue.poll());
          minFirstQueue.add(maxFirstQueue.poll());
        }

      } else {
        minFirstQueue.add(input);

        while (maxFirstQueue.peek() > minFirstQueue.peek()) {
          maxFirstQueue.add(minFirstQueue.poll());
          minFirstQueue.add(maxFirstQueue.poll());
        }
      }

      answer.append(maxFirstQueue.peek() + "\n");
    }

    System.out.println(answer);
  }

}
