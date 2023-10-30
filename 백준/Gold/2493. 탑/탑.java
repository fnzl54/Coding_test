import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<int[]> top = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    int[] answer = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      int[] current =  new int[] {n, Integer.parseInt(st.nextToken())};

      if (top.size() > 0) {
        while (!top.isEmpty()) {
          int[] check = top.peek();
          if (check[1] >= current[1]) {
            answer[n] = check[0] + 1;
            break;
          }
          top.pop();
        }
        if (top.isEmpty()) {
          answer[n] = 0;
        }
      } else {
        answer[n] = 0;
      }

      top.add(current);
    }

    for (int n = 0; n < N; n++) {
      sb.append(answer[n]).append(" ");
    }

    System.out.println(sb);
  }
}