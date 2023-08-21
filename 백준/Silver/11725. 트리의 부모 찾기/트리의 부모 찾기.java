import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    List<ArrayList<Integer>> tree = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    boolean[] visited = new boolean[N];
    int[] parent = new int[N];

    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    visited[0] = true;
    while(!q.isEmpty()) {
      int temp_node = q.poll();
      for (int i : tree.get(temp_node)) {
        if (!visited[i]) {
          visited[i] = true;
          q.add(i);
          parent[i] = temp_node;
        }
      }
    }

    for (int i = 1; i < N; i++) {
      System.out.println(parent[i] + 1);
    }
  }
}
