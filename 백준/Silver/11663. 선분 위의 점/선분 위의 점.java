import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Integer[] point_list = new Integer[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      point_list[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(point_list);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int left = 0, right = N-1, middle = 0;
      int a_num = 0, b_num = 0;

      while (left <= right) {
        middle = (left + right) / 2;

        if (point_list[middle] >= a) {
          right = middle - 1;
        } else {
          left = middle + 1;
        }
      }

      a_num = left;
      left = 0;
      right = N-1;
      middle = 0;

      while (left <= right) {
        middle = (left + right) / 2;

        if (point_list[middle] > b) {
          right = middle - 1;
        } else {
          left = middle + 1;
        }
      }

      b_num = left;

      sb.append(b_num - a_num).append("\n");
    }

    System.out.println(sb);
  }
}