import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] parent;
  static int[] check;
  static int root, N, answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    parent = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      parent[n] = Integer.parseInt(st.nextToken());
      if (parent[n] == -1) {
        root = n;
      }
    }

    int R = Integer.parseInt(br.readLine());
    removeNode(R);

    answer = 0;
    check = new int[N];
    countLeaf(root);

    System.out.println(answer);

  }

  public static void removeNode(int r) {
    parent[r] = -2;
    for (int n = 0; n < N; n++) {
      if (parent[n] == r) {
        removeNode(n);
      }
    }
  }

  public static void countLeaf(int r) {
    boolean visit = true;
    check[r] = 1;
    if (parent[r] != -2) {
      for (int n = 0; n < N; n++) {
        if (parent[n] == r && check[n] == 0) {
          countLeaf(n);
          visit = false;
        }
      }
      if (visit) {
        answer++;
      }
    }
  }
}