import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] tree = new int[N];
    int down = 0, top = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(tree);
    top = tree[N-1];

    while (down < top) {
      int middle = (down + top) / 2;
      long lengthSum = 0;

      for (int t : tree) {
        if (t - middle > 0) {
          lengthSum += t - middle;
        }
      }

      if (lengthSum < M) {
        top = middle;
      } else {
        down = middle + 1;
      }
    }

    System.out.println(down - 1);

  }
}