import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String[] nick_name = new String[N];
    int[] nick_power = new int[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      nick_name[i] = st.nextToken();
      nick_power[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      int input_power = Integer.parseInt(br.readLine());
      int start = 0, end = N-1, answer_num = Integer.MAX_VALUE;

      while (start <= end) {
        int middle = (start + end) / 2;

        if (nick_power[middle] >= input_power) {
          answer_num = Math.min(middle, answer_num);
          end = middle - 1;
        } else {
          start = middle + 1;
        }
      }

      sb.append(nick_name[answer_num]).append("\n");
    }

    System.out.println(sb);
  }
}