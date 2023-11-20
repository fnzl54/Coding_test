import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long N = Long.parseLong(st.nextToken());
    long K = Long.parseLong(st.nextToken());

    long left = 0, right = N;

    while (left <= right) {
      long col = (left + right) / 2;
      long row = N - col;
      long cutPaperCount = (col + 1) * (row + 1);

      if (cutPaperCount == K) {
        System.out.println("YES");
        return;
      } else if (cutPaperCount < K) {
        left = col + 1;
      } else {
        right = col - 1;
      }
    }

    System.out.println("NO");
  }
}