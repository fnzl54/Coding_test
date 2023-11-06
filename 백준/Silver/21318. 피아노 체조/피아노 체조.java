import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] music = new int[N];
    int[] mistakes = new int[N];
    int mistake = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      music[n] = Integer.parseInt(st.nextToken());
    }

    for (int n = 0; n < N-1; n++) {
      if (music[n] > music[n+1]) {
        mistake++;
      }
      mistakes[n+1] = mistake;
    }

    int Q = Integer.parseInt(br.readLine());
    for (int q = 0; q < Q; q++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken())-1;
      int y = Integer.parseInt(st.nextToken())-1;

      sb.append(mistakes[y] - mistakes[x]).append("\n");
    }

    System.out.println(sb);
  }
}