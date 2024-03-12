import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, K, S, X, Y;
  static int[][] map;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  static Queue<int[]> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    HashMap<Integer, List<int[]>> virusList = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] != 0) {
          List<int[]> temp = virusList.getOrDefault(map[i][j], new ArrayList<>());
          temp.add(new int[] {i, j});
          virusList.put(map[i][j], temp);
        }
      }
    }

    for (int key : virusList.keySet()) {
      for (int[] v : virusList.get(key)) {
        q.add(new int[] {v[0], v[1], key}); // x, y, 바이러스 종류
      }
    }

    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken()) - 1;
    Y = Integer.parseInt(st.nextToken()) - 1;

    bfs();

    System.out.println(map[X][Y]);
  }

  private static void bfs() {
    int time = 0;

    while (!q.isEmpty()) {
      if (time == S) {
        return;
      }

      int qSize = q.size();
      for (int t = 0; t < qSize; t++) {
        int[] now = q.poll();
        int x = now[0];
        int y = now[1];
        int virusNumber = now[2];

        for (int i = 0; i < 4; i++) {
          int nx = x + dx[i];
          int ny = y + dy[i];

          if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            if (map[nx][ny] == 0) {
              map[nx][ny] = virusNumber;
              q.add(new int[] {nx, ny, virusNumber});
            }
          }
        }
      }

      time++;
    }
  }

}